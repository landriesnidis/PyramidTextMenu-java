package pers.landriesnidis.ptm4j.menu.context;

import java.util.List;

import pers.landriesnidis.ptm4j.option.Option;

public interface IMenuOptionsControl {
	/**
	 * 根据序号获取Option对象
	 * @param index 索引
	 */
	Option getOption(int index);
	
	/**
	 * 根据关键字获取Option对象
	 * @param keyword Option的关键字
	 */
	Option getOption(String keyword);
	
	/**
	 * 获取选项组中最后一条Option对象
	 * @return 最后一条Option对象
	 */
	Option getLastOption();
	
	/**
	 * 获取TextMenu的选项组
	 * @return 
	 */
	List<Option> getMenuOptions();
}
