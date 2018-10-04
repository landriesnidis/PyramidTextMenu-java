package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.menu.TextMenu;

/**
 * Scene中TextMenu列表选择接口
 * @author Landriesnidis
 */
public interface IMenuSwitching {
	/**
	 * 获取初始TextMenu
	 * @return Scene初始TextMenu
	 */
	TextMenu getRootMenu();
	
	/**
	 * 设置初始TextMenu
	 * 每一个Scene都需要有一个RootMenu，RootMenu设置后会直接运行。如果当前Scene中已存在正在运行的TextMenu则直接清空TextMenu组并运行新的TextMenu。
	 * @param rootMenu 新的初始TextMenu
	 */
	void setRootMenu(TextMenu rootMenu);
	
	/**
	 * 获取当前正在运行的TextMenu
	 * @return 运行中的TextMenu
	 */
	TextMenu getRunningMenu();
	
	/**
	 * 设置一个TextMenu，使其处于运行状态
	 * @param runningMenu 新的TextMenu
	 */
	void setRunningMenu(TextMenu runningMenu);
}
