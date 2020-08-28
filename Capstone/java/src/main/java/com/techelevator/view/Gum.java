package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Item {

	public Gum(String itemName, String slotPosition, BigDecimal price, String selectType, int inventoryLevel) {
		super(itemName, slotPosition, price, selectType, inventoryLevel);
		
	}

	@Override
	public String dispenseMessage() {
		if (this.getInventoryLevel() > 0) {
			return "Chew Chew, Yum";
		} else {
			return "SOLD OUT";
		}
		
	}

	

}
