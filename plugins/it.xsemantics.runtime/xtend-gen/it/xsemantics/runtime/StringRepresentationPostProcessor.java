package it.xsemantics.runtime;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class StringRepresentationPostProcessor {
  public static int MAX_CHARS = 40;
  
  public static String OMISSIS = "...";
  
  public String process(final String string) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
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
      final int firstNewLine = string.indexOf("\n");
      String _xifexpression = null;
      boolean _greaterThan = (firstNewLine > 0);
      if (_greaterThan) {
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
    boolean _greaterThan = (_length > limit);
    if (_greaterThan) {
      String _substring = string.substring(0, limit);
      String _omissis = this.omissis();
      String _plus = (_substring + _omissis);
      _xifexpression = _plus;
    } else {
      _xifexpression = string;
    }
    return _xifexpression;
  }
}
