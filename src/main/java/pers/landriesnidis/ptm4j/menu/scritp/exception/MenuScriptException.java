package pers.landriesnidis.ptm4j.menu.scritp.exception;

/**
 * TextMenu脚本异常
 * @author Landriesnidis
 */
public class MenuScriptException extends Exception{
	private static final long serialVersionUID = 1L;

	public MenuScriptException(String filePath, String info) {
		super(String.format("%s : %s", filePath, info));
	}
}
