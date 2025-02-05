package com.parse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;

public class Parsing {

	public static void main(String[] args) {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src/new.xml");
			
//			getting the root Element
//			Element rootElement = doc.getDocumentElement();
//			rootElement.getTagName();
//			rootElement.getTextContent();
//			rootElement.getNodeName();
//			getNodeValue();
//			rootElement.TEXT_NODE  checks weather the node contains text
			
			NodeList nodes = doc.getElementsByTagName("book");
			
			for(int i =0; i<nodes.getLength(); i++) {
				
				Element ele = (Element) nodes.item(0);
				
				String title = ele.getElementsByTagName("title").item(0).getTextContent();  //item(0) Retrieves the first element from nodelist
				String author = ele.getElementsByTagName("author").item(0).getTextContent();
				String isbn = ele.getElementsByTagName("isbn").item(0).getTextContent();
                String publicationYear = ele.getElementsByTagName("publicationYear").item(0).getTextContent();
                String publisher = ele.getElementsByTagName("publisher").item(0).getTextContent();
                String price = ele.getElementsByTagName("price").item(0).getTextContent();
                
				 System.out.println("Book " + (i + 1) + ":");
	                System.out.println("\tTitle: " + title);
	                System.out.println("\tAuthor: " + author);
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






//
//
//
//package com.parse;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.w3c.dom.*;
//import java.sql.*;
//
//public class Parsing {
//
//    public static void main(String[] args) {
//
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//
//            // Setup the XML parsing
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse("src/new.xml");
//
//            // Establish database connection
//            String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
//            String user = "yourUsername";
//            String password = "yourPassword";
//            connection = DriverManager.getConnection(url, user, password);
//
//            // SQL query for inserting book records
//            String sql = "INSERT INTO books (title, author, isbn, publicationYear, publisher, price) VALUES (?, ?, ?, ?, ?, ?)";
//            statement = connection.prepareStatement(sql);
//
//            // Parse and insert XML data into the database
//            NodeList nodes = doc.getElementsByTagName("book");
//
//            for (int i = 0; i < nodes.getLength(); i++) {
//
//                Element ele = (Element) nodes.item(i);
//
//                String title = ele.getElementsByTagName("title").item(0).getTextContent();
//                String author = ele.getElementsByTagName("author").item(0).getTextContent();
//                String isbn = ele.getElementsByTagName("isbn").item(0).getTextContent();
//                String publicationYear = ele.getElementsByTagName("publicationYear").item(0).getTextContent();
//                String publisher = ele.getElementsByTagName("publisher").item(0).getTextContent();
//                String price = ele.getElementsByTagName("price").item(0).getTextContent();
//
//                // Set parameters for the SQL query
//                statement.setString(1, title);
//                statement.setString(2, author);
//                statement.setString(3, isbn);
//                statement.setString(4, publicationYear);
//                statement.setString(5, publisher);
//                statement.setString(6, price);
//
//                // Execute the insert
//                statement.executeUpdate();
//
//                System.out.println("Book " + (i + 1) + " added to the database.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the resources
//            if (statement != null) try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
//            if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
//        }
//    }
//}
//
