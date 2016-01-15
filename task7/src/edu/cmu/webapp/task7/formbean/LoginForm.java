package edu.cmu.webapp.task7.formbean;

import java.util.ArrayList;
import java.util.List;

public class LoginForm {
    private String userName;
    private String password;
    private String action;

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (getUserName() == null || getUserName().length() == 0) {
            errors.add("Username is required");
        }
        if (getPassword() == null || getPassword().length() == 0) {
            errors.add("Password is required");
        }
        if (getAction() == null) {
            errors.add("Invalid button");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!getAction().equals("customer") && !getAction().equals("employee")) {
            errors.add("Invalid button");
        }
        if (getUserName().matches(".*[<>\"].*")) {
            errors.add("User Name may not contain angle brackets or quotes");
        }

        return errors;
    }

    public boolean isEmployee() {
        return getAction() != null && getAction().equals("employee");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}