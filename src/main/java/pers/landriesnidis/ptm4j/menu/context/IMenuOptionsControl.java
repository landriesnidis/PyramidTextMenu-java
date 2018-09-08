package pers.landriesnidis.ptm4j.menu.context;

import java.util.List;

import pers.landriesnidis.ptm4j.option.Option;

public interface IMenuOptionsControl {
	/**
	 * 根据序号获取选项对象
	 * @param index
	 */
	Option getOption(int index);
	
	/**
	 * 根据关键字获取选项对象
	 * @param text
	 */
	Option getOption(String text);
	
	/**
	 * 获取选项组中最后一条选项对象
	 * @return
	 */
	Option getLastOption();
	
	/**
	 * 获取选项组
	 * @return
	 */
	List<Option> getMenuOptions();
}
