package pers.landriesnidis.ptm4j.menu;

import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;

/**
 * 应用生命周期
 * @author Landriesnidis
 */
public interface IMenuIifeCycle {
	void onCreate();				//当菜单被创建
	void onLoad(LoadEvent e);		//当菜单被加载
	void onStart(StartEvent e);
	void onStop(StopEvent e);		//当菜单被新应用暂时覆盖
	void onBack(BackEvent e);		//当菜单因为退回重新加载时
	void onDestroy();				//当菜单被销毁
}
