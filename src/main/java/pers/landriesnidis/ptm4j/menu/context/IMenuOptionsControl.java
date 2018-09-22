package pers.landriesnidis.ptm4j.menu.context;

import java.util.List;

import pers.landriesnidis.ptm4j.option.Option;

/**
 * TextMenu的Option组控制接口
 * @author Landriesnidis
 */
public interface IMenuOptionsControl {

	/**
	 * 根据序号获取Option对象
	 * @param index 索引
	 * @return Option组中第index+1个Option对象
	 */
	Option getOption(int index);
	
	/**
	 * 根据关键字获取Option对象
	 * @param keyword Option对象的关键字
	 * @return Option组中关键字相符为Option对象
	 */
	Option getOption(String keyword);
	
	/**
	 * 获取选项组中最后一条Option对象
	 * @return 最后一条Option对象
	 */
	Option getLastOption();
	
	/**
	 * 获取TextMenu的选项组
	 * @return TextMenu的选项组
	 */
	List<Option> getMenuOptions();
}
