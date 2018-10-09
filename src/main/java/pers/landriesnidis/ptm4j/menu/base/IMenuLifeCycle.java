package pers.landriesnidis.ptm4j.menu.base;

import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;

/**
 * TextMenu生命周期
 * @author Landriesnidis
 */
public interface IMenuLifeCycle {
	/**
	 * 当TextMenu对象创建时被触发
	 */
	void onCreate();
	
	/**
	 * 当TextMenu在Scene中加载时触发
	 * @param e 事件参数
	 */
	void onLoad(LoadEvent e);

	/**
	 * 当TextMenu开始执行时被触发
	 * 默认会执行showMenu()输出目录信息
	 * @param e 事件参数
	 */
	void onStart(StartEvent e);
	
	/**
	 * 当TextMenu被新TextMenu暂时覆盖时被触发
	 * @param e 事件参数
	 */
	void onStop(StopEvent e);
	
	/**
	 * 当TextMenu因为退回重新加载时被触发
	 * @param e 事件参数
	 */
	void onBack(BackEvent e);	
	
	/**
	 * 当TextMenu从Scene中卸载时被触发
	 */
	void onUnload();				
}
