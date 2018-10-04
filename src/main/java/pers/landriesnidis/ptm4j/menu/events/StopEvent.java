package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * 暂停事件类型
 * @see BaseEvent
 * @author Landriesnidis
 *
 */
public class StopEvent extends BaseEvent{

	public StopEvent(ISceneContext sceneContext) {
		super(sceneContext);
	}

}
