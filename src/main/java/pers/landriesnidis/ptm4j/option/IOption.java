package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface IOption {
	/**
	 * 选择项执行内容
	 * @param text
	 */
	void execute(String text, ISceneContext sceneContext, Object dataTag);
}
