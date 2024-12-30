package com.gmail.mpylypenko.calculator;

import java.util.Objects;

public class Calculator extends ReadScanner {
    private double numberFirst;
    private double numberSecond;
    private Operation operation;
    private boolean stopped = true;

    public Calculator() {
        super();
        this.stopped = false;
        System.out.println("Calculator started and ready to calculate!");
    }

    public boolean askNextSample() {
        if (!this.stopped) {
            String next = this.readString("Next sample? (Y/n):");
            if (Objects.equals(next, "n") || Objects.equals(next, "N")) {
                this.setStopped(true);
            }
        } else {
            this.setStopped(false);
        }
        return this.stopped;
    }

    public double calculate() {
        return this.calculateSeparateValues();
    }

    public double calculate(double first, double second, Operation operation) {
        this.setNumberFirst(first);
        this.setNumberSecond(second);
        this.setOperation(operation);
        return this.selectMethod();
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
        if (this.numberFirst < 0 && this.numberSecond < 0) {
            return this.plus();
        }
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

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
