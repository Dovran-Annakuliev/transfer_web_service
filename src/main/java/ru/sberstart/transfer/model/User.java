package ru.sberstart.transfer.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User extends DomainModel {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private static String name;

    @Size(max = 50, message = "Middle name should be between 1 and 50 characters")
    private static String middlename;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 1, max = 50, message = "Name should be between 1 and 50 characters")
    private static String surname;

    public User() {
    }

    public User(String name, String middlename, String surname) {
        User.name = name;
        User.middlename = middlename;
        User.surname = surname;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getMiddlename() {
        return middlename;
    }

    public static void setMiddlename(String middlename) {
        User.middlename = middlename;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        User.surname = surname;
    }
}
