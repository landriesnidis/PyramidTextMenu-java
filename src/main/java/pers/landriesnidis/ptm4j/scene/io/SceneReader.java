package pers.landriesnidis.ptm4j.scene.io;

import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface SceneReader {
	/**
	 * 从Scene中输出文本信息
	 * @param text 文本信息
	 * @param menuContext TextMenu会话环境
	 * @param scene
	 */
	void output(String text, IMenuContext menuContext, ISceneContext sceneContext, Object dataTag);
}
