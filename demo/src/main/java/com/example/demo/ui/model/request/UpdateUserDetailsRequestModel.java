package com.example.demo.ui.model.request;

import javax.validation.constraints.NotEmpty;

public class UpdateUserDetailsRequestModel {
    @NotEmpty(message="First name cannot be null")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be null")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
