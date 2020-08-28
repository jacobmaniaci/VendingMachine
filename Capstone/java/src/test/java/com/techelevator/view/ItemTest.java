package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void removeInventoryLevelTest() {
		Item x = new Chip(null, null, null, null, 5);
		
		int actual = x.removeInventoryLevel();
		int expected = 4;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void soldOutInventoryTest() {
		Item x = new Chip(null, null, null, null, 0);
		
		int actual = x.removeInventoryLevel();
		String expected = "SOLD OUT";
		
		assertEquals(expected, actual);
	}

}
