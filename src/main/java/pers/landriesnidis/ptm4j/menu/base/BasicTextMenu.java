package pers.landriesnidis.ptm4j.menu.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.base.IMenuLifeCycle;
import pers.landriesnidis.ptm4j.menu.base.IOptionGroup;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.base.IBasicTextMenu;
import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * TextMenu
 * 文本菜单/目录类型
 * @see pers.landriesnidis.ptm4j.menu.base.IBasicTextMenu
 * @see pers.landriesnidis.ptm4j.menu.base.IOptionGroup
 * @see pers.landriesnidis.ptm4j.menu.base.IMenuLifeCycle
 * @see pers.landriesnidis.ptm4j.menu.context.IMenuContext
 * @author Landriesnidis
 */
public class BasicTextMenu implements IBasicTextMenu, IOptionGroup, IMenuLifeCycle, IMenuContext{

	public final static String DEFAULT_TEXT_LINE = "·-·-·-·-·-·-·-·";
	
	// 选择项
	private List<Option> options;
	// 标题
	private String title;
	// 文本内容
	private String textContent;
	// 是否允许接收文本（接收非选择项的文本内容）
	private boolean allowReveiceText;
	// 是否显示序号
	private boolean allowShowSerialNumber;
	// 当从下一级TextMenu返回时跳过当前TextMenu直接返回至上一级
	private boolean skipMenuOnBack;
	
	public BasicTextMenu() {
		options = new ArrayList<Option>();
		onCreate();
	}
	
	public void onCreate() {
		
	}

	public void onLoad(LoadEvent e) {
		
	}
	
	public void onStart(StartEvent e) {
		showMenu(e.getSceneContext(),null);
	}

	public void onStop(StopEvent e) {
		
	}

	public void onBack(BackEvent e) {

	}

	public void onUnload() {
		
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
	
	public boolean isSkipMenuOnBack() {
		return skipMenuOnBack;
	}
	
	public void setSkipMenuOnBack(boolean skipMenuOnBack) {
		this.skipMenuOnBack = skipMenuOnBack;
	}
	
	public List<Option> getMenuOptions() {
		return options;
	}

	public IMenuContext getMenuContext() {
		return this;
	}
	
	public void addTextOption(String keyword, String content) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setTextContent(content);
		option.setActionType(ActionType.TEXT);
		options.add(option);
	}

	public void addMenuOption(String keyword, Class<? extends TextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setActionType(ActionType.MENU);
		options.add(option);
	}
	
	public void addMenuOption(String keyword, TextMenu menuObject) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(menuObject.getClass());
		option.setMenuObject(menuObject);
		option.setActionType(ActionType.MENU);
		options.add(option);
	}

	public void addArgsMenuOption(String keyword, Class<? extends TextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setActionType(ActionType.MENU_ARGS);
		options.add(option);
	}
	
	public void addArgsMenuOption(String keyword, TextMenu menuObject) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(menuObject.getClass());
		option.setMenuObject(menuObject);
		option.setActionType(ActionType.MENU_ARGS);
		options.add(option);
	}

	public void addBackOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setActionType(ActionType.BACK);
		options.add(option);
	}
	
	public void addBackRootOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setActionType(ActionType.BACK_ROOT);
		options.add(option);
	}

	public void addReloadOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setActionType(ActionType.RELOAD);
		options.add(option);
	}
	
	public void addTextLine(){
		addTextLine(DEFAULT_TEXT_LINE);
	}
	
	public void addTextLine(String text){
		Option option = new Option(this);
		option.setKeyWord(text);
		option.setActionType(ActionType.TEXT);
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
		for(int i=0;i<index+invalidItemCount && i<options.size();++i){
			if(!options.get(i).isOptional() || !options.get(i).isVisibility()){
				++invalidItemCount;
			}
		}
		index = index-1+invalidItemCount;
		if(index<options.size())
			return options.get(index);
		
		return null;
	}

	public Option getOption(String text) {
		int size = options.size()-1;
		String kw = null;
		Option o = null;
		String[] args = text.split(" ");
		// 遍历Option组
		for(int i=0;i<=size;++i){
			// 倒序遍历
			o = options.get(size-i);
			// 如果可选性为否则略过
			if(!o.isOptional())continue;
			// 获取关键字
			kw = o.getKeyWord();
			// 判断是否为携带参数类型
			if(kw.contentEquals(args[0])){
				return o;
			}
		}
		if(isAllowShowSerialNumber()){
			if(Pattern.compile("^[-\\+]?[\\d]*$").matcher(args[0]).matches()){
				try{
					return getOption(Integer.parseInt(args[0]));
				}catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return null;
	}
	
	public Option getLastOption() {
		return options.get(options.size()-1);
	}
	
	public String getMenuFormatString() {
		StringBuilder menuText = new StringBuilder();
		int i=1;
		// 遍历Option
		for(Option o:options){
			// 判断Option的可用性
			if(!o.isOptional()){
				menuText.append(String.format("%s\n", o.getKeyWord()));
				continue;
			}
			// 判断Option可见性
			if(!o.isVisibility()){
				continue;
			}
			// 判断是否启用序号
			if(isAllowShowSerialNumber()){
				menuText.append(String.format(" [%d] %s\n", i++, o.getKeyWord()));
			}else{
				menuText.append(String.format(" · %s\n", o.getKeyWord()));
			}
		}
		return menuText.toString();
	}

	public void showMenu(ISceneContext sceneContext, Object dataTag) {
		showInfo(getTitle(),getTextContent(),getMenuFormatString(),sceneContext,dataTag);
	}

	public void showInfo(String title, String content, String menu, ISceneContext sceneContext, Object dataTag) {
		String info = String.format("[%s]\n%s\n%s", title,content,menu);
		showMessage(info, sceneContext, dataTag);
	}

	public void showMessage(String msg, ISceneContext sceneContext, Object dataTag) {
		sceneContext.output(msg, this, sceneContext, dataTag);
	}

	public boolean selectOption(String text, ISceneContext sceneContext, Object dataTag) {
		// 获取关键字与输入内容相符的Option对象
		Option option = this.getOption(text);
		
		if(option!=null){
			// 若存在则执行相应操作
			option.execute(text, sceneContext, dataTag);
			return true;
		}else{
			// 判断TextMenu是否允许接收任意输入文本 且文本信息是否有效
			if(isAllowReveiceText() && onTextReveived(text, sceneContext, dataTag)){
				return true;
			}
		}
		return false;
	}

	public boolean onTextReveived(String text, ISceneContext sceneContext, Object dataTag) {
		return false;
	}
	
	public final static BasicTextMenu createBaseTextMenuObject(Class<? extends BasicTextMenu> menuClass){
		try {
			try {
				return (BasicTextMenu) Class.forName(menuClass.getName()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
