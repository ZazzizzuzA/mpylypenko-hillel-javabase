package com.gmail.mpylypenko.calculator;

import java.util.Objects;

public class Calculator extends ReadScanner {
    private double numberFirst;
    private double numberSecond;
    private Operation operation;
    private boolean stoped = true;

    public Calculator() {
        super();
        this.stoped = false;
        System.out.println("Calculator started and ready to calculate!");
    }

    public boolean askNextSample() {
        if (!this.stoped) {
            String next = this.readString("Next sample? (Y/n):");
            if (Objects.equals(next, "n") || Objects.equals(next, "N")) {
                this.setStoped(true);
            }
        } else {
            this.setStoped(false);
        }
        return this.stoped;
    }

    public double calculate() {
        return this.calculateSeparateValues();
    }

    private double calculateSeparateValues() {
        this.setNumberFirst(this.readInt("Write first value:"));
        this.setNumberSecond(this.readInt("Write second value:"));
        int indexOperation = this.readIntWithVariants("Choose an operation:", Operation.values());
        this.selectAndSetOperation(indexOperation);
        return this.selectMethod();
    }

    private void selectAndSetOperation(int index) {
        this.setOperation(Operation.values()[index - 1]);
    }

    private double selectMethod() {
        return switch (this.operation) {
            case PLUS -> this.plus();
            case MULTIPLY -> this.multiply();
            case DIVIDE -> this.divide();
            case MINUS -> this.minus();
        };
    }

    private double plus() {
        return this.numberFirst + this.numberSecond;
    }

    private double divide() {
        return this.numberFirst / this.numberSecond;
    }

    private double multiply() {
        return this.numberFirst * this.numberSecond;
    }

    private double minus() {
        return this.numberFirst - this.numberSecond;
    }

    protected void setNumberFirst(double value) {
        this.numberFirst = value;
    }

    protected void setNumberSecond(double value) {
        this.numberSecond = value;
    }

    protected void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean isStoped() {
        return this.stoped;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }
}
