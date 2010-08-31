package util;

public class JspHelper {
	public static String toRoman(int year) {
		final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		final int[]    number  = {1000, 900, 500, 400,  100,   90,  50, 40,   10,    9,   5,   4,    1};

		if (year <= 0 || year >= 4000) {
		    throw new NumberFormatException("Value outside roman numeral range.");
		}
		String romanyear = "";         // Roman notation will be accumualated here.

		// Loop from biggest value to smallest, successively subtracting,
		// from the binary value while adding to the roman representation.
		for (int i = 0; i < roman.length; i++) {
		    while (year >= number[i]) {
		        year -= number[i];
		        romanyear  += roman[i];
		    }
		}
		return romanyear;
	}
	
}
