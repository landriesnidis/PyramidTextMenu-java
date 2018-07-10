package pers.landriesnidis.ptm4j.menu;

import java.util.ArrayList;
import java.util.List;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.scene.Scene;
import pers.landriesnidis.ptm4j.scene.io.SceneWirter;

public class BaseTextMenu implements IMenuIifeCycle, IMenu{

	//所处的场景
	private Scene scene;
	//上一级菜单
	private BaseTextMenu previousMenu;
	//
	private List<Option> options;
	//
	private String textContent;
	
	public BaseTextMenu() {
		options = new ArrayList<Option>();
		onCreate();
	}
	
	public void onCreate() {
		
	}

	public void onLoad(LoadEvent e) {
		
	}

	public void onStop(StopEvent e) {
		
	}

	public void onBack(BackEvent e) {
		
	}

	public void onDestroy() {
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BaseTextMenu getPreviousMenu() {
		return previousMenu;
	}

	public void setPreviousMenu(BaseTextMenu previousMenu) {
		this.previousMenu = previousMenu;
	}

	public void addOption(Option option) {
		options.add(option);
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public String getTextContent() {
		return textContent;
	}

	public void addTextOption(String keyword, String content) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setTextContent(content);
		option.setType(ActionType.TEXT);
		options.add(option);
	}

	public void addMenuOption(String keyword, Class<BaseTextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setType(ActionType.MENU);
		options.add(option);
	}

	public void addArgsMenuOption(String keyword, Class<BaseTextMenu> classMenu) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setMenuClass(classMenu);
		option.setType(ActionType.MENU_ARGS);
		options.add(option);
	}

	public void addBackOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setType(ActionType.BACK);
		options.add(option);
	}

	public void addReloadOption(String keyword) {
		Option option = new Option(this);
		option.setKeyWord(keyword);
		option.setType(ActionType.RELOAD);
		options.add(option);
	}

	public void removeOption(Option option) {
		
	}

	public void removeOptionByKeyword(String keyword) {
		
	}

	public boolean selectOption(int index) {
		
		return false;
	}

	public boolean selectOption(String optionKeyword) {
		
		return false;
	}

	public void showMenu() {
		
	}

	public void showInfo(String title, String content, String menu) {
		
	}

	public void showMessage(String msg) {
		
	}
}
