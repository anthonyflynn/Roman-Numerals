package roman_numerals;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class romanNumeralsTest {
	private romanNumeral test;
	private ByteArrayInputStream in;
	
	//Unit tests for function input()
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
	
	//Unit tests for function getOnes()
	
	@Test
	public void testOnes0() {
		int inputValue = 0;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("", outputValue);
	}
	
	@Test
	public void testOnes1() {
		int inputValue = 1;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("I", outputValue);
	}
	
	@Test
	public void testOnes2() {
		int inputValue = 2;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("II", outputValue);
	}
	
	@Test
	public void testOnes3() {
		int inputValue = 3;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("III", outputValue);
	}
	
	@Test
	public void testOnes4() {
		int inputValue = 4;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("IV", outputValue);
	}
	
	@Test
	public void testOnes5() {
		int inputValue = 5;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("V", outputValue);
	}
	
	@Test
	public void testOnes6() {
		int inputValue = 6;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("VI", outputValue);
	}
	
	@Test
	public void testOnes7() {
		int inputValue = 7;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("VII", outputValue);
	}
	
	@Test
	public void testOnes8() {
		int inputValue = 8;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("VIII", outputValue);
	}
	
	@Test
	public void testOnes9() {
		int inputValue = 9;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getOnes(inputValue);
		assertEquals("IX", outputValue);
	}
	
	//Unit tests for function getTens()
	
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
		assertEquals("X", outputValue);
	}
	
	@Test
	public void testTens2() {
		int inputValue = 2;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("XX", outputValue);
	}
	
	@Test
	public void testTens3() {
		int inputValue = 3;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("XXX", outputValue);
	}
	
	@Test
	public void testTens4() {
		int inputValue = 4;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("XL", outputValue);
	}
	
	@Test
	public void testTens5() {
		int inputValue = 5;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("L", outputValue);
	}
	
	@Test
	public void testTens6() {
		int inputValue = 6;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("LX", outputValue);
	}
	
	@Test
	public void testTens7() {
		int inputValue = 7;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("LXX", outputValue);
	}
	
	@Test
	public void testTens8() {
		int inputValue = 8;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("LXXX", outputValue);
	}
	
	@Test
	public void testTens9() {
		int inputValue = 9;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getTens(inputValue);
		assertEquals("XC", outputValue);
	}
	
	//Unit tests for function getHundreds()
	
	@Test
	public void testHundreds0() {
		int inputValue = 0;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("", outputValue);
	}
		
	@Test
	public void testHundreds1() {
		int inputValue = 1;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("C", outputValue);
	}
	
	@Test
	public void testHundreds2() {
		int inputValue = 2;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("CC", outputValue);
	}
	
	@Test
	public void testHundreds3() {
		int inputValue = 3;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("CCC", outputValue);
	}
	
	@Test
	public void testHundreds4() {
		int inputValue = 4;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("CD", outputValue);
	}
	
	@Test
	public void testHundreds5() {
		int inputValue = 5;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("D", outputValue);
	}
	
	@Test
	public void testHundreds6() {
		int inputValue = 6;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("DC", outputValue);
	}
	
	@Test
	public void testHundreds7() {
		int inputValue = 7;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("DCC", outputValue);
	}
	
	@Test
	public void testHundreds8() {
		int inputValue = 8;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("DCCC", outputValue);
	}
	
	@Test
	public void testHundreds9() {
		int inputValue = 9;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getHundreds(inputValue);
		assertEquals("CM", outputValue);
	}

	//Unit tests for function getHundreds()
	
	@Test
	public void testThousands0() {
		int inputValue = 0;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getThousands(inputValue);
		assertEquals("", outputValue);
	}
			
	@Test
	public void testThousands1() {
		int inputValue = 1;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getThousands(inputValue);
		assertEquals("M", outputValue);
	}
			
	@Test
	public void testThousands2() {
		int inputValue = 2;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getThousands(inputValue);
		assertEquals("MM", outputValue);
	}
			
	@Test
	public void testThousands3() {
		int inputValue = 3;
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.getThousands(inputValue);
		assertEquals("MMM", outputValue);
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
	public void testRomanNumeralEquivalent850() {
		int inputValue = 850; // Tests C on right of D and L on right of C
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("DCCCL", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent1145() {
		int inputValue = 1145; // Tests C on right of M, X on left of C and V on right of L
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MCXLV", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent3999() {
		int inputValue = 3999; // Tests C on left of M, X and I on left of C
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMMCMXCIX", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent3554() {
		int inputValue = 3556; // Tests D on right of M, L on right of D and I on right of V
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMMDLVI", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent2449() {
		int inputValue = 2449; // Tests C on left of D, X on left of L, I on left of X
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MMCDXLIX", outputValue);
	}
	
	@Test
	public void testRomanNumeralEquivalent1965() {
		int inputValue = 1965; // Tests C on left of M, L on left of X and V on right of X
		test = new romanNumeral(System.in, System.out);
		String outputValue = test.romanNumeralEquivalent(inputValue);
		assertEquals("MCMLXV", outputValue);
	}
}
