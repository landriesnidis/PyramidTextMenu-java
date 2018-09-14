package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public interface IOption {
	/**
	 * 选择项执行内容
	 * @param text
	 */
	void execute(String text, ISceneContext sceneContext, Object dataTag);
	
	String getKeyWord();

	void setKeyWord(String keyWord);
	
	ActionType getActionType();

	void setActionType(ActionType type);
	
	boolean isOptional();
	
	void setOptional(Boolean optional);
	
	boolean isVisibility();
	
	void setVisibility(boolean visibility);

	String getTextContent();

	void setTextContent(String textContent);

	Class<? extends TextMenu> getMenuClass();

	void setMenuClass(Class<? extends TextMenu> menuClass);
	
	TextMenu getMenuObject();
	
	void setMenuObject(TextMenu menuObject);
	
	TextMenu getMenuContext();
	
	void setPreparatoryExecuteHandler(OptionHandler preparatoryExecuteHandler);
	
	OptionHandler getPreparatoryExecuteHandler();
	
}
