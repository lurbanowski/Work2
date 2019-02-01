package pl.urbanowski.Main;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            File inputFile = new File("/home/lukasz/Dokumenty/CodersLabs/Work2/src/main/file/sms.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("sms");
            System.out.println("----------------------------");

            File file2 = new File("/home/lukasz/Dokumenty/CodersLabs/Work2/src/main/file/1.txt");
            PrintWriter zapis = new PrintWriter("/home/lukasz/Dokumenty/CodersLabs/Work2/src/main/file/1.txt");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                zapis.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Numer nadawcy : " + eElement.getAttribute("address"));
                    zapis.println("Numer nadawcy : " + eElement.getAttribute("address"));
                    System.out.println("Treść : " + eElement.getAttribute("body"));
                    zapis.println("Treść : " + eElement.getAttribute("body"));
                    System.out.println("Nadawca :" + eElement.getAttribute("contact_name"));
                    zapis.println("Nadawca :" + eElement.getAttribute("contact_name"));
                    System.out.println("Data : " + eElement.getAttribute("readable_date"));
                    zapis.println("Data : " + eElement.getAttribute("readable_date"));
                }
            }

            zapis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}