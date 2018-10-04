package pers.landriesnidis.ptm4j.scene.base;

import pers.landriesnidis.ptm4j.scene.io.SceneReader;
import pers.landriesnidis.ptm4j.scene.io.SceneWriter;

/**
 * Scene会话环境接口
 * @see pers.landriesnidis.ptm4j.scene.base.IMenuTruns
 * @see pers.landriesnidis.ptm4j.scene.io.SceneWriter
 * @see pers.landriesnidis.ptm4j.scene.io.SceneReader
 * @author Landriesnidis
 *
 */
public interface ISceneContext extends IMenuTruns,SceneReader,SceneWriter{
}
