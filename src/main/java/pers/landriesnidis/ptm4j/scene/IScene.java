package pers.landriesnidis.ptm4j.scene;

import pers.landriesnidis.ptm4j.menu.BaseTextMenu;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public interface IScene {
	
	/** 
	 * 启动一个新菜单
	 * @param menu
	 */
	void startMenu(BaseTextMenu menu, Option option);
	/**
	 * 启动一个带参数的新菜单
	 * @param option
	 * @param args
	 */
	void startMenu(BaseTextMenu menu, Option option, String[] args);
	/**
	 * 返回到上一层菜单
	 */
	void returnToPreviousMenu(Option option);
	/**
	 * 返回上一层菜单（携带参数）
	 * @param args
	 */
	void returnToPreviousMenu(Option option, String[] args);
	/**
	 * 返回根目录
	 */
	void returnToRootMenu(Option option);
	
	/**
	 * 获取场景信息写入器
	 * @return
	 */
	SceneWirter getSceneWirter();
}
