package edu.cmu.webapp.task7.formbean;

import java.util.ArrayList;
import java.util.List;

public class ResearchFundFormBean extends MyFormBean {
    private String fundName;
    private String action;
    private String startDate;
    private String endDate;
    private String fundSymbol;

    @Override
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();
        if (getFundName() == null || getFundName().length() == 0) {
            errors.add("Fund name is required");
        }

        if (getAction() == null) {
            errors.add("Button is required");
        }

        if (getStartDate() == null) {
            errors.add("Start date is required");
        }

        if (getEndDate() == null) {
            errors.add("End date is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!getAction().equals("Research Fund")) {
            errors.add("Invalid button");
        }
        if (errors.size() > 0) {
            return errors;
        }

        try {
            if (dateFormat(getStartDate()).compareTo(dateFormat(getEndDate())) == 1) {
                errors.add("Start date cannot be later than end date");
            }
        } catch (MyException e) {
            errors.add(e.getMessage());
        }

        return errors;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFundSymbol() {
        return fundSymbol;
    }

    public void setFundSymbol(String fundSymbol) {
        this.fundSymbol = fundSymbol;
    }
}

