package data;

import java.util.List;
import java.util.ArrayList;

public class SalesMan {

    private String name;
    private String afm;
    private List<Receipt> receipts;
    private FileAppender fileAppender;


    public SalesMan() {
        receipts = new ArrayList<>();
    }

    public void setFileType(String fileType) {
        if (fileType.equals("TXT")) {
            fileAppender = new FileAppenderTXT();
        } else {
            fileAppender = new FileAppenderXML();
        }
    }

    public List<Receipt> getReceipts() {
        return receipts;
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

    public double calculateTotalSales() {
        double sumSales = 0;
        for (Receipt receipt : receipts) {
            sumSales += receipt.getSales();
        }
        return sumSales;
    }

    public int calculateTotalItems() {
        int sumItems = 0;
        for (Receipt receipt : receipts) {
            sumItems += receipt.getItems();
        }
        return sumItems;
    }

    public float calculateItemSales(String itemKind) {
        float itemSum = 0;
        for (Receipt receipt : receipts) {
            if (receipt.getKind().equals(itemKind)) {
                itemSum += receipt.getItems();
            }
        }
        return itemSum;
    }

    public double calculateCommission() {
        double totalSales = calculateTotalSales();
        double commission = 0;
        if (totalSales > 6000 && totalSales <= 10000) {
            commission = 0.1 * (totalSales - 6000);
        } else if (totalSales > 10000 && totalSales <= 40000) {
            commission = ((totalSales - 10000) * 0.15) + (10000 * 0.1);
        } else if (totalSales > 40000) {
            commission = 10000 * 0.1 + 30000 * 0.15 + (totalSales - 40000) * 0.2;
        }
        return commission;
    }

    public FileAppender getFileAppender() {
        return fileAppender;
    }
}
