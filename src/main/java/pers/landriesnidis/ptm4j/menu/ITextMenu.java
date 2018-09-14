package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface ITextMenu {
	
	/**
	 * 当接收到用户输入的信息（当菜单设置允许接收信息时才会被执行）
	 * @param text
	 * @return
	 */
	boolean onTextReveived(String text, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 获取菜单会话环境
	 * @return
	 */
	IMenuContext getMenuContext();
	
	/**
	 * 当前菜单是否允许显示行号
	 * @return
	 */
	boolean isAllowShowSerialNumber();
	
	/**
	 * 设置当前菜单是否显示行号
	 * @param allowShowSerialNumber
	 */
	void setAllowShowSerialNumber(boolean allowShowSerialNumber);
	
	/**
	 * 当前菜单是否允许接收文本
	 * @return
	 */
	boolean isAllowReveiceText();
	
	/**
	 * 设置当前菜单是否接收文本
	 * @param isAllowReveiceText
	 */
	void setAllowReveiceText(boolean isAllowReveiceText);
	
	/**
	 * 获取格式化的菜单信息
	 * @return
	 */
	String getMenuFormatString();
	
}
