package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * Option接口
 * @author Landriesnidis
 */
public interface IOption {
	
	/**
	 * 执行Option对象的预设功能
	 * @param text 文本信息
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 */
	void execute(String text, ISceneContext sceneContext, Object dataTag);
	
	/**
	 * 获取Option对象的关键字
	 * @return Option对象的关键字
	 */
	String getKeyWord();

	/**
	 * 设置Option对象的关键字
	 * @param keyWord 关键字
	 */
	void setKeyWord(String keyWord);
	
	/**
	 * 获取Option对象的动作类型
	 * @return Option对象的动作类型
	 */
	ActionType getActionType();

	/**
	 * 设置Option对象的动作类型
	 * @param type 动作类型
	 */
	void setActionType(ActionType type);
	
	/**
	 * 判断Option对象的可选性
	 * @return Option对象的可选性
	 */
	boolean isOptional();
	
	/**
	 * 设置Option对象的可选性
	 * @param optional 可选性
	 */
	void setOptional(Boolean optional);
	
	/**
	 * 判断Option对象的可见性
	 * @return Option对象的可见性
	 */
	boolean isVisibility();
	
	/**
	 * 设置Option对象的可见性
	 * @param visibility 可见性
	 */
	void setVisibility(boolean visibility);

	/**
	 * 获取Option对象的文本内容
	 * @return Option对象的文本内容
	 */
	String getTextContent();

	/**
	 * 设置Option对象的文本内容
	 * @param textContent 文本内容
	 */
	void setTextContent(String textContent);

	/**
	 * 获取指定启动的TextMenu类(子类)
	 * 此方法仅在Option的ActionType为MENU或MENU_ARGS时有效。
	 * @return 指定启动的TextMenu类(子类)
	 */
	Class<? extends TextMenu> getMenuClass();

	/**
	 * 设置指定启动的TextMenu类(子类)
	 * 此方法仅在Option的ActionType为MENU或MENU_ARGS时有效。
	 * @param menuClass TextMenu类(子类)
	 */
	void setMenuClass(Class<? extends TextMenu> menuClass);
	
	/**
	 * 获取指定启动的TextMenu类型(或子类型)对象
	 * 此方法仅在Option的ActionType为MENU或MENU_ARGS时有效。
	 * @return 指定启动的TextMenu类型(或子类型)对象
	 */
	TextMenu getMenuObject();
	
	/**
	 * 设置指定启动的TextMenu类型(或子类型)对象
	 * 此方法仅在Option的ActionType为MENU或MENU_ARGS时有效。
	 * @param menuObject TextMenu类型(或子类型)对象
	 */
	void setMenuObject(TextMenu menuObject);
	
	/**
	 * 获取Option对象所属TextMenu的会话环境
	 * @return TextMenu会话环境
	 */
	TextMenu getMenuContext();
	
	/**
	 * 设置Option的预处理程序
	 * @param preparatoryExecuteHandler Option的预处理程序
	 */
	void setPreparatoryExecuteHandler(OptionHandler preparatoryExecuteHandler);
	
	/**
	 * 获取Option的预处理程序
	 * @return Option的预处理程序
	 */
	OptionHandler getPreparatoryExecuteHandler();
	
}
