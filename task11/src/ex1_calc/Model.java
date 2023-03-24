package ex1_calc;

import ex1_calc.Complex;

public class Model {
    double result;

    public double getResult(double num1, double num2, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }

    public Complex getResultComplex(Complex num1, Complex num2, char operation) {
        double real = 0, image = 0;
        switch (operation) {
            case '+':
                real = num1.getRe() + num2.getRe();
                image = num1.getIm() + num2.getIm();
                break;
            case '-':
                real = num1.getRe() - num2.getRe();
                image = num1.getIm() - num2.getIm();
                break;
            case '*':
                real = num1.getRe() * num2.getRe() - num1.getIm() * num2.getIm();
                image = num1.getRe() * num2.getIm() + num1.getIm() * num2.getRe();
                break;
            case '/':
                double mod = Math.sqrt(Math.pow(num1.getRe(), 2) + Math.pow(num1.getIm(), 2));
                image = (num1.getIm() * num2.getRe() - num1.getRe() * num2.getIm()) / mod;
                real = (num1.getRe() * num2.getRe() - num1.getIm() * num2.getIm()) / mod;
                break;

        }
        return new Complex(real, image);
    }

}
