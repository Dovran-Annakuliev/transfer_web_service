package ru.sberstart.transfer.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User extends DomainModel {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String name;

    @Size(max = 50, message = "Middle name should be between 1 and 50 characters")
    private String middlename;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private String surname;

    public User() {
    }

    public User(String name, String middlename, String surname) {
        this.name = name;
        this.middlename = middlename;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
