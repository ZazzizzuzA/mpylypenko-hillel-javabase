package com.gmail.mpylypenko.calculator;

public enum Operation {
    PLUS("plus"),
    DIVIDE("divide"),
    MULTIPLY("multiply"),
    MINUS("minus");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }
}
