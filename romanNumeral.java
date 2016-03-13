package roman_numerals;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class romanNumeral {
	private final Scanner scanner;
	private final PrintStream out;
	private int inputValue;
	private String romanNumeralValue;
	
	/* Constructor to initialise parameter values */
	public romanNumeral(InputStream in, PrintStream out) {
		scanner = new Scanner(in);
		this.out = out;
		inputValue = Integer.MAX_VALUE; // to determine if valid value entered
		romanNumeralValue = "";
	}
	
	/* Method to run the converter */
	public void run() {		
		while(true) { // loop while user has more values to convert
			if(!this.input()) { // false when user types -1 (to exit program)
				break;
			}
			
			this.romanNumeralEquivalent(this.inputValue); // do conversion
			
			if(!this.output()) { // false when user do not have another value to convert
				break;
			}
		}
		
		scanner.close(); // close input stream
		out.close(); // close output stream
	}
	
	/* Main method */
	public static void main(String[] args) {
		romanNumeral example = new romanNumeral(System.in, System.out);
		example.run(); // start the romanNumeral converter object
	}
	
	
	/* Method asks the user to input a value and loops while an invalid number is
	 * entered.  Returns false if user wants to exit program, or true if input valid*/
	public boolean input() {
		out.println("Please enter an integer between 1 and 3,999 to be"
				+ " converted into a roman numeral, or '-1' to exit:");

		while(inputValue == Integer.MAX_VALUE) { // loops while user inputs invalid number
			try {
				int temp = scanner.nextInt();
				
				if(temp == -1) { // user wants to exit
					out.println("Exiting program.");
					return false;
				}
				else if(temp > -1 && temp <= 3999) { // valid input entered
					inputValue = temp;
				}
				else { // integer entered outside the valid range
					out.println("Output not valid. Please try again or enter '-1' to exit:");
				}
			} catch(InputMismatchException e) { // value entered not an integer
				out.println("Output not valid. Please try again or enter '-1' to exit:");
			    scanner.next(); // consumes the invalid user entry
			} catch(Exception e) { // unknown exception
				out.println("Error: " + e);
				System.exit(-1);
			}
		}
		out.println("Value entered: " + this.inputValue);
		return true;
	}
	
	/* Method outputs the roman numeral equivalent of input integer.  If user would like
	 * to convert another integer, method returns true.  Otherwise, false.*/
	public boolean output() {
		out.println("The equivalent value in Roman Numerals is: " + romanNumeralValue);
		
		try {
			out.println("Would you like to convert another value? (y/n)");
			String repeat = scanner.next();
			if(repeat.charAt(0) == 'y' || repeat.charAt(0) == 'Y') {
				inputValue = Integer.MAX_VALUE; // reset inputValue
				romanNumeralValue = ""; // Empty romanNumeral
				return true; // Ask user for another input number
			}
			else if(repeat.charAt(0) == 'n' || repeat.charAt(0) == 'N') {
				out.println("Exiting program."); // No more values to convert
			}
			else {
				out.println("Command not understood, exiting program.");
			}
		} catch(Exception e) {
			out.println("Error: " + e);
		}	
		return false;
	}
	
	/* Getter method to return value*/
	public int getValue() {
		return inputValue;
	}
	
	/* Method converts inputValue to its roman numeral equivalent and assigns
	 * this to the string romanNumeral*/
	public String romanNumeralEquivalent(int inputValue) {
		romanNumeralValue = getOnes(inputValue % 10) + romanNumeralValue; // adds units part
		inputValue /= 10;
		
		romanNumeralValue = getTens(inputValue % 10) + romanNumeralValue; // adds tens part
		inputValue /= 10;
		
		romanNumeralValue = getHundreds(inputValue % 10) + romanNumeralValue; // adds hundreds part
		inputValue /= 10;
		
		romanNumeralValue = getThousands(inputValue % 10) + romanNumeralValue; // adds thousands part
		
		return romanNumeralValue;
	}
	
	/* Method converts the integer inputValue into an equivalent roman numeral
	 * string and returns this string.  The parameters oneUnit, fiveUnit and tenUnit
	 * depend on whether inputValue is the units, tens or hundreds column of number
	 * being converted (e.g. for tens, the values are X(10), L(50) and C(100) respectively.*/
	private String getDigitEquivalent(int inputValue, String oneUnit, String fiveUnit, String tenUnit) {
		switch(inputValue) {
		case 0: return "";
		case 1: return oneUnit;
		case 2:	return oneUnit + oneUnit;
		case 3:	return oneUnit + oneUnit + oneUnit;
		case 4:	return oneUnit + fiveUnit;
		case 5: return fiveUnit;
		case 6: return fiveUnit + oneUnit;
		case 7: return fiveUnit + oneUnit + oneUnit;
		case 8: return fiveUnit + oneUnit + oneUnit + oneUnit;
		case 9:	return oneUnit + tenUnit;
		default:
			out.println("Invalid digit called during conversion.  Exiting.");
			System.exit(-1);
			return "";
		}
	}
	
	/* Method to return the value in the ones units column of input*/
	public String getOnes(int inputValue) {
		return getDigitEquivalent(inputValue, "I", "V", "X");
	}
	
	/* Method to return the value in the tens units column of input*/
	public String getTens(int inputValue) {
		return getDigitEquivalent(inputValue, "X", "L", "C");
	}
	
	/* Method to return the value in the hundreds units column of input*/
	public String getHundreds(int inputValue) {
		return getDigitEquivalent(inputValue, "C", "D", "M");
	}
	
	/* Method to return the value in the thousands units column of input*/
	public String getThousands(int inputValue) {
		String thousandsString = "";
		for(int i = 0; i < inputValue; i++) {
			thousandsString += "M";
		}
		return thousandsString;
	}


}
