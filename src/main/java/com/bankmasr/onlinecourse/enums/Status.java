package com.bankmasr.onlinecourse.enums;

/**
 * @author agamal on 11/3/2020
 */
public enum Status {
    OPEN("OPEN"),
    CLOSED("CLOSED");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
