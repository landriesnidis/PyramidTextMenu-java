package pers.landriesnidis.ptm4j.scene.io;

import pers.landriesnidis.ptm4j.menu.context.IMenuContext;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * Scene信息输出接口
 * @author Landriesnidis
 *
 */
public interface SceneReader {
	/**
	 * 从Scene中输出文本信息
	 * @param text 文本信息
	 * @param menuContext TextMenu会话环境
	 * @param sceneContext Scene会话环境
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 */
	void output(String text, IMenuContext menuContext, ISceneContext sceneContext, Object dataTag);
}
