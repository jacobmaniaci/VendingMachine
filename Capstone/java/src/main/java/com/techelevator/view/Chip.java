package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Item {

	public Chip(String itemName, String slotPosition, BigDecimal price, String selectType, int inventoryLevel) {
		super(itemName, slotPosition, price, selectType, inventoryLevel);
	}

	@Override
	public String dispenseMessage() {
		if (getInventoryLevel() > 0) {
			return "Crunch Crunch, Yum";
		} else {
			return "SOLD OUT";
		}
		
	}
	
	

	

}
