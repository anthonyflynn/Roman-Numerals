package roman_numerals;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class romanNumeral {
	private final Scanner scanner;
	private final PrintStream out;
	private int inputValue;
	//REMEMBER TO CLOSE THE SCANNER
	
	/* Constructor to initialise parameter values */
	public romanNumeral(InputStream in, PrintStream out) {
		scanner = new Scanner(in);
		this.out = out;
		inputValue = Integer.MAX_VALUE; // to determine if valid value entered
	}
	
	
	public static void main(String[] args) {
		romanNumeral example = new romanNumeral(System.in, System.out);
		example.input();
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
	
	/* getter function to return value*/
	public int getValue() {
		return inputValue;
	}
	

}
