package by.bsu.xmlconfigurator.parsers.parserdom;

import by.bsu.xmlconfigurator.exceptions.LogicException;

import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public final class DomParser {

    private final static DomParser instance = new DomParser();

    private DomParser() {
    }

    public static DomParser getInstance() {
        return instance;
    }


    public Map<String, String> parse(String fileName) throws LogicException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            Element root = document.getDocumentElement();
            Map<String, String> configurations = Analyzer.buildList(root);
            return configurations;
        } catch (SAXException e) {
            throw new LogicException(e);
        } catch (ParserConfigurationException e) {
            throw new LogicException(e);
        } catch (IOException e) {
            throw new LogicException(e);
        }
    }
}
