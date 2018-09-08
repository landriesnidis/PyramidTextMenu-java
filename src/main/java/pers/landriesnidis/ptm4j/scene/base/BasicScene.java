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
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public class BasicScene implements IBasicScene,IMenuSwitching,ISceneContext {
	// 菜单组
	private LinkedList<TextMenu> textMenuLinkedList = new LinkedList<TextMenu>();
	
	// 场景信息读取器
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

	public SceneWirter getSceneWirter() {
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
				
		// 避免在菜单组中出现环
		// 如果新跳转的菜单对象存在于菜单组中，则从菜单组中删除后续(包含新菜单对象)
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
		
		// 切换至上一级菜单并保存原运行中的Menu
		TextMenu menu = textMenuLinkedList.removeLast();

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;

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
		
		// 如果当前已处于根菜单则什么也不做
		if(textMenuLinkedList.size()<=1)return;
		
		// 切换菜单
		TextMenu menu = getRunningMenu();

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;
		
		// 返回至根菜单
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
