package com.thoughtworks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class FizzBuzzGameTest {
    Method method;
    FizzBuzzGame game;

    @Before
    public void setUp() throws Exception {
        game = new FizzBuzzGame();
        method = FizzBuzzGame.class.getDeclaredMethod("countOff", int.class);
        method.setAccessible(true);
    }

    @After
    public void tearDown() throws Exception {
        method.setAccessible(false);
    }

    @Test
    public void should_return_Fizz_when_have_3() throws Exception {
        String result = (String) method.invoke(game, 13);
        Assert.assertEquals("Fizz", result);
    }

    @Test
    public void should_return_Fizz_when_only_multiple_of_3() throws Exception{
        String result = (String) method.invoke(game, 3);
        Assert.assertEquals("Fizz", result);
    }

    @Test
    public void should_return_Buzz_when_only_multiple_of_5() throws Exception{
        String result = (String) method.invoke(game, 5);
        Assert.assertEquals("Buzz", result);
    }

    @Test
    public void should_return_Whizz_when_only_multiple_of_7() throws Exception{
        String result = (String) method.invoke(game, 7);
        Assert.assertEquals("Whizz", result);
    }

    @Test
    public void shoud_return_FizzBuzz_when_multiple_of_3_and_5() throws Exception{
        String result = (String) method.invoke(game, 15);
        Assert.assertEquals("FizzBuzz", result);
    }

    @Test
    public void shoud_return_FizzWhizz_when_multiple_of_3_and_7() throws Exception{
        String result = (String) method.invoke(game, 21);
        Assert.assertEquals("FizzWhizz", result);
    }

    @Test
    public void shoud_return_BuzzWhizz_when_multiple_of_5_and_7() throws Exception{
        String result = (String) method.invoke(game, 70);
        Assert.assertEquals("BuzzWhizz", result);
    }

    @Test
    public void shoud_return_FizzBuzzWhizz_when_multiple_of_3_5_and_7() throws Exception{
        String result = (String) method.invoke(game, 105);
        Assert.assertEquals("FizzBuzzWhizz", result);
    }


    @Test
    public void should_return_true_when_contain_digit() throws Exception{
        Method methodDigitsContains = FizzBuzzGame.class.getDeclaredMethod("digitsContains", int.class, int.class);
        int firstNum = 3;
        methodDigitsContains.setAccessible(true);
        Assert.assertTrue((Boolean) methodDigitsContains.invoke(game, 12345, firstNum));
        Assert.assertFalse((Boolean) methodDigitsContains.invoke(game, 1, firstNum));
        Assert.assertFalse((Boolean) methodDigitsContains.invoke(game, 12456, firstNum));
        methodDigitsContains.setAccessible(false);
    }
}
