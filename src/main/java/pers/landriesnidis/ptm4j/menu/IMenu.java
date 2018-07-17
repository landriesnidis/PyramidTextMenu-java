package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.option.Option;

public interface IMenu {
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
	void addMenuOption(String keyword, Class<? extends BaseTextMenu> classMenu);
	/**
	 * 添加可接受参数的菜单选项
	 * @param keyword
	 * @param classMenu
	 */
	void addArgsMenuOption(String keyword, Class<? extends BaseTextMenu> classMenu);
	/**
	 * 添加返回上一层菜单的选项
	 * @param keyword
	 */
	void addBackOption(String keyword);
	/**
	 * 添加重新加载菜单的选择
	 * @param keyword
	 */
	void addReloadOption(String keyword);
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
	
	/**
	 * 根据序号获取选项对象
	 * @param index
	 */
	Option getOption(int index);
	/**
	 * 根据关键字获取选项对象
	 * @param optionKeyword
	 */
	Option getOption(String optionKeyword);
	
	/**
	 * 根据输入内容选择选项
	 * @param text
	 * @return
	 */
	boolean selectOption(String text);
	
	/**
	 * 显示菜单信息
	 */
	void showMenu();
	/**
	 * 显示格式化信息
	 * @param title
	 * @param content
	 * @param menu
	 */
	void showInfo(String title, String content, String menu);
	/**
	 * 显示
	 * @param msg
	 */
	void showMessage(String msg);
	/**
	 * 当接收到用户输入的信息（当菜单设置允许接收信息时才会被执行）
	 * @param text
	 * @return
	 */
	boolean onTextReveived(String text);
}
