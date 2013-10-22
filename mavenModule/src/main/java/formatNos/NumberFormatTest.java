package formatNos;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatTest {

	private NumberFormat myFormatter = new NumberFormat();
	
	
	@Test
	public void testReadNumber() {
		
		myFormatter.readNumber();
	}

	@Test
	public void testFormatNumber() {
		
		myFormatter.formatNumber();
	}

	@Test
	public void testDisplayFormattedNumbers() {
		
		myFormatter.displayFormattedNumbers();
	}

}
