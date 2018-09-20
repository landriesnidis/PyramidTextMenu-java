package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.menu.TextMenu;

public interface IMenuSwitching {
	/**
	 * 获取根TextMenu
	 * @return
	 */
	TextMenu getRootMenu();
	
	/**
	 * 设置根TextMenu
	 * 每一个Scene都需要有一个RootMenu，RootMenu设置后会直接运行。如果当前Scene中已存在正在运行的TextMenu则直接清空TextMenu组并运行新的TextMenu。
	 * @param rootMenu
	 */
	void setRootMenu(TextMenu rootMenu);
	
	/**
	 * 获取当前正在运行的TextMenu
	 * @return
	 */
	TextMenu getRunningMenu();
	
	/**
	 * 设置一个TextMenu，使其处于运行状态
	 * @param runningMenu
	 */
	void setRunningMenu(TextMenu runningMenu);
}
