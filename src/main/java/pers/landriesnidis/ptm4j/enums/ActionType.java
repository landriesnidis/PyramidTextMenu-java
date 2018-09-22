package pers.landriesnidis.ptm4j.enums;

/**
 * 动作类型
 * @author Landriesnidis
 */
public enum ActionType {
	//返回固定的文本信息
	TEXT,		
	//打开指定TextMenu
	MENU,		
	//打开指定TextMenu并传入参数
	MENU_ARGS,	
	//返回上一级应TextMenu（销毁当前TextMenu）
	BACK,		
	//返回到根TextMenu首页
	BACK_ROOT,	
	//重新加载当前TextMenu
	RELOAD		
}
