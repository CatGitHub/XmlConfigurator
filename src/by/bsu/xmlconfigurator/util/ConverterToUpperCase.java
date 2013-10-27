package by.bsu.xmlconfigurator.util;

public final class ConverterToUpperCase {

    public static String firstCharacterToUpperCase(String param) {
        return Character.toUpperCase(param.charAt(0)) + param.substring(1);
    }
}
