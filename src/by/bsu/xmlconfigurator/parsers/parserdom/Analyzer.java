package by.bsu.xmlconfigurator.parsers.parserdom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class Analyzer {

    static Map<String, String> buildList(Element root) throws SAXException, IOException {
        Map<String, String> configurations = new HashMap<String, String>();

        NodeList categoryNodes = root.getChildNodes();
        int categoryNumber = categoryNodes.getLength();
        for (int i = 1; i < categoryNumber; i += 2) {
            Node node = categoryNodes.item(i);

            String name = node.getNodeName();
            NodeList nlist = node.getChildNodes();
            String value = nlist.item(0).getNodeValue();
           
            configurations.put(name, value);
        }
        return configurations;
    }
}
