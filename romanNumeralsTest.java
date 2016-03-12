package roman_numerals;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class romanNumeralsTest {
	
	@Test
	public void testInput0() {
		ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		System.setIn(in); // simulate user entering a given value
		//Create new romanNumeral object:
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input(); // call function to get user input 
		assertEquals(0, test.getValue()); // test value is as expected
		assertTrue(valid); // test program knows input valid
	}
	
	@Test
	public void testInput1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(1, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput10() {
		ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(10, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput987() {
		ByteArrayInputStream in = new ByteArrayInputStream("987".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(987, test.getValue());
		assertTrue(valid);
	}
	
	@Test
	public void testInput1234() {
		ByteArrayInputStream in = new ByteArrayInputStream("1234".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(1234, test.getValue());
		assertTrue(valid); 
	}

	@Test
	public void testInput3999() {
		ByteArrayInputStream in = new ByteArrayInputStream("3999".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertEquals(3999, test.getValue());
		assertTrue(valid); 
	}
	
	@Test
	public void testInput4000() {
		//input() function will loop until correct value entered.  Use -1 to finish loop
		ByteArrayInputStream in = new ByteArrayInputStream("4000\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input(); 
		assertFalse(valid);
	}
	
	@Test
	public void testInput12345() {
		ByteArrayInputStream in = new ByteArrayInputStream("12345\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputDouble() {
		ByteArrayInputStream in = new ByteArrayInputStream("1.5\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputChar() {
		ByteArrayInputStream in = new ByteArrayInputStream("abc\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus1() {
		ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus2() {
		ByteArrayInputStream in = new ByteArrayInputStream("-2\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
	@Test
	public void testInputMinus10() {
		ByteArrayInputStream in = new ByteArrayInputStream("-10\n-1".getBytes());
		System.setIn(in);
		romanNumeral test = new romanNumeral(System.in, System.out);
		boolean valid = test.input();
		assertFalse(valid);
	}
	
}
