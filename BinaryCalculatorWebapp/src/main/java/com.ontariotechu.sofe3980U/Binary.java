package com.ontariotechu.sofe3980U;

/** Name: Nuha Tahnia Haq
 *  Student ID: 100867378 */

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// Ensure empty strings are replaced with "0"
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}
	
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1, Binary num2)
	{
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		String num3 = "";  // the binary value of the sum
		
		while(ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if(ind1 >= 0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2 >= 0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2;  // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
		}
		
		return new Binary(num3);  // create a binary object with the calculated value.
	}
	
	/**
	* OR-ing two binary variables.
	*
	* @param num1 The first operand object
	* @param num2 The second operand object
	* @return A binary variable with a value of <i>num1 OR num2</i>.
	*/
	public static Binary or(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // the binary value of the OR result
		
		// if num1 and num2 have digits to be OR-ed
		while (ind1 >= 0 || ind2 >= 0) {
			// if num1 has a digit to OR, convert the digit to int and assign it to bit 1
			int bit1 = (ind1 >= 0) ? (num1.number.charAt(ind1) - '0') : 0;
			// if num2 has a digit to OR, convert the digit to int and assign it to bit 2
			int bit2 = (ind2 >= 0) ? (num2.number.charAt(ind2) - '0') : 0;

			int orResult = bit1 | bit2; // perform bitwise logical OR on bit1 and bit2
			num3 = (orResult == 1 ? "1" : "0") + num3; // convert orResult to string and append it to num3
			ind1--; // update ind1
			ind2--; // update ind2
		}
		
		return new Binary(num3);
	}	
	
	/**
	* AND-ing two binary variables.
	*
	* @param num1 The first operand object
	* @param num2 The second operand object
	* @return A binary variable with a value of <i>num1 AND num2</i>.
	*/
	public static Binary and(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // the binary value of the AND result
		
		// if num1 or num2 have digits to be AND-ed
		while (ind1 >= 0 || ind2 >= 0) {
			// if num1 has a digit to AND, convert the digit to int and assign it to bit 1
			int bit1 = (ind1 >= 0) ? (num1.number.charAt(ind1) - '0') : 0;
			// if num2 has a digit to AND, convert the digit to int and assign it to bit 2
			int bit2 = (ind2 >= 0) ? (num2.number.charAt(ind2) - '0') : 0;

			int andResult = bit1 & bit2; // perform bitwise logical AND on bit1 and bit2
			num3 = (andResult == 1 ? "1" : "0") + num3; // convert andResult to string and append it to num3
			ind1--; // update ind1
			ind2--; // update ind2
		}
		
		return new Binary(num3);
	}

	/**
	* Multiplying two binary variables, using the Add function from above.
	*
	* @param num1 The first operand object
	* @param num2 The second operand object
	* @return A binary variable with a value of <i>num1*num2</i>.
	*/
	public static Binary multiply(Binary num1, Binary num2) {
		Binary result = new Binary("0"); // initialize binary object with 0
		
		// loop until all the digits are processed for the second binary number
		for (int i = 0; i < num2.number.length(); i++) {
			// if num2 has a digit to multiply
			if (num2.number.charAt(num2.number.length() - 1 - i) == '1') {
				StringBuilder shifted = new StringBuilder(num1.number); // create a String object with num1
				for (int j = 0; j < i; j++) {
					shifted.append('0'); // append zeroes to shift num1 String object
				}
				result = add(result, new Binary(shifted.toString())); // for every shifted line, add to final result
			}
		}
		return result;
	}
}