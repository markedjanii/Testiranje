package org.example.testdome;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> folders = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        Document document = builder.parse(is);
        NodeList folderElements = document.getElementsByTagName("folder");
        for (int i = 0; i < folderElements.getLength(); i++) {
            Node folderNode = folderElements.item(i);
            String folderName = folderNode.getAttributes().getNamedItem("name").getNodeValue();
            if (folderName.startsWith(String.valueOf(startingLetter))) {
                folders.add(folderName);
            }
        }
        return folders;
    }

    public static void main(String[] args) throws Exception {
        String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                "<folder name=\"program files\">" +
                "<folder name=\"uninstall information\" />" +
                "</folder>" +
                "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}