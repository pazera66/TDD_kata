package test;

import com.company.Calculator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by karol on 03.08.16.
 */


public class CalcTest {


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void add_0_numbers_Test(){

        Calculator calculator = new Calculator();
        int result  = calculator.add("");
        Assert.assertEquals(0,result);
    }


    @Test
    public void add_1_numbers_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("3");
        Assert.assertEquals(3,result);
    }

    @Test
    public void add_many_numbers_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("4,6,1");
        Assert.assertEquals(11,result);
    }

    @Test
    public void add_newLine_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("4\n6");
        Assert.assertEquals(10,result);
    }

    @Test
    public void add_newDelim_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("//;\n4;6");
        Assert.assertEquals(10,result);
    }

    @Test
    public void add_negativeArgs_Test(){
        Calculator calculator = new Calculator();
        exception.expect(IllegalArgumentException.class);
        int result  = calculator.add("//;\n-1;6");

    }

    @Test
    public void add_over1000_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("//;\n1002;6");
        Assert.assertEquals(6,result);
    }

    @Test
    public void add_longerDelimiters_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("//[***]\n1002***6");
        Assert.assertEquals(6,result);
    }

    @Test
    public void add_multipleLongerDelimiters_Test(){
        Calculator calculator = new Calculator();
        int result  = calculator.add("//[bob][bab]\n1002bab6bob7");
        Assert.assertEquals(13,result);
    }
}
