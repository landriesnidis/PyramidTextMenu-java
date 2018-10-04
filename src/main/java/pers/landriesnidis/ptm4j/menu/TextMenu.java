package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.menu.base.BasicTextMenu;

/**
 * TextMenu
 * 文本菜单/目录类型
 * @see pers.landriesnidis.ptm4j.menu.base.IBasicTextMenu
 * @see pers.landriesnidis.ptm4j.menu.base.IOptionGroup
 * @see pers.landriesnidis.ptm4j.menu.base.IMenuLifeCycle
 * @see pers.landriesnidis.ptm4j.menu.context.IMenuContext
 * @author Landriesnidis
 */
public class TextMenu extends BasicTextMenu{

	public final static TextMenu createTextMenuObject(Class<? extends BasicTextMenu> menuClass){
		try {
			try {
				return (TextMenu) Class.forName(menuClass.getName()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
