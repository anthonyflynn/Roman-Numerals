package roman_numerals;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class romanNumeral {
	private final Scanner scanner;
	private final PrintStream out;
	private int inputValue;
	private String romanNumeral;
	
	/* Constructor to initialise parameter values */
	public romanNumeral(InputStream in, PrintStream out) {
		scanner = new Scanner(in);
		this.out = out;
		inputValue = Integer.MAX_VALUE; // to determine if valid value entered
		romanNumeral = "";
	}
	
	/* Method to run the converter */
	public void run() {		
		while(true) { // loop while user has more values to convert
			if(!this.input()) { // false when user types -1 (to exit program)
				break;
			}
			this.romanNumeralEquivalent(this.inputValue);
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
		out.println("The equivalent value in Roman Numerals is: " + romanNumeral);
		
		try {
			out.println("Would you like to convert another value? (y/n)");
			String repeat = scanner.next();
			if(repeat.charAt(0) == 'y' || repeat.charAt(0) == 'Y') {
				inputValue = Integer.MAX_VALUE;
				romanNumeral = "";
				return true;
			}
			else if(repeat.charAt(0) == 'n' || repeat.charAt(0) == 'N') {
				out.println("Exiting program.");
			}
			else {
				out.println("Command not understood, exiting program.");
			}
		} catch(Exception e) {
			out.println("Command not understood, exiting program.");	
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
		int unit = 0;
		
		unit = inputValue / 1000;
		inputValue = inputValue % 1000;
		romanNumeral += getThousands(unit); // adds thousands part
		
		unit = inputValue / 100;
		inputValue = inputValue % 100;
		romanNumeral += getHundreds(unit); // adds hundreds part
		
		unit = inputValue / 10;
		inputValue = inputValue % 10;
		romanNumeral += getTens(unit); // adds tens part
		romanNumeral += getOnes(inputValue); // remainder is units part
		
		return romanNumeral;
	}
	
	/* Method to return the value in the single units column of input*/
	public String getOnes(int inputValue) {
		switch(inputValue) {
		case 0: return "";
		case 1: return "I";
		case 2:	return "II";
		case 3:	return "III";
		case 4:	return "IV";
		case 5: return "V";
		case 6: return "VI";
		case 7: return "VII";
		case 8: return "VIII";
		case 9:	return "IX";
		default:
			out.println("Error in ones function.  Exiting.");
			System.exit(-1);
			return "";
		}
	}
	
	/* Method to return the value in the tens units column of input*/
	public String getTens(int inputValue) {
		switch(inputValue) {
		case 0: return "";
		case 1: return "X";
		case 2:	return "XX";
		case 3:	return "XXX";
		case 4:	return "XL";
		case 5: return "L";
		case 6: return "LX";
		case 7: return "LXX";
		case 8: return "LXXX";
		case 9:	return "XC";
		default:
			out.println("Error in tens function.  Exiting.");
			System.exit(-1);
			return "";
		}
	}
	
	/* Method to return the value in the hundreds units column of input*/
	public String getHundreds(int inputValue) {
		switch(inputValue) {
		case 0: return "";
		case 1: return "C";
		case 2:	return "CC";
		case 3:	return "CCC";
		case 4:	return "CD";
		case 5: return "D";
		case 6: return "DC";
		case 7: return "DCC";
		case 8: return "DCCC";
		case 9:	return "CM";
		default:
			out.println("Error in hundreds function.  Exiting.");
			System.exit(-1);
			return "";
		}
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
