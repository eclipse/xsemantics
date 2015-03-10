package it.xsemantics.runtime;

public class StringRepresentationPostProcessor {
	
	public static int MAX_CHARS = 40;
	
	public static String OMISSIS = "...";
	
	public String process(String string) {
		if (string == null) {
			return "";
		}
		return stopAtNewLine(limitChars(string, maxChars()));
	}
	
	public int maxChars() {
		return MAX_CHARS;
	}
	
	public String omissis() {
		return OMISSIS;
	}
	
	public String stopAtNewLine(String string) {
		int firstNewLine = string.indexOf("\n");
		if (firstNewLine > 0) {
			return string.substring(0, firstNewLine);
		}
		return string;
	}
	
	public String limitChars(String string, int limit) {
		if (string.length() > limit) {
			return string.substring(0, limit) + omissis();
		}
		return string;
	}
}