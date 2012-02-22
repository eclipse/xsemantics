package it.xsemantics.runtime

import static extension org.eclipse.xtext.util.Strings.*

class StringRepresentationPostProcessor {
	
	public static int MAX_CHARS = 40
	
	public static String OMISSIS = "..."
	
	def process(String string) {
		if (string == null)
			""
		else
			string.limitChars(maxChars).stopAtNewLine
	}
	
	def maxChars() {
		MAX_CHARS
	}
	
	def omissis() {
		OMISSIS
	}
	
	def stopAtNewLine(String string) {
		val firstNewLine = string.indexOf("\n")
		if (firstNewLine > 0)
			string.substring(0, firstNewLine)
		else
			string
	}
	
	def limitChars(String string, int limit) {
		if (string.length > limit)
			string.substring(0, limit) + omissis
		else
			string
	}
}