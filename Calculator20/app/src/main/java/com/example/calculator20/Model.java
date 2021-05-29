package com.example.calculator20;

public class Model {

    private static String equation;
    private static String result;
    private int id;

    public Model(int id, String equation, String result) {
        this.id = id;
        this.equation = equation;
        this.result = result;
    }

    public Model() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public static String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return equation + " = " + result;
    }
}
