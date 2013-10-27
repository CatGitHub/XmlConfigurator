package by.bsu.xmlconfigurator.configurator;

import by.bsu.xmlconfigurator.exceptions.LogicException;
import by.bsu.xmlconfigurator.parsers.parserdom.DomParser;
import by.bsu.xmlconfigurator.util.ConverterToUpperCase;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class PropertyConfiguratorWithoutType {

    private final static PropertyConfiguratorWithoutType instance = new PropertyConfiguratorWithoutType();

    private PropertyConfiguratorWithoutType() {
    }

    public static PropertyConfiguratorWithoutType getInstance() {
        return instance;
    }

    public Object configure(String fileName, String className) throws LogicException {
        DomParser domParser = DomParser.getInstance();
        Map<String, String> configurations = domParser.parse(fileName);
        try {
            Class cls = Class.forName(className);
            Object obj = cls.newInstance();
            Set<String> params = configurations.keySet();
            Class[] paramString = new Class[1];
            paramString[0] = String.class;
            for (String param : params) {
                Method method = cls.getDeclaredMethod("set" + ConverterToUpperCase.firstCharacterToUpperCase(param), paramString);
                method.invoke(obj, configurations.get(param));
            }
            return obj;
        } catch (Exception ex) {
            throw new LogicException(ex);
        }
    }
}
