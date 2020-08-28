package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DrinkTest {
	
	
	
	@Test
	public void dispenseMessageTest() {
		Item drink = new Drink(null, null, null, null, 1);
		
		String actual = drink.dispenseMessage();
		String expected = "Glug Glug, Yum";
		
		
		assertEquals(expected, actual);

	}
	
	@Test
	public void dispenseMessageTestSoldOut() {
		Item drink = new Drink(null, null, null, null, 0);
		
		String actual = drink.dispenseMessage();
		String expected = "SOLD OUT";
		
		
		assertEquals(expected, actual);

	}

}
