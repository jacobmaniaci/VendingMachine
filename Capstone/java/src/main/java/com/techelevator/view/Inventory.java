package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

	public List<Item> itemsList = new ArrayList<>();
	String[] newArr;

	public boolean readFile() throws FileNotFoundException {

		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(inputFile)) {
			if (!inputFile.exists()) {
				return false;
			}

			while (fileScanner.hasNextLine()) {
				String newLine = fileScanner.nextLine();
				newArr = newLine.split("\\|");

				if (newArr[3].equals("Chip")) {
					itemsList.add(new Chip(newArr[1], newArr[0], new BigDecimal(newArr[2]), newArr[3], 5));
				}
				if (newArr[3].equals("Candy")) {
					itemsList.add(new Candy(newArr[1], newArr[0], new BigDecimal(newArr[2]), newArr[3], 5));
				}
				if (newArr[3].equals("Drink")) {
					itemsList.add(new Drink(newArr[1], newArr[0], new BigDecimal(newArr[2]), newArr[3], 5));
				}
				if (newArr[3].equals("Gum")) {
					itemsList.add(new Gum(newArr[1], newArr[0], new BigDecimal(newArr[2]), newArr[3], 5));
				}
			}

		}

		return true;
	}

	public void displayItems() {

		System.out.println(String.format("%-8s %-20s %-10s %-7s", "Slot", "Name", "Price", "Inventory\n"));

		for (Item item : itemsList) {
			System.out.printf("%-8s %-20s %-10s %-7s \n", item.getSlotPosition(), item.getItemName(), item.getPrice(),
					item.getInventoryLevel());
		}

	}

	public String[] selectionArray() {
		String[] selectionArr = new String[itemsList.size()];

		int count = 0;
		for (Item item : itemsList) {
			selectionArr[count] = item.toString();

			count++;
		}
		return selectionArr;

	}

	// get information from product selected
	public List<Item> getItemsList() {
		return itemsList;
	}

}
