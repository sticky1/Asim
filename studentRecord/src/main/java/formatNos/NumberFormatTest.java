package formatNos;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatTest {

	private NumberFormatter myFormatter = new NumberFormatter();
	
	@Test
	public void testReadNumber() {
		
		assertEquals(123,123.123, myFormatter.readNumber());
	}

	@Test
	public void testGetFormattedNumber() {
		
		myFormatter.getFormattedNumber();
	}

	@Test
	public void testDisplayFormattedNumbers() {
		
		myFormatter.displayFormattedNumbers();
	}

	@Test
	public void testRetrievePercentage(){
		
		myFormatter.readNumber();	
		assertEquals("67%", myFormatter.retrievePercentage());
	}
}
