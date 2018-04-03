package test.io;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * aio、bio、nio
 * https://blog.csdn.net/anxpp/article/details/51512200
 */
public class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}
