package it.xsemantics.example.fj.typing;

import com.google.common.base.Objects;
import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.Cast;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.example.fj.fj.IntConstant;
import it.xsemantics.example.fj.fj.Member;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.MethodBody;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.fj.StringConstant;
import it.xsemantics.example.fj.fj.This;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.fj.TypedElement;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * A version of the FJ system where type computation involves also
 * type checking.
 */
public class FjTypeSystem extends XsemanticsRuntimeSystem {
  public final static String TTHIS = "it.xsemantics.example.fj.typing.rules.TThis";
  
  public final static String TNEW = "it.xsemantics.example.fj.typing.rules.TNew";
  
  public final static String TPARAMREF = "it.xsemantics.example.fj.typing.rules.TParamRef";
  
  public final static String TSTRINGCONSTANT = "it.xsemantics.example.fj.typing.rules.TStringConstant";
  
  public final static String TINTCONSTANT = "it.xsemantics.example.fj.typing.rules.TIntConstant";
  
  public final static String TBOOLCONSTANT = "it.xsemantics.example.fj.typing.rules.TBoolConstant";
  
  public final static String TSELECTION = "it.xsemantics.example.fj.typing.rules.TSelection";
  
  public final static String TCAST = "it.xsemantics.example.fj.typing.rules.TCast";
  
  public final static String TEXPRESSIONCLASSTYPE = "it.xsemantics.example.fj.typing.rules.TExpressionClassType";
  
  public final static String GENERALSUBTYPING = "it.xsemantics.example.fj.typing.rules.GeneralSubtyping";
  
  public final static String BASICSUBTYPING = "it.xsemantics.example.fj.typing.rules.BasicSubtyping";
  
  public final static String CLASSSUBTYPING = "it.xsemantics.example.fj.typing.rules.ClassSubtyping";
  
  public final static String EXPRESSIONASSIGNABLETOTYPE = "it.xsemantics.example.fj.typing.rules.ExpressionAssignableToType";
  
  public final static String GENERALEQUALS = "it.xsemantics.example.fj.typing.rules.GeneralEquals";
  
  public final static String BASICEQUALS = "it.xsemantics.example.fj.typing.rules.BasicEquals";
  
  public final static String CLASSEQUALS = "it.xsemantics.example.fj.typing.rules.ClassEquals";
  
  public final static String SUBTYPESEQUENCE = "it.xsemantics.example.fj.typing.rules.SubtypeSequence";
  
  public final static String METHODOVERRIDE = "it.xsemantics.example.fj.typing.rules.MethodOverride";
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<ClassType>> classtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> assignableDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> equalstypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> overridesDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypesequenceDispatcher;
  
  public FjTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    classtypeDispatcher = buildPolymorphicDispatcher1(
    	"classtypeImpl", 3, "|~", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
    assignableDispatcher = buildPolymorphicDispatcher1(
    	"assignableImpl", 4, "|-", "<|");
    equalstypeDispatcher = buildPolymorphicDispatcher1(
    	"equalstypeImpl", 4, "|-", "~~");
    overridesDispatcher = buildPolymorphicDispatcher1(
    	"overridesImpl", 4, "||-", "~~");
    subtypesequenceDispatcher = buildPolymorphicDispatcher1(
    	"subtypesequenceImpl", 5, "|-", "~>", "<<");
  }
  
  public Result<Type> type(final Expression expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final Expression expression) {
    return type(_environment_, null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return typeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<ClassType> classtype(final Expression expression) {
    return classtype(new RuleEnvironment(), null, expression);
  }
  
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final Expression expression) {
    return classtype(_environment_, null, expression);
  }
  
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return classtypeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	return resultForFailure(_e_classtype);
    }
  }
  
  public Result<Boolean> subtype(final Type left, final Type right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtype(_environment_, null, left, right);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }
  
  public Result<Boolean> assignable(final Expression expression, final Type right) {
    return assignable(new RuleEnvironment(), null, expression, right);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final Expression expression, final Type right) {
    return assignable(_environment_, null, expression, right);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression, final Type right) {
    try {
    	return assignableInternal(_environment_, _trace_, expression, right);
    } catch (Exception _e_assignable) {
    	return resultForFailure(_e_assignable);
    }
  }
  
  public Result<Boolean> equalstype(final Type left, final Type right) {
    return equalstype(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstype(_environment_, null, left, right);
  }
  
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return equalstypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_equalstype) {
    	return resultForFailure(_e_equalstype);
    }
  }
  
  public Result<Boolean> overrides(final Method current, final Method previous) {
    return overrides(new RuleEnvironment(), null, current, previous);
  }
  
  public Result<Boolean> overrides(final RuleEnvironment _environment_, final Method current, final Method previous) {
    return overrides(_environment_, null, current, previous);
  }
  
  public Result<Boolean> overrides(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Method current, final Method previous) {
    try {
    	return overridesInternal(_environment_, _trace_, current, previous);
    } catch (Exception _e_overrides) {
    	return resultForFailure(_e_overrides);
    }
  }
  
  public Result<Boolean> subtypesequence(final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequence(new RuleEnvironment(), null, owner, expressions, elements);
  }
  
  public Result<Boolean> subtypesequence(final RuleEnvironment _environment_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequence(_environment_, null, owner, expressions, elements);
  }
  
  public Result<Boolean> subtypesequence(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	return subtypesequenceInternal(_environment_, _trace_, owner, expressions, elements);
    } catch (Exception _e_subtypesequence) {
    	return resultForFailure(_e_subtypesequence);
    }
  }
  
  public Result<Boolean> checkMethodBody(final Method method) {
    try {
    	return checkMethodBodyInternal(null, method);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkMethodBodyInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    
    {
      it.xsemantics.example.fj.fj.Class _containerOfType = EcoreUtil2.<it.xsemantics.example.fj.fj.Class>getContainerOfType(method, it.xsemantics.example.fj.fj.Class.class);
      final ClassType typeForThis = FjTypeUtils.createClassType(_containerOfType);
      /* 'this' <- typeForThis |- method.body.expression <| method.type */
      MethodBody _body = method.getBody();
      Expression _expression = _body.getExpression();
      Type _type = method.getType();
      assignableInternal(environmentEntry("this", typeForThis), _trace_, _expression, _type);
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkField(final Field field) {
    try {
    	return checkFieldInternal(null, field);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkFieldInternal(final RuleApplicationTrace _trace_, final Field field) throws RuleFailedException {
    
    {
      EObject _eContainer = field.eContainer();
      final it.xsemantics.example.fj.fj.Class clazz = ((it.xsemantics.example.fj.fj.Class) _eContainer);
      it.xsemantics.example.fj.fj.Class _superclass = clazz.getSuperclass();
      boolean _notEquals = (!Objects.equal(_superclass, null));
      if (_notEquals) {
        {
          it.xsemantics.example.fj.fj.Class _superclass_1 = clazz.getSuperclass();
          EReference _class_Members = FjPackage.eINSTANCE.getClass_Members();
          EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
          List<Field> inheritedFields = this.<Field>getAll(_superclass_1, _class_Members, _class_Superclass, 
            Field.class);
          final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field inheritedField) {
                String _name = field.getName();
                String _name_1 = inheritedField.getName();
                boolean _equals = Objects.equal(_name, _name_1);
                if (_equals) {
                  /* fail error "field already defined in superclass " + stringRep(inheritedField.eContainer) */
                  EObject _eContainer = inheritedField.eContainer();
                  String _stringRep = FjTypeSystem.this.stringRep(_eContainer);
                  String _plus = ("field already defined in superclass " + _stringRep);
                  String error = _plus;
                  throwForExplicitFail(error, new ErrorInformation(null, null));
                }
              }
            };
          IterableExtensions.<Field>forEach(inheritedFields, _function);
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkMethodOverride(final Method method) {
    try {
    	return checkMethodOverrideInternal(null, method);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkMethodOverrideInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    
    {
      EObject _eContainer = method.eContainer();
      final it.xsemantics.example.fj.fj.Class clazz = ((it.xsemantics.example.fj.fj.Class) _eContainer);
      it.xsemantics.example.fj.fj.Class _superclass = clazz.getSuperclass();
      boolean _notEquals = (!Objects.equal(_superclass, null));
      if (_notEquals) {
        {
          it.xsemantics.example.fj.fj.Class _superclass_1 = clazz.getSuperclass();
          EReference _class_Members = FjPackage.eINSTANCE.getClass_Members();
          EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
          List<Method> inheritedMethods = this.<Method>getAll(_superclass_1, _class_Members, _class_Superclass, 
            Method.class);
          final Procedure1<Method> _function = new Procedure1<Method>() {
              public void apply(final Method inheritedMethod) {
                List<Method> _selectMethods = FjAuxiliaryFunctions.selectMethods(clazz);
                final Procedure1<Method> _function = new Procedure1<Method>() {
                    public void apply(final Method it) {
                      /* empty ||- it ~~ inheritedMethod */
                      overridesInternal(emptyEnvironment(), _trace_, it, inheritedMethod);
                    }
                  };
                IterableExtensions.<Method>forEach(_selectMethods, _function);
              }
            };
          IterableExtensions.<Method>forEach(inheritedMethods, _function);
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	return checkClassHierachyNotCyclicInternal(null, cl);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkClassHierachyNotCyclicInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    
    it.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      /* !getAll( cl, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class) ).contains(cl) or fail error "Cyclic hierarchy for " + cl.name source cl */
      try {
        EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
        EReference _class_Superclass_1 = FjPackage.eINSTANCE.getClass_Superclass();
        List<it.xsemantics.example.fj.fj.Class> _all = this.<it.xsemantics.example.fj.fj.Class>getAll(
          cl, _class_Superclass, _class_Superclass_1, 
          it.xsemantics.example.fj.fj.Class.class);
        boolean _contains = _all.contains(cl);
        boolean _not = (!_contains);
        /* !getAll( cl, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class) ).contains(cl) */
        if (!_not) {
          sneakyThrowRuleFailedException("!getAll( cl, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class) ).contains(cl)");
        }
      } catch (Exception e) {
        /* fail error "Cyclic hierarchy for " + cl.name source cl */
        String _name = cl.getName();
        String _plus = ("Cyclic hierarchy for " + _name);
        String error = _plus;
        EObject source = cl;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkMain(final Program program) {
    try {
    	return checkMainInternal(null, program);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkMainInternal(final RuleApplicationTrace _trace_, final Program program) throws RuleFailedException {
    
    /* program.main == null or empty |- program.main : var Type mainType */
    try {
      Expression _main = program.getMain();
      boolean _equals = Objects.equal(_main, null);
      /* program.main == null */
      if (!_equals) {
        sneakyThrowRuleFailedException("program.main == null");
      }
    } catch (Exception e) {
      /* empty |- program.main : var Type mainType */
      Expression _main_1 = program.getMain();
      Type mainType = null;
      Result<Type> result = typeInternal(emptyEnvironment(), _trace_, _main_1);
      checkAssignableTo(result.getFirst(), Type.class);
      mainType = (Type) result.getFirst();
      
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return typeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _issue, final Exception _ex, final Expression expression) throws RuleFailedException {
    
    String _stringRep = this.stringRep(expression);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<ClassType> classtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return classtypeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	sneakyThrowRuleFailedException(_e_classtype);
    	return null;
    }
  }
  
  protected void classtypeThrowException(final String _issue, final Exception _ex, final Expression expression) throws RuleFailedException {
    
    String _stringRep = this.stringRep(expression);
    String _plus = (_stringRep + " has not a class type");
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }
  
  protected void subtypeThrowException(final String _issue, final Exception _ex, final Type left, final Type right) throws RuleFailedException {
    
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not a subtype of ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> assignableInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression, final Type right) {
    try {
    	checkParamsNotNull(expression, right);
    	return assignableDispatcher.invoke(_environment_, _trace_, expression, right);
    } catch (Exception _e_assignable) {
    	sneakyThrowRuleFailedException(_e_assignable);
    	return null;
    }
  }
  
  protected void assignableThrowException(final String _issue, final Exception _ex, final Expression expression, final Type right) throws RuleFailedException {
    
    String _stringRep = this.stringRep(expression);
    String _plus = (_stringRep + " is not assignable for ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> equalstypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return equalstypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_equalstype) {
    	sneakyThrowRuleFailedException(_e_equalstype);
    	return null;
    }
  }
  
  protected void equalstypeThrowException(final String _issue, final Exception _ex, final Type left, final Type right) throws RuleFailedException {
    
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not the same type as ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> overridesInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Method current, final Method previous) {
    try {
    	checkParamsNotNull(current, previous);
    	return overridesDispatcher.invoke(_environment_, _trace_, current, previous);
    } catch (Exception _e_overrides) {
    	sneakyThrowRuleFailedException(_e_overrides);
    	return null;
    }
  }
  
  protected void overridesThrowException(final String _issue, final Exception _ex, final Method current, final Method previous) throws RuleFailedException {
    
    String _name = current.getName();
    String _plus = (_name + " does not override the superclass method");
    String error = _plus;
    EObject source = current;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> subtypesequenceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	checkParamsNotNull(owner, expressions, elements);
    	return subtypesequenceDispatcher.invoke(_environment_, _trace_, owner, expressions, elements);
    } catch (Exception _e_subtypesequence) {
    	sneakyThrowRuleFailedException(_e_subtypesequence);
    	return null;
    }
  }
  
  protected void subtypesequenceThrowException(final String _issue, final Exception _ex, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) throws RuleFailedException {
    
    String error = "invalid arguments for expected parameters";
    EObject source = owner;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTThis(G, _subtrace_, _this);
      addToTrace(_trace_, ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTThis) {
      typeThrowException(TTHIS,
      	e_applyRuleTThis, _this);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTThis(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    
    /* env(G, 'this', ClassType) */
    ClassType _environmentaccess = environmentAccess(G, "this", ClassType.class);
    return new Result<Type>(_environmentaccess);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTNew(G, _subtrace_, newExp);
      addToTrace(_trace_, ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTNew) {
      typeThrowException(TNEW,
      	e_applyRuleTNew, newExp);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    
    {
      ClassType _type = newExp.getType();
      it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
      EReference _class_Members = FjPackage.eINSTANCE.getClass_Members();
      EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
      List<Field> fields = this.<Field>getAll(_classref, _class_Members, _class_Superclass, 
        Field.class);
      Collections.reverse(fields);
      /* G |- newExp ~> newExp.args << fields */
      EList<Expression> _args = newExp.getArgs();
      subtypesequenceInternal(G, _trace_, newExp, _args, fields);
    }
    ClassType _type_1 = newExp.getType();
    return new Result<Type>(_type_1);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTParamRef(G, _subtrace_, paramref);
      addToTrace(_trace_, ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTParamRef) {
      typeThrowException(TPARAMREF,
      	e_applyRuleTParamRef, paramref);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    
    Parameter _parameter = paramref.getParameter();
    Type _type = _parameter.getType();
    return new Result<Type>(_type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTStringConstant(G, _subtrace_, s);
      addToTrace(_trace_, ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTStringConstant) {
      typeThrowException(TSTRINGCONSTANT,
      	e_applyRuleTStringConstant, s);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTStringConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    
    BasicType _xblockexpression = null;
    {
      final BasicType result = FjFactory.eINSTANCE.createBasicType();
      result.setBasic("String");
      _xblockexpression = (result);
    }
    return new Result<Type>(_xblockexpression);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTIntConstant(G, _subtrace_, i);
      addToTrace(_trace_, ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTIntConstant) {
      typeThrowException(TINTCONSTANT,
      	e_applyRuleTIntConstant, i);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTIntConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    
    BasicType _createIntType = FjTypeUtils.createIntType();
    return new Result<Type>(_createIntType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTBoolConstant(G, _subtrace_, b);
      addToTrace(_trace_, ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTBoolConstant) {
      typeThrowException(TBOOLCONSTANT,
      	e_applyRuleTBoolConstant, b);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTBoolConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    
    final Function1<BasicType,BasicType> _function = new Function1<BasicType,BasicType>() {
        public BasicType apply(final BasicType it) {
          BasicType _xblockexpression = null;
          {
            it.setBasic("boolean");
            _xblockexpression = (it);
          }
          return _xblockexpression;
        }
      };
    BasicType _createBasicType = FjFactory.eINSTANCE.createBasicType();
    BasicType _apply = _function.apply(_createBasicType);
    return new Result<Type>(_apply);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTSelection(G, _subtrace_, selection);
      addToTrace(_trace_, ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTSelection) {
      typeThrowException(TSELECTION,
      	e_applyRuleTSelection, selection);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    
    {
      /* G |- selection.receiver : var ClassType receiverType */
      Expression _receiver = selection.getReceiver();
      ClassType receiverType = null;
      Result<Type> result = typeInternal(G, _trace_, _receiver);
      checkAssignableTo(result.getFirst(), ClassType.class);
      receiverType = (ClassType) result.getFirst();
      
      final Member message = selection.getMessage();
      boolean _matched = false;
      if (!_matched) {
        if (message instanceof Method) {
          final Method _method = (Method)message;
          _matched=true;
          /* G |- selection ~> selection.args << message.params */
          EList<Expression> _args = selection.getArgs();
          EList<Parameter> _params = _method.getParams();
          subtypesequenceInternal(G, _trace_, selection, _args, _params);
        }
      }
    }
    Member _message = selection.getMessage();
    Type _type = _message.getType();
    return new Result<Type>(_type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Type> _result_ = applyRuleTCast(G, _subtrace_, cast);
      addToTrace(_trace_, ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTCast) {
      typeThrowException(TCAST,
      	e_applyRuleTCast, cast);
      return null;
    }
  }
  
  protected Result<Type> applyRuleTCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    
    {
      /* G |- cast.expression : var Type expType */
      Expression _expression = cast.getExpression();
      Type expType = null;
      Result<Type> result = typeInternal(G, _trace_, _expression);
      checkAssignableTo(result.getFirst(), Type.class);
      expType = (Type) result.getFirst();
      
      /* G |- cast.type <: expType or G |- expType <: cast.type */
      try {
        /* G |- cast.type <: expType */
        ClassType _type = cast.getType();
        subtypeInternal(G, _trace_, _type, expType);
      } catch (Exception e) {
        /* G |- expType <: cast.type */
        ClassType _type_1 = cast.getType();
        subtypeInternal(G, _trace_, expType, _type_1);
      }
    }
    ClassType _type_2 = cast.getType();
    return new Result<Type>(_type_2);
  }
  
  protected Result<ClassType> classtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<ClassType> _result_ = applyRuleTExpressionClassType(G, _subtrace_, expression);
      addToTrace(_trace_, ruleName("TExpressionClassType") + stringRepForEnv(G) + " |~ " + stringRep(expression) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTExpressionClassType) {
      classtypeThrowException(TEXPRESSIONCLASSTYPE,
      	e_applyRuleTExpressionClassType, expression);
      return null;
    }
  }
  
  protected Result<ClassType> applyRuleTExpressionClassType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression) throws RuleFailedException {
    ClassType classType = null; // output parameter
    
    /* G |- expression : classType */
    Result<Type> result = typeInternal(G, _trace_, expression);
    checkAssignableTo(result.getFirst(), ClassType.class);
    classType = (ClassType) result.getFirst();
    
    return new Result<ClassType>(classType);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleGeneralSubtyping(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("GeneralSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleGeneralSubtyping) {
      
      String _stringRep = this.stringRep(left);
      String _plus = ("types " + _stringRep);
      String _plus_1 = (_plus + " and ");
      String _stringRep_1 = this.stringRep(right);
      String _plus_2 = (_plus_1 + _stringRep_1);
      String _plus_3 = (_plus_2 + 
        " are not comparable");
      String error = _plus_3;
      throwRuleFailedException(error,
      	GENERALSUBTYPING, e_applyRuleGeneralSubtyping, new ErrorInformation(null, null));;
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleGeneralSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleBasicSubtyping(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("BasicSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleBasicSubtyping) {
      subtypeThrowException(BASICSUBTYPING,
      	e_applyRuleBasicSubtyping, left, right);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    
    String _basic = left.getBasic();
    String _basic_1 = right.getBasic();
    boolean _equals = _basic.equals(_basic_1);
    /* left.basic.equals(right.basic) */
    if (!Boolean.valueOf(_equals)) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleClassSubtyping(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleClassSubtyping) {
      subtypeThrowException(CLASSSUBTYPING,
      	e_applyRuleClassSubtyping, left, right);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    
    /* left.classref == right.classref or right.classref.name == "Object" or { getAll(left.classref, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class)) .contains(right.classref) } */
    try {
      it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
      it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
      boolean _equals = Objects.equal(_classref, _classref_1);
      /* left.classref == right.classref */
      if (!_equals) {
        sneakyThrowRuleFailedException("left.classref == right.classref");
      }
    } catch (Exception e) {
      /* right.classref.name == "Object" or { getAll(left.classref, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class)) .contains(right.classref) } */
      try {
        it.xsemantics.example.fj.fj.Class _classref_2 = right.getClassref();
        String _name = _classref_2.getName();
        boolean _equals_1 = Objects.equal(_name, "Object");
        /* right.classref.name == "Object" */
        if (!_equals_1) {
          sneakyThrowRuleFailedException("right.classref.name == \"Object\"");
        }
      } catch (Exception e_1) {
        it.xsemantics.example.fj.fj.Class _classref_3 = left.getClassref();
        EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
        EReference _class_Superclass_1 = FjPackage.eINSTANCE.getClass_Superclass();
        List<it.xsemantics.example.fj.fj.Class> _all = this.<it.xsemantics.example.fj.fj.Class>getAll(_classref_3, _class_Superclass, _class_Superclass_1, 
          it.xsemantics.example.fj.fj.Class.class);
        it.xsemantics.example.fj.fj.Class _classref_4 = right.getClassref();
        boolean _contains = _all.contains(_classref_4);
        /* getAll(left.classref, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class)) .contains(right.classref) */
        if (!_contains) {
          sneakyThrowRuleFailedException("getAll(left.classref, FjPackage::eINSTANCE.class_Superclass, FjPackage::eINSTANCE.class_Superclass, typeof(Class)) .contains(right.classref)");
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> assignableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression, final Type right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleExpressionAssignableToType(G, _subtrace_, expression, right);
      addToTrace(_trace_, ruleName("ExpressionAssignableToType") + stringRepForEnv(G) + " |- " + stringRep(expression) + " <| " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleExpressionAssignableToType) {
      assignableThrowException(EXPRESSIONASSIGNABLETOTYPE,
      	e_applyRuleExpressionAssignableToType, expression, right);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleExpressionAssignableToType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression, final Type right) throws RuleFailedException {
    
    {
      Type expressionType = null;
      /* G |- expression : expressionType */
      Result<Type> result = typeInternal(G, _trace_, expression);
      checkAssignableTo(result.getFirst(), Type.class);
      expressionType = (Type) result.getFirst();
      
      /* G |- expressionType <: right */
      subtypeInternal(G, _trace_, expressionType, right);
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleGeneralEquals(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("GeneralEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleGeneralEquals) {
      
      String _stringRep = this.stringRep(left);
      String _plus = ("types " + _stringRep);
      String _plus_1 = (_plus + " and ");
      String _stringRep_1 = this.stringRep(right);
      String _plus_2 = (_plus_1 + _stringRep_1);
      String _plus_3 = (_plus_2 + 
        " are not comparable");
      String error = _plus_3;
      throwRuleFailedException(error,
      	GENERALEQUALS, e_applyRuleGeneralEquals, new ErrorInformation(null, null));;
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleGeneralEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleBasicEquals(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleBasicEquals) {
      equalstypeThrowException(BASICEQUALS,
      	e_applyRuleBasicEquals, left, right);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    
    String _basic = left.getBasic();
    String _basic_1 = right.getBasic();
    boolean _equals = _basic.equals(_basic_1);
    /* left.basic.equals(right.basic) */
    if (!Boolean.valueOf(_equals)) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleClassEquals(G, _subtrace_, left, right);
      addToTrace(_trace_, ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleClassEquals) {
      equalstypeThrowException(CLASSEQUALS,
      	e_applyRuleClassEquals, left, right);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    
    it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
    it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
    boolean _equals = Objects.equal(_classref, _classref_1);
    /* left.classref == right.classref */
    if (!Boolean.valueOf(_equals)) {
      sneakyThrowRuleFailedException("left.classref == right.classref");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypesequenceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleSubtypeSequence(G, _subtrace_, owner, expressions, typedElements);
      addToTrace(_trace_, ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(expressions) + " << " + stringRep(typedElements));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleSubtypeSequence) {
      subtypesequenceThrowException(SUBTYPESEQUENCE,
      	e_applyRuleSubtypeSequence, owner, expressions, typedElements);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleSubtypeSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
    
    {
      /* expressions.size == typedElements.size or fail error "expected " + typedElements.size + " arguments, but got " + expressions.size source owner */
      try {
        int _size = expressions.size();
        int _size_1 = typedElements.size();
        boolean _equals = (_size == _size_1);
        /* expressions.size == typedElements.size */
        if (!_equals) {
          sneakyThrowRuleFailedException("expressions.size == typedElements.size");
        }
      } catch (Exception e) {
        /* fail error "expected " + typedElements.size + " arguments, but got " + expressions.size source owner */
        int _size_2 = typedElements.size();
        String _plus = ("expected " + Integer.valueOf(_size_2));
        String _plus_1 = (_plus + " arguments, but got ");
        int _size_3 = expressions.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_3));
        String error = _plus_2;
        EObject source = owner;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
      final Iterator<TypedElement> typedElementsIterator = typedElements.iterator();
      for (final Expression exp : expressions) {
        /* G |- exp <| typedElementsIterator.next.type */
        TypedElement _next = typedElementsIterator.next();
        Type _type = _next.getType();
        assignableInternal(G, _trace_, exp, _type);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> overridesImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method current, final Method previous) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleMethodOverride(G, _subtrace_, current, previous);
      addToTrace(_trace_, ruleName("MethodOverride") + stringRepForEnv(G) + " ||- " + stringRep(current) + " ~~ " + stringRep(previous));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleMethodOverride) {
      overridesThrowException(METHODOVERRIDE,
      	e_applyRuleMethodOverride, current, previous);
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleMethodOverride(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method current, final Method previous) throws RuleFailedException {
    
    /* current.name != previous.name or { G |- current.type ~~ previous.type or fail error "cannot change return type of inherited method: " + stringRep(previous.type) source current feature FjPackage::eINSTANCE.typedElement_Type current.params.size == previous.params.size val previousParamsIt = previous.params.iterator for (param : current.params) { G |- param.type ~~ previousParamsIt.next.type } } */
    try {
      String _name = current.getName();
      String _name_1 = previous.getName();
      boolean _notEquals = (!Objects.equal(_name, _name_1));
      /* current.name != previous.name */
      if (!_notEquals) {
        sneakyThrowRuleFailedException("current.name != previous.name");
      }
    } catch (Exception e) {
      {
        /* G |- current.type ~~ previous.type or fail error "cannot change return type of inherited method: " + stringRep(previous.type) source current feature FjPackage::eINSTANCE.typedElement_Type */
        try {
          /* G |- current.type ~~ previous.type */
          Type _type = current.getType();
          Type _type_1 = previous.getType();
          equalstypeInternal(G, _trace_, _type, _type_1);
        } catch (Exception e_1) {
          /* fail error "cannot change return type of inherited method: " + stringRep(previous.type) source current feature FjPackage::eINSTANCE.typedElement_Type */
          Type _type_2 = previous.getType();
          String _stringRep = this.stringRep(_type_2);
          String _plus = ("cannot change return type of inherited method: " + _stringRep);
          String error = _plus;
          EObject source = current;
          EReference _typedElement_Type = FjPackage.eINSTANCE.getTypedElement_Type();
          EStructuralFeature feature = _typedElement_Type;
          throwForExplicitFail(error, new ErrorInformation(source, feature));
        }
        EList<Parameter> _params = current.getParams();
        int _size = _params.size();
        EList<Parameter> _params_1 = previous.getParams();
        int _size_1 = _params_1.size();
        boolean _equals = (_size == _size_1);
        /* current.params.size == previous.params.size */
        if (!_equals) {
          sneakyThrowRuleFailedException("current.params.size == previous.params.size");
        }
        EList<Parameter> _params_2 = previous.getParams();
        final Iterator<Parameter> previousParamsIt = _params_2.iterator();
        EList<Parameter> _params_3 = current.getParams();
        for (final Parameter param : _params_3) {
          /* G |- param.type ~~ previousParamsIt.next.type */
          Type _type_3 = param.getType();
          Parameter _next = previousParamsIt.next();
          Type _type_4 = _next.getType();
          equalstypeInternal(G, _trace_, _type_3, _type_4);
        }
      }
    }
    return new Result<Boolean>(true);
  }
}
