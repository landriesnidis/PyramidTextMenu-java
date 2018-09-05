package pers.landriesnidis.ptm4j.enums;

public enum ActionType {
	TEXT,		//返回固定的文本信息
	MENU,		//打开指定菜单
	MENU_ARGS,	//打开指定菜单并传入参数
	BACK,		//返回上一级应菜单（销毁当前菜单）
	BACK_ROOT,	//返回到根菜单首页
	RELOAD		//重新加载当前菜单
}
