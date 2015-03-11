package it.xsemantics.runtime;

public class StringRepresentationPostProcessor {
	
	/**
	 * @since 1.8
	 */
	protected int numOfMaxChars = 40;
	
	/**
	 * @since 1.8
	 */
	protected String omissisString = "...";
	
	public String process(String string) {
		if (string == null) {
			return "";
		}
		return stopAtNewLine(limitChars(string, maxChars()));
	}
	
	public int maxChars() {
		return numOfMaxChars;
	}
	
	public String omissis() {
		return omissisString;
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