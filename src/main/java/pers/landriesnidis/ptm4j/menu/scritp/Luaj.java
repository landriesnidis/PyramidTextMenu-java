package pers.landriesnidis.ptm4j.menu.scritp;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.jse.JsePlatform;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.scritp.exception.MenuScriptException;

public class Luaj {
	
	/**
	 * 通过指定的Lua脚本创建TextMenu对象
	 * 该方法会读取脚本文件并从脚本中执行名为`create()`的方法（`create()`返回一个TextMenu对象）
	 * @param fileName 脚本文件路径
	 * @return TextMenu对象
	 * @throws MenuScriptException 
	 */
	public static TextMenu createTextMenuFromScriptFile(String fileName) throws MenuScriptException{
		return createTextMenuFromScriptFile(fileName,null);
	}
	
	/**
	 * 通过指定的Lua脚本创建TextMenu对象
	 * 该方法会读取脚本文件并从脚本中执行名为`create()`的方法（`create()`返回一个TextMenu对象）
	 * @param fileName 脚本文件路径
	 * @param libs	自定义库
	 * @return TextMenu对象
	 * @throws MenuScriptException 
	 */
	public static TextMenu createTextMenuFromScriptFile(String fileName,TwoArgFunction[] libs) throws MenuScriptException{
		// lua脚本文件所在路径
		Globals globals = JsePlatform.standardGlobals();
		
		// 加载自定义函数 库
		if(libs!=null){
			for(TwoArgFunction lib:libs){
				globals.load(lib);
			}
	        LoadState.install(globals);
		}
		
		// 加载脚本文件并编译
		globals.loadfile(fileName).call();
		// 获取函数
		LuaValue func = globals.get(LuaValue.valueOf("create"));
		// 判断函数是否存在
		if(func == LuaValue.NIL){
			throw new MenuScriptException(fileName, "method `create` does not exist.");
		}
		// 执行create()方法获取TextMenu对象
		LuaValue luaResualt = func.call();
		TextMenu menu = (TextMenu) luaResualt.checkuserdata(TextMenu.class);
		return menu;
	}
	
	
	
	
}
