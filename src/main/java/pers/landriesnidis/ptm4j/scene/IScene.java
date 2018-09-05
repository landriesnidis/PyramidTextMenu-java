package pers.landriesnidis.ptm4j.scene;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public interface IScene {
	
	/** 
	 * 启动一个新菜单
	 * @param menu
	 */
	void startMenu(TextMenu menu, Option option);
	/**
	 * 启动一个带参数的新菜单
	 * @param option
	 * @param args
	 */
	void startMenu(TextMenu menu, Option option, String[] args);
	
	/**
	 * 未经选项触发强制退回
	 */
	void returnToPreviousMenu();
	/**
	 * 返回到上一层菜单
	 */
	void returnToPreviousMenu(Option option);
	/**
	 * 返回上一层菜单（携带参数）
	 * @param args
	 */
	void returnToPreviousMenu(Option option, String[] args);
	/**
	 * 返回根目录
	 */
	void returnToRootMenu(Option option);
	/**
	 * 重新加载当前菜单
	 * @param option
	 */
	void reloadMenu();
	
	/**
	 * 获取场景信息写入器
	 * @return
	 */
	SceneWirter getSceneWirter();
	
	/**
	 * 获取根菜单
	 * @return
	 */
	TextMenu getRootMenu();
	
	/**
	 * 设置根菜单
	 * 每一个Scene都需要有一个RootMenu，RootMenu设置后会直接运行。如果当前Scene中已存在正在运行的菜单则直接清空菜单组并运行新的菜单。
	 * @param rootMenu
	 */
	void setRootMenu(TextMenu rootMenu);
	TextMenu getRunningMenu();
	void setRunningMenu(TextMenu runningMenu);
}
