package ru.sberstart.transfer.model;

import java.io.Serializable;

public class DomainModel implements Serializable {
    private static Long id;

    public static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
