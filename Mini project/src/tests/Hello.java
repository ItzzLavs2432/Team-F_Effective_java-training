package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class Hello {

	@Test
	public void test1() {
		//our test logic here
		System.out.println("I am Test A");
	}
	
	
	public void test2() {
		//our test logic here
		System.out.println("I am Test B");
	}
	
	@Test
	public void notATest() {
		//our test logic here
		System.out.println("I am NOT a Test");
	}

}
