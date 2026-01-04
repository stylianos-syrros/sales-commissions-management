package input;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends Input {
 
	public XMLInput(File receiptFileXML ){
		inputFile = receiptFileXML;
		
	}
	
	public void readFile() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList agentList = doc.getElementsByTagName("Agent");
            processAgent((Element) agentList.item(0));

            NodeList receiptsNodeList = ((Element) agentList.item(0)).getElementsByTagName("Receipt");
            processReceipts(receiptsNodeList);

        } catch (Exception e) {
            handleException(e);
        } 
    }

    private void processAgent(Element agentElement) {
        name = getTextContent(agentElement, "Name");
        afm = getTextContent(agentElement, "AFM");
        addAgent();
    }

    private void processReceipts(NodeList receiptsNodeList) {
        int receiptsCount = receiptsNodeList.getLength();
        for (int i = 0; i < receiptsCount; i++) {
            Element receiptElement = (Element) receiptsNodeList.item(i);
            receiptID = parseInt(getTextContent(receiptElement, "ReceiptID"));
            date = getTextContent(receiptElement, "Date");
            kind = getTextContent(receiptElement, "Kind");
            sales = parseDouble(getTextContent(receiptElement, "Sales"));
            items = parseInt(getTextContent(receiptElement, "Items"));
            companyName = getTextContent(receiptElement, "Company");
            companyCountry = getTextContent(receiptElement, "Country");
            companyCity = getTextContent(receiptElement, "City");
            companyStreet = getTextContent(receiptElement, "Street");
            companyStreetNumber = parseInt(getTextContent(receiptElement, "Number"));
            addReceipt();
        }
    }

    private String getTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

    private int parseInt(String value) {
        return Integer.parseInt(value);
    }

    private double parseDouble(String value) {
        return Double.parseDouble(value);
    }

    private void handleException(Exception e) {
        JOptionPane.showMessageDialog(null, "An error occurred while processing the XML file.");
        // You can choose to log the error or handle it differently.
    }
    
    
    
}


