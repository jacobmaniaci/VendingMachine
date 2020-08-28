package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {
	
	
	
	@Test
	public void dispenseMessageTest() {
		Item candy = new Candy(null, null, null, null, 1);
		
		String actual = candy.dispenseMessage();
		String expected = "Munch Munch, Yum";
		
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void dispenseMessageTestSoldOut() {
		Item candy = new Candy(null, null, null, null, 0);
		
		String actual = candy.dispenseMessage();
		String expected = "SOLD OUT";
		
		
		assertEquals(expected, actual);

	}

}
