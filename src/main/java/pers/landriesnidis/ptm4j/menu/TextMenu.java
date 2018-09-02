package pers.landriesnidis.ptm4j.menu;

import java.util.ArrayList;
import java.util.List;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.Scene;

public class TextMenu implements IMenuIifeCycle, ITextMenu{

	//所处的场景
	private Scene scene;
	//上一级菜单
	private TextMenu previousMenu;
	//选择项
	private List<Option> options;
	//标题
	private String title = "Menu";
	//文本内容
	private String textContent;
	// 是否允许接收文本（接收非选择项的文本内容）
	private boolean allowReveiceText;
	private boolean allowShowSerialNumber;
	public TextMenu() {
		options = new ArrayList<Option>();
		onCreate();
	}
	
	public void onCreate() {
		
	}

	public void onLoad(LoadEvent e) {
		showMenu(null);
	}

	public void onStop(StopEvent e) {
		
	}

	public void onBack(BackEvent e) {
		showMenu(null);
	}

	public void onDestroy() {
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public TextMenu getPreviousMenu() {
		return previousMenu;
	}

	public void setPreviousMenu(TextMenu previousMenu) {
		this.previousMenu = previousMenu;
	}

	public void addOption(Option option) {
		options.add(option);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public String getTextContent() {
		return textContent;
	}

	public boolean isAllowShowSerialNumber() {
		return allowShowSerialNumber;
	}

	public void setAllowShowSerialNumber(boolean allowShowSerialNumber) {
		this.allowShowSerialNumber = allowShowSerialNumber;
	}

	public boolean isAllowReveiceText() {
		return allowReveiceText;
	}

	public void setAllowReveiceText(boolean isAllowReveiceText) {
		this.allowReveiceText = isAllowReveiceText;
	}
	
	public void addTextOption(String keyword, String content) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setTextContent(content);
		option.setType(ActionType.TEXT);
		options.add(option);
	}

	public void addMenuOption(String keyword, Class<? extends TextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setType(ActionType.MENU);
		options.add(option);
	}

	public void addArgsMenuOption(String keyword, Class<? extends TextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setType(ActionType.MENU_ARGS);
		options.add(option);
	}

	public void addBackOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setType(ActionType.BACK);
		options.add(option);
	}

	public void addReloadOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setType(ActionType.RELOAD);
		options.add(option);
	}
	
	public void addTextLine(String text){
		Option option = new Option(this);
		option.setKeyWord(text);
		option.setType(ActionType.TEXT);
		option.setOptional(false);
		options.add(option);
	}

	public void removeOption(Option option) {
		options.remove(option);
	}

	public void removeOptionByKeyword(String keyword) {
		for(Option option:options){
			if(option.getKeyWord().equals(keyword)){
				options.remove(option);
				return;
			}
		}
	}

	public Option getOption(int index) {
		int invalidItemCount = 0;
		for(int i=0;i<index+invalidItemCount;i++){
			if(!options.get(i).getOptional()){
				++invalidItemCount;
			}
		}
		return options.get(index-1+invalidItemCount);
	}

	public Option getOption(String optionKeyword) {
		int size = options.size()-1;
		String kw = null;
		Option o = null;
		for(int i=0;i<=size;++i){
			o = options.get(size-i);
			kw = o.getKeyWord();
			if(o.getType()==ActionType.MENU_ARGS){
				if(kw.contentEquals(optionKeyword.split(" ")[0])){
					return o;
				}
			}else{
				if(kw.contentEquals(optionKeyword)){
					return o;
				}
			}
		}
		return null;
	}
	
	public Option getLastOption() {
		return options.get(options.size()-1);
	}

	public void showMenu(Object dataTag) {
		StringBuilder textMenu = new StringBuilder();
		// 判断是否显示序号
		if(isAllowShowSerialNumber()){
			int i=1;
			for(Option o:options){
				if(o.getOptional())
					textMenu.append(String.format(" [%d] %s\n", i++, o.getKeyWord()));
				else
					textMenu.append(String.format("%s\n", o.getKeyWord()));
			}
		}else{
			for(Option o:options){
				if(o.getOptional())
					textMenu.append(String.format(" · %s\n", o.getKeyWord()));
				else
					textMenu.append(String.format("%s\n", o.getKeyWord()));
			}
		}
		
		showInfo(getTitle(),getTextContent(),textMenu.toString(),dataTag);
	}

	public void showInfo(String title, String content, String menu, Object dataTag) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("[%s]\n", title));
		sb.append(String.format("%s\n", content));
		sb.append("----------\n");
		sb.append(menu);
		showMessage(sb.toString(),dataTag);
	}

	public void showMessage(String msg, Object dataTag) {
		getScene().output(msg,dataTag);
	}

	public boolean selectOption(String text, Object dataTag) {
		// 获取关键字与输入内容相符的选项对象
		Option option = this.getOption(text);
		// 判断选项是否存在
		if(option!=null){
			// 若存在则执行相应操作
			option.execute(text, dataTag);
			return true;
		}else{
			// 若不存在
			// 判断菜单是否允许接收任意输入文本 且文本信息是否有效
			if(isAllowReveiceText() && onTextReveived(text, dataTag)){
				return true;
			}
			//执行序号
			int index = 0;
			try{
				index = Integer.parseInt(text.trim());
				option = this.getOption(index);
				if(option!=null){
					option.execute(text, dataTag);
					return true;
				}else{
					return false;
				}
			}catch (Exception e) {
				return false;
			}	
		}
	}

	public boolean onTextReveived(String text, Object dataTag) {
		return false;
	}
}
