package pers.landriesnidis.ptm4j.scene.io;

import pers.landriesnidis.ptm4j.menu.TextMenuReader;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface SceneReader {
	/**
	 * 从场景中输出文本信息
	 * @param text 文本信息
	 * @param textMenuReader 文本菜单信息读取器
	 * @param scene
	 */
	void output(String text, TextMenuReader textMenuReader, ISceneContext context, Object dataTag);
}
