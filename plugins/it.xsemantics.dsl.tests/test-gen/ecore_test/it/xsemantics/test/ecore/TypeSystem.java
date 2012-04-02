package it.xsemantics.test.ecore;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class TypeSystem extends XsemanticsRuntimeSystem {
	public final static String ECLASSEOBJECT = "it.xsemantics.test.ecore.rules.EClassEObject";

	protected PolymorphicDispatcher<Result<Boolean>> typeDispatcher;

	public TypeSystem() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 4, "|-", ":");
	}

	public Result<Boolean> type(final EClass c, final EObject o) {
		return type(new RuleEnvironment(),
			null, c, o);
	}
	
	public Result<Boolean> type(final RuleEnvironment _environment_,
			final EClass c, final EObject o) {
		return type(_environment_,
			null, c, o);
	}
	
	public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c, final EObject o) {
		try {
			return typeInternal(_environment_, _trace_, c, o);
		} catch (Exception _e_type) {
			return resultForFailure(_e_type);
		}
	}


	protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final EClass c, final EObject o) {
		try {
			checkParamsNotNull(c, o);
			return typeDispatcher.invoke(_environment_, _trace_, c, o);
		} catch (Exception _e_type) {
			sneakyThrowRuleFailedException(_e_type);
			return null;
		}
	}
	
	protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass, final EObject object) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
			addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEClassEObject) {
			throwRuleFailedException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object),
				ECLASSEOBJECT,
				e_applyRuleEClassEObject, new ErrorInformation(eClass), new ErrorInformation(object));
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final EClass eClass, final EObject object) 
			throws RuleFailedException {
		
		{
		  String _string = new String();
		  String _firstUpper = StringExtensions.toFirstUpper("bar");
		  String _operator_plus = StringExtensions.operator_plus(_string, _firstUpper);
		  boolean _operator_equals = ObjectExtensions.operator_equals("foo", _operator_plus);
		  /* 'foo' == new String() + 'bar'.toFirstUpper */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
		  }
		  EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
		  final EClass eC = _createEClass;
		  eC.setName("MyEClass");
		  boolean _operator_equals_1 = ObjectExtensions.operator_equals(eClass, eC);
		  /* eClass == eC */
		  if (!_operator_equals_1) {
		    sneakyThrowRuleFailedException("eClass == eC");
		  }
		}
		return new Result<Boolean>(true);
	}
}
