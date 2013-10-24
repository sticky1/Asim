package com.deerwalk.ml.date;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.SimpleDateFormat;

public class ParseDateTest {

	ParseDate myParseDate = new ParseDate();
	SimpleDateFormat formatDate = new SimpleDateFormat();
	
	@Test
	public void testParseString() {
		
		assertEquals(myParseDate.parseString("10/10/95 5:30 PM").toString(), "Tue Oct 10 17:30:00 NPT 1995");
	}

	@Test
	public void testCurrentDate() {
		
		myParseDate.currentDate();
	}

	@Test
	public void testParseToString() {
		
		assertEquals(myParseDate.parseToString(myParseDate.parseString("10/10/95 5:30 PM")), "10/10/95 5:30 PM");
	}

}
