package it.xsemantics.runtime;

import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class StringRepresentationPostProcessor {
  public static int MAX_CHARS = 40;
  
  public static String OMISSIS = "...";
  
  public String process(final String string) {
    String _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(string, null);
    if (_operator_equals) {
      _xifexpression = "";
    } else {
      int _maxChars = this.maxChars();
      String _limitChars = this.limitChars(string, _maxChars);
      String _stopAtNewLine = this.stopAtNewLine(_limitChars);
      _xifexpression = _stopAtNewLine;
    }
    return _xifexpression;
  }
  
  public int maxChars() {
    return StringRepresentationPostProcessor.MAX_CHARS;
  }
  
  public String omissis() {
    return StringRepresentationPostProcessor.OMISSIS;
  }
  
  public String stopAtNewLine(final String string) {
    String _xblockexpression = null;
    {
      int _indexOf = string.indexOf("\n");
      final int firstNewLine = _indexOf;
      String _xifexpression = null;
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(firstNewLine, 0);
      if (_operator_greaterThan) {
        String _substring = string.substring(0, firstNewLine);
        _xifexpression = _substring;
      } else {
        _xifexpression = string;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String limitChars(final String string, final int limit) {
    String _xifexpression = null;
    int _length = string.length();
    boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_length, limit);
    if (_operator_greaterThan) {
      String _substring = string.substring(0, limit);
      String _omissis = this.omissis();
      String _operator_plus = StringExtensions.operator_plus(_substring, _omissis);
      _xifexpression = _operator_plus;
    } else {
      _xifexpression = string;
    }
    return _xifexpression;
  }
}
