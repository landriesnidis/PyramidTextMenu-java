package pers.landriesnidis.ptm4j.scene;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.BaseTextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public class Scene implements IScene, SceneWirter, SceneReader {

	// 根目录
	private BaseTextMenu rootMenu;
	// 当前运行中的目录
	private BaseTextMenu runningMenu;
	// 场景信息读取器
	private SceneReader reader;

	public Scene(SceneReader reader) {
		this.reader = reader;
	}

	public void startMenu(BaseTextMenu menu, Option option) {
		// 切换Menu
		menu.setPreviousMenu(getRunningMenu());
		setRunningMenu(menu);

		// 创建StopEvent事件
		StopEvent se = new StopEvent();
		se.setKeyword(option.getKeyWord());

		// 原Menu触发onStop事件
		menu.getPreviousMenu().onStop(se);

		// 创建LoadEvent事件对象
		LoadEvent le = new LoadEvent();
		le.setActionType(option.getType());
		le.setKeyword(option.getKeyWord());
		le.setMenuContext(menu.getPreviousMenu());

		// 新Menu触发onLoad事件
		menu.onLoad(le);
	}

	public void startMenu(BaseTextMenu menu, Option option, String[] args) {
		// 切换Menu
		menu.setPreviousMenu(getRunningMenu());
		setRunningMenu(menu);

		// 创建StopEvent事件
		StopEvent se = new StopEvent();
		se.setKeyword(option.getKeyWord());

		// 原Menu触发onStop事件
		menu.getPreviousMenu().onStop(se);

		// 创建LoadEvent事件对象
		LoadEvent le = new LoadEvent();
		le.setActionType(option.getType());
		le.setKeyword(option.getKeyWord());
		le.setMenuContext(menu.getPreviousMenu());
		le.setArgs(args);

		// 新Menu触发onLoad事件
		menu.onLoad(le);
	}

	public void returnToPreviousMenu(Option option) {
		// 切换菜单
		BaseTextMenu menu = getRunningMenu();
		setRunningMenu(getRunningMenu().getPreviousMenu());

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;

		// 创建BackEvent事件对象
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());

		// 上一级Menu触发onLoad事件
		getRunningMenu().onBack(e);
	}

	public void returnToPreviousMenu(Option option, String[] args) {
		// 切换菜单
		BaseTextMenu menu = getRunningMenu();
		setRunningMenu(getRunningMenu().getPreviousMenu());

		// 原Menu触发onDestroy事件
		menu.onDestroy();
		menu = null;

		// 创建BackEvent事件对象
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());
		e.setArgs(args);

		// 上一级Menu触发onLoad事件
		getRunningMenu().onBack(e);
	}

	public void returnToRootMenu(Option option) {
		// 切换菜单
		BaseTextMenu menu = getRunningMenu();
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
	}

	public BaseTextMenu getRootMenu() {
		return rootMenu;
	}

	public void setRootMenu(BaseTextMenu rootMenu) {
		this.rootMenu = rootMenu;
	}

	public BaseTextMenu getRunningMenu() {
		return runningMenu;
	}

	public void setRunningMenu(BaseTextMenu runningMenu) {
		this.runningMenu = runningMenu;
	}

	public SceneWirter getSceneWirter() {
		return this;
	}

	public boolean input(String text) {
		return runningMenu.selectOption(text);
	}

	public void output(String text) {
		reader.output(text);
	}
}
