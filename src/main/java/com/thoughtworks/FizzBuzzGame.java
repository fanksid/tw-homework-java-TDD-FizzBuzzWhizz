package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzzGame {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String WHIZZ = "Whizz";
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

        if ((num + "").contains(firstNum + "")) {
            return FIZZ;
        }

        String result = muitipleOf(num, firstNum, secondNum, thirdNum);

        if (result.length() == 0) {
            return num + "";
        } else {
            return result;
        }

    }

    private String muitipleOf(int num, int firstNum, int secondNum, int thirdNum) {
        StringBuilder sbResult = new StringBuilder();

        if (num % firstNum == 0) {
            sbResult.append(FIZZ);
        }
        if (num % secondNum == 0) {
            sbResult.append(BUZZ);
        }
        if(num % thirdNum == 0)
            sbResult.append(WHIZZ);
        return sbResult.toString();
    }

    public List<String> getResults() {
        return results;
    }
}


