package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import com.techelevator.view.Inventory;
import com.techelevator.view.Log;
import com.techelevator.view.Menu;
import com.techelevator.view.Funds;

public class VendingMachineCLI {
	static Inventory inv = new Inventory();
	Funds fundsAvailable = new Funds();

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction" };
	private static final String[] MONEY_MENU = { "$1 Bill", "$2 Bill", "$5 Bill", "$10 Bill", "Back" };
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			"Exit" };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayMenuOptions();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				processPurchaseMenuOption();
			} else if (choice.equals("Exit")) {
				System.exit(0);
			}
		}
	}

	private void displayMenuOptions() throws IOException {
		inv.displayItems();
	}

	private void processPurchaseMenuOption() throws IOException {
		String purchaseMenuOption = "";

		while (!purchaseMenuOption.equals("Back")) {
			purchaseMenuOption = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

			if (purchaseMenuOption.equals("Feed Money")) {
				processMoneyFeed();
			} else if (purchaseMenuOption.equals("Select Product")) {
				productSelection();
			} else if (purchaseMenuOption.equals("Finish Transaction")) {
				fundsAvailable.returnChange();
				run();
			}
		}
	}

	private void productSelection() throws IOException {

		inv.selectionArray();
		String[] newArr = inv.selectionArray();

		String itemSlotPositionSelected = "";
		itemSlotPositionSelected = (String) menu.getChoiceFromOptions(newArr);

		String[] selection = itemSlotPositionSelected.split("\\s+");
		fundsAvailable.makePurchaseAndDeductFunds(selection, inv.itemsList);

		processPurchaseMenuOption();
	}

	private void processMoneyFeed() throws IOException {
		String dollarBillOption = "";
		
		while (!dollarBillOption.equals("Back")) {

			dollarBillOption = (String) menu.getChoiceFromOptions(MONEY_MENU);

			if (dollarBillOption.equals("$1 Bill")) {
				fundsAvailable.setCurrentTotalVendingMachine(new BigDecimal(1.00));
				System.out.println("Added: " + dollarBillOption + ", Funds Available: $"
						+ fundsAvailable.getCurrentTotalVendingMachine());
				Log.WriteLog("FEED MONEY: $1.00" + " $" + fundsAvailable.getCurrentTotalVendingMachine());
			} else if (dollarBillOption.equals("$2 Bill")) {
				fundsAvailable.setCurrentTotalVendingMachine(new BigDecimal(2.00));
				System.out.println("Added: " + dollarBillOption + ", Funds Available: $"
						+ fundsAvailable.getCurrentTotalVendingMachine());
				Log.WriteLog("FEED MONEY: $2.00" + " $" + fundsAvailable.getCurrentTotalVendingMachine());
			} else if (dollarBillOption.equals("$5 Bill")) {
				fundsAvailable.setCurrentTotalVendingMachine(new BigDecimal(5.00));
				System.out.println("Added: " + dollarBillOption + ", Funds Available: $"
						+ fundsAvailable.getCurrentTotalVendingMachine());
				Log.WriteLog("FEED MONEY: $5.00" + " $" + fundsAvailable.getCurrentTotalVendingMachine());
			} else if (dollarBillOption.equals("$10 Bill")) {
				fundsAvailable.setCurrentTotalVendingMachine(new BigDecimal(10.00));
				System.out.println("Added: " + dollarBillOption + ", Funds Available: $"
						+ fundsAvailable.getCurrentTotalVendingMachine());
				Log.WriteLog("FEED MONEY: $10.00" + " $" + fundsAvailable.getCurrentTotalVendingMachine());
			} else {

			}

		}

	}

	public static void main(String[] args) throws IOException {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		inv.readFile();
		Log.WriteLog("Stock machine.");
		cli.run();

	}
}
