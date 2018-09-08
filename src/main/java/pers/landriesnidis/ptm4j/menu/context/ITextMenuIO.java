package pers.landriesnidis.ptm4j.menu.context;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface ITextMenuIO {
	/**
	 * 根据输入内容选择选项
	 * @param text
	 * @return
	 */
	boolean selectOption(String text, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 显示菜单信息
	 */
	void showMenu(ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 显示格式化信息
	 * @param title
	 * @param content
	 * @param menu
	 */
	void showInfo(String title, String content, String menu, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 显示
	 * @param msg
	 */
	void showMessage(String msg, ISceneContext sceneContext, Object dataTag);
}
