package pers.landriesnidis.ptm4j.menu;

import java.util.ArrayList;
import java.util.List;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.Scene;

public class BaseTextMenu implements IMenuIifeCycle, IMenu{

	//所处的场景
	private Scene scene;
	//上一级菜单
	private BaseTextMenu previousMenu;
	//
	private List<Option> options;
	//标题
	private String title = "Menu";
	//文本内容
	private String textContent;
	
	public BaseTextMenu() {
		options = new ArrayList<Option>();
		onCreate();
	}
	
	public void onCreate() {
		
	}

	public void onLoad(LoadEvent e) {
		
	}

	public void onStop(StopEvent e) {
		
	}

	public void onBack(BackEvent e) {
		
	}

	public void onDestroy() {
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BaseTextMenu getPreviousMenu() {
		return previousMenu;
	}

	public void setPreviousMenu(BaseTextMenu previousMenu) {
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

	public void addTextOption(String keyword, String content) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setTextContent(content);
		option.setType(ActionType.TEXT);
		options.add(option);
	}

	public void addMenuOption(String keyword, Class<BaseTextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setType(ActionType.MENU);
		options.add(option);
	}

	public void addArgsMenuOption(String keyword, Class<BaseTextMenu> classMenu) {
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

	public void removeOption(Option option) {
		
	}

	public void removeOptionByKeyword(String keyword) {
		
	}

	public Option getOption(int index) {
		if(index<1 || index>options.size()){
			return null;
		}else{
			return options.get(index-1);
		}
	}

	public Option getOption(String optionKeyword) {
		
		return null;
	}

	public void showMenu() {
		StringBuilder textMenu = new StringBuilder();
		for(Option o:options){
			textMenu.append(String.format(" · %s\n", o.getKeyWord()));
		}
		showInfo(getTitle(),getTextContent(),textMenu.toString());
	}

	public void showInfo(String title, String content, String menu) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("[%s]\n", title));
		sb.append(String.format("%s\n", content));
		sb.append("----------\n");
		sb.append(menu);
		showMessage(sb.toString());
	}

	public void showMessage(String msg) {
		getScene().output(msg);
	}

	public boolean selectOption(String text) {
		Option option = this.getOption(text);
		if(option!=null){
			return true;
		}else{
			int index = 0;
			try{
				index = Integer.parseInt(text.trim());
				option = this.getOption(index);
				if(option!=null){
					option.execute(text);
					return true;
				}else{
					return false;
				}
			}catch (Exception e) {
				return false;
			}
		}
	}
}
