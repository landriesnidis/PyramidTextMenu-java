package pers.landriesnidis.ptm4j.menu.context;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface ITextMenuIO {
	
	/**
	 * 根据文本选择对应的Option
	 * @param text 输入文本
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 * @return 文本是否有效（是否有对应的选项）
	 */
	boolean selectOption(String text, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 输出TextMenu的文本信息（包含选项组列表）
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 */
	void showMenu(ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 输出包含TextMenu主要属性的文本信息
	 * @param title 标题
	 * @param content 内容
	 * @param menu 选项列表
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 */
	void showInfo(String title, String content, String menu, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 输出文本信息
	 * @param msg 文本信息
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 */
	void showMessage(String msg, ISceneContext sceneContext, Object dataTag);
}
