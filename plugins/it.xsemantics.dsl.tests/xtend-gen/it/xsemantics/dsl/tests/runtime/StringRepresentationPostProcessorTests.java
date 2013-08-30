package it.xsemantics.dsl.tests.runtime;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.runtime.StringRepresentationPostProcessor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class StringRepresentationPostProcessorTests extends XsemanticsBaseTest {
  @Inject
  @Extension
  private StringRepresentationPostProcessor processor;
  
  @Test
  public void testStopAtNewLineAbsent() {
    String _stopAtNewLine = this.processor.stopAtNewLine("no new line");
    this.assertEqualsStrings("no new line", _stopAtNewLine);
  }
  
  @Test
  public void testStopAtNewLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("no new line");
    _builder.newLine();
    _builder.append("some new");
    _builder.newLine();
    _builder.append("lines");
    _builder.newLine();
    String _string = _builder.toString();
    String _stopAtNewLine = this.processor.stopAtNewLine(_string);
    this.assertEqualsStrings("no new line", _stopAtNewLine);
  }
  
  @Test
  public void testLimitTo() {
    String _limitChars = this.processor.limitChars("123456", 4);
    this.assertEqualsStrings("1234...", _limitChars);
  }
  
  @Test
  public void testLimitToWithSmaller() {
    String _limitChars = this.processor.limitChars("12", 4);
    this.assertEqualsStrings("12", _limitChars);
  }
  
  @Test
  public void testLimitSameLength() {
    String _limitChars = this.processor.limitChars("12", 2);
    this.assertEqualsStrings("12", _limitChars);
  }
  
  @Test
  public void testProcessNull() {
    String _process = this.processor.process(null);
    this.assertEqualsStrings("", _process);
  }
  
  @Test
  public void testProcessLongString() {
    int _length = StringRepresentationPostProcessor.OMISSIS.length();
    int _plus = (StringRepresentationPostProcessor.MAX_CHARS + _length);
    int _plus_1 = (StringRepresentationPostProcessor.MAX_CHARS + 30);
    String _repeat = Strings.repeat("a", _plus_1);
    String _process = this.processor.process(_repeat);
    int _length_1 = _process.length();
    Assert.assertEquals(_plus, _length_1);
  }
  
  @Test
  public void testProcess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("no new line");
    _builder.newLine();
    _builder.append("some new");
    _builder.newLine();
    _builder.append("lines");
    _builder.newLine();
    String _string = _builder.toString();
    String _process = this.processor.process(_string);
    this.assertEqualsStrings("no new line", _process);
  }
}
