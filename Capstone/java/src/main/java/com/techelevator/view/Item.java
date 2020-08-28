package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Item {

	// all items will have these attributes
	private String slotPosition;
	private String itemName;
	private BigDecimal price;
	private int inventoryLevel = 5;
	private String selectType;

	// each item will have a different return message
	public abstract String dispenseMessage();

	// all items follow this constructor
	public Item(String itemName, String slotPosition, BigDecimal price, String selectType, int inventoryLevel) {
		this.itemName = itemName;
		this.slotPosition = slotPosition;
		this.price = price;
		this.selectType = selectType;
		this.inventoryLevel = inventoryLevel;
	}

	public int getInventoryLevel() {
		return this.inventoryLevel;
	}

	// all inventory levels start at five as shown in the attribute
	public void setInventoryLevel(int inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}

	// this method needs to reduce inventory as items are purchased
	public int removeInventoryLevel() {
		return this.inventoryLevel -= 1;
	}

	public String getSlotPosition() {
		return this.slotPosition;
	}

	public String getItemName() {
		return this.itemName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public String getSelectType() {
		return this.selectType;
	}

	public String toString() {
		return (String.format("%-8s %-20s %-10s %-7s", getSlotPosition(), getItemName(), getPrice(),
				getInventoryLevel()));
	}

}
