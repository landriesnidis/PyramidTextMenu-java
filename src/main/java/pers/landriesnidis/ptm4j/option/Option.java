package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class Option implements IOption {
	// 触发动作的关键字
	private String keyWord;
	// 动作类型
	private ActionType type;
	// 所属的菜单对象
	private TextMenu menuContext;
	// 文本类信息（对应ActionType:TEXT）
	private String textContent;
	// 触发的下级菜单类型（仅对应ActionType:MENU,MENU_ARGS）
	private Class<? extends TextMenu> menuClass;
	// 触发的下级菜单对象
	private TextMenu menuObject;
	// 准备执行的处理程序
	private OptionHandler preparatoryExecuteHandler;
	// 是否可选
	private Boolean optional = true;

	public Option(TextMenu menuContext) {
		this.menuContext = menuContext;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public ActionType getActionType() {
		return type;
	}

	public void setActionType(ActionType type) {
		this.type = type;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public Class<? extends TextMenu> getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(Class<? extends TextMenu> menuClass) {
		this.menuClass = menuClass;
	}
	
	public TextMenu getMenuObject() {
		return menuObject;
	}

	public void setMenuObject(TextMenu menuObject) {
		this.menuObject = menuObject;
	}
	
	public TextMenu getMenuContext() {
		return menuContext;
	}
	
	public void setPreparatoryExecuteHandler(OptionHandler preparatoryExecuteHandler) {
		this.preparatoryExecuteHandler = preparatoryExecuteHandler;
	}
	
	public OptionHandler getPreparatoryExecuteHandler() {
		return preparatoryExecuteHandler;
	}
	
	public Boolean getOptional() {
		return optional;
	}
	
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public void execute(String text, ISceneContext sceneContext, Object dataTag) {
		// 获取所处菜单
		TextMenu menu = this.getMenuContext();
		// 检查可用状态
		if(!this.optional)return;
		// 执行预处理回调方法
		if(this.preparatoryExecuteHandler!=null && !this.preparatoryExecuteHandler.preparatoryExecuteHandle(text, sceneContext, dataTag, this)) return;
		// 根据动作类型执行操作
		switch (getActionType()) {
		case TEXT:
			if(getTextContent()!=null)sceneContext.output(getTextContent(), menu.getMenuContext(), sceneContext, dataTag);
			break;
		case MENU:
			if(menuObject!=null){
				sceneContext.startMenu(menuObject, this);
			}else{
				sceneContext.startMenu(createTextMenuObject(getMenuClass()), this);
			}
			break;
		case MENU_ARGS:
			if(menuObject!=null){
				
			}else{
				sceneContext.startMenu(menuObject, this, text.split(" "));
			}
			break;
		case BACK:
			sceneContext.returnToPreviousMenu(this, text.contains(" ")?text.split(" "):null);
			break;
		case BACK_ROOT:
			sceneContext.returnToRootMenu(this);
			break;
		case RELOAD:
			sceneContext.reloadMenu(text.split(" "));
			break;
		default:
			
		}
	}
	
	public final static TextMenu createTextMenuObject(Class<? extends TextMenu> menuClass){
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
