/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package it.xsemantics.test.fj.alt;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * alternative type system for FJ using external auxiliary functions
 */
@SuppressWarnings("all")
public class FjAltTypeSystem extends FjFirstTypeSystem {
  public final static String TYPEEQUALS = "it.xsemantics.test.fj.alt.TypeEquals";
  
  public final static String CHECKNEW = "it.xsemantics.test.fj.alt.CheckNew";
  
  public final static String CHECKCLASS = "it.xsemantics.test.fj.alt.CheckClass";
  
  @Inject
  private FjAuxiliaryFunctions fjAux;
  
  private PolymorphicDispatcher<Result<ClassType>> classtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subclassDispatcher;
  
  public FjAltTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    classtypeDispatcher = buildPolymorphicDispatcher1(
    	"classtypeImpl", 3, "||~", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
    subclassDispatcher = buildPolymorphicDispatcher1(
    	"subclassImpl", 4, "|-", "<|");
  }
  
  public FjAuxiliaryFunctions getFjAux() {
    return this.fjAux;
  }
  
  public void setFjAux(final FjAuxiliaryFunctions fjAux) {
    this.fjAux = fjAux;
  }
  
  @Override
  public Result<ClassType> classtype(final Expression expression) {
    return classtype(new RuleEnvironment(), null, expression);
  }
  
  @Override
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final Expression expression) {
    return classtype(_environment_, null, expression);
  }
  
  @Override
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return classtypeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	return resultForFailure(_e_classtype);
    }
  }
  
  @Override
  public Result<Boolean> subtype(final Type left, final Type right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtype(_environment_, null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }
  
  @Override
  public Boolean subtypeSucceeded(final Type left, final Type right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }
  
  @Override
  public Result<Boolean> subclass(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(new RuleEnvironment(), null, candidate, superclass);
  }
  
  @Override
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(_environment_, null, candidate, superclass);
  }
  
  @Override
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	return subclassInternal(_environment_, _trace_, candidate, superclass);
    } catch (Exception _e_subclass) {
    	return resultForFailure(_e_subclass);
    }
  }
  
  @Override
  public Boolean subclassSucceeded(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(new RuleEnvironment(), null, candidate, superclass);
  }
  
  @Override
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(_environment_, null, candidate, superclass);
  }
  
  @Override
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	subclassInternal(_environment_, _trace_, candidate, superclass);
    	return true;
    } catch (Exception _e_subclass) {
    	return false;
    }
  }
  
  @Override
  public Result<Boolean> checkMain(final Program program) {
    return checkMain(null, program);
  }
  
  @Override
  public Result<Boolean> checkMain(final RuleApplicationTrace _trace_, final Program program) {
    try {
    	return checkMainInternal(_trace_, program);
    } catch (Exception _e_CheckMain) {
    	return resultForFailure(_e_CheckMain);
    }
  }
  
  @Override
  protected Result<Boolean> checkMainInternal(final RuleApplicationTrace _trace_, final Program program) throws RuleFailedException {
    /* program.main == null or empty |- program.main */
    {
      RuleFailedException previousFailure = null;
      try {
        Expression _main = program.getMain();
        boolean _equals = Objects.equal(_main, null);
        /* program.main == null */
        if (!_equals) {
          sneakyThrowRuleFailedException("program.main == null");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* empty |- program.main */
        Expression _main_1 = program.getMain();
        checkInternal(emptyEnvironment(), _trace_, _main_1);
      }
    }
    return new Result<Boolean>(true);
  }
  
  @Override
  public Result<Boolean> checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    return checkClassOk(null, clazz);
  }
  
  @Override
  public Result<Boolean> checkClassOk(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) {
    try {
    	return checkClassOkInternal(_trace_, clazz);
    } catch (Exception _e_CheckClassOk) {
    	return resultForFailure(_e_CheckClassOk);
    }
  }
  
  @Override
  protected Result<Boolean> checkClassOkInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    /* empty |- clazz */
    checkInternal(emptyEnvironment(), _trace_, clazz);
    return new Result<Boolean>(true);
  }
  
  @Override
  protected Result<ClassType> classtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return classtypeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	sneakyThrowRuleFailedException(_e_classtype);
    	return null;
    }
  }
  
  @Override
  protected void classtypeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(expression);
    String _plus = (_stringRep + " has not a class type");
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  @Override
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }
  
  @Override
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not a subtype of ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    EObject source = left;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  @Override
  protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	checkParamsNotNull(candidate, superclass);
    	return subclassDispatcher.invoke(_environment_, _trace_, candidate, superclass);
    } catch (Exception _e_subclass) {
    	sneakyThrowRuleFailedException(_e_subclass);
    	return null;
    }
  }
  
  @Override
  protected void subclassThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _name = candidate.getName();
    String _plus = (_name + " is not a subclass of ");
    String _name_1 = superclass.getName();
    String _plus_1 = (_plus + _name_1);
    String error = _plus_1;
    EObject source = candidate;
    EAttribute _class_Name = FjPackage.eINSTANCE.getClass_Name();
    EStructuralFeature feature = _class_Name;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleTypeEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TypeEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeEquals) {
    	typeEqualsThrowException(e_applyRuleTypeEquals, left, right);
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleTypeEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  private void typeEqualsThrowException(final Exception e_applyRuleTypeEquals, final Type left, final Type right) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " and ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String _plus_2 = (_plus_1 + 
      " are not comparable");
    String error = _plus_2;
    throwRuleFailedException(error,
    	TYPEEQUALS, e_applyRuleTypeEquals, new ErrorInformation(null, null));
  }
  
  @Override
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckNew) {
    	checkThrowException(ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp),
    		CHECKNEW,
    		e_applyRuleCheckNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  @Override
  protected Result<Boolean> applyRuleCheckNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    List<Field> fields = this.fjAux.getFields(newExp.getType().getClassref());
    /* G |- newExp : newExp.args << fields */
    EList<Expression> _args = newExp.getArgs();
    subtypesequenceInternal(G, _trace_, newExp, _args, fields);
    final Consumer<Expression> _function = new Consumer<Expression>() {
      public void accept(final Expression it) {
        /* G |- it */
        checkInternal(G, _trace_, it);
      }
    };
    newExp.getArgs().forEach(_function);
    return new Result<Boolean>(true);
  }
  
  @Override
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckClass(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckClass) {
    	checkThrowException(ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl),
    		CHECKCLASS,
    		e_applyRuleCheckClass, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  @Override
  protected Result<Boolean> applyRuleCheckClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      List<it.xsemantics.example.fj.fj.Class> superClasses = this.fjAux.getSuperclasses(cl);
      boolean _contains = superClasses.contains(cl);
      boolean _not = (!_contains);
      /* !superClasses.contains(cl) */
      if (!_not) {
        sneakyThrowRuleFailedException("!superClasses.contains(cl)");
      }
      List<Field> inheritedFields = this.fjAux.getFields(cl.getSuperclass());
      final Consumer<Field> _function = new Consumer<Field>() {
        public void accept(final Field inheritedField) {
          List<Field> _selectFields = FjAltTypeSystem.this.fjAux.selectFields(cl);
          for (final Field field : _selectFields) {
            /* field.name != inheritedField.name or fail error "field already defined in superclass " + stringRep(inheritedField.eContainer) */
            {
              RuleFailedException previousFailure = null;
              try {
                String _name = field.getName();
                String _name_1 = inheritedField.getName();
                boolean _notEquals = (!Objects.equal(_name, _name_1));
                /* field.name != inheritedField.name */
                if (!_notEquals) {
                  sneakyThrowRuleFailedException("field.name != inheritedField.name");
                }
              } catch (Exception e) {
                previousFailure = extractRuleFailedException(e);
                /* fail error "field already defined in superclass " + stringRep(inheritedField.eContainer) */
                String _stringRep = FjAltTypeSystem.this.stringRep(inheritedField.eContainer());
                String _plus = ("field already defined in superclass " + _stringRep);
                String error = _plus;
                throwForExplicitFail(error, new ErrorInformation(null, null));
              }
            }
          }
        }
      };
      inheritedFields.forEach(_function);
      List<Method> inheritedMethods = this.fjAux.getMethods(cl.getSuperclass());
      final Consumer<Method> _function_1 = new Consumer<Method>() {
        public void accept(final Method inheritedMethod) {
          final Consumer<Method> _function = new Consumer<Method>() {
            public void accept(final Method it) {
              /* it.name != inheritedMethod.name or { G |- it.type ~~ inheritedMethod.type it.params.size == inheritedMethod.params.size val inheritedMethodParamsIt = inheritedMethod.params.iterator for (param : it.params) { G |- param.type ~~ inheritedMethodParamsIt.next.type } } */
              {
                RuleFailedException previousFailure = null;
                try {
                  String _name = it.getName();
                  String _name_1 = inheritedMethod.getName();
                  boolean _notEquals = (!Objects.equal(_name, _name_1));
                  /* it.name != inheritedMethod.name */
                  if (!_notEquals) {
                    sneakyThrowRuleFailedException("it.name != inheritedMethod.name");
                  }
                } catch (Exception e) {
                  previousFailure = extractRuleFailedException(e);
                  /* G |- it.type ~~ inheritedMethod.type */
                  Type _type = it.getType();
                  Type _type_1 = inheritedMethod.getType();
                  equalstypeInternal(G, _trace_, _type, _type_1);
                  int _size = it.getParams().size();
                  int _size_1 = inheritedMethod.getParams().size();
                  boolean _equals = (_size == _size_1);
                  /* it.params.size == inheritedMethod.params.size */
                  if (!_equals) {
                    sneakyThrowRuleFailedException("it.params.size == inheritedMethod.params.size");
                  }
                  final Iterator<Parameter> inheritedMethodParamsIt = inheritedMethod.getParams().iterator();
                  EList<Parameter> _params = it.getParams();
                  for (final Parameter param : _params) {
                    /* G |- param.type ~~ inheritedMethodParamsIt.next.type */
                    Type _type_2 = param.getType();
                    Type _type_3 = inheritedMethodParamsIt.next().getType();
                    equalstypeInternal(G, _trace_, _type_2, _type_3);
                  }
                }
              }
            }
          };
          FjAltTypeSystem.this.fjAux.selectMethods(cl).forEach(_function);
        }
      };
      inheritedMethods.forEach(_function_1);
    }
    return new Result<Boolean>(true);
  }
}
