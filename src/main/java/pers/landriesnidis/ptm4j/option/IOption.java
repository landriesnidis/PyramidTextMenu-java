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
	
	public String getKeyWord();

	public void setKeyWord(String keyWord);
	
	public ActionType getActionType();

	public void setActionType(ActionType type);
	
	public Boolean getOptional();
	
	public void setOptional(Boolean optional);

	public String getTextContent();

	public void setTextContent(String textContent);

	public Class<? extends TextMenu> getMenuClass();

	public void setMenuClass(Class<? extends TextMenu> menuClass);
	
	public TextMenu getMenuObject();
	
	public void setMenuObject(TextMenu menuObject);
	
	public TextMenu getMenuContext();
	
	public void setPreparatoryExecuteHandler(OptionHandler preparatoryExecuteHandler);
	
	public OptionHandler getPreparatoryExecuteHandler();
	

}
