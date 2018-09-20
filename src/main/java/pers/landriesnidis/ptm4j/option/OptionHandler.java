package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface OptionHandler {
	/**
	 * 执行前的预处理程序
	 * @param text 接收到文本信息
	 * @param optionContext 正在执行的选择项对象
	 * @return 返回true则继续执行Option的触发事件，返回false则不会触发Option的事件
	 */
	boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext);
}
