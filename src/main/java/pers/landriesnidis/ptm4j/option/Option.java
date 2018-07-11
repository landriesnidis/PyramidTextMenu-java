package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.BaseTextMenu;
import pers.landriesnidis.ptm4j.scene.Scene;

public class Option implements IOption {
	// 触发动作的关键字
	private String keyWord;
	// 动作类型
	private ActionType type;
	// 所属的菜单对象
	private BaseTextMenu menuContext;

	// 文本类信息（对应ActionType:TEXT）
	private String textContent;
	// 触发的下级菜单（仅对应ActionType:MENU,MENU_ARGS）
	private Class<? extends BaseTextMenu> menuClass;

	public Option(BaseTextMenu menuContext) {
		this.menuContext = menuContext;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public Class<? extends BaseTextMenu> getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(Class<? extends BaseTextMenu> menuClass) {
		this.menuClass = menuClass;
	}

	public BaseTextMenu getMenuContext() {
		return menuContext;
	}

	public void execute(String text) {
		// 获取所处菜单
		BaseTextMenu menu = this.getMenuContext();
		// 获取所处场景
		Scene scene = menu.getScene();

		//根据动作类型执行操作
		switch (getType()) {
		case TEXT:
			scene.output(getTextContent());
			break;
		case MENU:
			scene.startMenu(createTextMenuObject(getMenuClass()), this);
			break;
		case MENU_ARGS:
			scene.startMenu(createTextMenuObject(getMenuClass()), this, text.split(" "));
			break;
		case BACK:
			scene.returnToPreviousMenu(this);
			break;
		case BACK_HOME:
			scene.returnToRootMenu(this);
			break;
		case RELOAD:

			break;
		}
	}
	public static BaseTextMenu createTextMenuObject(Class<? extends BaseTextMenu> menuClass){
		try {
			try {
				return (BaseTextMenu) Class.forName(menuClass.getName()).newInstance();
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
