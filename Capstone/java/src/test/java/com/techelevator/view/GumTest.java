package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GumTest {

	Item gum = new Gum(null, null, null, null, 1);

	@Test
	public void dispenseMessageTest() {

		String actual = gum.dispenseMessage();
		String expected = "Chew Chew, Yum";

		assertEquals(expected, actual);

	}

	@Test
	public void dispenseMessageTestSoldOut() {
		Item gum = new Gum(null, null, null, null, 0);

		String actual = gum.dispenseMessage();
		String expected = "SOLD OUT";

		assertEquals(expected, actual);
	}

}
