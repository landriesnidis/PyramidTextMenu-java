package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * TextMenu接口
 * @author Landriesnidis
 */
public interface ITextMenu {
	
	/**
	 * 当接收到用户输入的信息会触发此方法（当TextMenu设置允许接收信息时才会被执行，即：setAllowReveiceText(true)）
	 * @param text 接收到的文本
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 * @return 若输入的信息有效，则应当返回true；若输入的信息无效，则应当返回false。
	 */
	boolean onTextReveived(String text, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 获取TextMenu会话环境
	 * @return TextMenu会话环境
	 */
	IMenuContext getMenuContext();
	
	/**
	 * 判断该TextMenu是否启用行号显示
	 * @return 是否显示行号
	 */
	boolean isAllowShowSerialNumber();
	
	/**
	 * 设置当前TextMenu是否显示行号
	 * @param allowShowSerialNumber 是否显示行号
	 */
	void setAllowShowSerialNumber(boolean allowShowSerialNumber);
	
	/**
	 * 判断该TextMenu是否允许接收文本
	 * @return 是否接收文本
	 */
	boolean isAllowReveiceText();
	
	/**
	 * 设置当前TextMenu是否接收文本
	 * @param isAllowReveiceText 是否接收文本
	 */
	void setAllowReveiceText(boolean isAllowReveiceText);
	
	/**
	 * 当从下一级TextMenu返回时是否直接跳过当前TextMenu返回至上一级
	 * @return 是否跳过
	 */
	boolean isSkipMenuOnBack();
	
	/**
	 * 设置当从下一级TextMenu返回时跳过当前TextMenu直接返回至上一级
	 * 跳过的TextMenu不会触发onBack()、onStart()事件
	 * @param skipMenuOnBack 是否跳过
	 */
	void setSkipMenuOnBack(boolean skipMenuOnBack);
	
	/**
	 * 获取格式化的TextMenu信息
	 * @return TextMenu的文本信息
	 */
	String getMenuFormatString();
	
}
