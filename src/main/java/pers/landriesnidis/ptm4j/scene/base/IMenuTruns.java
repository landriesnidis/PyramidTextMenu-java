package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.option.Option;

public interface IMenuTruns {
	/** 
	 * 启动一个新TextMenu
	 * @param menu
	 */
	void startMenu(TextMenu menu, Option option);
	/**
	 * 启动一个带参数的新TextMenu
	 * @param option
	 * @param args
	 */
	void startMenu(TextMenu menu, Option option, String[] args);
	
	/**
	 * 未经Option触发强制退回
	 */
	void returnToPreviousMenu();
	/**
	 * 返回到上一层TextMenu
	 */
	void returnToPreviousMenu(Option option);
	/**
	 * 返回上一层TextMenu（携带参数）
	 * @param args
	 */
	void returnToPreviousMenu(Option option, String[] args);
	/**
	 * 返回根目录
	 */
	void returnToRootMenu(Option option);
	/**
	 * 重新加载当前TextMenu
	 * @param option
	 */
	void reloadMenu(String[] args);
}
