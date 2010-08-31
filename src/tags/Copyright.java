package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class Copyright extends SimpleTagSupport {
	
	private static final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final int[]    number  = {1000, 900, 500, 400,  100,   90,  50, 40,   10,    9,   5,   4,    1};
	
	public static String toRoman(int year) {

		if (year <= 0 || year >= 4000) {
		    throw new NumberFormatException("Value outside roman numeral range.");
		}
		String romanyear = "";

		for (int i = 0; i < roman.length; i++) {
		    while (year >= number[i]) {
		        year -= number[i];
		        romanyear  += roman[i];
		    }
		}
		return romanyear;
	}
	
	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		StringWriter stringWriter = new StringWriter();
		JspFragment body = getJspBody();
		
		try {
			body.invoke(stringWriter);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		try {
		out.println("Hello World");
		} catch (Exception e) {
		// Ignore.
		}
	}
}
