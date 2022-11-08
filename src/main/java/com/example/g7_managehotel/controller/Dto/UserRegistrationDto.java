package com.example.g7_managehotel.controller.Dto;

public class UserRegistrationDto {
    private String username;
    private String password;
    private String lastname;
    private String firstname;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String username, String password, String lastname, String firstname) {
        super();
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
