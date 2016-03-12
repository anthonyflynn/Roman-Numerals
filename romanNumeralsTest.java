package roman_numerals;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class romanNumeralsTest {
	private romanNumeral test;
	private ByteArrayInputStream in;
	
	@Test
	public void testInput0() {
		in = new ByteArrayInputStream("0".getBytes());
		System.setIn(in); // simulate user entering a given value
		//Create new romanNumeral object:
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input(); // call function to get user input 
		assertEquals(0, test.getValue()); // test value is as expected
		assertTrue(valid); // test program knows input valid
	}
	
	@Test
	public void testInput1() {
		in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(1, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput10() {
		in = new ByteArrayInputStream("10".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(10, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput987() {
		in = new ByteArrayInputStream("987".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(987, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput1234() {
		in = new ByteArrayInputStream("1234".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(1234, test.getValue());
		assertTrue(valid); 
	}

	@Test
	public void testInput3999() {
		in = new ByteArrayInputStream("3999".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(3999, test.getValue());
		assertTrue(valid); 
	}
	
	@Test
	public void testInput4000() {
		//input() function will loop until correct value entered.  Use -1 to finish loop
		in = new ByteArrayInputStream("4000\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input(); 
		assertFalse(valid);
	}
	
	@Test
	public void testInput12345() {
		in = new ByteArrayInputStream("12345\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputDouble() {
		in = new ByteArrayInputStream("1.5\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputChar() {
		in = new ByteArrayInputStream("abc\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus1() {
		in = new ByteArrayInputStream("-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus2() {
		in = new ByteArrayInputStream("-2\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus10() {
		in = new ByteArrayInputStream("-10\n-1".getBytes());
		System.setIn(in);
		test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testTens0() {
		int inputValue = 0;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("", outputValue);
	}
	
	@Test
	public void testTens1() {
		int inputValue = 1;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("I", outputValue);
	}
	
	@Test
	public void testTens2() {
		int inputValue = 2;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("II", outputValue);
	}
	
	@Test
	public void testTens3() {
		int inputValue = 3;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("III", outputValue);
	}
	
	@Test
	public void testTens4() {
		int inputValue = 4;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("IV", outputValue);
	}
	
	@Test
	public void testTens5() {
		int inputValue = 5;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("V", outputValue);
	}
	
	@Test
	public void testTens6() {
		int inputValue = 6;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("VI", outputValue);
	}
	
	@Test
	public void testTens7() {
		int inputValue = 7;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("VII", outputValue);
	}
	
	@Test
	public void testTens8() {
		int inputValue = 8;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("VIII", outputValue);
	}
	
	@Test
	public void testTens9() {
		int inputValue = 9;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("IX", outputValue);
	}
	
	
	//Tests for full number converter function:
	@Test
	public void testRomanNumeralEquivalent1() {
		int inputValue = 1;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("I", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent5() {
		int inputValue = 5;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("V", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent10() {
		int inputValue = 10;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("X", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent20() {
		int inputValue = 20;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("XX", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent3999() {
		int inputValue = 3999;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMMCMXCIX", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent3554() {
		int inputValue = 3554;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMMDLIV", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent2449() {
		int inputValue = 2449;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMCDXLIX", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent1965() {
		int inputValue = 1965;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MCMLXV", outputValue);
	}
}
