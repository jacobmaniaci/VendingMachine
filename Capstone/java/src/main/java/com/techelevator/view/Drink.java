package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String itemName, String slotPosition, BigDecimal price, String selectType, int inventoryLevel) {
		super(itemName, slotPosition, price, selectType, inventoryLevel);
		
	}

	@Override
	public String dispenseMessage() {
		if (getInventoryLevel() > 0) {
			return "Glug Glug, Yum";
		} else {
			return "SOLD OUT";
		}
		
	}
	
	

}
