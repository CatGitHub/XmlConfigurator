package by.bsu.xmlconfigurator.configurator;

import by.bsu.xmlconfigurator.configurations.WindowConfiguration;
import by.bsu.xmlconfigurator.exceptions.LogicException;
import by.bsu.xmlconfigurator.parsers.parserdom.DomParser;
import java.util.Map;

public class PropertyConfigurator {

    private final static PropertyConfigurator instance = new PropertyConfigurator();

    private PropertyConfigurator() {
    }

    public static PropertyConfigurator getInstance() {
        return instance;
    }

    public WindowConfiguration configure(String fileName) throws LogicException {
        DomParser domParser = DomParser.getInstance();
        Map<String, String> configurations = domParser.parse(fileName);
        WindowConfiguration configuration = new WindowConfiguration();
        try {
            configuration.setDepth(Double.parseDouble(configurations.get("depth")));
            configuration.setWidth(Double.parseDouble(configurations.get("width")));
            configuration.setHeigth(Double.parseDouble(configurations.get("heigth")));

            return configuration;
        } catch (Exception ex) {
            throw new LogicException(ex);
        }
    }
}
