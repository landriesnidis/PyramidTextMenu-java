package pers.landriesnidis.ptm4j.scene;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public class Scene implements IScene, SceneWirter, SceneReader {

	// 根目录
	private TextMenu rootMenu;
	// 当前运行中的目录
	private TextMenu runningMenu;
	// 场景信息读取器
	private SceneReader reader;

	public Scene() {
	}

	public Scene(SceneReader reader) {
		this.reader = reader;
	}

	public void startMenu(TextMenu menu, Option option) {
		startMenu(menu, option, null);
	}

	public void startMenu(TextMenu menu, Option option, String[] args) {
		// 切换Menu
		menu.setPreviousMenu(getRunningMenu());
		setRunningMenu(menu);

		// 创建StopEvent对象
		StopEvent stopEvent = new StopEvent();
		stopEvent.setKeyword(option.getKeyWord());

		// 原Menu触发onStop事件
		menu.getPreviousMenu().onStop(stopEvent);

		// 创建LoadEvent对象
		LoadEvent loadEvent = new LoadEvent();
		loadEvent.setActionType(option.getType());
		loadEvent.setKeyword(option.getKeyWord());
		loadEvent.setMenuContext(menu.getPreviousMenu());

		// 新Menu触发onLoad事件
		menu.onLoad(loadEvent);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent();
		startEvent.setActionType(option.getType());
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

		// 切换菜单
		TextMenu menu = getRunningMenu();
		setRunningMenu(getRunningMenu().getPreviousMenu());

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;

		// 创建BackEvent事件对象
		BackEvent e = new BackEvent();
		if (option != null) {
			e.setKeyword(option.getKeyWord());
			if (args != null) {
				e.setArgs(args);
			}
		}

		// 上一级Menu触发onLoad事件
		getRunningMenu().onBack(e);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent();
		startEvent.setActionType(option.getType());
		startEvent.setArgs(args);

		// 新Menu触发onStart事件
		getRunningMenu().onStart(startEvent);
	}

	public void returnToRootMenu(Option option) {
		// 切换菜单
		TextMenu menu = getRunningMenu();
		setRunningMenu(getRootMenu());

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;

		// 创建BackEvent事件对象
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());
		e.setType(ActionType.BACK_HOME);

		// 根Menu触发onLoad事件
		getRunningMenu().onBack(e);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent();
		startEvent.setActionType(option.getType());
		startEvent.setArgs(null);

		// 新Menu触发onStart事件
		getRunningMenu().onStart(startEvent);
	}

	public void reloadMenu() {

		TextMenu oldMenu = getRunningMenu();
		TextMenu newMenu = Option.createTextMenuObject(oldMenu.getClass());

		// 切换Menu
		newMenu.setPreviousMenu(oldMenu.getPreviousMenu());
		setRunningMenu(newMenu);

		// 创建LoadEvent事件对象
		LoadEvent le = new LoadEvent();
		le.setActionType(ActionType.RELOAD);
		le.setKeyword(null);
		le.setMenuContext(newMenu.getPreviousMenu());

		// 新Menu触发onLoad事件
		newMenu.onLoad(le);

		// 创建StartEvent对象
		StartEvent startEvent = new StartEvent();
		startEvent.setActionType(ActionType.RELOAD);
		startEvent.setArgs(null);

		// 新Menu触发onStart事件
		newMenu.onStart(startEvent);
	}

	public TextMenu getRootMenu() {
		return rootMenu;
	}

	public void setRootMenu(TextMenu rootMenu) {
		this.rootMenu = rootMenu;
		rootMenu.setScene(this);
		if (getRunningMenu() == null) {
			setRunningMenu(rootMenu);
			getRootMenu().onLoad(null);
		}
	}

	public TextMenu getRunningMenu() {
		return runningMenu;
	}

	public void setRunningMenu(TextMenu runningMenu) {
		runningMenu.setScene(this);
		this.runningMenu = runningMenu;
	}

	public SceneWirter getSceneWirter() {
		return this;
	}

	public boolean input(String text, Object dataTag) {
		return runningMenu.selectOption(text, dataTag);
	}

	public void output(String text, Object dataTag) {
		reader.output(text, dataTag);
	}

	public void setReader(SceneReader reader) {
		this.reader = reader;
	}
}
