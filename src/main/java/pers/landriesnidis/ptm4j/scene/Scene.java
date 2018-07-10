package pers.landriesnidis.ptm4j.scene;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.BaseTextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public class Scene implements IScene, SceneWirter {

	// 根目录
	private BaseTextMenu rootMenu;
	// 当前运行中的目录
	private BaseTextMenu runningMenu;
	// 场景信息读取器
	SceneReader reader;

	public Scene(SceneReader reader) {
		this.reader = reader;
	}

	public void startMenu(BaseTextMenu menu, Option option) {
		/*
		 * try { try { BaseTextMenu tm = (BaseTextMenu)
		 * Class.forName(menu.getClass().getName()).newInstance(); LoadEvent ce
		 * = new LoadEvent(); ce.setActionType(menu); tm.onCreate();
		 * tm.setPreviousMenu(runningMenu); tm.setScene(this);
		 * this.setRunningMenu(tm); } catch (InstantiationException e) {
		 * e.printStackTrace(); } catch (IllegalAccessException e) {
		 * e.printStackTrace(); } } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 */

		// 切换Menu
		menu.setPreviousMenu(runningMenu);
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
		menu.setPreviousMenu(runningMenu);
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
		setRunningMenu(runningMenu.getPreviousMenu());
		// 创建对象事件
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());
		// 触发返回事件
		getRunningMenu().onBack(e);
	}

	public void returnToPreviousMenu(Option option, String[] args) {
		// 切换菜单
		setRunningMenu(runningMenu.getPreviousMenu());
		// 创建对象事件
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());
		e.setArgs(args);
		// 触发返回事件
		getRunningMenu().onBack(e);
	}

	public void returnToRootMenu(Option option) {
		// 切换菜单
		setRunningMenu(runningMenu.getPreviousMenu());
		// 创建对象事件
		BackEvent e = new BackEvent();
		e.setKeyword(option.getKeyWord());
		e.setType(ActionType.BACK_HOME);
		// 触发返回事件
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
		if(runningMenu.selectOption(text)){
			return true;
		}else{
			int index = 0;
			try{
				index = Integer.parseInt(text.trim());
				return runningMenu.selectOption(index);
			}catch (Exception e) {
				return false;
			}
		}
	}
}
