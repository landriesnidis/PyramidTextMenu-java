package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.option.Option;

/**
 * TextMenu选项组接口
 * @author Landriesnidis
 */
public interface IOptionGroup {
	/**
	 * 添加一个Option对象到所属TextMenu的选项组中
	 * @param option Option对象
	 */
	void addOption(Option option);
	
	/**
	 * 添加一个文本类型的选项
	 * @param keyword Option对象的关键字
	 * @param content 文本内容
	 */
	void addTextOption(String keyword, String content);
	
	/**
	 * 添加一个打开TextMenu类型的选项（指定TextMenu Class）
	 * @param keyword Option对象的关键字
	 * @param classMenu 继承于TextMenu的Class
	 */
	void addMenuOption(String keyword, Class<? extends TextMenu> classMenu);
	
	/**
	 * 添加一个打开TextMenu类型的选项（给定一个TextMenu对象）
	 * @param keyword Option对象的关键字
	 * @param menuObject 继承于TextMenu的类的对象
	 */
	void addMenuOption(String keyword, TextMenu menuObject);
	
	/**
	 * 添加可接受参数的子TextMenuOption（指定TextMenu类型）
	 * @param keyword Option对象的关键字
	 * @param classMenu 继承于TextMenu的Class
	 */
	void addArgsMenuOption(String keyword, Class<? extends TextMenu> classMenu);
	
	/**
	 * 添加可接受参数的子TextMenuOption（指定TextMenu对象）
	 * @param keyword Option对象的关键字
	 * @param menuObject 继承于TextMenu的类的对象
	 */
	void addArgsMenuOption(String keyword, TextMenu menuObject);
	
	/**
	 * 添加返回上一层TextMenu的Option
	 * @param keyword Option对象的关键字
	 */
	void addBackOption(String keyword);
	
	/**
	 * 添加返回根TextMenu的Option
	 * @param keyword Option对象的关键字
	 */
	void addBackRootOption(String keyword);
	
	/**
	 * 添加重新加载TextMenu的选择
	 * @param keyword Option对象的关键字
	 */
	void addReloadOption(String keyword);
	
	/**
	 * 添加一个分割线
	 * 分割线的本质是一个文本类型的Option，并设置的可选性为false
	 */
	void addTextLine();
	
	/**
	 * 添加一条指定文本内容的Option分割线
	 * @param text 分割线
	 */
	void addTextLine(String text);
	
	/**
	 * 移除Option
	 * @param option 要移除的Option对象
	 */
	void removeOption(Option option);
	
	/**
	 * 通过关键字移除Option
	 * @param keyword Option对象的关键字
	 */
	void removeOptionByKeyword(String keyword);
	
}
