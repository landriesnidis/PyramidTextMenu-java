package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.menu.TextMenu;

public interface IMenuSwitching {
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
	
	/**
	 * 获取当前正在运行的菜单
	 * @return
	 */
	TextMenu getRunningMenu();
	
	/**
	 * 设置一个菜单，使其处于运行状态
	 * @param runningMenu
	 */
	void setRunningMenu(TextMenu runningMenu);
}
