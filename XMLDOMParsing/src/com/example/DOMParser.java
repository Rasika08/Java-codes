package com.example;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParser {
    public static void main(String[] args) {
        try {
            // 1. Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 2. Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 3. Parse the XML file and create a Document object
            Document document = builder.parse("src/library.xml");

            // 4. Normalize the XML structure
            document.getDocumentElement().normalize();

            // 5. Get all <book> elements
            NodeList nodeList = document.getElementsByTagName("book");

            // 6. Loop through each <book> element and print the details
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element bookElement = (Element) nodeList.item(i);

                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String isbn = bookElement.getElementsByTagName("isbn").item(0).getTextContent();
                String publicationYear = bookElement.getElementsByTagName("publicationYear").item(0).getTextContent();
                String publisher = bookElement.getElementsByTagName("publisher").item(0).getTextContent();
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Book " + (i + 1) + ":");
                System.out.println("\tTitle: " + title);
                System.out.println("\tAuthor: " + author);
                System.out.println("\tISBN: " + isbn);
                System.out.println("\tPublication Year: " + publicationYear);
                System.out.println("\tPublisher: " + publisher);
                System.out.println("\tPrice: " + price);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
