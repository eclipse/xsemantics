package it.xsemantics.test.orexpressions.ecore;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

public class TypeSystem extends XsemanticsRuntimeSystem {
	public final static String ECLASSEOBJECT = "it.xsemantics.test.orexpressions.ecore.rules.EClassEObject";
	public final static String ECLASSEOBJECT2 = "it.xsemantics.test.orexpressions.ecore.rules.EClassEObject2";

	protected PolymorphicDispatcher<Result<EObject>> typeDispatcher;
	
	protected PolymorphicDispatcher<Result<EObject>> type2Dispatcher;

	public TypeSystem() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 3, "|-", ":");
		type2Dispatcher = buildPolymorphicDispatcher1(
			"type2Impl", 3, "||-", ":");
	}

	public Result<EObject> type(final EClass c) {
		return type(new RuleEnvironment(),
			null, c);
	}
	
	public Result<EObject> type(final RuleEnvironment _environment_,
			final EClass c) {
		return type(_environment_,
			null, c);
	}
	
	public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			return typeInternal(_environment_, _trace_, c);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<EObject> type2(final EClass c) {
		return type2(new RuleEnvironment(),
			null, c);
	}
	
	public Result<EObject> type2(final RuleEnvironment _environment_,
			final EClass c) {
		return type2(_environment_,
			null, c);
	}
	
	public Result<EObject> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			return type2Internal(_environment_, _trace_, c);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}


	protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			checkParamsNotNull(c);
			return typeDispatcher.invoke(_environment_, _trace_, c);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<EObject> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c) {
		try {
			checkParamsNotNull(c);
			return type2Dispatcher.invoke(_environment_, _trace_, c);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<EObject> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<EObject> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass);
			addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEClassEObject) {
			throwRuleFailedException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject",
				ECLASSEOBJECT,
				e_applyRuleEClassEObject, new ErrorInformation(eClass));
			return null;
		}
	}
	
	protected Result<EObject> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		EObject object = null;
		
		/* eClass.name == 'foo' or object.eClass.name == 'bar' */
		try {
		  String _name = eClass.getName();
		  boolean _operator_equals = ObjectExtensions.operator_equals(_name, "foo");
		  /* eClass.name == 'foo' */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("eClass.name == \'foo\'");
		  }
		} catch (Exception e) {
		  EClass _eClass = object.eClass();
		  String _name_1 = _eClass.getName();
		  boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "bar");
		  /* object.eClass.name == 'bar' */
		  if (!_operator_equals_1) {
		    sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
		  }
		}
		return new Result<EObject>(object);
	}
	
	protected Result<EObject> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<EObject> _result_ = applyRuleEClassEObject2(G, _subtrace_, eClass);
			addToTrace(_trace_, ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEClassEObject2) {
			throwRuleFailedException(ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + "EObject",
				ECLASSEOBJECT2,
				e_applyRuleEClassEObject2, new ErrorInformation(eClass));
			return null;
		}
	}
	
	protected Result<EObject> applyRuleEClassEObject2(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass) 
			throws RuleFailedException {
		EObject object = null;
		
		/* eClass.name == 'foo' or object.eClass.name == 'bar' or { val foo = 'foo' object.eClass.name == 'bar2' eClass.name == foo } */
		try {
		  String _name = eClass.getName();
		  boolean _operator_equals = ObjectExtensions.operator_equals(_name, "foo");
		  /* eClass.name == 'foo' */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("eClass.name == \'foo\'");
		  }
		} catch (Exception e) {
		  /* object.eClass.name == 'bar' or { val foo = 'foo' object.eClass.name == 'bar2' eClass.name == foo } */
		  try {
		    EClass _eClass = object.eClass();
		    String _name_1 = _eClass.getName();
		    boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name_1, "bar");
		    /* object.eClass.name == 'bar' */
		    if (!_operator_equals_1) {
		      sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
		    }
		  } catch (Exception e_1) {
		    {
		      final String foo = "foo";
		      EClass _eClass_1 = object.eClass();
		      String _name_2 = _eClass_1.getName();
		      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_2, "bar2");
		      /* object.eClass.name == 'bar2' */
		      if (!_operator_equals_2) {
		        sneakyThrowRuleFailedException("object.eClass.name == \'bar2\'");
		      }
		      String _name_3 = eClass.getName();
		      boolean _operator_equals_3 = ObjectExtensions.operator_equals(_name_3, foo);
		      /* eClass.name == foo */
		      if (!_operator_equals_3) {
		        sneakyThrowRuleFailedException("eClass.name == foo");
		      }
		    }
		  }
		}
		return new Result<EObject>(object);
	}
}
