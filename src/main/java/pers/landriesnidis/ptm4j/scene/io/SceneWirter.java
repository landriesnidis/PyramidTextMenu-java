package pers.landriesnidis.ptm4j.scene.io;

public interface SceneWirter {
	/**
	 * 向Scene中输入文本信息
	 * @param text
	 * @return 信息无法识别则返回false
	 */
	boolean input(String text, Object dataTag);
}
