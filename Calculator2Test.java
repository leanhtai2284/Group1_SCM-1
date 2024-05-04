package Tai;

import static org.junit.Assert.*;

import org.junit.Test;

import Le.Calculator2;

public class Calculator2Test {

	 @Test
	    public void testSub() {
	        Calculator2 calculator = new Calculator2();
	        
	        // Test case: Test the result value
	        calculator.number1 = 10;
	        calculator.number2 = 5;
	        calculator.sub();
	        assertEquals(5, calculator.result);
	        
	        // Test case: Test the number larger than maximum the int type
	        calculator.number1 = Integer.MAX_VALUE;
	        calculator.number2 = 1;
	        ArithmeticException exception1 = assertThrows(ArithmeticException.class, calculator::sub);
	        assertEquals("integer overflow", exception1.getMessage());
	        
	        // Test case: Test the number smaller than minimum the int type
	        calculator.number1 = Integer.MIN_VALUE;
	        calculator.number2 = 1;
	        ArithmeticException exception2 = assertThrows(ArithmeticException.class, calculator::sub);
	        assertEquals("integer overflow", exception2.getMessage());
	    }

}
