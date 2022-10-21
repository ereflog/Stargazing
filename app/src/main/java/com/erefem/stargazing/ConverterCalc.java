package com.erefem.stargazing;

import androidx.annotation.NonNull;

import java.text.NumberFormat;

public class ConverterCalc {
    final double millimeters = 1000;
    final double centimeters = 100;
    final double inches = 39.3701;
    final double meters = 1;
    final double kilometers = 0.001;
    final double miles = 0.000621371;
    final double astronomical_unit = 6.6845871226706E-12;
    final double light_year = 1.0570008340247E-16;
    final double parsec = 3.2407792896664E-17;

    private double inputNumbers;
    private double outputNumbers;
    private String inputUnitType;
    private String outputUnitType;

    /*public ConverterCalc() {
        this.inputNumbers = inputNumbers;
        this.outputNumbers = outputNumbers;
        this.inputUnitType = inputUnitType;
        this.outputUnitType = outputUnitType;
    }*/

    public ConverterCalc(){
        inputNumbers = 0;
        outputNumbers = 0;
        inputUnitType = "";
        outputUnitType = "";
    }

    public double getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(double inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public double getOutputNumbers() {
        return outputNumbers;
    }

    public void setOutputNumbers(double outputNumbers) {
        this.outputNumbers = outputNumbers;
    }

    public String getInputUnitType() {
        return inputUnitType;
    }

    public void setInputUnitType(String inputUnitType) {
        this.inputUnitType = inputUnitType;
    }

    public String getOutputUnitType() {
        return outputUnitType;
    }

    public void setOutputUnitType(String outputUnitType) {
        this.outputUnitType = outputUnitType;
    }

    public double getUnitTypeConstant(String unit_type) {
        if (unit_type.equals("meters")){
            return meters;
        }
        if (unit_type.equals("millimeters")){
            return millimeters;
        }
        if (unit_type.equals("centimeters")){
            return centimeters;
        }
        if (unit_type.equals("inches")){
            return inches;
        }
        if (unit_type.equals("kilometers")){
            return kilometers;
        }
        if (unit_type.equals("miles")){
            return miles;
        }
        if (unit_type.equals("astronomical unit")){
            return astronomical_unit;
        }
        if (unit_type.equals("light-year")){
            return light_year;
        }
        if (unit_type.equals("parsec")){
            return parsec;
        }
        return 0;
    }

    public double calculateOutputNumbers(){
        double inputNumbers = getInputNumbers();
        double outputNumbers = getOutputNumbers();
        double inputUnitType = getUnitTypeConstant(getInputUnitType());
        double outputUnitType = getUnitTypeConstant(getOutputUnitType());

        outputNumbers = meters / inputUnitType; //convert to meters
        outputNumbers = outputNumbers * outputUnitType; //convert from meters
        outputNumbers = outputNumbers * inputNumbers; //multiply by initial numbers to get final output numbers
        return outputNumbers; //return the final numbers
    }

    @NonNull
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (outputUnitType.equals("millimeters") || outputUnitType.equals("centimeters") ||
                outputUnitType.equals("inches") || outputUnitType.equals("meters") ||
                outputUnitType.equals("kilometers") || outputUnitType.equals("miles")){
            nf.setMaximumFractionDigits(2);
        } else {
            nf.setMaximumFractionDigits(10);
        }
        return nf.format(getOutputNumbers()) + " " + getOutputUnitType();
    }
}
