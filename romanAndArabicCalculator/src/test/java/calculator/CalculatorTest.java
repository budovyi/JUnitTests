package calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void testCorrectInput() {
        int expectedResult = 25;
        int actualResult = calculator.calculate("8*5-3*(4+1)");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculatorShouldThrowIllegalArgumentException() {
        int expectedResult = 25;
        int actualResult = calculator.calculate("((8*5-3*(4+1)");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void testCalculatorExpectedException() {
        int expectedResult = 0;
        int actualResult = calculator.calculate("((");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCorrectWorkRomanConverter() {
        String expectedResult = "1997";
        String actualResult = RomanConverter.convert("MCMXCVII");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectInput() {
        int expectedResult = 2;
        int actualResult = calculator.calculate("1999 - MCMXCVII");
        Assert.assertEquals(expectedResult, actualResult);
    }
}
