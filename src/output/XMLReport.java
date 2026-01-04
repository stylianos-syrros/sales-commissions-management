package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Agent;

public class XMLReport extends Report{

		
	public XMLReport(Agent a){
			agent = a;
	}	

		
	public void saveFile() {
        String fullPathName = "/users/Nick/Desktop/Reports/" + agent.getAfm() + "_SALES.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            
            // Create root element
            Element agentElem = document.createElement("Agent");
            document.appendChild(agentElem);
            
            createElement(document, agentElem, "Name", agent.getName());
            createElement(document, agentElem, "AFM", agent.getAfm());
            createElement(document, agentElem, "TotalSales", Double.toString(agent.calculateTotalSales()));
            createElement(document, agentElem, "TrouserSales", Float.toString(agent.calculateTrouserSales()));
            createElement(document, agentElem, "SkirtsSales", Float.toString(agent.calculateSkirtsSales()));
            createElement(document, agentElem, "ShirtsSales", Float.toString(agent.calculateShirtsSales()));
            createElement(document, agentElem, "CoatsSales", Float.toString(agent.calculateCoatsSales()));
            createElement(document, agentElem, "Commission", Double.toString(agent.calculateCommission()));

            // Transform and write the XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(fullPathName));
            transformer.transform(domSource, streamResult);

        } catch (Exception ex) {
            System.err.println("An error occurred while creating the XML report: " + ex.getMessage());
        }
    }

    private void createElement(Document document, Element parentElement, String elementName, String textContent) {
        Element element = document.createElement(elementName);
        element.appendChild(document.createTextNode(textContent));
        parentElement.appendChild(element);
    }
    
    /*
	public void saveFile() {
		String fullPathName =  "/users/Nick/Desktop/Reports/" + agent.getAfm() + "_SALES.xml";
        try {
        	 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        	 Document document = documentBuilder.newDocument();
        	 // root element
        	 Element agentElem = document.createElement("Agent");
        	 document.appendChild(agentElem);
        	 
        	
        	 
        	 Element name = document.createElement("Name");
        	 name.appendChild(document.createTextNode(agent.getName()));
        	 agentElem.appendChild(name);
        	 
        	 Element afm = document.createElement("AFM");
        	 afm.appendChild(document.createTextNode(agent.getAfm()));	
        	 agentElem.appendChild(afm);
        	 
        	 Element totalSales = document.createElement("TotalSales");
        	 totalSales.appendChild(document.createTextNode(Double.toString(agent.calculateTotalSales())));
        	 agentElem.appendChild(totalSales);
        	 
        	 Element trouserSales = document.createElement("TrouserSales");
        	 trouserSales.appendChild(document.createTextNode(Float.toString(agent.calculateTrouserSales())));
        	 agentElem.appendChild(trouserSales);
        	 
        	 Element skirtsSales = document.createElement("SkirtsSales");
        	 skirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateSkirtsSales())));
        	 agentElem.appendChild(skirtsSales);
        	 
        	 Element shirtsSales = document.createElement("ShirtsSales");
        	 shirtsSales.appendChild(document.createTextNode(Float.toString(agent.calculateShirtsSales())));
        	 agentElem.appendChild(shirtsSales);
        	 
        	 Element coatsSales = document.createElement("CoatsSales");
        	 coatsSales.appendChild(document.createTextNode(Float.toString(agent.calculateCoatsSales())));
        	 agentElem.appendChild(coatsSales);
        	 
        	 Element commission = document.createElement("Commission");
        	 commission.appendChild(document.createTextNode(Double.toString(agent.calculateCommission())));
        	 agentElem.appendChild(commission);
        
        	 
        	 
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	 Transformer transformer = transformerFactory.newTransformer();
        	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        	 DOMSource domSource = new DOMSource(document);
        	 StreamResult streamResult = new StreamResult(new File(fullPathName));
        	 transformer.transform(domSource, streamResult);
      
    		
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    		
	}*/

}

