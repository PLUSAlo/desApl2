package utng.dom;
import utng.data.*;
import utng.controller.*;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.*;

public class OrderDOM {
	private String pathFile = "C:\\Users\\Alondra\\Desktop\\Aplicaciones II\\workspace\\AGQUnidad2\\src\\utng\\data\\orders.xml";
	
	public void add(Order data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);

			Element orders = document.getDocumentElement();
			// Crear student tag
			Element order = document.createElement("order");

			// Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			order.appendChild(id);

			// Create name tag
			Element customerId = document.createElement("customerId");
			customerId.appendChild(document.createTextNode(String.valueOf(data.getCustomerId())));
			order.appendChild(customerId);

			// Create age tag
			Element shipName = document.createElement("shipName");
			shipName.appendChild(document.createTextNode(data.getShipName()));
			order.appendChild(shipName);
			
			Element shipAddress = document.createElement("shipAddress");
			shipAddress.appendChild(document.createTextNode(data.getShipAddress()));
			order.appendChild(shipAddress);
			
			

			orders.appendChild(order);

			DOMHelper.saveXMLContent(document, pathFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("order");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element order = (Element) nodeList.item(i);
				if (order.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					order.getParentNode().removeChild(order);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Order data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("order");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element order = (Element)nodeList.item(i);

				if (order.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					order.getElementsByTagName("customerId").item(0).setTextContent(String.valueOf(data.getCustomerId()));
					order.getElementsByTagName("shipName").item(0).setTextContent(data.getShipName());
					order.getElementsByTagName("shipAddress").item(0).setTextContent(data.getShipAddress());
				}
			}

			DOMHelper.saveXMLContent(document, pathFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Order findById(String id) {
		Order order = null;
		try {
			Document document= DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("order");
			for(int i=0; i<nodeList.getLength(); i++) {
				Element s= (Element)nodeList.item(i);
			if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)){
				order = new Order();
				order.setId(id);
				order.setCustomerId(Integer.parseInt(
						s.getElementsByTagName("customerId").item(0).getTextContent()));
				order.setShipName(
						s.getElementsByTagName("shipName").item(0).getTextContent());
				order.setShipAddress(
						s.getElementsByTagName("shipAddress").item(0).getTextContent());


			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public List<Order> getOrders(){
		List<Order> orders = new ArrayList<Order>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList= document.getElementsByTagName("order");
		
		for(int i=0; i<nodeList.getLength(); i++) {
			Element s= (Element)nodeList.item(i);
			Order order = new Order();
			 order.setId(s.getElementsByTagName("id").item(0).getTextContent());
			 order.setCustomerId(Integer.parseInt(s.getElementsByTagName("customerId").item(0).getTextContent()));
			 order.setShipName(s.getElementsByTagName("shipName").item(0).getTextContent());
			 order.setShipAddress(s.getElementsByTagName("shipAddress").item(0).getTextContent());
			 orders.add(order);
		}
		return orders;
		
	}
}
