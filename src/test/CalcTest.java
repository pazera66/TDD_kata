package test;

import com.company.Calculator;
import com.company.NegativeNumbersException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by karol on 03.08.16.
 */


public class CalcTest{


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void add_0_numbers_Test() throws NegativeNumbersException {

        Calculator calculator = new Calculator();
        int result  = calculator.add("");
        Assert.assertEquals(0,result);
    }


    @Test
    public void add_1_numbers_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("3");
        Assert.assertEquals(3,result);
    }

    @Test
    public void add_many_numbers_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("4,6,1");
        Assert.assertEquals(11,result);
    }

    @Test
    public void add_newLine_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("4\n6");
        Assert.assertEquals(10,result);
    }

    @Test
    public void add_newDelim_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("//;\n4;6");
        Assert.assertEquals(10,result);
    }

    @Test
    public void add_negativeArgs_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        exception.expect(NegativeNumbersException.class);
        int result  = calculator.add("//;\n-1;6");

    }

    @Test
    public void add_over1000_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("//;\n1002;6");
        Assert.assertEquals(6,result);
    }

    @Test
    public void add_longerDelimiters_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("//[ala]\n1002ala6");
        Assert.assertEquals(6,result);
    }

    @Test
    public void add_multipleLongerDelimiters_Test() throws NegativeNumbersException {
        Calculator calculator = new Calculator();
        int result  = calculator.add("//[bob][bab]\n1002bab6bob7");
        Assert.assertEquals(13,result);
    }
}
