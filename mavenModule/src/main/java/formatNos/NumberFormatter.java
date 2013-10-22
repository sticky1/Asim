package formatNos;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.text.NumberFormat;

public class NumberFormatter {

	private DecimalFormat myDecimalFormatter = new DecimalFormat();
	private NumberFormat myNumberFormatter = new NumberFormat();
	
	private double orgNumber;
	private String formattedNumber;
	
	public void readNumber(){
		
		Scanner input = new Scanner(System.in);
		
		orgNumber = input.nextDouble();
	}
	
	public void getFormattedNumber(){
		
		formattedNumber = myDecimalFormatter.format(orgNumber);
	}
	
	public String retrievePercentage(){
		
		formattedNumber = myNumberFormatter.getPercentage();
		return formattedNumber;
	}
	
	public void displayFormattedNumbers(){
		
		System.out.println(formattedNumber);
	}
}
