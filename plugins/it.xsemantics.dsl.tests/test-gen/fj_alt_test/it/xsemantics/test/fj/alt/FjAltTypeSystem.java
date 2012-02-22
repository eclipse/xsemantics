package it.xsemantics.test.fj.alt;

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
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class FjAltTypeSystem extends XsemanticsRuntimeSystem {
	public final static String TTYPEDELEMENT = "it.xsemantics.test.fj.alt.rules.TTypedElement";
	public final static String TTHIS = "it.xsemantics.test.fj.alt.rules.TThis";
	public final static String TNEW = "it.xsemantics.test.fj.alt.rules.TNew";
	public final static String TPARAMREF = "it.xsemantics.test.fj.alt.rules.TParamRef";
	public final static String TSTRINGCONSTANT = "it.xsemantics.test.fj.alt.rules.TStringConstant";
	public final static String TINTCONSTANT = "it.xsemantics.test.fj.alt.rules.TIntConstant";
	public final static String TBOOLCONSTANT = "it.xsemantics.test.fj.alt.rules.TBoolConstant";
	public final static String TSELECTION = "it.xsemantics.test.fj.alt.rules.TSelection";
	public final static String TCAST = "it.xsemantics.test.fj.alt.rules.TCast";
	public final static String TEXPRESSIONCLASSTYPE = "it.xsemantics.test.fj.alt.rules.TExpressionClassType";
	public final static String BASICSUBTYPING = "it.xsemantics.test.fj.alt.rules.BasicSubtyping";
	public final static String CLASSSUBTYPING = "it.xsemantics.test.fj.alt.rules.ClassSubtyping";
	public final static String SUBCLASSING = "it.xsemantics.test.fj.alt.rules.Subclassing";
	public final static String TYPEEQUALS = "it.xsemantics.test.fj.alt.rules.TypeEquals";
	public final static String BASICEQUALS = "it.xsemantics.test.fj.alt.rules.BasicEquals";
	public final static String CLASSEQUALS = "it.xsemantics.test.fj.alt.rules.ClassEquals";
	public final static String SUBTYPESEQUENCE = "it.xsemantics.test.fj.alt.rules.SubtypeSequence";
	public final static String CHECKCONSTANT = "it.xsemantics.test.fj.alt.rules.CheckConstant";
	public final static String CHECKTYPEDELEMENT = "it.xsemantics.test.fj.alt.rules.CheckTypedElement";
	public final static String CHECKPARAMREF = "it.xsemantics.test.fj.alt.rules.CheckParamRef";
	public final static String CHECKTHIS = "it.xsemantics.test.fj.alt.rules.CheckThis";
	public final static String CHECKMETHOD = "it.xsemantics.test.fj.alt.rules.CheckMethod";
	public final static String CHECKNEW = "it.xsemantics.test.fj.alt.rules.CheckNew";
	public final static String CHECKSELECTION = "it.xsemantics.test.fj.alt.rules.CheckSelection";
	public final static String CHECKCAST = "it.xsemantics.test.fj.alt.rules.CheckCast";
	public final static String CHECKCLASS = "it.xsemantics.test.fj.alt.rules.CheckClass";

	protected PolymorphicDispatcher<Result<Type>> typeDispatcher;
	
	protected PolymorphicDispatcher<Result<ClassType>> classtypeDispatcher;
	
	protected PolymorphicDispatcher<Result<Type>> typedeclDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> equalstypeDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> subtypesequenceDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> subclassDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> checkDispatcher;

	public FjAltTypeSystem() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 3, "|-", ":");
		classtypeDispatcher = buildPolymorphicDispatcher1(
			"classtypeImpl", 3, "||~", ":");
		typedeclDispatcher = buildPolymorphicDispatcher1(
			"typedeclImpl", 3, "||-", ":");
		subtypeDispatcher = buildPolymorphicDispatcher1(
			"subtypeImpl", 4, "|-", "<:");
		equalstypeDispatcher = buildPolymorphicDispatcher1(
			"equalstypeImpl", 4, "|-", "~~");
		subtypesequenceDispatcher = buildPolymorphicDispatcher1(
			"subtypesequenceImpl", 5, "|-", ":", "<<");
		subclassDispatcher = buildPolymorphicDispatcher1(
			"subclassImpl", 4, "|-", "<|");
		checkDispatcher = buildPolymorphicDispatcher1(
			"checkImpl", 3, "|-");
	}

	public Result<Type> type(final Expression expression) {
		return type(new RuleEnvironment(),
			null, expression);
	}
	
	public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			return typeInternal(_environment_, _trace_, expression);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<ClassType> classtype(final Expression expression) {
		return classtype(new RuleEnvironment(),
			null, expression);
	}
	
	public Result<ClassType> classtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			return classtypeInternal(_environment_, _trace_, expression);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Type> typedecl(final TypedElement element) {
		return typedecl(new RuleEnvironment(),
			null, element);
	}
	
	public Result<Type> typedecl(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypedElement element) {
		try {
			return typedeclInternal(_environment_, _trace_, element);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> subtype(final Type left, final Type right) {
		return subtype(new RuleEnvironment(),
			null, left, right);
	}
	
	public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type left, final Type right) {
		try {
			return subtypeInternal(_environment_, _trace_, left, right);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> equalstype(final Type left, final Type right) {
		return equalstype(new RuleEnvironment(),
			null, left, right);
	}
	
	public Result<Boolean> equalstype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type left, final Type right) {
		try {
			return equalstypeInternal(_environment_, _trace_, left, right);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> subtypesequence(final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
		return subtypesequence(new RuleEnvironment(),
			null, owner, expressions, elements);
	}
	
	public Result<Boolean> subtypesequence(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
		try {
			return subtypesequenceInternal(_environment_, _trace_, owner, expressions, elements);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> subclass(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
		return subclass(new RuleEnvironment(),
			null, candidate, superclass);
	}
	
	public Result<Boolean> subclass(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
		try {
			return subclassInternal(_environment_, _trace_, candidate, superclass);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> check(final EObject obj) {
		return check(new RuleEnvironment(),
			null, obj);
	}
	
	public Result<Boolean> check(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject obj) {
		try {
			return checkInternal(_environment_, _trace_, obj);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}

	public Result<Boolean> checkMain(final Program program) {
		try {
			return checkMainInternal(null, program);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkMainInternal(final RuleApplicationTrace _trace_, final Program program) 
			throws RuleFailedException {
		
		/* program.main == null or empty |- program.main */
		try {
		  Expression _main = program.getMain();
		  boolean _operator_equals = ObjectExtensions.operator_equals(_main, null);
		  /* program.main == null */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("program.main == null");
		  }
		} catch (Exception e) {
		  /* empty |- program.main */
		  Expression _main_1 = program.getMain();
		  checkInternal(emptyEnvironment(), _trace_, _main_1);
		}
		return new Result<Boolean>(true);
	}
	
	public Result<Boolean> checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
		try {
			return checkClassOkInternal(null, clazz);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkClassOkInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) 
			throws RuleFailedException {
		
		/* empty |- clazz */
		checkInternal(emptyEnvironment(), _trace_, clazz);
		return new Result<Boolean>(true);
	}
	
	public Result<Boolean> checkMethodBody(final Method method) {
		try {
			return checkMethodBodyInternal(null, method);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkMethodBodyInternal(final RuleApplicationTrace _trace_, final Method method) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	public Result<Boolean> checkField(final Field field) {
		try {
			return checkFieldInternal(null, field);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkFieldInternal(final RuleApplicationTrace _trace_, final Field field) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	public Result<Boolean> checkMethodOverride(final Method method) {
		try {
			return checkMethodOverrideInternal(null, method);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkMethodOverrideInternal(final RuleApplicationTrace _trace_, final Method method) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	public Result<Boolean> checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
		try {
			return checkClassHierachyNotCyclicInternal(null, cl);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkClassHierachyNotCyclicInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}

	protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			checkParamsNotNull(expression);
			return typeDispatcher.invoke(_environment_, _trace_, expression);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected void classtypeThrowException(String _issue, Exception _ex, final Expression expression) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(expression);
		String _operator_plus = StringExtensions.operator_plus(_stringRep, " has not a class type");
		String error = _operator_plus;
		EObject source = expression;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, null));
	}
	
	protected Result<ClassType> classtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			checkParamsNotNull(expression);
			return classtypeDispatcher.invoke(_environment_, _trace_, expression);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Type> typedeclInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypedElement element) {
		try {
			checkParamsNotNull(element);
			return typedeclDispatcher.invoke(_environment_, _trace_, element);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected void subtypeThrowException(String _issue, Exception _ex, final Type left, final Type right) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(left);
		String _operator_plus = StringExtensions.operator_plus(_stringRep, " is not a subtype of ");
		String _stringRep_1 = this.stringRep(right);
		String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _stringRep_1);
		String error = _operator_plus_1;
		EObject source = left;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, null));
	}
	
	protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type left, final Type right) {
		try {
			checkParamsNotNull(left, right);
			return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> equalstypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type left, final Type right) {
		try {
			checkParamsNotNull(left, right);
			return equalstypeDispatcher.invoke(_environment_, _trace_, left, right);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> subtypesequenceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
		try {
			checkParamsNotNull(owner, expressions, elements);
			return subtypesequenceDispatcher.invoke(_environment_, _trace_, owner, expressions, elements);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected void subclassThrowException(String _issue, Exception _ex, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) 
			throws RuleFailedException {
		
		String _name = candidate.getName();
		String _operator_plus = StringExtensions.operator_plus(_name, " is not a subclass of ");
		String _name_1 = superclass.getName();
		String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name_1);
		String error = _operator_plus_1;
		EObject source = candidate;
		EAttribute _class_Name = FjPackage.eINSTANCE.getClass_Name();
		EStructuralFeature feature = _class_Name;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, feature));
	}
	
	protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
		try {
			checkParamsNotNull(candidate, superclass);
			return subclassDispatcher.invoke(_environment_, _trace_, candidate, superclass);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Boolean> checkInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EObject obj) {
		try {
			checkParamsNotNull(obj);
			return checkDispatcher.invoke(_environment_, _trace_, obj);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Type> typedeclImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypedElement typedElement) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTTypedElement(G, _subtrace_, typedElement);
			addToTrace(_trace_, ruleName("TTypedElement") + stringRepForEnv(G) + " ||- " + stringRep(typedElement) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTTypedElement) {
			throwRuleFailedException(ruleName("TTypedElement") + stringRepForEnv(G) + " ||- " + stringRep(typedElement) + " : " + "Type",
				TTYPEDELEMENT,
				e_applyRuleTTypedElement, new ErrorInformation(typedElement));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTTypedElement(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypedElement typedElement) 
			throws RuleFailedException {
		
		Type _type = typedElement.getType();
		return new Result<Type>(_type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final This _this) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTThis(G, _subtrace_, _this);
			addToTrace(_trace_, ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTThis) {
			throwRuleFailedException(ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + "ClassType",
				TTHIS,
				e_applyRuleTThis, new ErrorInformation(_this));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTThis(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final This _this) 
			throws RuleFailedException {
		
		/* env(G, 'this', ClassType) */
		ClassType _environmentaccess = environmentAccess(G, "this", ClassType.class);
		return new Result<Type>(_environmentaccess);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final New newExp) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTNew(G, _subtrace_, newExp);
			addToTrace(_trace_, ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTNew) {
			throwRuleFailedException(ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + "ClassType",
				TNEW,
				e_applyRuleTNew, new ErrorInformation(newExp));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTNew(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final New newExp) 
			throws RuleFailedException {
		
		ClassType _type = newExp.getType();
		return new Result<Type>(_type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ParamRef paramref) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTParamRef(G, _subtrace_, paramref);
			addToTrace(_trace_, ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTParamRef) {
			throwRuleFailedException(ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + "Type",
				TPARAMREF,
				e_applyRuleTParamRef, new ErrorInformation(paramref));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ParamRef paramref) 
			throws RuleFailedException {
		Type type = null;
		
		/* G ||- paramref.parameter : type */
		Parameter _parameter = paramref.getParameter();
		Result<Type> result = typedeclInternal(G, _trace_, _parameter);
		checkAssignableTo(result.getFirst(), Type.class);
		type = (Type) result.getFirst();
		
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringConstant s) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTStringConstant(G, _subtrace_, s);
			addToTrace(_trace_, ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTStringConstant) {
			throwRuleFailedException(ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + "BasicType",
				TSTRINGCONSTANT,
				e_applyRuleTStringConstant, new ErrorInformation(s));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTStringConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringConstant s) 
			throws RuleFailedException {
		
		BasicType _xblockexpression = null;
		{
		  BasicType _createBasicType = FjFactory.eINSTANCE.createBasicType();
		  final BasicType result = _createBasicType;
		  result.setBasic("String");
		  _xblockexpression = (result);
		}
		return new Result<Type>(_xblockexpression);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final IntConstant i) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTIntConstant(G, _subtrace_, i);
			addToTrace(_trace_, ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTIntConstant) {
			throwRuleFailedException(ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + "BasicType",
				TINTCONSTANT,
				e_applyRuleTIntConstant, new ErrorInformation(i));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTIntConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final IntConstant i) 
			throws RuleFailedException {
		
		BasicType _createIntType = FjTypeUtils.createIntType();
		return new Result<Type>(_createIntType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BoolConstant b) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTBoolConstant(G, _subtrace_, b);
			addToTrace(_trace_, ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTBoolConstant) {
			throwRuleFailedException(ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + "BasicType",
				TBOOLCONSTANT,
				e_applyRuleTBoolConstant, new ErrorInformation(b));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTBoolConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BoolConstant b) 
			throws RuleFailedException {
		
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
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Selection selection) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTSelection(G, _subtrace_, selection);
			addToTrace(_trace_, ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTSelection) {
			throwRuleFailedException(ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + "Type",
				TSELECTION,
				e_applyRuleTSelection, new ErrorInformation(selection));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Selection selection) 
			throws RuleFailedException {
		Type type = null;
		
		/* G ||- selection.message : type */
		Member _message = selection.getMessage();
		Result<Type> result = typedeclInternal(G, _trace_, _message);
		checkAssignableTo(result.getFirst(), Type.class);
		type = (Type) result.getFirst();
		
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Cast cast) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleTCast(G, _subtrace_, cast);
			addToTrace(_trace_, ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTCast) {
			throwRuleFailedException(ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + "ClassType",
				TCAST,
				e_applyRuleTCast, new ErrorInformation(cast));
			return null;
		}
	}
	
	protected Result<Type> applyRuleTCast(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Cast cast) 
			throws RuleFailedException {
		
		ClassType _type = cast.getType();
		return new Result<Type>(_type);
	}
	
	protected Result<ClassType> classtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Expression expression) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<ClassType> _result_ = applyRuleTExpressionClassType(G, _subtrace_, expression);
			addToTrace(_trace_, ruleName("TExpressionClassType") + stringRepForEnv(G) + " ||~ " + stringRep(expression) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTExpressionClassType) {
			classtypeThrowException(TEXPRESSIONCLASSTYPE,
				e_applyRuleTExpressionClassType, expression);
			return null;
		}
	}
	
	protected Result<ClassType> applyRuleTExpressionClassType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Expression expression) 
			throws RuleFailedException {
		ClassType classType = null;
		
		/* G |- expression : classType */
		Result<Type> result = typeInternal(G, _trace_, expression);
		checkAssignableTo(result.getFirst(), ClassType.class);
		classType = (ClassType) result.getFirst();
		
		return new Result<ClassType>(classType);
	}
	
	protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BasicType left, final BasicType right) 
			throws RuleFailedException {
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
	
	protected Result<Boolean> applyRuleBasicSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BasicType left, final BasicType right) 
			throws RuleFailedException {
		
		String _basic = left.getBasic();
		String _basic_1 = right.getBasic();
		boolean _equals = _basic.equals(_basic_1);
		/* left.basic.equals(right.basic) */
		if (!_equals) {
		  sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ClassType left, final ClassType right) 
			throws RuleFailedException {
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
	
	protected Result<Boolean> applyRuleClassSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ClassType left, final ClassType right) 
			throws RuleFailedException {
		
		/* G |- left.classref <| right.classref */
		it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
		it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
		subclassInternal(G, _trace_, _classref, _classref_1);
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> subclassImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class class1, final it.xsemantics.example.fj.fj.Class class2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleSubclassing(G, _subtrace_, class1, class2);
			addToTrace(_trace_, ruleName("Subclassing") + stringRepForEnv(G) + " |- " + stringRep(class1) + " <| " + stringRep(class2));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleSubclassing) {
			subclassThrowException(SUBCLASSING,
				e_applyRuleSubclassing, class1, class2);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleSubclassing(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class class1, final it.xsemantics.example.fj.fj.Class class2) 
			throws RuleFailedException {
		
		/* class1 == class2 or class2.name == "Object" or { class1.superclass != null G |- class1.superclass <| class2 } */
		try {
		  boolean _operator_equals = ObjectExtensions.operator_equals(class1, class2);
		  /* class1 == class2 */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("class1 == class2");
		  }
		} catch (Exception e) {
		  /* class2.name == "Object" or { class1.superclass != null G |- class1.superclass <| class2 } */
		  try {
		    String _name = class2.getName();
		    boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name, "Object");
		    /* class2.name == "Object" */
		    if (!_operator_equals_1) {
		      sneakyThrowRuleFailedException("class2.name == \"Object\"");
		    }
		  } catch (Exception e_1) {
		    {
		      it.xsemantics.example.fj.fj.Class _superclass = class1.getSuperclass();
		      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superclass, null);
		      /* class1.superclass != null */
		      if (!_operator_notEquals) {
		        sneakyThrowRuleFailedException("class1.superclass != null");
		      }
		      /* G |- class1.superclass <| class2 */
		      it.xsemantics.example.fj.fj.Class _superclass_1 = class1.getSuperclass();
		      subclassInternal(G, _trace_, _superclass_1, class2);
		    }
		  }
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Type left, final Type right) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleTypeEquals(G, _subtrace_, left, right);
			addToTrace(_trace_, ruleName("TypeEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleTypeEquals) {
			
			String _stringRep = this.stringRep(left);
			String _operator_plus = StringExtensions.operator_plus(_stringRep, " and ");
			String _stringRep_1 = this.stringRep(right);
			String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _stringRep_1);
			String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, " are not comparable");
			String error = _operator_plus_2;
			throwRuleFailedException(error,
				TYPEEQUALS, e_applyRuleTypeEquals,
				new ErrorInformation(null, null));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleTypeEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Type left, final Type right) 
			throws RuleFailedException {
		
		/* fail */
		throwForExplicitFail();
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BasicType left, final BasicType right) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleBasicEquals(G, _subtrace_, left, right);
			addToTrace(_trace_, ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleBasicEquals) {
			throwRuleFailedException(ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
				BASICEQUALS,
				e_applyRuleBasicEquals, new ErrorInformation(left), new ErrorInformation(right));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleBasicEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BasicType left, final BasicType right) 
			throws RuleFailedException {
		
		String _basic = left.getBasic();
		String _basic_1 = right.getBasic();
		boolean _equals = _basic.equals(_basic_1);
		/* left.basic.equals(right.basic) */
		if (!_equals) {
		  sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ClassType left, final ClassType right) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleClassEquals(G, _subtrace_, left, right);
			addToTrace(_trace_, ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleClassEquals) {
			throwRuleFailedException(ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
				CLASSEQUALS,
				e_applyRuleClassEquals, new ErrorInformation(left), new ErrorInformation(right));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleClassEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ClassType left, final ClassType right) 
			throws RuleFailedException {
		
		it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
		it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
		boolean _operator_equals = ObjectExtensions.operator_equals(_classref, _classref_1);
		/* left.classref == right.classref */
		if (!_operator_equals) {
		  sneakyThrowRuleFailedException("left.classref == right.classref");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> subtypesequenceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Expression onwer, final List<Expression> expressions, final List<TypedElement> typedElements) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleSubtypeSequence(G, _subtrace_, onwer, expressions, typedElements);
			addToTrace(_trace_, ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(onwer) + " : " + stringRep(expressions) + " << " + stringRep(typedElements));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleSubtypeSequence) {
			throwRuleFailedException(ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(onwer) + " : " + stringRep(expressions) + " << " + stringRep(typedElements),
				SUBTYPESEQUENCE,
				e_applyRuleSubtypeSequence, new ErrorInformation(onwer));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleSubtypeSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Expression onwer, final List<Expression> expressions, final List<TypedElement> typedElements) 
			throws RuleFailedException {
		
		{
		  int _size = expressions.size();
		  int _size_1 = typedElements.size();
		  boolean _operator_equals = IntegerExtensions.operator_equals(_size, _size_1);
		  /* expressions.size == typedElements.size */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("expressions.size == typedElements.size");
		  }
		  Iterator<TypedElement> _iterator = typedElements.iterator();
		  final Iterator<TypedElement> typedElementsIterator = _iterator;
		  for (final Expression exp : expressions) {
		    {
		      Type expressionType = null;
		      /* G |- exp : expressionType */
		      Result<Type> result = typeInternal(G, _trace_, exp);
		      checkAssignableTo(result.getFirst(), Type.class);
		      expressionType = (Type) result.getFirst();
		      
		      Type typedElementType = null;
		      /* G ||- typedElementsIterator.next : typedElementType */
		      TypedElement _next = typedElementsIterator.next();
		      Result<Type> result_1 = typedeclInternal(G, _trace_, _next);
		      checkAssignableTo(result_1.getFirst(), Type.class);
		      typedElementType = (Type) result_1.getFirst();
		      
		      /* G |- expressionType <: typedElementType */
		      subtypeInternal(G, _trace_, expressionType, typedElementType);
		    }
		  }
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Constant _const) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckConstant(G, _subtrace_, _const);
			addToTrace(_trace_, ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckConstant) {
			throwRuleFailedException(ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const),
				CHECKCONSTANT,
				e_applyRuleCheckConstant, new ErrorInformation(_const));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Constant _const) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypedElement typedElement) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckTypedElement(G, _subtrace_, typedElement);
			addToTrace(_trace_, ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckTypedElement) {
			throwRuleFailedException(ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement),
				CHECKTYPEDELEMENT,
				e_applyRuleCheckTypedElement, new ErrorInformation(typedElement));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckTypedElement(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypedElement typedElement) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ParamRef paramref) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckParamRef(G, _subtrace_, paramref);
			addToTrace(_trace_, ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckParamRef) {
			throwRuleFailedException(ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref),
				CHECKPARAMREF,
				e_applyRuleCheckParamRef, new ErrorInformation(paramref));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ParamRef paramref) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final This _this) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckThis(G, _subtrace_, _this);
			addToTrace(_trace_, ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckThis) {
			throwRuleFailedException(ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this),
				CHECKTHIS,
				e_applyRuleCheckThis, new ErrorInformation(_this));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckThis(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final This _this) 
			throws RuleFailedException {
		
		/* env(G, 'this', ClassType) */
		ClassType _environmentaccess = environmentAccess(G, "this", ClassType.class);
		boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_environmentaccess, null);
		/* env(G, 'this', ClassType) != null */
		if (!_operator_notEquals) {
		  sneakyThrowRuleFailedException("env(G, \'this\', ClassType) != null");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Method method) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckMethod(G, _subtrace_, method);
			addToTrace(_trace_, ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckMethod) {
			throwRuleFailedException(ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method),
				CHECKMETHOD,
				e_applyRuleCheckMethod, new ErrorInformation(method));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckMethod(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Method method) 
			throws RuleFailedException {
		
		{
		  it.xsemantics.example.fj.fj.Class _containerOfType = EcoreUtil2.<it.xsemantics.example.fj.fj.Class>getContainerOfType(method, it.xsemantics.example.fj.fj.Class.class);
		  ClassType _createClassType = FjTypeUtils.createClassType(_containerOfType);
		  final ClassType typeForThis = _createClassType;
		  Type bodyType = null;
		  /* G, 'this' <- typeForThis |- method.body.expression : bodyType */
		  MethodBody _body = method.getBody();
		  Expression _expression = _body.getExpression();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("this", typeForThis)
		  ), _trace_, _expression);
		  checkAssignableTo(result.getFirst(), Type.class);
		  bodyType = (Type) result.getFirst();
		  
		  /* G |- bodyType <: method.type */
		  Type _type = method.getType();
		  subtypeInternal(G, _trace_, bodyType, _type);
		  /* G, 'this' <- typeForThis |- method.body.expression */
		  MethodBody _body_1 = method.getBody();
		  Expression _expression_1 = _body_1.getExpression();
		  checkInternal(environmentComposition(
		    G, environmentEntry("this", typeForThis)
		  ), _trace_, _expression_1);
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final New newExp) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckNew(G, _subtrace_, newExp);
			addToTrace(_trace_, ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckNew) {
			throwRuleFailedException(ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp),
				CHECKNEW,
				e_applyRuleCheckNew, new ErrorInformation(newExp));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckNew(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final New newExp) 
			throws RuleFailedException {
		
		{
		  ClassType _type = newExp.getType();
		  it.xsemantics.example.fj.fj.Class _classref = _type.getClassref();
		  List<Field> _fields = FjAuxiliaryFunctions.getFields(_classref);
		  List<Field> fields = _fields;
		  /* G |- newExp : newExp.args << fields */
		  EList<Expression> _args = newExp.getArgs();
		  subtypesequenceInternal(G, _trace_, newExp, _args, fields);
		  EList<Expression> _args_1 = newExp.getArgs();
		  final Procedure1<Expression> _function = new Procedure1<Expression>() {
		      public void apply(final Expression it) {
		        /* G |- it */
		        checkInternal(G, _trace_, it);
		      }
		    };
		  IterableExtensions.<Expression>forEach(_args_1, _function);
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Selection selection) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckSelection(G, _subtrace_, selection);
			addToTrace(_trace_, ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckSelection) {
			throwRuleFailedException(ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection),
				CHECKSELECTION,
				e_applyRuleCheckSelection, new ErrorInformation(selection));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Selection selection) 
			throws RuleFailedException {
		
		{
		  /* G |- selection.receiver */
		  Expression _receiver = selection.getReceiver();
		  checkInternal(G, _trace_, _receiver);
		  Member _message = selection.getMessage();
		  final Member message = _message;
		  boolean matched = false;
		  if (!matched) {
		    if (message instanceof Method) {
		      final Method _method = (Method)message;
		      matched=true;
		      {
		        /* G |- selection : selection.args << message.params */
		        EList<Expression> _args = selection.getArgs();
		        EList<Parameter> _params = _method.getParams();
		        subtypesequenceInternal(G, _trace_, selection, _args, _params);
		        EList<Expression> _args_1 = selection.getArgs();
		        for (final Expression arg : _args_1) {
		          /* G |- arg */
		          checkInternal(G, _trace_, arg);
		        }
		      }
		    }
		  }
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Cast cast) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckCast(G, _subtrace_, cast);
			addToTrace(_trace_, ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckCast) {
			throwRuleFailedException(ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast),
				CHECKCAST,
				e_applyRuleCheckCast, new ErrorInformation(cast));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckCast(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Cast cast) 
			throws RuleFailedException {
		
		{
		  Type expType = null;
		  /* G |- cast.expression : expType */
		  Expression _expression = cast.getExpression();
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
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class cl) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleCheckClass(G, _subtrace_, cl);
			addToTrace(_trace_, ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleCheckClass) {
			throwRuleFailedException(ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl),
				CHECKCLASS,
				e_applyRuleCheckClass, new ErrorInformation(cl));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleCheckClass(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final it.xsemantics.example.fj.fj.Class cl) 
			throws RuleFailedException {
		
		it.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
		boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_superclass, null);
		if (_operator_notEquals) {
		  {
		    List<it.xsemantics.example.fj.fj.Class> _superclasses = FjAuxiliaryFunctions.getSuperclasses(cl);
		    List<it.xsemantics.example.fj.fj.Class> superClasses = _superclasses;
		    boolean _contains = superClasses.contains(cl);
		    boolean _operator_not = BooleanExtensions.operator_not(_contains);
		    /* !superClasses.contains(cl) */
		    if (!_operator_not) {
		      sneakyThrowRuleFailedException("!superClasses.contains(cl)");
		    }
		    it.xsemantics.example.fj.fj.Class _superclass_1 = cl.getSuperclass();
		    List<Field> _fields = FjAuxiliaryFunctions.getFields(_superclass_1);
		    List<Field> inheritedFields = _fields;
		    final Procedure1<Field> _function = new Procedure1<Field>() {
		        public void apply(final Field inheritedField) {
		          List<Field> _selectFields = FjAuxiliaryFunctions.selectFields(cl);
		          for (final Field field : _selectFields) {
		            String _name = field.getName();
		            String _name_1 = inheritedField.getName();
		            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, _name_1);
		            /* field.name != inheritedField.name */
		            if (!_operator_notEquals) {
		              sneakyThrowRuleFailedException("field.name != inheritedField.name");
		            }
		          }
		        }
		      };
		    IterableExtensions.<Field>forEach(inheritedFields, _function);
		    it.xsemantics.example.fj.fj.Class _superclass_2 = cl.getSuperclass();
		    List<Method> _methods = FjAuxiliaryFunctions.getMethods(_superclass_2);
		    List<Method> inheritedMethods = _methods;
		    final Procedure1<Method> _function_1 = new Procedure1<Method>() {
		        public void apply(final Method inheritedMethod) {
		          List<Method> _selectMethods = FjAuxiliaryFunctions.selectMethods(cl);
		          final Procedure1<Method> _function = new Procedure1<Method>() {
		              public void apply(final Method it) {
		                /* it.name != inheritedMethod.name or { G |- it.type ~~ inheritedMethod.type it.params.size == inheritedMethod.params.size val inheritedMethodParamsIt = inheritedMethod.params.iterator for (param : it.params) { G |- param.type ~~ inheritedMethodParamsIt.next.type } } */
		                try {
		                  String _name = it.getName();
		                  String _name_1 = inheritedMethod.getName();
		                  boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, _name_1);
		                  /* it.name != inheritedMethod.name */
		                  if (!_operator_notEquals) {
		                    sneakyThrowRuleFailedException("it.name != inheritedMethod.name");
		                  }
		                } catch (Exception e) {
		                  {
		                    /* G |- it.type ~~ inheritedMethod.type */
		                    Type _type = it.getType();
		                    Type _type_1 = inheritedMethod.getType();
		                    equalstypeInternal(G, _trace_, _type, _type_1);
		                    EList<Parameter> _params = it.getParams();
		                    int _size = _params.size();
		                    EList<Parameter> _params_1 = inheritedMethod.getParams();
		                    int _size_1 = _params_1.size();
		                    boolean _operator_equals = IntegerExtensions.operator_equals(_size, _size_1);
		                    /* it.params.size == inheritedMethod.params.size */
		                    if (!_operator_equals) {
		                      sneakyThrowRuleFailedException("it.params.size == inheritedMethod.params.size");
		                    }
		                    EList<Parameter> _params_2 = inheritedMethod.getParams();
		                    Iterator<Parameter> _iterator = _params_2.iterator();
		                    final Iterator<Parameter> inheritedMethodParamsIt = _iterator;
		                    EList<Parameter> _params_3 = it.getParams();
		                    for (final Parameter param : _params_3) {
		                      /* G |- param.type ~~ inheritedMethodParamsIt.next.type */
		                      Type _type_2 = param.getType();
		                      Parameter _next = inheritedMethodParamsIt.next();
		                      Type _type_3 = _next.getType();
		                      equalstypeInternal(G, _trace_, _type_2, _type_3);
		                    }
		                  }
		                }
		              }
		            };
		          IterableExtensions.<Method>forEach(_selectMethods, _function);
		        }
		      };
		    IterableExtensions.<Method>forEach(inheritedMethods, _function_1);
		  }
		}
		return new Result<Boolean>(true);
	}
}
