package com.deerwalk.ml.formatNos;

public class TestFormatter {

	public static void main(String[] args) {

		NumberFormatter myFormatter = new NumberFormatter();
		
		System.out.println("\nEnter a number to format: ");
		myFormatter.readNumber();
		myFormatter.getFormattedNumber();
		myFormatter.displayFormattedNumbers();
		
		System.out.println("\nEnter a number to get percentage: ");
		myFormatter.readNumber();
		myFormatter.retrievePercentage();
		myFormatter.displayFormattedNumbers();
	}

}
