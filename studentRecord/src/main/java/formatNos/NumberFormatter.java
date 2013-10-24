package formatNos;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.NumberFormat;

public class NumberFormatter {

	private DecimalFormat myDecimalFormatter = new DecimalFormat();
	private NumberFormat myNumberFormatter = NumberFormat.getPercentInstance();
	
	private double orgNumber;
	private String formattedNumber;
	
	public double readNumber(){
		
		Scanner input = new Scanner(System.in);
		
		orgNumber = input.nextDouble();
		return orgNumber;
	}
	
	public double getFormattedNumber(){
		
		formattedNumber = myDecimalFormatter.format(orgNumber);
		return orgNumber;
	}
	
	public String retrievePercentage(){
		
		formattedNumber = myNumberFormatter.format(orgNumber);
		return formattedNumber;
	}
	
	public void displayFormattedNumbers(){
		
		System.out.println(formattedNumber);
	}
}
