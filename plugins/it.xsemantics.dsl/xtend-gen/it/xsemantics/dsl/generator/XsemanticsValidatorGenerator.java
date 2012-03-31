package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XsemanticsValidatorGenerator {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  public CharSequence compile(final XsemanticsSystem ts) {
    CharSequence _xblockexpression = null;
    {
      JvmGenericType _createValidatorJvmType = this._xsemanticsGeneratorExtensions.createValidatorJvmType(ts);
      ImportManager _importManager = new ImportManager(true, _createValidatorJvmType);
      final ImportManager importManager = _importManager;
      CharSequence _compile = this.compile(ts, importManager);
      _xblockexpression = (_compile);
    }
    return _xblockexpression;
  }
  
  public CharSequence compile(final XsemanticsSystem ts, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    final String packageGen = this._xsemanticsGeneratorExtensions.toValidatorPackage(ts);
    _builder.newLineIfNotEmpty();
    final String injectClass = this._xsemanticsGeneratorExtensions.injectAnnotation(importManager);
    _builder.newLineIfNotEmpty();
    JvmGenericType _createJvmType = this._xsemanticsGeneratorExtensions.createJvmType(ts);
    final CharSequence generatedTypeSystemClass = importManager.serialize(_createJvmType);
    _builder.newLineIfNotEmpty();
    JvmGenericType _createJvmType_1 = this._xsemanticsGeneratorExtensions.createJvmType(XsemanticsBasedDeclarativeValidator.class);
    final CharSequence superClass = importManager.serialize(_createJvmType_1);
    _builder.newLineIfNotEmpty();
    final String checkMethods = this.compileCheckRuleMethods(ts, importManager);
    _builder.newLineIfNotEmpty();
    {
      int _length = packageGen.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("package ");
        _builder.append(packageGen, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<String> _imports = importManager.getImports();
      boolean _isEmpty = _imports.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.newLine();
        {
          List<String> _imports_1 = importManager.getImports();
          for(final String i : _imports_1) {
            _builder.append("import ");
            _builder.append(i, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _validatorJavaClassName = this._xsemanticsGeneratorExtensions.toValidatorJavaClassName(ts);
    _builder.append(_validatorJavaClassName, "");
    _builder.append(" extends ");
    _builder.append(superClass, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(injectClass, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected ");
    _builder.append(generatedTypeSystemClass, "	");
    _builder.append(" xsemanticsSystem;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(checkMethods, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String compileCheckRuleMethods(final XsemanticsSystem ts, final ImportManager importManager) {
    EList<CheckRule> _checkrules = ts.getCheckrules();
    final Function1<CheckRule,CharSequence> _function = new Function1<CheckRule,CharSequence>() {
        public CharSequence apply(final CheckRule it) {
          CharSequence _compileCheckRuleMethod = XsemanticsValidatorGenerator.this.compileCheckRuleMethod(it, importManager);
          return _compileCheckRuleMethod;
        }
      };
    List<CharSequence> _map = ListExtensions.<CheckRule, CharSequence>map(_checkrules, _function);
    String _join = IterableExtensions.join(_map, "\n");
    return _join;
  }
  
  public CharSequence compileCheckRuleMethod(final CheckRule rule, final ImportManager importManager) {
    StringConcatenation _builder = new StringConcatenation();
    String _checkAnnotation = this._xsemanticsGeneratorExtensions.checkAnnotation(importManager);
    _builder.append(_checkAnnotation, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void ");
    String _methodName = this._xsemanticsGeneratorExtensions.methodName(rule);
    _builder.append(_methodName, "");
    _builder.append("(");
    CharSequence _inputParameter = this._xsemanticsGeneratorExtensions.inputParameter(rule, importManager);
    _builder.append(_inputParameter, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("generateErrors(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xsemanticsSystem.");
    String _methodName_1 = this._xsemanticsGeneratorExtensions.methodName(rule);
    _builder.append(_methodName_1, "		");
    _builder.append("(");
    CharSequence _inputParameterName = this._xsemanticsGeneratorExtensions.inputParameterName(rule);
    _builder.append(_inputParameterName, "		");
    _builder.append("),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _inputParameterName_1 = this._xsemanticsGeneratorExtensions.inputParameterName(rule);
    _builder.append(_inputParameterName_1, "		");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
