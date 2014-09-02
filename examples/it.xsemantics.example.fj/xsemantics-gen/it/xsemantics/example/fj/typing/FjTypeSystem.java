package it.xsemantics.example.fj.typing;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.Cast;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Constant;
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
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result3;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * A version of the FJ system where type computation involves also
 * type checking.
 */
@SuppressWarnings("all")
public class FjTypeSystem extends XsemanticsRuntimeSystem {
  public final static String SUPERCLASSES = "it.xsemantics.example.fj.typing.Superclasses";
  
  public final static String FIELDS = "it.xsemantics.example.fj.typing.Fields";
  
  public final static String METHODS = "it.xsemantics.example.fj.typing.Methods";
  
  public final static String OVERRIDES = "it.xsemantics.example.fj.typing.Overrides";
  
  public final static String ISVALUE = "it.xsemantics.example.fj.typing.IsValue";
  
  public final static String REPLACETHISANDPARAMS = "it.xsemantics.example.fj.typing.ReplaceThisAndParams";
  
  public final static String TTHIS = "it.xsemantics.example.fj.typing.TThis";
  
  public final static String TNEW = "it.xsemantics.example.fj.typing.TNew";
  
  public final static String TPARAMREF = "it.xsemantics.example.fj.typing.TParamRef";
  
  public final static String TSTRINGCONSTANT = "it.xsemantics.example.fj.typing.TStringConstant";
  
  public final static String TINTCONSTANT = "it.xsemantics.example.fj.typing.TIntConstant";
  
  public final static String TBOOLCONSTANT = "it.xsemantics.example.fj.typing.TBoolConstant";
  
  public final static String TSELECTION = "it.xsemantics.example.fj.typing.TSelection";
  
  public final static String TCAST = "it.xsemantics.example.fj.typing.TCast";
  
  public final static String TEXPRESSIONCLASSTYPE = "it.xsemantics.example.fj.typing.TExpressionClassType";
  
  public final static String GENERALSUBTYPING = "it.xsemantics.example.fj.typing.GeneralSubtyping";
  
  public final static String BASICSUBTYPING = "it.xsemantics.example.fj.typing.BasicSubtyping";
  
  public final static String CLASSSUBTYPING = "it.xsemantics.example.fj.typing.ClassSubtyping";
  
  public final static String EXPRESSIONASSIGNABLETOTYPE = "it.xsemantics.example.fj.typing.ExpressionAssignableToType";
  
  public final static String GENERALEQUALS = "it.xsemantics.example.fj.typing.GeneralEquals";
  
  public final static String BASICEQUALS = "it.xsemantics.example.fj.typing.BasicEquals";
  
  public final static String CLASSEQUALS = "it.xsemantics.example.fj.typing.ClassEquals";
  
  public final static String SUBTYPESEQUENCE = "it.xsemantics.example.fj.typing.SubtypeSequence";
  
  public final static String RNEW = "it.xsemantics.example.fj.typing.RNew";
  
  public final static String RSELECTION = "it.xsemantics.example.fj.typing.RSelection";
  
  public final static String RCAST = "it.xsemantics.example.fj.typing.RCast";
  
  public final static String SUBJRED = "it.xsemantics.example.fj.typing.SubjRed";
  
  @Inject
  private FjTypeUtils fjTypeUtils;
  
  private PolymorphicDispatcher<List<it.xsemantics.example.fj.fj.Class>> superclassesDispatcher;
  
  private PolymorphicDispatcher<List<Field>> fieldsDispatcher;
  
  private PolymorphicDispatcher<List<Method>> methodsDispatcher;
  
  private PolymorphicDispatcher<Boolean> overridesDispatcher;
  
  private PolymorphicDispatcher<Boolean> isValueDispatcher;
  
  private PolymorphicDispatcher<MethodBody> replaceThisAndParamsDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<ClassType>> classtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> assignableDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> equalstypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypesequenceDispatcher;
  
  private PolymorphicDispatcher<Result<Expression>> reduceDispatcher;
  
  private PolymorphicDispatcher<Result3<Expression, Type, Type>> subjredDispatcher;
  
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
    	"assignableImpl", 4, "|-", "|>");
    equalstypeDispatcher = buildPolymorphicDispatcher1(
    	"equalstypeImpl", 4, "|-", "~~");
    subtypesequenceDispatcher = buildPolymorphicDispatcher1(
    	"subtypesequenceImpl", 5, "|-", "~>", "<<");
    reduceDispatcher = buildPolymorphicDispatcher1(
    	"reduceImpl", 3, "|-", "~>");
    subjredDispatcher = buildPolymorphicDispatcher3(
    	"subjredImpl", 3, "|=", "~>", ":", "<:");
    superclassesDispatcher = buildPolymorphicDispatcher(
    	"superclassesImpl", 2);
    fieldsDispatcher = buildPolymorphicDispatcher(
    	"fieldsImpl", 2);
    methodsDispatcher = buildPolymorphicDispatcher(
    	"methodsImpl", 2);
    overridesDispatcher = buildPolymorphicDispatcher(
    	"overridesImpl", 3);
    isValueDispatcher = buildPolymorphicDispatcher(
    	"isValueImpl", 2);
    replaceThisAndParamsDispatcher = buildPolymorphicDispatcher(
    	"replaceThisAndParamsImpl", 5);
  }
  
  public FjTypeUtils getFjTypeUtils() {
    return this.fjTypeUtils;
  }
  
  public void setFjTypeUtils(final FjTypeUtils fjTypeUtils) {
    this.fjTypeUtils = fjTypeUtils;
  }
  
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return superclasses(null, cl);
  }
  
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return superclassesInternal(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	throw extractRuleFailedException(_e_superclasses);
    }
  }
  
  public List<Field> fields(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return fields(null, cl);
  }
  
  public List<Field> fields(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return fieldsInternal(_trace_, cl);
    } catch (Exception _e_fields) {
    	throw extractRuleFailedException(_e_fields);
    }
  }
  
  public List<Method> methods(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return methods(null, cl);
  }
  
  public List<Method> methods(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return methodsInternal(_trace_, cl);
    } catch (Exception _e_methods) {
    	throw extractRuleFailedException(_e_methods);
    }
  }
  
  public Boolean overrides(final Method current, final Method previous) throws RuleFailedException {
    return overrides(null, current, previous);
  }
  
  public Boolean overrides(final RuleApplicationTrace _trace_, final Method current, final Method previous) throws RuleFailedException {
    try {
    	return overridesInternal(_trace_, current, previous);
    } catch (Exception _e_overrides) {
    	throw extractRuleFailedException(_e_overrides);
    }
  }
  
  public Boolean isValue(final Expression e) throws RuleFailedException {
    return isValue(null, e);
  }
  
  public Boolean isValue(final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    try {
    	return isValueInternal(_trace_, e);
    } catch (Exception _e_isValue) {
    	throw extractRuleFailedException(_e_isValue);
    }
  }
  
  public MethodBody replaceThisAndParams(final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args) throws RuleFailedException {
    return replaceThisAndParams(null, body, thisReplacement, params, args);
  }
  
  public MethodBody replaceThisAndParams(final RuleApplicationTrace _trace_, final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args) throws RuleFailedException {
    try {
    	return replaceThisAndParamsInternal(_trace_, body, thisReplacement, params, args);
    } catch (Exception _e_replaceThisAndParams) {
    	throw extractRuleFailedException(_e_replaceThisAndParams);
    }
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
  
  public Boolean subtypeSucceeded(final Type left, final Type right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
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
  
  public Boolean assignableSucceeded(final Expression expression, final Type right) {
    return assignableSucceeded(new RuleEnvironment(), null, expression, right);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final Expression expression, final Type right) {
    return assignableSucceeded(_environment_, null, expression, right);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression, final Type right) {
    try {
    	assignableInternal(_environment_, _trace_, expression, right);
    	return true;
    } catch (Exception _e_assignable) {
    	return false;
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
  
  public Boolean equalstypeSucceeded(final Type left, final Type right) {
    return equalstypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	equalstypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_equalstype) {
    	return false;
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
  
  public Boolean subtypesequenceSucceeded(final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequenceSucceeded(new RuleEnvironment(), null, owner, expressions, elements);
  }
  
  public Boolean subtypesequenceSucceeded(final RuleEnvironment _environment_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequenceSucceeded(_environment_, null, owner, expressions, elements);
  }
  
  public Boolean subtypesequenceSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	subtypesequenceInternal(_environment_, _trace_, owner, expressions, elements);
    	return true;
    } catch (Exception _e_subtypesequence) {
    	return false;
    }
  }
  
  public Result<Expression> reduce(final Expression exp) {
    return reduce(new RuleEnvironment(), null, exp);
  }
  
  public Result<Expression> reduce(final RuleEnvironment _environment_, final Expression exp) {
    return reduce(_environment_, null, exp);
  }
  
  public Result<Expression> reduce(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression exp) {
    try {
    	return reduceInternal(_environment_, _trace_, exp);
    } catch (Exception _e_reduce) {
    	return resultForFailure(_e_reduce);
    }
  }
  
  public Result3<Expression, Type, Type> subjred(final Expression exp) {
    return subjred(new RuleEnvironment(), null, exp);
  }
  
  public Result3<Expression, Type, Type> subjred(final RuleEnvironment _environment_, final Expression exp) {
    return subjred(_environment_, null, exp);
  }
  
  public Result3<Expression, Type, Type> subjred(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression exp) {
    try {
    	return subjredInternal(_environment_, _trace_, exp);
    } catch (Exception _e_subjred) {
    	return resultForFailure3(_e_subjred);
    }
  }
  
  public Result<Boolean> checkMethodBody(final Method method) {
    return checkMethodBody(null, method);
  }
  
  public Result<Boolean> checkMethodBody(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodBodyInternal(_trace_, method);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkMethodBodyInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _containerOfType = EcoreUtil2.<it.xsemantics.example.fj.fj.Class>getContainerOfType(method, it.xsemantics.example.fj.fj.Class.class);
    final ClassType typeForThis = this.fjTypeUtils.createClassType(_containerOfType);
    /* 'this' <- typeForThis |- method.body.expression |> method.type */
    MethodBody _body = method.getBody();
    Expression _expression = _body.getExpression();
    Type _type = method.getType();
    assignableInternal(environmentEntry("this", typeForThis), _trace_, _expression, _type);
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkField(final Field field) {
    return checkField(null, field);
  }
  
  public Result<Boolean> checkField(final RuleApplicationTrace _trace_, final Field field) {
    try {
    	return checkFieldInternal(_trace_, field);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkFieldInternal(final RuleApplicationTrace _trace_, final Field field) throws RuleFailedException {
    EObject _eContainer = field.eContainer();
    final it.xsemantics.example.fj.fj.Class clazz = ((it.xsemantics.example.fj.fj.Class) _eContainer);
    it.xsemantics.example.fj.fj.Class _superclass = clazz.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      it.xsemantics.example.fj.fj.Class _superclass_1 = clazz.getSuperclass();
      List<Field> inheritedFields = this.fieldsInternal(_trace_, _superclass_1);
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
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkMethodOverride(final Method method) {
    return checkMethodOverride(null, method);
  }
  
  public Result<Boolean> checkMethodOverride(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodOverrideInternal(_trace_, method);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkMethodOverrideInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    EObject _eContainer = method.eContainer();
    final it.xsemantics.example.fj.fj.Class clazz = ((it.xsemantics.example.fj.fj.Class) _eContainer);
    it.xsemantics.example.fj.fj.Class _superclass = clazz.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      it.xsemantics.example.fj.fj.Class _superclass_1 = clazz.getSuperclass();
      List<Method> inheritedMethods = this.methodsInternal(_trace_, _superclass_1);
      EList<Member> _members = clazz.getMembers();
      final List<Method> methods = EcoreUtil2.<Method>typeSelect(_members, Method.class);
      final Procedure1<Method> _function = new Procedure1<Method>() {
        public void apply(final Method inheritedMethod) {
          final Procedure1<Method> _function = new Procedure1<Method>() {
            public void apply(final Method it) {
              try {
                FjTypeSystem.this.overridesInternal(_trace_, it, inheritedMethod);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          IterableExtensions.<Method>forEach(methods, _function);
        }
      };
      IterableExtensions.<Method>forEach(inheritedMethods, _function);
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    return checkClassHierachyNotCyclic(null, cl);
  }
  
  public Result<Boolean> checkClassHierachyNotCyclic(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	return checkClassHierachyNotCyclicInternal(_trace_, cl);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkClassHierachyNotCyclicInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      /* !superclasses(cl).contains(cl) or fail error "Cyclic hierarchy for " + cl.name source cl */
      try {
        List<it.xsemantics.example.fj.fj.Class> _superclasses = this.superclassesInternal(_trace_, cl);
        boolean _contains = _superclasses.contains(cl);
        boolean _not = (!_contains);
        /* !superclasses(cl).contains(cl) */
        if (!_not) {
          sneakyThrowRuleFailedException("!superclasses(cl).contains(cl)");
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
    return checkMain(null, program);
  }
  
  public Result<Boolean> checkMain(final RuleApplicationTrace _trace_, final Program program) {
    try {
    	return checkMainInternal(_trace_, program);
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
  
  protected List<it.xsemantics.example.fj.fj.Class> superclassesInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return superclassesDispatcher.invoke(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	sneakyThrowRuleFailedException(_e_superclasses);
    	return null;
    }
  }
  
  protected void superclassesThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<Field> fieldsInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return fieldsDispatcher.invoke(_trace_, cl);
    } catch (Exception _e_fields) {
    	sneakyThrowRuleFailedException(_e_fields);
    	return null;
    }
  }
  
  protected void fieldsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<Method> methodsInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return methodsDispatcher.invoke(_trace_, cl);
    } catch (Exception _e_methods) {
    	sneakyThrowRuleFailedException(_e_methods);
    	return null;
    }
  }
  
  protected void methodsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Boolean overridesInternal(final RuleApplicationTrace _trace_, final Method current, final Method previous) {
    try {
    	checkParamsNotNull(current, previous);
    	return overridesDispatcher.invoke(_trace_, current, previous);
    } catch (Exception _e_overrides) {
    	sneakyThrowRuleFailedException(_e_overrides);
    	return false;
    }
  }
  
  protected void overridesThrowException(final String _error, final String _issue, final Exception _ex, final Method current, final Method previous, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _name = current.getName();
    String _plus = (_name + " does not override the superclass method");
    String error = _plus;
    EObject source = current;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Boolean isValueInternal(final RuleApplicationTrace _trace_, final Expression e) {
    try {
    	checkParamsNotNull(e);
    	return isValueDispatcher.invoke(_trace_, e);
    } catch (Exception _e_isValue) {
    	return false;
    }
  }
  
  protected void isValueThrowException(final String _error, final String _issue, final Exception _ex, final Expression e, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected MethodBody replaceThisAndParamsInternal(final RuleApplicationTrace _trace_, final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args) {
    try {
    	checkParamsNotNull(body, thisReplacement, params, args);
    	return replaceThisAndParamsDispatcher.invoke(_trace_, body, thisReplacement, params, args);
    } catch (Exception _e_replaceThisAndParams) {
    	sneakyThrowRuleFailedException(_e_replaceThisAndParams);
    	return null;
    }
  }
  
  protected void replaceThisAndParamsThrowException(final String _error, final String _issue, final Exception _ex, final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
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
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
  
  protected void classtypeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
  
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
  
  protected void assignableThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
  
  protected void equalstypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not the same type as ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
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
  
  protected void subtypesequenceThrowException(final String _error, final String _issue, final Exception _ex, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = "invalid arguments for expected parameters";
    EObject source = owner;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Expression> reduceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression exp) {
    try {
    	checkParamsNotNull(exp);
    	return reduceDispatcher.invoke(_environment_, _trace_, exp);
    } catch (Exception _e_reduce) {
    	sneakyThrowRuleFailedException(_e_reduce);
    	return null;
    }
  }
  
  protected void reduceThrowException(final String _error, final String _issue, final Exception _ex, final Expression exp, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result3<Expression, Type, Type> subjredInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression exp) {
    try {
    	checkParamsNotNull(exp);
    	return subjredDispatcher.invoke(_environment_, _trace_, exp);
    } catch (Exception _e_subjred) {
    	sneakyThrowRuleFailedException(_e_subjred);
    	return null;
    }
  }
  
  protected void subjredThrowException(final String _error, final String _issue, final Exception _ex, final Expression exp, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> superclassesImpl(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final List<it.xsemantics.example.fj.fj.Class> _result_ = applyAuxFunSuperclasses(_subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("superclasses") + "(" + stringRep(cl)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunSuperclasses) {
    	superclassesThrowException(auxFunName("superclasses") + "(" + stringRep(cl)+ ")",
    		SUPERCLASSES,
    		e_applyAuxFunSuperclasses, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> applyAuxFunSuperclasses(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    EReference _class_Superclass = FjPackage.eINSTANCE.getClass_Superclass();
    EReference _class_Superclass_1 = FjPackage.eINSTANCE.getClass_Superclass();
    return this.<it.xsemantics.example.fj.fj.Class>getAll(cl, _class_Superclass, _class_Superclass_1, 
      it.xsemantics.example.fj.fj.Class.class);
  }
  
  protected List<Field> fieldsImpl(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final List<Field> _result_ = applyAuxFunFields(_subtrace_, clazz);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("fields") + "(" + stringRep(clazz)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunFields) {
    	fieldsThrowException(auxFunName("fields") + "(" + stringRep(clazz)+ ")",
    		FIELDS,
    		e_applyAuxFunFields, clazz, new ErrorInformation[] {new ErrorInformation(clazz)});
    	return null;
    }
  }
  
  protected List<Field> applyAuxFunFields(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    ArrayList<Field> _xblockexpression = null;
    {
      Iterable<Field> fields = new ArrayList<Field>();
      List<it.xsemantics.example.fj.fj.Class> _superclasses = this.superclassesInternal(_trace_, clazz);
      for (final it.xsemantics.example.fj.fj.Class superclass : _superclasses) {
        EList<Member> _members = superclass.getMembers();
        List<Field> _typeSelect = EcoreUtil2.<Field>typeSelect(_members, Field.class);
        Iterable<Field> _plus = Iterables.<Field>concat(_typeSelect, fields);
        fields = _plus;
      }
      EList<Member> _members_1 = clazz.getMembers();
      List<Field> _typeSelect_1 = EcoreUtil2.<Field>typeSelect(_members_1, Field.class);
      Iterable<Field> _plus_1 = Iterables.<Field>concat(fields, _typeSelect_1);
      fields = _plus_1;
      _xblockexpression = (Lists.<Field>newArrayList(fields));
    }
    return _xblockexpression;
  }
  
  protected List<Method> methodsImpl(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final List<Method> _result_ = applyAuxFunMethods(_subtrace_, clazz);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("methods") + "(" + stringRep(clazz)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunMethods) {
    	methodsThrowException(auxFunName("methods") + "(" + stringRep(clazz)+ ")",
    		METHODS,
    		e_applyAuxFunMethods, clazz, new ErrorInformation[] {new ErrorInformation(clazz)});
    	return null;
    }
  }
  
  protected List<Method> applyAuxFunMethods(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    List<Method> _xblockexpression = null;
    {
      EList<Member> _members = clazz.getMembers();
      final List<Method> methods = EcoreUtil2.<Method>typeSelect(_members, Method.class);
      List<it.xsemantics.example.fj.fj.Class> _superclasses = this.superclassesInternal(_trace_, clazz);
      final Procedure1<it.xsemantics.example.fj.fj.Class> _function = new Procedure1<it.xsemantics.example.fj.fj.Class>() {
        public void apply(final it.xsemantics.example.fj.fj.Class c) {
          EList<Member> _members = c.getMembers();
          List<Method> _typeSelect = EcoreUtil2.<Method>typeSelect(_members, Method.class);
          methods.addAll(_typeSelect);
        }
      };
      IterableExtensions.<it.xsemantics.example.fj.fj.Class>forEach(_superclasses, _function);
      _xblockexpression = (methods);
    }
    return _xblockexpression;
  }
  
  protected Boolean overridesImpl(final RuleApplicationTrace _trace_, final Method current, final Method previous) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunOverrides(_subtrace_, current, previous);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("overrides") + "(" + stringRep(current) + ", " + stringRep(previous)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunOverrides) {
    	overridesThrowException(auxFunName("overrides") + "(" + stringRep(current) + ", " + stringRep(previous)+ ")",
    		OVERRIDES,
    		e_applyAuxFunOverrides, current, previous, new ErrorInformation[] {new ErrorInformation(current), new ErrorInformation(previous)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunOverrides(final RuleApplicationTrace _trace_, final Method current, final Method previous) throws RuleFailedException {
    /* current.name != previous.name or { empty |- current.type ~~ previous.type or fail error "cannot change return type of inherited method: " + stringRep(previous.type) source current feature FjPackage::eINSTANCE.typedElement_Type current.params.size == previous.params.size val previousParamsIt = previous.params.iterator for (param : current.params) { empty |- param.type ~~ previousParamsIt.next.type } } */
    try {
      String _name = current.getName();
      String _name_1 = previous.getName();
      boolean _notEquals = (!Objects.equal(_name, _name_1));
      /* current.name != previous.name */
      if (!_notEquals) {
        sneakyThrowRuleFailedException("current.name != previous.name");
      }
    } catch (Exception e) {
      /* empty |- current.type ~~ previous.type or fail error "cannot change return type of inherited method: " + stringRep(previous.type) source current feature FjPackage::eINSTANCE.typedElement_Type */
      try {
        /* empty |- current.type ~~ previous.type */
        Type _type = current.getType();
        Type _type_1 = previous.getType();
        equalstypeInternal(emptyEnvironment(), _trace_, _type, _type_1);
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
        /* empty |- param.type ~~ previousParamsIt.next.type */
        Type _type_3 = param.getType();
        Parameter _next = previousParamsIt.next();
        Type _type_4 = _next.getType();
        equalstypeInternal(emptyEnvironment(), _trace_, _type_3, _type_4);
      }
    }
    return true;
  }
  
  protected Boolean isValueImpl(final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunIsValue(_subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("isValue") + "(" + stringRep(e)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunIsValue) {
    	isValueThrowException(auxFunName("isValue") + "(" + stringRep(e)+ ")",
    		ISVALUE,
    		e_applyAuxFunIsValue, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunIsValue(final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    /* false */
    if (!Boolean.valueOf(false)) {
      sneakyThrowRuleFailedException("false");
    }
    return Boolean.valueOf(false);
  }
  
  protected Boolean isValueImpl(final RuleApplicationTrace _trace_, final Constant exp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunIsValue(_subtrace_, exp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("isValue") + "(" + stringRep(exp)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunIsValue) {
    	isValueThrowException(auxFunName("isValue") + "(" + stringRep(exp)+ ")",
    		ISVALUE,
    		e_applyAuxFunIsValue, exp, new ErrorInformation[] {new ErrorInformation(exp)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunIsValue(final RuleApplicationTrace _trace_, final Constant exp) throws RuleFailedException {
    /* true */
    if (!Boolean.valueOf(true)) {
      sneakyThrowRuleFailedException("true");
    }
    return Boolean.valueOf(true);
  }
  
  protected Boolean isValueImpl(final RuleApplicationTrace _trace_, final New exp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunIsValue(_subtrace_, exp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("isValue") + "(" + stringRep(exp)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunIsValue) {
    	isValueThrowException(auxFunName("isValue") + "(" + stringRep(exp)+ ")",
    		ISVALUE,
    		e_applyAuxFunIsValue, exp, new ErrorInformation[] {new ErrorInformation(exp)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunIsValue(final RuleApplicationTrace _trace_, final New exp) throws RuleFailedException {
    EList<Expression> _args = exp.getArgs();
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      public Boolean apply(final Expression it) {
        try {
          return FjTypeSystem.this.isValueInternal(_trace_, it);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    boolean _forall = IterableExtensions.<Expression>forall(_args, _function);
    /* exp.args.forall[isValue(it)] */
    if (!Boolean.valueOf(_forall)) {
      sneakyThrowRuleFailedException("exp.args.forall[isValue(it)]");
    }
    return Boolean.valueOf(_forall);
  }
  
  protected MethodBody replaceThisAndParamsImpl(final RuleApplicationTrace _trace_, final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final MethodBody _result_ = applyAuxFunReplaceThisAndParams(_subtrace_, body, thisReplacement, params, args);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("replaceThisAndParams") + "(" + stringRep(body) + ", " + stringRep(thisReplacement) + ", " + stringRep(params) + ", " + stringRep(args)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunReplaceThisAndParams) {
    	replaceThisAndParamsThrowException(auxFunName("replaceThisAndParams") + "(" + stringRep(body) + ", " + stringRep(thisReplacement) + ", " + stringRep(params) + ", " + stringRep(args)+ ")",
    		REPLACETHISANDPARAMS,
    		e_applyAuxFunReplaceThisAndParams, body, thisReplacement, params, args, new ErrorInformation[] {new ErrorInformation(body), new ErrorInformation(thisReplacement)});
    	return null;
    }
  }
  
  protected MethodBody applyAuxFunReplaceThisAndParams(final RuleApplicationTrace _trace_, final MethodBody body, final Expression thisReplacement, final List<Parameter> params, final List<Expression> args) throws RuleFailedException {
    MethodBody _clone = this.<MethodBody>clone(body);
    final Procedure1<MethodBody> _function = new Procedure1<MethodBody>() {
      public void apply(final MethodBody it) {
        List<This> _eAllOfType = EcoreUtil2.<This>eAllOfType(it, This.class);
        final Procedure1<This> _function = new Procedure1<This>() {
          public void apply(final This it) {
            EObject _eContainer = it.eContainer();
            EStructuralFeature _eContainingFeature = it.eContainingFeature();
            Expression _clone = FjTypeSystem.this.<Expression>clone(thisReplacement);
            EcoreUtil2.replace(_eContainer, _eContainingFeature, it, _clone);
          }
        };
        IterableExtensions.<This>forEach(_eAllOfType, _function);
        List<ParamRef> _eAllOfType_1 = EcoreUtil2.<ParamRef>eAllOfType(it, ParamRef.class);
        final Procedure1<ParamRef> _function_1 = new Procedure1<ParamRef>() {
          public void apply(final ParamRef it) {
            Parameter _parameter = it.getParameter();
            final int paramIndex = params.indexOf(_parameter);
            EObject _eContainer = it.eContainer();
            EStructuralFeature _eContainingFeature = it.eContainingFeature();
            Expression _get = args.get(paramIndex);
            Expression _clone = FjTypeSystem.this.<Expression>clone(_get);
            EcoreUtil2.replace(_eContainer, _eContainingFeature, it, _clone);
          }
        };
        IterableExtensions.<ParamRef>forEach(_eAllOfType_1, _function_1);
      }
    };
    return ObjectExtensions.<MethodBody>operator_doubleArrow(_clone, _function);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTThis(G, _subtrace_, _this);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTThis) {
    	typeThrowException(ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + "ClassType",
    		TTHIS,
    		e_applyRuleTThis, _this, new ErrorInformation[] {new ErrorInformation(_this)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTThis(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTThis_1(G, _this));
  }
  
  private ClassType _applyRuleTThis_1(final RuleEnvironment G, final This _this) throws RuleFailedException {
    ClassType _env = this.<ClassType>env(G, "this", ClassType.class);
    return _env;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTNew) {
    	typeThrowException(ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + "ClassType",
    		TNEW,
    		e_applyRuleTNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    ClassType _type = newExp.getType();
    it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
    List<Field> fields = this.fieldsInternal(_trace_, _classref);
    /* G |- newExp ~> newExp.args << fields */
    EList<Expression> _args = newExp.getArgs();
    subtypesequenceInternal(G, _trace_, newExp, _args, fields);
    return new Result<Type>(_applyRuleTNew_1(G, newExp));
  }
  
  private ClassType _applyRuleTNew_1(final RuleEnvironment G, final New newExp) throws RuleFailedException {
    ClassType _type = newExp.getType();
    return _type;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTParamRef(G, _subtrace_, paramref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTParamRef) {
    	typeThrowException(ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + "Type",
    		TPARAMREF,
    		e_applyRuleTParamRef, paramref, new ErrorInformation[] {new ErrorInformation(paramref)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTParamRef_1(G, paramref));
  }
  
  private Type _applyRuleTParamRef_1(final RuleEnvironment G, final ParamRef paramref) throws RuleFailedException {
    Parameter _parameter = paramref.getParameter();
    Type _type = _parameter.getType();
    return _type;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTStringConstant(G, _subtrace_, s);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTStringConstant) {
    	typeThrowException(ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + "BasicType",
    		TSTRINGCONSTANT,
    		e_applyRuleTStringConstant, s, new ErrorInformation[] {new ErrorInformation(s)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTStringConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTStringConstant_1(G, s));
  }
  
  private BasicType _applyRuleTStringConstant_1(final RuleEnvironment G, final StringConstant s) throws RuleFailedException {
    BasicType _xblockexpression = null;
    {
      final BasicType result = FjFactory.eINSTANCE.createBasicType();
      result.setBasic("String");
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTIntConstant(G, _subtrace_, i);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTIntConstant) {
    	typeThrowException(ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + "BasicType",
    		TINTCONSTANT,
    		e_applyRuleTIntConstant, i, new ErrorInformation[] {new ErrorInformation(i)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTIntConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTIntConstant_1(G, i));
  }
  
  private BasicType _applyRuleTIntConstant_1(final RuleEnvironment G, final IntConstant i) throws RuleFailedException {
    BasicType _createIntType = this.fjTypeUtils.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTBoolConstant(G, _subtrace_, b);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTBoolConstant) {
    	typeThrowException(ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + "BasicType",
    		TBOOLCONSTANT,
    		e_applyRuleTBoolConstant, b, new ErrorInformation[] {new ErrorInformation(b)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTBoolConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTBoolConstant_1(G, b));
  }
  
  private BasicType _applyRuleTBoolConstant_1(final RuleEnvironment G, final BoolConstant b) throws RuleFailedException {
    final Function1<BasicType, BasicType> _function = new Function1<BasicType, BasicType>() {
      public BasicType apply(final BasicType t) {
        BasicType _xblockexpression = null;
        {
          t.setBasic("boolean");
          _xblockexpression = t;
        }
        return _xblockexpression;
      }
    };
    BasicType _createBasicType = FjFactory.eINSTANCE.createBasicType();
    BasicType _apply = _function.apply(_createBasicType);
    return _apply;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTSelection(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTSelection) {
    	typeThrowException(ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + "Type",
    		TSELECTION,
    		e_applyRuleTSelection, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
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
        _matched=true;
        /* G |- selection ~> selection.args << message.params */
        EList<Expression> _args = selection.getArgs();
        EList<Parameter> _params = ((Method)message).getParams();
        subtypesequenceInternal(G, _trace_, selection, _args, _params);
      }
    }
    return new Result<Type>(_applyRuleTSelection_1(G, selection));
  }
  
  private Type _applyRuleTSelection_1(final RuleEnvironment G, final Selection selection) throws RuleFailedException {
    Member _message = selection.getMessage();
    Type _type = _message.getType();
    return _type;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTCast(G, _subtrace_, cast);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTCast) {
    	typeThrowException(ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + "ClassType",
    		TCAST,
    		e_applyRuleTCast, cast, new ErrorInformation[] {new ErrorInformation(cast)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
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
    return new Result<Type>(_applyRuleTCast_1(G, cast));
  }
  
  private ClassType _applyRuleTCast_1(final RuleEnvironment G, final Cast cast) throws RuleFailedException {
    ClassType _type = cast.getType();
    return _type;
  }
  
  protected Result<ClassType> classtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<ClassType> _result_ = applyRuleTExpressionClassType(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TExpressionClassType") + stringRepForEnv(G) + " |~ " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTExpressionClassType) {
    	classtypeThrowException(ruleName("TExpressionClassType") + stringRepForEnv(G) + " |~ " + stringRep(expression) + " : " + "ClassType",
    		TEXPRESSIONCLASSTYPE,
    		e_applyRuleTExpressionClassType, expression, new ErrorInformation[] {new ErrorInformation(expression)});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleGeneralSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("GeneralSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleGeneralSubtyping) {
    	generalSubtypingThrowException(e_applyRuleGeneralSubtyping, left, right);
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleGeneralSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  private void generalSubtypingThrowException(final Exception e_applyRuleGeneralSubtyping, final Type left, final Type right) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = ("types " + _stringRep);
    String _plus_1 = (_plus + " and ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_2 = (_plus_1 + _stringRep_1);
    String _plus_3 = (_plus_2 + 
      " are not comparable");
    String error = _plus_3;
    throwRuleFailedException(error,
    	GENERALSUBTYPING, e_applyRuleGeneralSubtyping, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleBasicSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BasicSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBasicSubtyping) {
    	subtypeThrowException(ruleName("BasicSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		BASICSUBTYPING,
    		e_applyRuleBasicSubtyping, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    String _basic = left.getBasic();
    String _basic_1 = right.getBasic();
    /* left.basic.equals(right.basic) */
    if (!_basic.equals(_basic_1)) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleClassSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassSubtyping) {
    	subtypeThrowException(ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		CLASSSUBTYPING,
    		e_applyRuleClassSubtyping, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    /* left.classref == right.classref or right.classref.name == "Object" or { superclasses(left.classref).contains(right.classref) } */
    try {
      it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
      it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
      boolean _equals = Objects.equal(_classref, _classref_1);
      /* left.classref == right.classref */
      if (!_equals) {
        sneakyThrowRuleFailedException("left.classref == right.classref");
      }
    } catch (Exception e) {
      /* right.classref.name == "Object" or { superclasses(left.classref).contains(right.classref) } */
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
        List<it.xsemantics.example.fj.fj.Class> _superclasses = this.superclassesInternal(_trace_, _classref_3);
        it.xsemantics.example.fj.fj.Class _classref_4 = right.getClassref();
        /* superclasses(left.classref).contains(right.classref) */
        if (!_superclasses.contains(_classref_4)) {
          sneakyThrowRuleFailedException("superclasses(left.classref).contains(right.classref)");
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> assignableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression, final Type right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleExpressionAssignableToType(G, _subtrace_, expression, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ExpressionAssignableToType") + stringRepForEnv(G) + " |- " + stringRep(expression) + " |> " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleExpressionAssignableToType) {
    	assignableThrowException(ruleName("ExpressionAssignableToType") + stringRepForEnv(G) + " |- " + stringRep(expression) + " |> " + stringRep(right),
    		EXPRESSIONASSIGNABLETOTYPE,
    		e_applyRuleExpressionAssignableToType, expression, right, new ErrorInformation[] {new ErrorInformation(expression), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleExpressionAssignableToType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression, final Type right) throws RuleFailedException {
    Type expressionType = null;
    /* G |- expression : expressionType */
    Result<Type> result = typeInternal(G, _trace_, expression);
    checkAssignableTo(result.getFirst(), Type.class);
    expressionType = (Type) result.getFirst();
    
    /* G |- expressionType <: right */
    subtypeInternal(G, _trace_, expressionType, right);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleGeneralEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("GeneralEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleGeneralEquals) {
    	generalEqualsThrowException(e_applyRuleGeneralEquals, left, right);
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleGeneralEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type left, final Type right) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  private void generalEqualsThrowException(final Exception e_applyRuleGeneralEquals, final Type left, final Type right) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = ("types " + _stringRep);
    String _plus_1 = (_plus + " and ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_2 = (_plus_1 + _stringRep_1);
    String _plus_3 = (_plus_2 + 
      " are not comparable");
    String error = _plus_3;
    throwRuleFailedException(error,
    	GENERALEQUALS, e_applyRuleGeneralEquals, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleBasicEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBasicEquals) {
    	equalstypeThrowException(ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		BASICEQUALS,
    		e_applyRuleBasicEquals, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    String _basic = left.getBasic();
    String _basic_1 = right.getBasic();
    /* left.basic.equals(right.basic) */
    if (!_basic.equals(_basic_1)) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleClassEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassEquals) {
    	equalstypeThrowException(ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		CLASSEQUALS,
    		e_applyRuleClassEquals, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
    it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
    /* left.classref == right.classref */
    if (!Objects.equal(_classref, _classref_1)) {
      sneakyThrowRuleFailedException("left.classref == right.classref");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypesequenceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubtypeSequence(G, _subtrace_, owner, expressions, typedElements);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(expressions) + " << " + stringRep(typedElements);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubtypeSequence) {
    	subtypesequenceThrowException(ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(expressions) + " << " + stringRep(typedElements),
    		SUBTYPESEQUENCE,
    		e_applyRuleSubtypeSequence, owner, expressions, typedElements, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSubtypeSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
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
      /* G |- exp |> typedElementsIterator.next.type */
      TypedElement _next = typedElementsIterator.next();
      Type _type = _next.getType();
      assignableInternal(G, _trace_, exp, _type);
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Expression> reduceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New exp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Expression> _result_ = applyRuleRNew(G, _subtrace_, exp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RNew") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRNew) {
    	reduceThrowException(ruleName("RNew") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + "New",
    		RNEW,
    		e_applyRuleRNew, exp, new ErrorInformation[] {new ErrorInformation(exp)});
    	return null;
    }
  }
  
  protected Result<Expression> applyRuleRNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New exp) throws RuleFailedException {
    New exp1 = null; // output parameter
    New _clone = this.<New>clone(exp);
    exp1 = _clone;
    EList<Expression> _args = exp1.getArgs();
    final Predicate<Expression> _function = new Predicate<Expression>() {
      public boolean apply(final Expression it) {
        try {
          Boolean _isValue = FjTypeSystem.this.isValueInternal(_trace_, it);
          return (!(_isValue).booleanValue());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final int indexOfNextToReduce = Iterables.<Expression>indexOf(_args, _function);
    /* { indexOfNextToReduce < 0 } or { val nextToReduce = exp1.args.get(indexOfNextToReduce) G |- nextToReduce ~> var Expression expi exp1.args.set(indexOfNextToReduce, expi) } */
    try {
      /* indexOfNextToReduce < 0 */
      if (!(indexOfNextToReduce < 0)) {
        sneakyThrowRuleFailedException("indexOfNextToReduce < 0");
      }
    } catch (Exception e) {
      EList<Expression> _args_1 = exp1.getArgs();
      final Expression nextToReduce = _args_1.get(indexOfNextToReduce);
      /* G |- nextToReduce ~> var Expression expi */
      Expression expi = null;
      Result<Expression> result = reduceInternal(G, _trace_, nextToReduce);
      checkAssignableTo(result.getFirst(), Expression.class);
      expi = (Expression) result.getFirst();
      
      EList<Expression> _args_2 = exp1.getArgs();
      _args_2.set(indexOfNextToReduce, expi);
    }
    return new Result<Expression>(exp1);
  }
  
  protected Result<Expression> reduceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection exp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Expression> _result_ = applyRuleRSelection(G, _subtrace_, exp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RSelection") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRSelection) {
    	reduceThrowException(ruleName("RSelection") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + "Expression",
    		RSELECTION,
    		e_applyRuleRSelection, exp, new ErrorInformation[] {new ErrorInformation(exp)});
    	return null;
    }
  }
  
  protected Result<Expression> applyRuleRSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection exp) throws RuleFailedException {
    Expression exp1 = null; // output parameter
    /* { val sel = clone(exp) !isValue(exp.receiver) G |- exp.receiver ~> var Expression expi sel.receiver = expi exp1 = sel } or { val receiver = exp.receiver as New val message = exp.message switch (message) { Field: { val fieldIndex = Iterables::indexOf(fields(receiver.type.classref)) [ name == message.name ] exp1 = receiver.args.get(fieldIndex) } Method: { val indexOfNextToReduce = Iterables::indexOf(exp.args) [ !isValue(it) ] { indexOfNextToReduce < 0 val method = exp.message as Method exp1 = replaceThisAndParams( method.body, receiver, method.params, exp.args).expression } or { val sel = clone(exp) val nextToReduce = sel.args.get(indexOfNextToReduce) G |- nextToReduce ~> var Expression argi sel.args.set(indexOfNextToReduce, argi) exp1 = sel } } } } */
    try {
      final Selection sel = this.<Selection>clone(exp);
      Expression _receiver = exp.getReceiver();
      Boolean _isValue = this.isValueInternal(_trace_, _receiver);
      boolean _not = (!(_isValue).booleanValue());
      /* !isValue(exp.receiver) */
      if (!_not) {
        sneakyThrowRuleFailedException("!isValue(exp.receiver)");
      }
      /* G |- exp.receiver ~> var Expression expi */
      Expression _receiver_1 = exp.getReceiver();
      Expression expi = null;
      Result<Expression> result = reduceInternal(G, _trace_, _receiver_1);
      checkAssignableTo(result.getFirst(), Expression.class);
      expi = (Expression) result.getFirst();
      
      sel.setReceiver(expi);
      exp1 = sel;
    } catch (Exception e) {
      Expression _receiver_2 = exp.getReceiver();
      final New receiver = ((New) _receiver_2);
      final Member message = exp.getMessage();
      boolean _matched = false;
      if (!_matched) {
        if (message instanceof Field) {
          _matched=true;
          ClassType _type = receiver.getType();
          it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
          List<Field> _fields = this.fieldsInternal(_trace_, _classref);
          final Predicate<Field> _function = new Predicate<Field>() {
            public boolean apply(final Field it) {
              String _name = it.getName();
              String _name_1 = ((Field)message).getName();
              return Objects.equal(_name, _name_1);
            }
          };
          final int fieldIndex = Iterables.<Field>indexOf(_fields, _function);
          EList<Expression> _args = receiver.getArgs();
          Expression _get = _args.get(fieldIndex);
          exp1 = _get;
        }
      }
      if (!_matched) {
        if (message instanceof Method) {
          _matched=true;
          EList<Expression> _args = exp.getArgs();
          final Predicate<Expression> _function = new Predicate<Expression>() {
            public boolean apply(final Expression it) {
              try {
                Boolean _isValue = FjTypeSystem.this.isValueInternal(_trace_, it);
                return (!(_isValue).booleanValue());
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          final int indexOfNextToReduce = Iterables.<Expression>indexOf(_args, _function);
          /* { indexOfNextToReduce < 0 val method = exp.message as Method exp1 = replaceThisAndParams( method.body, receiver, method.params, exp.args).expression } or { val sel = clone(exp) val nextToReduce = sel.args.get(indexOfNextToReduce) G |- nextToReduce ~> var Expression argi sel.args.set(indexOfNextToReduce, argi) exp1 = sel } */
          try {
            /* indexOfNextToReduce < 0 */
            if (!(indexOfNextToReduce < 0)) {
              sneakyThrowRuleFailedException("indexOfNextToReduce < 0");
            }
            Member _message = exp.getMessage();
            final Method method = ((Method) _message);
            MethodBody _body = method.getBody();
            EList<Parameter> _params = method.getParams();
            EList<Expression> _args_1 = exp.getArgs();
            MethodBody _replaceThisAndParams = this.replaceThisAndParamsInternal(_trace_, _body, receiver, _params, _args_1);
            Expression _expression = _replaceThisAndParams.getExpression();
            exp1 = _expression;
          } catch (Exception e_1) {
            final Selection sel_1 = this.<Selection>clone(exp);
            EList<Expression> _args_2 = sel_1.getArgs();
            final Expression nextToReduce = _args_2.get(indexOfNextToReduce);
            /* G |- nextToReduce ~> var Expression argi */
            Expression argi = null;
            Result<Expression> result_1 = reduceInternal(G, _trace_, nextToReduce);
            checkAssignableTo(result_1.getFirst(), Expression.class);
            argi = (Expression) result_1.getFirst();
            
            EList<Expression> _args_3 = sel_1.getArgs();
            _args_3.set(indexOfNextToReduce, argi);
            exp1 = sel_1;
          }
        }
      }
    }
    return new Result<Expression>(exp1);
  }
  
  protected Result<Expression> reduceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast exp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Expression> _result_ = applyRuleRCast(G, _subtrace_, exp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RCast") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRCast) {
    	reduceThrowException(ruleName("RCast") + stringRepForEnv(G) + " |- " + stringRep(exp) + " ~> " + "Expression",
    		RCAST,
    		e_applyRuleRCast, exp, new ErrorInformation[] {new ErrorInformation(exp)});
    	return null;
    }
  }
  
  protected Result<Expression> applyRuleRCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast exp) throws RuleFailedException {
    Expression exp1 = null; // output parameter
    final Cast cast = this.<Cast>clone(exp);
    Expression _expression = cast.getExpression();
    Boolean _isValue = this.isValueInternal(_trace_, _expression);
    if ((_isValue).booleanValue()) {
      /* G |- cast.expression |> cast.type */
      Expression _expression_1 = cast.getExpression();
      ClassType _type = cast.getType();
      assignableInternal(G, _trace_, _expression_1, _type);
      Expression _expression_2 = cast.getExpression();
      exp1 = _expression_2;
    } else {
      /* G |- cast.expression ~> var Expression expi */
      Expression _expression_3 = cast.getExpression();
      Expression expi = null;
      Result<Expression> result = reduceInternal(G, _trace_, _expression_3);
      checkAssignableTo(result.getFirst(), Expression.class);
      expi = (Expression) result.getFirst();
      
      cast.setExpression(expi);
      exp1 = cast;
    }
    return new Result<Expression>(exp1);
  }
  
  protected Result3<Expression, Type, Type> subjredImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result3<Expression, Type, Type> _result_ = applyRuleSubjRed(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubjRed") + stringRepForEnv(G) + " |= " + stringRep(e) + " ~> " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()) + " <: " + stringRep(_result_.getThird());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubjRed) {
    	subjredThrowException(ruleName("SubjRed") + stringRepForEnv(G) + " |= " + stringRep(e) + " ~> " + "Expression" + " : " + "Type" + " <: " + "Type",
    		SUBJRED,
    		e_applyRuleSubjRed, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result3<Expression, Type, Type> applyRuleSubjRed(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    Expression e1 = null; // output parameter
    Type T1 = null; // output parameter
    Type T = null; // output parameter
    /* G |- e : T */
    Result<Type> result = typeInternal(G, _trace_, e);
    checkAssignableTo(result.getFirst(), Type.class);
    T = (Type) result.getFirst();
    
    /* G |- e ~> e1 */
    Result<Expression> result_1 = reduceInternal(G, _trace_, e);
    checkAssignableTo(result_1.getFirst(), Expression.class);
    e1 = (Expression) result_1.getFirst();
    
    /* G |- e1 : T1 */
    Result<Type> result_2 = typeInternal(G, _trace_, e1);
    checkAssignableTo(result_2.getFirst(), Type.class);
    T1 = (Type) result_2.getFirst();
    
    /* G |- T1 <: T */
    subtypeInternal(G, _trace_, T1, T);
    return new Result3<Expression, Type, Type>(e1, T1, T);
  }
}
