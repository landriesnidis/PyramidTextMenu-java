package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.BaseTextMenu;

public class Option{
	//触发动作的关键字
	private String keyWord;	
	//动作类型
	private ActionType type;
	//所属的菜单对象 
	private BaseTextMenu menuContext;
	
	//文本类信息（对应ActionType:TEXT）
	private String textContent;
	//触发的下级菜单（仅对应ActionType:MENU,MENU_ARGS）
	private Class<BaseTextMenu> menuClass;
	
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

	public Class<BaseTextMenu> getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(Class<BaseTextMenu> menuClass) {
		this.menuClass = menuClass;
	}

	public BaseTextMenu getMenuContext() {
		return menuContext;
	}
	
	
}
 