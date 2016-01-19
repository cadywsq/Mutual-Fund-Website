package edu.cmu.webapp.task7.databean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FundPriceHistoryBean implements Comparable<FundPriceHistoryBean> {
    private int fundId;
    private String priceDate;
    private double price;

    @Override
    public int compareTo(FundPriceHistoryBean fundPriceHistory) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(this.getPriceDate()).compareTo(dateFormat.parse(fundPriceHistory.getPriceDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
