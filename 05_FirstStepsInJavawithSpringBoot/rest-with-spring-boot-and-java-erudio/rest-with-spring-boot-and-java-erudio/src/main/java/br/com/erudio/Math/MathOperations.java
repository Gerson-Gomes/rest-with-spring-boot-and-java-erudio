package br.com.erudio.Math;

import br.com.erudio.exeptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class MathOperations {
    public Double sum(double numberOne, double numberTwo) {

        return (numberOne) + (numberTwo);
    }


    public Double subtraction(double numberOne, double numberTwo) {

        return (numberOne) - (numberTwo);
    }


    public Double multiplication(double numberOne, double numberTwo) {

        return (numberOne) * (numberTwo);
    }


    public Double division(double numberOne, double numberTwo) {

        return (numberOne) / (numberTwo);
    }


    public Double average(double numberOne, double numberTwo) {

        return ((numberOne) + (numberTwo)) / 2;
    }


    public Double root(double numberOne){

        return Math.sqrt(numberOne);
    }
}
