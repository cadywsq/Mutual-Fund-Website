package edu.cmu.webapp.task7.formbean;

import java.util.ArrayList;
import java.util.List;


public class CreateCustomerForm extends FormBean {
    private String userName;
    private String firstName;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String addrLine1;
    private String addrLine2;
    private String city;
    private String state;
    private String zip;
    private long cash;
    private String action;

    @Override
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (getUserName() == null || getUserName().length() == 0) {
            errors.add("User Name is required");
        }
        if (getFirstName() == null || getFirstName().length() == 0) {
            errors.add("First Name is required");
        }
        if (getLastName() == null || getLastName().length() == 0) {
            errors.add("Last Name is required");
        }
        if (getPassword() == null || getPassword().length() == 0) {
            errors.add("Password is required");
        }
        if (getConfirmPassword() == null || getConfirmPassword().length() == 0) {
            errors.add("Confirm password is required");
        }
        if (!getPassword().equals(getConfirmPassword())) {
            errors.add("Passwords are not the same");
        }
        if (getAction() == null) {
            errors.add("Button is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (getUserName().matches(".*[<>\"].*")) {
            errors.add("User Name may not contain angle brackets or quotes");
        }
        if (getFirstName().matches(".*[<>\"].*")) {
            errors.add("First Name may not contain angle brackets or quotes");
        }
        if (getLastName().matches(".*[<>\"].*")) {
            errors.add("Last Name may not contain angle brackets or quotes");
        }
        if (getPassword().matches(".*[<>\"].*")) {
            errors.add("Password may not contain angle brackets or quotes");
        }
        if ((getAddrLine1() != null && getAddrLine1().matches(".*[<>\"].*"))
                || (getAddrLine2() != null && getAddrLine2().matches(".*[<>\"].*"))) {
            errors.add("Address may not contain angle brackets or quotes");
        }
        if (getCity() != null && getCity().matches(".*[<>\"].*")) {
            errors.add("City may not contain angle brackets or quotes");
        }
        if (getState() != null && getState().matches(".*[<>\"].*")) {
            errors.add("State may not contain angle brackets or quotes");
        }
        if (getZip() != null && getState().matches(".*[<>\"].*")) {
            errors.add("Zip Code may not contain angle brackets or quotes");
        }

        if (!getAction().equals("create")) {
            errors.add("Invalid button");
        }

        return errors;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
