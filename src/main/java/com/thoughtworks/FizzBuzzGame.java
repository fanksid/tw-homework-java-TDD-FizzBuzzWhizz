package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzzGame {
    private List<String> results = new ArrayList<>();

    public void start(int count) {
        for (int i = 1; i <= count; i++) {
            results.add(countOff(i));
        }
    }

    private String countOff(int num) {
        final int firstNum = 3;
        final int secondNum = 5;
        final int thirdNum = 7;

        if (digitsContains(num, firstNum)) {
            return "Fizz";
        }
        StringBuilder sbResult = new StringBuilder();

        if (num % firstNum == 0) {
            sbResult.append("Fizz");
        }
        if (num % secondNum == 0) {
            sbResult.append("Buzz");
        }
        if(num % thirdNum == 0)
            sbResult.append("Whizz");

        String result = sbResult.toString();

        if (result.length() == 0) {
            return num + "";
        } else {
            return result;
        }

    }

    private boolean digitsContains(int num, int firstNum) {
        while (num > 0) {
            int digit = num % 10;
            if (digit == firstNum) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public List<String> getResults() {
        return results;
    }
}


