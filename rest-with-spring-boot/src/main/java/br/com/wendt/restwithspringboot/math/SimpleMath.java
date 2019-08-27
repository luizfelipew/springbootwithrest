package br.com.wendt.restwithspringboot.math;

public class SimpleMath {

    public Double sum( Double numberOne,  Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double substraction( Double numberOne,  Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplication( Double numberOne,  Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double division( Double numberOne,  Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double mean( Double numberOne,  Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(final Double number){
        return (Double) Math.sqrt(number);
    }






}
