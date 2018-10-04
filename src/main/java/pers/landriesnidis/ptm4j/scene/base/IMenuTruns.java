package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.menu.base.BasicTextMenu;
import pers.landriesnidis.ptm4j.option.base.BasicOption;

/**
 * TextMenu跳转方法接口
 * @author Landriesnidis
 *
 */
public interface IMenuTruns {
	/**
	 * 启动一个TextMenu
	 * @param menu 启动的新TextMenu对象
	 * @param option 产生跳转事件的Option对象
	 */
	void startMenu(BasicTextMenu menu, BasicOption option);
	
	/**
	 * 启动一个TextMenu并携带参数
	 * @param menu 启动的新TextMenu对象
	 * @param option 产生跳转事件的Option对象
	 * @param args 参数
	 */
	void startMenu(BasicTextMenu menu, BasicOption option, String[] args);
	
	/**
	 * 未经BACK类型的Option触发，强制退回上一级TextMenu
	 */
	void returnToPreviousMenu();
	
	/**
	 * 返回到上一级TextMenu
	 * @param option 产生跳转事件的Option对象
	 */
	void returnToPreviousMenu(BasicOption option);
	
	/**
	 * 返回上一级TextMenu并携带参数
	 * @param option 产生跳转事件的Option对象
	 * @param args 参数
	 */
	void returnToPreviousMenu(BasicOption option, String[] args);
	
	/**
	 * 返回初始TextMenu
	 * @param option 产生跳转事件的Option对象
	 */
	void returnToRootMenu(BasicOption option);
	
	/**
	 * 重新加载当前TextMenu
	 * @param args 参数
	 */
	void reloadMenu(String[] args);
}
