package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String itemName, String slotPosition, BigDecimal price, String selectType, int inventoryLevel) {
		super(itemName, slotPosition, price, selectType, inventoryLevel);
		
	}

	@Override
	public String dispenseMessage() {
		if (getInventoryLevel() > 0) {
			return "Munch Munch, Yum";
		} else {
			return "SOLD OUT";
		}
		
	}
	
	

}
