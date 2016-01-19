package edu.cmu.webapp.task7.formbean;

import java.util.ArrayList;
import java.util.List;

public class ViewCustomerFormBean extends FormBean {
    private String userName;
    private String action;

    @Override
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if ((getUserName() == null || getUserName().length() == 0)) {
            errors.add("Username is required");
        }

        if (getAction() == null) {
            errors.add("Button is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!getAction().equals("View Customer Account")) {
            errors.add("Invalid button");
        }
        if (getUserName().matches(".*[<>\"].*")) {
            errors.add("User Name may not contain angle brackets or quotes");
        }

        return errors;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
