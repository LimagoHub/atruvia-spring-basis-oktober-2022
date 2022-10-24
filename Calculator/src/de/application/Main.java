package de.application;

import de.atruvia.math.Calculator;
import de.atruvia.math.CalculatorImpl;
import de.atruvia.math.CalculatorLogger;
import de.atruvia.math.CalculatorSecure;
import de.client.CalcClient;


public class Main {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        calculator = new CalculatorLogger(calculator);
        calculator = new CalculatorSecure(calculator);
        CalcClient client = new CalcClient(calculator);
        client.go();

    }
}