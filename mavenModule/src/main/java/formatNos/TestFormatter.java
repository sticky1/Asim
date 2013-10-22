package formatNos;

public class TestFormatter {

	public static void main(String[] args) {

		NumberFormat myFormatter = new NumberFormat();
		
		System.out.println("\nEnter a number to format: ");
		myFormatter.readNumber();
		myFormatter.getFormattedNumber();
		myFormatter.displayFormattedNumbers();
		
		System.out.println("\nEnter a number less than 1 and greater than 0 to get percentage: ");
		myFormatter.readNumber();
		myFormatter.getPercentage();
		myFormatter.displayFormattedNumbers();
	}

}
