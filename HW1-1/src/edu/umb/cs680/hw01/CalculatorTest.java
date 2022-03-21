package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void multiply5By4() {
		Calculator cc = new Calculator();
		float expected = 20;
		float actual = cc.multiply(5,4);
		assertTrue(cc instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void divide3By2(){
		Calculator cc = new Calculator();
		float expected = 1.5f;
		float actual = cc.divide(3,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By0withTryCatch(){
		Calculator cc = new Calculator();
		try{
			cc.divide(10, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage());
		}
	}
}
