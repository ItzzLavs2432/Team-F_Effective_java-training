package tests;



import static tests.MyMaths.divide;
import static tests.MyMaths.minus;
import static tests.MyMaths.multiply;
import static tests.MyMaths.plus;

import org.junit.Assert;
import org.junit.Test;



public class MyMath {

	@Test
	public void testPlus() {
		int result=plus(4, 3);
		
		if(result!=7)
			Assert.fail("Test failed.");
		
	}
	
	@Test
	public void testMinus() {
		int result=minus(4, 3);
		if(result!=(4-3))
			Assert.fail("Test failed.");
	}
	
	@Test
	public void testMultiply() {
		int result=multiply(4, 3);
		
		Assert.assertEquals(4*3, result);
	}
	@Test
	public void testDivide() {
		int result=divide(4, 3);
		
		Assert.assertEquals(4/3, result);
	}
	
	@Test
	public void testDivideByZero() {
		int result=divide(2,0);
		System.out.println("Last line should crash!");
	}
	
	
	
}
