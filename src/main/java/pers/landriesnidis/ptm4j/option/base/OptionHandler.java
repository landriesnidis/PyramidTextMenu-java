package pers.landriesnidis.ptm4j.option.base;

import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * Option处理程序接口
 * @author Landriesnidis
 */
public interface OptionHandler {
	/**
	 * 执行前的预处理程序
	 * @param text 接收到文本信息
	 * @param sceneContext Scene会话环境
	 * @param dataTag sceneContext Scene会话环境
	 * @param optionContext 正在执行的Option对象
	 * @return 返回true则继续执行Option的触发事件，返回false则不会触发Option的事件
	 */
	boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext);
}
