package com.example.demo.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotEmpty(message="First name cannot be null")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be null")
    private String lastName;
    @NotEmpty(message = "email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "password cannot be null")
    @Size(min=8,max=16,message = "Password should be greater than 8 ")
    private String password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
