package pers.landriesnidis.ptm4j.scene.base;

import java.util.LinkedList;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWriter;

/**
 * BasicScene
 * 基本会话场景
 * @author Landriesnidis
 *
 */
public class BasicScene implements IBasicScene,IMenuSwitching,ISceneContext {
	// TextMenu组
	private LinkedList<TextMenu> textMenuLinkedList = new LinkedList<TextMenu>();
	
	// Scene信息读取器
	private SceneReader reader;

	public BasicScene() {
	}

	public BasicScene(SceneReader reader) {
		this.reader = reader;
	}
	
	public boolean input(String text, Object dataTag) {
		return getRunningMenu().selectOption(text,this, dataTag);
	}
	
	public void output(String text, IMenuContext menuContext, ISceneContext sceneContext, Object dataTag) {
		this.reader.output(text, menuContext, sceneContext, dataTag);
	}

	public void setSceneReader(SceneReader reader) {
		this.reader = reader;
	}

	public SceneWriter getSceneWriter() {
		return this;
	}
	
	public ISceneContext getSceneContext() {
		return this;
	}
	
	public TextMenu getRootMenu() {
		return textMenuLinkedList.getFirst();
	}

	public void setRootMenu(TextMenu rootMenu) {
		textMenuLinkedList.clear();
		textMenuLinkedList.add(rootMenu);

		rootMenu.onLoad(new LoadEvent(this));
		rootMenu.onStart(new StartEvent(this));
	}

	public TextMenu getRunningMenu() {
		return textMenuLinkedList.getLast();
	}

	public void setRunningMenu(TextMenu runningMenu) {
		textMenuLinkedList.add(runningMenu);
	}

	public void startMenu(TextMenu menu, Option option) {
		startMenu(menu, option, null);
	}

	public void startMenu(TextMenu menu, Option option, String[] args) {
		
		// 保存原运行中的Menu
		TextMenu previousMenu = getRunningMenu();
				
		// 避免在TextMenu组中出现环
		// 如果新跳转的TextMenu对象存在于TextMenu组中，则从TextMenu组中删除后续(包含新TextMenu对象)
		if(textMenuLinkedList.contains(menu)){
			while(menu != textMenuLinkedList.removeLast());
		}
		
		// 切换Menu
		setRunningMenu(menu);

		// 创建StopEvent对象
		StopEvent stopEvent = new StopEvent(this);
		stopEvent.setKeyword(option.getKeyWord());

		// 原Menu触发onStop事件
		previousMenu.onStop(stopEvent);

		// 创建LoadEvent对象
		LoadEvent loadEvent = new LoadEvent(this);
		loadEvent.setActionType(option.getActionType());
		loadEvent.setKeyword(option.getKeyWord());

		// 新Menu触发onLoad事件
		menu.onLoad(loadEvent);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent(this);
		startEvent.setActionType(option.getActionType());
		startEvent.setKeyword(option.getKeyWord());
		startEvent.setArgs(args);

		// 新Menu触发onStart事件
		menu.onStart(startEvent);
	}

	public void returnToPreviousMenu() {
		returnToPreviousMenu(null);
	}

	public void returnToPreviousMenu(Option option) {
		returnToPreviousMenu(option, null);
	}

	public void returnToPreviousMenu(Option option, String[] args) {
		// 检测是否已是根Menu
		if (getRunningMenu() == getRootMenu())
			return;
		
		// 切换至上一级TextMenu并保存原运行中的Menu
		TextMenu menu = textMenuLinkedList.removeLast();

		// 原Menu触发onDestroy事件
		menu.onUnload();
		menu = null;
		
		// 如果返回的TextMenu设置了“返回时跳过”的属性，则继续向上一级TextMenu返回
		if(textMenuLinkedList.getLast().isSkipMenuOnBack()){
			returnToPreviousMenu(option, args);
			return;
		}

		// 创建BackEvent事件对象
		BackEvent backEvent = new BackEvent(this);
		if (option != null) {
			backEvent.setKeyword(option.getKeyWord());
			if (args != null) {
				backEvent.setArgs(args);
			}
		}

		// 重回运行状态的Menu触发onBack事件
		getRunningMenu().onBack(backEvent);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent(this);
		if (option != null) {
			startEvent.setActionType(option.getActionType());
			if (args != null) {
				startEvent.setArgs(args);
			}
		}

		// 新Menu触发onStart事件
		getRunningMenu().onStart(startEvent);
	}

	public void returnToRootMenu(Option option) {
		
		// 如果当前已处于根TextMenu则什么也不做
		if(textMenuLinkedList.size()<=1)return;
		
		// 切换TextMenu
		TextMenu menu = getRunningMenu();

		// 原Menu触发onDestroy事件
		menu.onUnload();
		menu = null;
		
		// 返回至根TextMenu
		TextMenu rootMenu = getRootMenu();
		textMenuLinkedList.clear();
		textMenuLinkedList.add(rootMenu);

		// 创建BackEvent事件对象
		BackEvent e = new BackEvent(this);
		e.setKeyword(option.getKeyWord());
		e.setActionType(ActionType.BACK_ROOT);

		// 根Menu触发onLoad事件
		getRunningMenu().onBack(e);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent(this);
		startEvent.setActionType(option.getActionType());
		startEvent.setArgs(null);

		// 新Menu触发onStart事件
		getRunningMenu().onStart(startEvent);
	}

	public void reloadMenu(String[] args) {
		// 保存原Menu和上一层Menu，根据原Menu创建新的同类型Menu并替换
		TextMenu oldMenu = textMenuLinkedList.removeLast();
		TextMenu newMenu = TextMenu.createTextMenuObject(oldMenu.getClass());
		setRunningMenu(newMenu);

		// 创建LoadEvent事件对象
		LoadEvent le = new LoadEvent(this);
		le.setActionType(ActionType.RELOAD);
		le.setKeyword(null);

		// 新Menu触发onLoad事件
		newMenu.onLoad(le);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent(this);
		startEvent.setActionType(ActionType.RELOAD);
		startEvent.setArgs(args);

		// 新Menu触发onStart事件
		newMenu.onStart(startEvent);
	}


}
