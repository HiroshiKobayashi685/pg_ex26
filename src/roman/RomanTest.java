package roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanTest {

	@Test
	public void test_to_number() {
		Roman roman = new Roman();
		assertEquals(1 , roman.to_number("I"));
		assertEquals(3, roman.to_number("III"));
        assertEquals(4, roman.to_number("IV"));
        assertEquals(5, roman.to_number("V"));
        assertEquals(6, roman.to_number("VI"));
        assertEquals(9, roman.to_number("IX"));
        assertEquals(444, roman.to_number("CDXLIV"));
        assertEquals(3999, roman.to_number("MMMCMXCIX"));
    }

	/*
	@Test
	public void test_to_number_exception() {
		Roman roman = new Roman();
		try{
			roman.to_number("IIII");
		}finally {
			fail ("Caught SomeApplicationException exception");
		}
	}
	*/

	@Test
	public void test_to_roman(){
		Roman roman = new Roman();
        assertEquals("I", roman.to_roman(1));
        assertEquals("III", roman.to_roman(3));
        assertEquals("IV", roman.to_roman(4));
        assertEquals("V", roman.to_roman(5));
        assertEquals("VIII", roman.to_roman(8));
        assertEquals("IX", roman.to_roman(9));
        assertEquals("X", roman.to_roman(10));
        assertEquals("L", roman.to_roman(50));
        assertEquals("CDXLIV", roman.to_roman(444));
        assertEquals("MMMCMXCIX", roman.to_roman(3999));
	}

	@Test
	public void test_to_roman_exception(){
		Roman roman = new Roman();
        assertEquals("範囲外です", roman.to_roman(0));
        assertEquals("範囲外です", roman.to_roman(4000));
	}

}
