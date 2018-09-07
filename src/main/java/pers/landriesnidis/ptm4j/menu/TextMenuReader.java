package pers.landriesnidis.ptm4j.menu;

import java.util.List;

import pers.landriesnidis.ptm4j.option.Option;

public interface TextMenuReader {
	/**
	 * 获取选项组
	 * @return
	 */
	List<Option> getMenuOptions();
	
	/**
	 * 获取标题
	 * @return
	 */
	String getMenuTitle();
	
	/**
	 * 获取正文内容
	 * @return
	 */
	String getMenuTextContent();
}
