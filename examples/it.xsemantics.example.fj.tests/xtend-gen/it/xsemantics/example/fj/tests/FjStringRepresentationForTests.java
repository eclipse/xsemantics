package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.Cast;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Member;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.MethodBody;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.typing.FjStringRepresentation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class FjStringRepresentationForTests extends FjStringRepresentation {
  public String stringRep(final EObject eObject) {
    final ICompositeNode node = NodeModelUtils.getNode(eObject);
    boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
    if (_notEquals) {
      return super.stringRep(eObject);
    } else {
      CharSequence _customRep = this.customRep(eObject);
      return _customRep.toString();
    }
  }
  
  protected CharSequence _customRep(final EObject eObject) {
    String _stringRep = super.stringRep(eObject);
    return _stringRep;
  }
  
  protected CharSequence _customRep(final New exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    ClassType _type = exp.getType();
    it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
    String _name = _classref.getName();
    _builder.append(_name, "");
    _builder.append("(");
    EList<Expression> _args = exp.getArgs();
    final Function1<Expression,String> _function = new Function1<Expression,String>() {
        public String apply(final Expression it) {
          String _string = FjStringRepresentationForTests.this.string(it);
          return _string;
        }
      };
    List<String> _map = ListExtensions.<Expression, String>map(_args, _function);
    String _join = IterableExtensions.join(_map, ", ");
    String _plus = (_builder + _join);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(")");
    String _plus_1 = (_plus + _builder_1.toString());
    return _plus_1;
  }
  
  protected CharSequence _customRep(final Selection exp) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _receiver = exp.getReceiver();
    String _string = this.string(_receiver);
    _builder.append(_string, "");
    _builder.append(".");
    String _switchResult = null;
    Member _message = exp.getMessage();
    final Member _switchValue = _message;
    boolean _matched = false;
    if (!_matched) {
      if (_switchValue instanceof Field) {
        final Field _field = (Field)_switchValue;
        _matched=true;
        Member _message_1 = exp.getMessage();
        String _name = _message_1.getName();
        _switchResult = _name;
      }
    }
    if (!_matched) {
      if (_switchValue instanceof Method) {
        final Method _method = (Method)_switchValue;
        _matched=true;
        Member _message_1 = exp.getMessage();
        String _name = _message_1.getName();
        String _plus = (_name + "(");
        EList<Expression> _args = exp.getArgs();
        final Function1<Expression,String> _function = new Function1<Expression,String>() {
            public String apply(final Expression it) {
              String _string = FjStringRepresentationForTests.this.string(it);
              return _string;
            }
          };
        List<String> _map = ListExtensions.<Expression, String>map(_args, _function);
        String _join = IterableExtensions.join(_map, ", ");
        String _plus_1 = (_plus + _join);
        String _plus_2 = (_plus_1 + 
          ")");
        _switchResult = _plus_2;
      }
    }
    String _plus = (_builder + _switchResult);
    return _plus;
  }
  
  protected CharSequence _customRep(final Cast cast) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    ClassType _type = cast.getType();
    it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
    String _name = _classref.getName();
    _builder.append(_name, "");
    _builder.append(") ");
    Expression _expression = cast.getExpression();
    String _string = this.string(_expression);
    _builder.append(_string, "");
    return _builder;
  }
  
  protected CharSequence _customRep(final ClassType c) {
    it.xsemantics.example.fj.fj.Class _classref = c.getClassref();
    String _name = _classref.getName();
    return _name;
  }
  
  protected CharSequence _customRep(final BasicType c) {
    String _basic = c.getBasic();
    return _basic;
  }
  
  protected CharSequence _customRep(final MethodBody m) {
    Expression _expression = m.getExpression();
    String _stringRep = this.stringRep(_expression);
    return _stringRep;
  }
  
  public CharSequence customRep(final EObject c) {
    if (c instanceof BasicType) {
      return _customRep((BasicType)c);
    } else if (c instanceof Cast) {
      return _customRep((Cast)c);
    } else if (c instanceof ClassType) {
      return _customRep((ClassType)c);
    } else if (c instanceof New) {
      return _customRep((New)c);
    } else if (c instanceof Selection) {
      return _customRep((Selection)c);
    } else if (c instanceof MethodBody) {
      return _customRep((MethodBody)c);
    } else if (c != null) {
      return _customRep(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
