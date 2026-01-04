package data;


import java.util.List;
import java.util.ArrayList;


public class Agent {
	private String name;
	private String afm;
    private List<Receipt> allReceipts;
	private FileAppender fileAppender;
	
	
	public Agent(){
        allReceipts = new ArrayList<>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			fileAppender = new FileAppenderTXT();
		}	
		else{
			fileAppender = new FileAppenderXML();
		}	
	}
	public List<Receipt> getReceipts(){
		return allReceipts;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(Receipt receipt : allReceipts){
			sumSales += receipt.getSales();
		}
		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(Receipt receipt : allReceipts){
			sumItems += receipt.getItems();
		}
		return sumItems;
	}
	
	/*
	public float calculateSkirtsSales(){
		float skirtSum = 0;
		for (Receipt receipt : allReceipts){
			if(receipt.getKind().equals("Skirt")){
				skirtSum += receipt.getItems();
			}
		}
		return skirtSum;
	}

	public float calculateCoatsSales(){
		float coatsSum = 0;
		for (Receipt receipt : allReceipts){
				if(receipt.getKind().equals("Coat")){
					coatsSum += receipt.getItems();
				}
		}		
		return coatsSum;
	}
	
	public float calculateTrouserSales(){
		float trousersSum = 0;
		for (Receipt receipt : allReceipts){
			if(receipt.getKind().equals("Trouser")){
				trousersSum += receipt.getItems();
			}	
		}
		return trousersSum;
	}
	
	public float calculateShirtsSales(){
		float shirtSum = 0;
		for (Receipt receipt : allReceipts){
			if(receipt.getKind().equals("Shirt")){				
				shirtSum += receipt.getItems();
			}
		}
		return shirtSum;
	}*/
	
	public float calculateSkirtsSales() {
	    return calculateItemSales("Skirt");
	}

	public float calculateCoatsSales() {
	    return calculateItemSales("Coat");
	}

	public float calculateTrouserSales() {
	    return calculateItemSales("Trouser");
	}

	public float calculateShirtsSales() {
	    return calculateItemSales("Shirt");
	}

	private float calculateItemSales(String itemKind) {
	    float itemSum = 0;
	    for (Receipt receipt : allReceipts) {
	        if (receipt.getKind().equals(itemKind)) {
	            itemSum += receipt.getItems();
	        }
	    }
	    return itemSum;
	}
	
	public double calculateCommission(){
        double totalSales = calculateTotalSales();
		double commission = 0;
		if( totalSales > 6000 && totalSales<= 10000){
			commission = 0.1*(totalSales-6000);
		}
		else if(totalSales > 10000 && totalSales <= 40000 ){
			commission = ((totalSales - 10000) * 0.15) + (10000*0.1);			
		}
		else if(totalSales > 40000 ) {
			commission = 10000*0.1 + 30000*0.15 + (totalSales - 40000)*0.2;			
		}
		return commission;
	}


	public FileAppender getFileAppender() {
		return fileAppender;
	}


}


