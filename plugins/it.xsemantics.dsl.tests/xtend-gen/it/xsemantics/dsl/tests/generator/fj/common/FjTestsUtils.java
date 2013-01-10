package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Member;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Program;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class FjTestsUtils {
  public it.xsemantics.example.fj.fj.Class fjClassForName(final Program program, final String className) {
    EList<it.xsemantics.example.fj.fj.Class> _classes = program.getClasses();
    final Function1<it.xsemantics.example.fj.fj.Class,Boolean> _function = new Function1<it.xsemantics.example.fj.fj.Class,Boolean>() {
        public Boolean apply(final it.xsemantics.example.fj.fj.Class it) {
          String _name = it.getName();
          boolean _equals = _name.equals(className);
          return Boolean.valueOf(_equals);
        }
      };
    it.xsemantics.example.fj.fj.Class _findFirst = IterableExtensions.<it.xsemantics.example.fj.fj.Class>findFirst(_classes, _function);
    return _findFirst;
  }
  
  public Field fjFieldForName(final Program program, final String fieldName) {
    Field _xblockexpression = null;
    {
      List<Field> _allContentsOfType = EcoreUtil2.<Field>getAllContentsOfType(program, Field.class);
      final Function1<Field,Boolean> _function = new Function1<Field,Boolean>() {
          public Boolean apply(final Field it) {
            String _name = it.getName();
            boolean _equals = _name.equals(fieldName);
            return Boolean.valueOf(_equals);
          }
        };
      final Field field = IterableExtensions.<Field>findFirst(_allContentsOfType, _function);
      String _plus = ("field not found: " + fieldName);
      boolean _notEquals = ObjectExtensions.operator_notEquals(field, null);
      Assert.assertTrue(_plus, _notEquals);
      _xblockexpression = (field);
    }
    return _xblockexpression;
  }
  
  public Method fjMethodForName(final Program program, final String methodName) {
    Method _xblockexpression = null;
    {
      List<Method> _allContentsOfType = EcoreUtil2.<Method>getAllContentsOfType(program, Method.class);
      final Function1<Method,Boolean> _function = new Function1<Method,Boolean>() {
          public Boolean apply(final Method it) {
            String _name = it.getName();
            boolean _equals = _name.equals(methodName);
            return Boolean.valueOf(_equals);
          }
        };
      final Method method = IterableExtensions.<Method>findFirst(_allContentsOfType, _function);
      String _plus = ("method not found: " + methodName);
      boolean _notEquals = ObjectExtensions.operator_notEquals(method, null);
      Assert.assertTrue(_plus, _notEquals);
      _xblockexpression = (method);
    }
    return _xblockexpression;
  }
  
  public Expression mainExpression(final Program program) {
    Expression _main = program.getMain();
    return _main;
  }
  
  public ParamRef variableExpression(final Program program) {
    List<ParamRef> _allContentsOfType = EcoreUtil2.<ParamRef>getAllContentsOfType(program, ParamRef.class);
    ParamRef _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public String diagnosticsToString(final AssertableDiagnostics validate) {
    Diagnostic _diagnostic = validate.getDiagnostic();
    List<Diagnostic> _children = _diagnostic.getChildren();
    String _join = IterableExtensions.join(_children, "\n");
    return _join;
  }
  
  public String removeObjectIdentifiers(final String s) {
    String _replaceAll = s.replaceAll("@(\\w)+", "");
    return _replaceAll;
  }
  
  public Field field(final Member member) {
    return ((Field) member);
  }
  
  public Method method(final Member member) {
    return ((Method) member);
  }
}
