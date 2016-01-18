package edu.cmu.webapp.task7.formbean;

import java.util.ArrayList;
import java.util.List;


public class CreateFundFormBean extends FormBean {
    private String name;
    private String ticker;
    private long firstPrice;
    private String action;

    @Override
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (getName() == null || getName().length() == 0) {
            errors.add("Fund Name is required");
        }
        if (getTicker() == null || getTicker().length() == 0) {
            errors.add("Ticker is required");
        }
        if (getAction() == null) {
            errors.add("Button is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (getName().matches(".*[<>;\"].*")) {
            errors.add("Fund Name may not contain angle brackets or quotes");
        }
        if (getTicker().matches(".*[<>\"];.*")) {
            errors.add("Ticker Name may not contain angle brackets or quotes");
        }

        if (!getAction().equals("Create Fund")) {
            errors.add("Invalid button");
        }

        return errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public long getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(long firstPrice) {
        this.firstPrice = firstPrice;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
