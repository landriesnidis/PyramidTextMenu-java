package pers.landriesnidis.ptm4j.scene.io;

/**
 * Scene信息输入接口
 * @author Landriesnidis
 *
 */
public interface SceneWriter {
	/**
	 * 向Scene中输入文本信息
	 * @param text 文本信息
	 * @param dataTag 对Scene的一次I/O中传递的标识参数
	 * @return 文本信息是否有效
	 */
	boolean input(String text, Object dataTag);
}
