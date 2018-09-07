package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class Event {
	private ISceneContext context;
	private String keyword;
	
	public Event(ISceneContext context) {
		this.context = context;
	}
	
	public ISceneContext getContext() {
		return context;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
