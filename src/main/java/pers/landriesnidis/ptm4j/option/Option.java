package pers.landriesnidis.ptm4j.option;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.base.BasicTextMenu;
import pers.landriesnidis.ptm4j.option.base.BasicOption;

/**
 * TextMenu选项类
 * @see pers.landriesnidis.ptm4j.option.base.IBasicOption
 * @author Landriesnidis
 */
public class Option extends BasicOption {

	public Option(TextMenu menuContext) {
		super(menuContext);
	}
	
	public Option(BasicTextMenu menuContext) {
		super((TextMenu) menuContext);
	}

}
