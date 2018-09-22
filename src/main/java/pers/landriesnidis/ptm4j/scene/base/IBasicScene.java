package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWriter;

/**
 * 基本会话场景接口
 * @author Landriesnidis
 */
public interface IBasicScene {
	/**
	 * 获取Scene信息写入器
	 * @return Scene信息写入器
	 */
	SceneWriter getSceneWriter();
	
	/**
	 * 设置Scene信息读取器
	 * @param reader Scene信息读取器
	 */
	void setSceneReader(SceneReader reader);
	
	/**
	 * 获取Scene的会话环境
	 * @return Scene会话环境
	 */
	ISceneContext getSceneContext();
}
