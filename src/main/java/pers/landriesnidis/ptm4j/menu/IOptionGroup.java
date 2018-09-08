package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.option.Option;

public interface IOptionGroup {
	/**
	 * 添加选项
	 * @param option
	 */
	void addOption(Option option);
	/**
	 * 添加一个文本类型选项
	 * @param keyword
	 * @param content
	 */
	void addTextOption(String keyword, String content);
	/**
	 *  添加子菜单选项
	 * @param keyword
	 * @param classMenu
	 */
	void addMenuOption(String keyword, Class<? extends TextMenu> classMenu);
	/**
	 * 添加可接受参数的菜单选项
	 * @param keyword
	 * @param classMenu
	 */
	void addArgsMenuOption(String keyword, Class<? extends TextMenu> classMenu);
	/**
	 * 添加返回上一层菜单的选项
	 * @param keyword
	 */
	void addBackOption(String keyword);
	/**
	 * 添加返回根菜单的选项
	 * @param keyword
	 */
	void addBackRootOption(String keyword);
	/**
	 * 添加重新加载菜单的选择
	 * @param keyword
	 */
	void addReloadOption(String keyword);
	/**
	 * 添加一行不能被选的文本
	 * @param text
	 */
	public void addTextLine(String text);
	/**
	 * 移除选项
	 * @param option
	 */
	void removeOption(Option option);
	/**
	 * 通过关键字移除选项
	 * @param keyword
	 */
	void removeOptionByKeyword(String keyword);
	
}
