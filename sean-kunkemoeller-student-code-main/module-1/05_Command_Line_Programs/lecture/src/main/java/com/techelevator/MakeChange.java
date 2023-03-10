package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Total Bill Amount: ");
		String billTotalFromUser = scanner.nextLine();
		double billTotal = Double.parseDouble(billTotalFromUser);

		System.out.println("Enter Amount Tendered: ");
		String amountTenderedFromUser = scanner.nextLine();
		double amountTendered = Double.parseDouble(amountTenderedFromUser);

		double changeRequired = amountTendered - billTotal;
		System.out.println("Change Received = $" + changeRequired);
	}

}
