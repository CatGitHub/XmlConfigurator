package by.bsu.xmlconfigurator.main;

import by.bsu.xmlconfigurator.configurations.WindowConfiguration;
import by.bsu.xmlconfigurator.configurations.WindowConfigurationWthoutType;
import by.bsu.xmlconfigurator.configurator.PropertyConfigurator;
import by.bsu.xmlconfigurator.configurator.PropertyConfiguratorWithoutType;
import by.bsu.xmlconfigurator.constants.CommonConstants;
import by.bsu.xmlconfigurator.exceptions.LogicException;
import by.bsu.xmlconfigurator.parsers.parserdom.DomParser;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlConfigurator {

    public static void main(String[] args) {
        DomParser domParser = DomParser.getInstance();  
        ////varian1
        try {
            PropertyConfiguratorWithoutType configurator = PropertyConfiguratorWithoutType.getInstance();
            WindowConfigurationWthoutType configuration = (WindowConfigurationWthoutType) configurator.configure(CommonConstants.NAME_FILE_XML, "by.bsu.xmlconfigurator.configurations.WindowConfigurationWthoutType");
            System.out.println("heigth: " + configuration.getHeigth());
            System.out.println("width: " + configuration.getWidth());
            System.out.println("depth: " + configuration.getDepth());
        } catch (LogicException ex) {
            Logger.getLogger(XmlConfigurator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           ////varian2
        try {
            PropertyConfigurator configurator = PropertyConfigurator.getInstance();
            WindowConfiguration configuration =  configurator.configure(CommonConstants.NAME_FILE_XML);
            System.out.println("heigth: " + configuration.getHeigth());
            System.out.println("width: " + configuration.getWidth());
            System.out.println("depth: " + configuration.getDepth());
        } catch (LogicException ex) {
            Logger.getLogger(XmlConfigurator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
