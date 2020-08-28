package com.techelevator.view;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import com.techelevator.view.Item;

public class Funds {

	private BigDecimal currentTotalVendingMachine;

	// constructor for purchases and inserts
	public Funds() {
		this.currentTotalVendingMachine = new BigDecimal(0.00).setScale(2);
	}

	public BigDecimal getCurrentTotalVendingMachine() {
		return currentTotalVendingMachine;
	}

	public void setCurrentTotalVendingMachine(BigDecimal currentTotalVendingMachine) {
		this.currentTotalVendingMachine = getCurrentTotalVendingMachine().add(currentTotalVendingMachine).setScale(2);
	}

	public BigDecimal resetCurrentTotalVendingMachine() {
		return this.currentTotalVendingMachine = new BigDecimal(0.00).setScale(2);
	}

	// this method return Item that has been deducted from funds and inventory

	public void makePurchaseAndDeductFunds(String[] selection, List<Item> a) throws IOException {

		for (Item item : a) {
			if (selection[0].equals(item.getSlotPosition())) {

				// check for available funds
				if (item.getPrice().compareTo(getCurrentTotalVendingMachine()) < 0) {

					// check available inventory
					if (item.getInventoryLevel() > 0) {

						// remove item from inventory
						item.removeInventoryLevel();

						// return available funds to user
						setCurrentTotalVendingMachine(item.getPrice().multiply(new BigDecimal(-1.00)));

						// return message to user
						if (item.getSelectType().equals("Chip")) {
							System.out.println(item.getItemName() + "\t$" + item.getPrice());
							System.out.println(item.dispenseMessage());
						} else if (item.getSelectType().equals("Candy")) {
							System.out.println(item.getItemName() + "\t$" + item.getPrice());
							System.out.println(item.dispenseMessage());
						} else if (item.getSelectType().equals("Drink")) {
							System.out.println(item.getItemName() + "\t$" + item.getPrice());
							System.out.println(item.dispenseMessage());
						} else {
							System.out.println(item.getItemName() + "\t$" + item.getPrice());
							System.out.println(item.dispenseMessage());
						}
						System.out.println("\nCurrent balance: $" + getCurrentTotalVendingMachine());
						Log.WriteLog(item.getSlotPosition() + " " + item.getItemName() + " $"
								+ (currentTotalVendingMachine.add(item.getPrice()) + " $"
										+ getCurrentTotalVendingMachine()));

					} else {
						System.out.println("SOLD OUT");
					}

				} else {
					System.out.println("Please insert more money.");
				}
			}
		}
	}

	public BigDecimal returnChange() throws IOException {
		BigDecimal remainingBalance = getCurrentTotalVendingMachine().multiply(new BigDecimal(100));
		int penny = remainingBalance.intValue();

		// return max quarters
		int quarter = penny / 25;
		penny = penny % 25;

		// return max dimes next
		int dime = penny / 10;
		penny = penny % 10;

		// return remaining nickels
		int nickel = penny / 5;

		System.out.println("Returning your change: $" + getCurrentTotalVendingMachine());
		System.out.println(quarter + " quarters\n" + dime + " dimes\n" + nickel + " nickels");
		Log.WriteLog("GIVE CHANGE: $" + getCurrentTotalVendingMachine() + " $" + resetCurrentTotalVendingMachine());
		return getCurrentTotalVendingMachine();
	}
}
