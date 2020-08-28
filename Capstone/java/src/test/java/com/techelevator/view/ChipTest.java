package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChipTest {
	
	
	@Test
	public void dispenseMessageTest() {
		Item chip = new Chip(null, null, null, null, 1);
		
		String actual = chip.dispenseMessage();
		String expected = "Crunch Crunch, Yum";
		
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void dispenseMessageTestSoldOut() {
		Item chip = new Chip(null, null, null, null, 0);
		
		String actual = chip.dispenseMessage();
		String expected = "SOLD OUT";
		
		
		assertEquals(expected, actual);

	}

}
