package pers.landriesnidis.ptm4j.scene.io;

import pers.landriesnidis.ptm4j.menu.TextMenuReader;

public interface SceneReader {
	void output(String text, TextMenuReader textMenuReader, Object dataTag);
}
