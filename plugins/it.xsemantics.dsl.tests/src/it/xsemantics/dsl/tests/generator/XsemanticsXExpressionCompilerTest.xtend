package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler
import it.xsemantics.dsl.util.XsemanticsUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsXExpressionCompilerTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsUtils

	@Inject XsemanticsXExpressionCompiler xbaseCompiler
	
	@Test
	def void testRuleInvocation() {
		checkCompilationOfRuleInvocation(
			testFiles.testRuleInvokingAnotherRule, 0,
'''

/* G |- object.eClass : eClass */
EClass _eClass = object.eClass();
typeInternal(G, _trace_, _eClass, eClass);'''
			)
	}
	
	@Test
	def void testRuleInvocation2() {
		checkCompilationOfRuleInvocation(
			testFiles.testRuleInvokingAnotherRule, 1,
'''

/* G |- eClass : object.eClass */
EClass _eClass = object.eClass();
typeInternal(G, _trace_, eClass, _eClass);'''
			)
	}
	
	@Test
	def void testOrExpression() {
		checkCompilationOfOr(
			testFiles.testOrExpression, 0,
'''

/* eClass.name == 'foo' or object.eClass.name == 'bar' */
try {
  String _name = eClass.getName();
  boolean _equals = Objects.equal(_name, "foo");
  /* eClass.name == 'foo' */
  if (!_equals) {
    sneakyThrowRuleFailedException("eClass.name == \'foo\'");
  }
} catch (Exception e) {
  EClass _eClass = object.eClass();
  String _name_1 = _eClass.getName();
  boolean _equals_1 = Objects.equal(_name_1, "bar");
  /* object.eClass.name == 'bar' */
  if (!_equals_1) {
    sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
  }
}'''
			)
	}
	
	@Test
	def void testOrExpression2() {
		checkCompilationOfOr(
			testFiles.testOrExpression2, 0,
'''

/* eClass.name == 'foo' or object.eClass.name == 'bar' */
try {
  String _name = eClass.getName();
  boolean _equals = Objects.equal(_name, "foo");
  /* eClass.name == 'foo' */
  if (!_equals) {
    sneakyThrowRuleFailedException("eClass.name == \'foo\'");
  }
} catch (Exception e) {
  EClass _eClass = object.eClass();
  String _name_1 = _eClass.getName();
  boolean _equals_1 = Objects.equal(_name_1, "bar");
  /* object.eClass.name == 'bar' */
  if (!_equals_1) {
    sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
  }
}'''
			)
	}
	
	@Test
	def void testOrExpressionWithBlocks() {
		checkCompilationOfOr(
			testFiles.testOrExpressionWithBlocks, 0,
'''

/* {eClass.name == 'foo' eClass.name == 'foo'} or {object.eClass.name == 'bar' object.eClass.name == 'bar'} */
try {
  boolean _xblockexpression = false;
  {
    String _name = eClass.getName();
    boolean _equals = Objects.equal(_name, "foo");
    /* eClass.name == 'foo' */
    if (!_equals) {
      sneakyThrowRuleFailedException("eClass.name == \'foo\'");
    }
    String _name_1 = eClass.getName();
    boolean _equals_1 = Objects.equal(_name_1, "foo");
    /* eClass.name == 'foo' */
    if (!_equals_1) {
      sneakyThrowRuleFailedException("eClass.name == \'foo\'");
    }
    _xblockexpression = (_equals_1);
  }
} catch (Exception e) {
  {
    EClass _eClass = object.eClass();
    String _name_2 = _eClass.getName();
    boolean _equals_2 = Objects.equal(_name_2, "bar");
    /* object.eClass.name == 'bar' */
    if (!_equals_2) {
      sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
    }
    EClass _eClass_1 = object.eClass();
    String _name_3 = _eClass_1.getName();
    boolean _equals_3 = Objects.equal(_name_3, "bar");
    /* object.eClass.name == 'bar' */
    if (!_equals_3) {
      sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
    }
  }
}'''
			)
	}
	
	@Test
	def void testOrExpressionWithManyBranches() {
		checkCompilationOfOr(
			testFiles.testOrExpressionWithManyBranches, 0,
'''

/* G |- object.eClass : eClass or G |- object.eClass : eClass or {G |- object.eClass : eClass object.eClass.name == 'bar'} or object.eClass.name == 'bar' */
try {
  /* G |- object.eClass : eClass */
  EClass _eClass = object.eClass();
  typeInternal(G, _trace_, _eClass, eClass);
} catch (Exception e) {
  /* G |- object.eClass : eClass or {G |- object.eClass : eClass object.eClass.name == 'bar'} or object.eClass.name == 'bar' */
  try {
    /* G |- object.eClass : eClass */
    EClass _eClass_1 = object.eClass();
    typeInternal(G, _trace_, _eClass_1, eClass);
  } catch (Exception e_1) {
    /* {G |- object.eClass : eClass object.eClass.name == 'bar'} or object.eClass.name == 'bar' */
    try {
      boolean _xblockexpression = false;
      {
        /* G |- object.eClass : eClass */
        EClass _eClass_2 = object.eClass();
        typeInternal(G, _trace_, _eClass_2, eClass);
        EClass _eClass_3 = object.eClass();
        String _name = _eClass_3.getName();
        boolean _equals = Objects.equal(_name, "bar");
        /* object.eClass.name == 'bar' */
        if (!_equals) {
          sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
        }
        _xblockexpression = (_equals);
      }
    } catch (Exception e_2) {
      EClass _eClass_4 = object.eClass();
      String _name_1 = _eClass_4.getName();
      boolean _equals_1 = Objects.equal(_name_1, "bar");
      /* object.eClass.name == 'bar' */
      if (!_equals_1) {
        sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
      }
    }
  }
}'''
			)
	}
	
	@Test
	def void testRuleInvocationResultVariable() {
		val appendable = createAppendable()
		checkRuleInvocationVariable(
			testFiles.testRuleInvokingAnotherRule, 0, appendable, "result")
		checkRuleInvocationVariable(
			testFiles.testRuleInvokingAnotherRule, 1, appendable, "result_1")
	}
	
	@Test
	def void testFeatureCallExpressions() {
		checkCompilationOfAllPremises(
			testFiles.testRuleWithFeatureCalls,
'''

{
  boolean _or = false;
  String _string = new String();
  boolean _equals = Objects.equal("foo", _string);
  if (_equals) {
    _or = true;
  } else {
    String _string_1 = new String();
    boolean _equals_1 = Objects.equal("bar", _string_1);
    _or = (_equals || _equals_1);
  }
  /* 'foo' == new String() || 'bar' == new String() */
  if (!_or) {
    sneakyThrowRuleFailedException("\'foo\' == new String() || \'bar\' == new String()");
  }
  boolean _and = false;
  String _string_2 = new String();
  boolean _equals_2 = Objects.equal("foo", _string_2);
  if (!_equals_2) {
    _and = false;
  } else {
    String _string_3 = new String();
    boolean _equals_3 = Objects.equal("bar", _string_3);
    _and = (_equals_2 && _equals_3);
  }
  /* 'foo' == new String() && 'bar' == new String() */
  if (!_and) {
    sneakyThrowRuleFailedException("\'foo\' == new String() && \'bar\' == new String()");
  }
  String _string_4 = new String();
  String _firstUpper = StringExtensions.toFirstUpper("bar");
  String _plus = (_string_4 + _firstUpper);
  boolean _equals_4 = Objects.equal("foo", _plus);
  /* 'foo' == new String() + 'bar'.toFirstUpper */
  if (!_equals_4) {
    sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
  }
  String _string_5 = new String();
  String _firstUpper_1 = StringExtensions.toFirstUpper("bar");
  String _plus_1 = (_string_5 + _firstUpper_1);
  boolean _notEquals = (!Objects.equal("foo", _plus_1));
  /* 'foo' != new String() + 'bar'.toFirstUpper */
  if (!_notEquals) {
    sneakyThrowRuleFailedException("\'foo\' != new String() + \'bar\'.toFirstUpper");
  }
  String _string_6 = new String();
  String _firstUpper_2 = StringExtensions.toFirstUpper("bar");
  final String temp = (_string_6 + _firstUpper_2);
  boolean _contains = "foo".contains("f");
  /* 'foo'.contains('f') */
  if (!_contains) {
    sneakyThrowRuleFailedException("\'foo\'.contains(\'f\')");
  }
  "foo".concat("f");
  boolean _contains_1 = "foo".contains("f");
  boolean _not = (!_contains_1);
  /* !('foo'.contains('f')) */
  if (!_not) {
    sneakyThrowRuleFailedException("!(\'foo\'.contains(\'f\'))");
  }
  final EClass eC = EcoreFactory.eINSTANCE.createEClass();
}'''
			)
	}
	
	@Test
	def void testThrowRuleFailedException() {
		val a = createAppendable
		xbaseCompiler.throwNewRuleFailedException(getXAbstractFeatureCall(0), a)
		assertEqualsStrings('''sneakyThrowRuleFailedException("\'foo\' == new String() || \'bar\' == new String()");''', 
			a.toString
		)
	}
	
	@Test
	def void testCompilationOfEnvironmentAccess() {
		checkCompilationOfXExpression(testFiles.testWithEnvironmentAccess, 3,
'''

/* env(G, eClass.name, EClass) */
String _name = eClass.getName();
environmentAccess(G, _name, EClass.class);'''
		)
	}
	
	@Test
	def void testCompilationOfEnvironmentAccessAsExpression() {
		checkCompilationOfXExpression(testFiles.testWithEnvironmentAccess, 4,
'''

/* env(G, eClass.name, EClass) */
String _name = eClass.getName();
EClass _environmentaccess = environmentAccess(G, _name, EClass.class);
String _instanceClassName = _environmentaccess.getInstanceClassName();
Objects.equal("foo", _instanceClassName);'''
		)
	}
	
	@Test
	def void testEmptyEnvironmentSpecification() {
		checkCompilationOfEnvironmentSpecfication(
			testFiles.testEmptyEnvironment,
			"emptyEnvironment()"
		)
	}
	
	@Test
	def void testEnvironmentReference() {
		checkCompilationOfEnvironmentSpecfication(
			testFiles.testRuleOnlyInvokingRules,
			"G"
		)
	}
	
	@Test
	def void testSingleEnvironmentMapping() {
		checkCompilationOfEnvironmentSpecfication(
			testFiles.testSingleEnvironmentMapping,
			'''environmentEntry("this", object)'''
		)
	}
	
	@Test
	def void testEnvironmentComposition() {
		checkCompilationOfEnvironmentSpecfication(
			testFiles.testEnvironmentCompositionWithMapping,
'''
environmentComposition(
  G, environmentEntry("this", object)
)'''
		)
	}
	
	@Test
	def void testRuleInvocationEnvironmentComposition() {
		checkCompilationOfRuleInvocation(
			testFiles.testEnvironmentComposition2, 0,
'''

/* empty, G, empty, G |- object.eClass : eClass */
EClass _eClass = object.eClass();
typeInternal(environmentComposition(
  emptyEnvironment(), environmentComposition(
    G, environmentComposition(
      emptyEnvironment(), G
    )
  )
), _trace_, _eClass, eClass);'''
		)
	}
	
	@Test
	def void testRuleInvocationEnvironmentComposition2() {
		checkCompilationOfRuleInvocation(
			testFiles.testEnvironmentMapping2, 0,
'''

/* G, 'this' <- object, object <- EcoreFactory::eINSTANCE.createEClass() |- object.eClass : eClass */
EClass _eClass = object.eClass();
EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
typeInternal(environmentComposition(
  G, environmentComposition(
    environmentEntry("this", object), environmentEntry(object, _createEClass)
  )
), _trace_, _eClass, eClass);'''
		)
	}
	
	@Test
	def void testForFail() {
		checkCompilationOfAllPremises(
			testFiles.testForFail,
'''

{
  /* empty |- obj : eClass */
  Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, obj);
  checkAssignableTo(result.getFirst(), EClass.class);
  eClass = (EClass) result.getFirst();
  
  /* fail */
  throwForExplicitFail();
}'''
			)
	}
	
	@Test
	def void testForFailWithErrorSpecification() {
		checkCompilationOfAllPremises(
			testFiles.testForFailWithErrorSpecification,
'''

{
  /* empty |- obj : eClass */
  Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, obj);
  checkAssignableTo(result.getFirst(), EClass.class);
  eClass = (EClass) result.getFirst();
  
  /* fail error "this is the error" source obj */
  String error = "this is the error";
  EObject source = obj;
  throwForExplicitFail(error, new ErrorInformation(source, null));
}'''
			)
	}

	@Test
	def void testForClosures() {
		checkCompilationOfAllPremises(
			testFiles.testForClosures,
'''

{
  EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
  final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
      public Boolean apply(final EStructuralFeature it) {
        String _name = it.getName();
        boolean _notEquals = (!Objects.equal(_name, "foo"));
        return Boolean.valueOf(_notEquals);
      }
    };
  boolean _forall = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures, _function);
  /* eClass.EStructuralFeatures.forall [ it.name != 'foo' ] */
  if (!_forall) {
    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.forall [ it.name != \'foo\' ]");
  }
  EList<EStructuralFeature> _eStructuralFeatures_1 = eClass.getEStructuralFeatures();
  final Function1<EStructuralFeature,Boolean> _function_1 = new Function1<EStructuralFeature,Boolean>() {
      public Boolean apply(final EStructuralFeature it) {
        String _name = it.getName();
        boolean _notEquals = (!Objects.equal(_name, "foo"));
        /* it.name != 'foo' */
        if (!Boolean.valueOf(_notEquals)) {
          sneakyThrowRuleFailedException("it.name != \'foo\'");
        }
        return Boolean.valueOf(_notEquals);
      }
    };
  boolean _forall_1 = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures_1, _function_1);
  /* eClass.EStructuralFeatures.forall [ { it.name != 'foo' } ] */
  if (!_forall_1) {
    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.forall [ { it.name != \'foo\' } ]");
  }
  EList<EStructuralFeature> _eStructuralFeatures_2 = eClass.getEStructuralFeatures();
  final Function1<EStructuralFeature,Boolean> _function_2 = new Function1<EStructuralFeature,Boolean>() {
      public Boolean apply(final EStructuralFeature it) {
        /* G ||- it */
        uselessInternal(G, _trace_, it);
        return null;
      }
    };
  boolean _forall_2 = IterableExtensions.<EStructuralFeature>forall(_eStructuralFeatures_2, _function_2);
  /* eClass.EStructuralFeatures.forall [ G ||- it ] */
  if (!_forall_2) {
    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.forall [ G ||- it ]");
  }
  EList<EStructuralFeature> _eStructuralFeatures_3 = eClass.getEStructuralFeatures();
  EStructuralFeature _get = _eStructuralFeatures_3.get(0);
  String _name = _get.getName();
  boolean _notEquals = (!Objects.equal(_name, "foo"));
  /* eClass.EStructuralFeatures.get(0).name != 'foo' */
  if (!Boolean.valueOf(_notEquals)) {
    sneakyThrowRuleFailedException("eClass.EStructuralFeatures.get(0).name != \'foo\'");
  }
}'''
			)
	}
	
	@Test
	def void testForClosureWithExpressionWithNoSideEffect() {
		checkCompilationOfAllPremises(
			testFiles.testForClosureWithExpressionWithNoSideEffect,
'''

EList<EStructuralFeature> _eStructuralFeatures = eClass.getEStructuralFeatures();
final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {
    public void apply(final EStructuralFeature it) {
      String _name = it.getName();
      boolean _notEquals = (!Objects.equal(_name, "foo"));
    }
  };
IterableExtensions.<EStructuralFeature>forEach(_eStructuralFeatures, _function);'''
			)
	}
	
	@Test
	def void testForScopeOfThisInRule() {
		checkCompilationOfAllPremises(
			testFiles.testForScopeOfThisInRule,
'''

EClass _eClass = obj.eClass();
EClass _clone = this.<EClass>clone(_eClass);
eClass = _clone;'''
			)
	}
	
	@Test
	def void testForScopeOfThisInClosure() {
		checkCompilationOfAllPremises(
			testFiles.testForScopeOfThisInClosure,
'''

EList<EStructuralFeature> _eAllStructuralFeatures = eClass.getEAllStructuralFeatures();
final Procedure1<EStructuralFeature> _function = new Procedure1<EStructuralFeature>() {
    public void apply(final EStructuralFeature it) {
      EClass _eClass = obj.eClass();
      final EClass e = TypeSystem.this.<EClass>clone(_eClass);
      InputOutput.<EClass>println(e);
    }
  };
IterableExtensions.<EStructuralFeature>forEach(_eAllStructuralFeatures, _function);'''
			)
	}
	
	@Test
	def void testForScopeOfThisInCheckRule() {
		checkCompilationOfAllPremisesOfCheckRule(
			testFiles.testForScopeOfThisInCheckRule,
'''

EClass _eClass = obj.eClass();
final EClass eClass = this.<EClass>clone(_eClass);'''
			)
	}
	
	@Test
	def void testRuleInvocationWithVarDeclarationAsOutputArg() {
		checkCompilationOfRuleInvocation(
			testFiles.testVariableDeclarationAsOutputArgument, 0,
'''

/* G |- o : var EClass e */
EClass e = null;
Result<EClass> result = typeInternal(G, _trace_, o);
checkAssignableTo(result.getFirst(), EClass.class);
e = (EClass) result.getFirst();
'''
			)
	}
	
	def void checkCompilationOfRuleInvocation(CharSequence inputCode, int index,
		CharSequence expected) {
		val rule = inputCode.firstRule
		val xexp = rule.ruleInvocations.get(index)
		val result = rule.createAppendable
		xbaseCompiler.toJavaStatement(xexp, result, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkCompilationOfOr(CharSequence inputCode, int index,
		CharSequence expected) {
		val rule = inputCode.firstRule
		val xexp = rule.ors.get(index)
		val result = rule.createAppendable
		xbaseCompiler.toJavaStatement(xexp, result, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkRuleInvocationVariable(CharSequence inputCode, int index,
		ITreeAppendable appendable, String expectedVariableName) {
		val xexp = inputCode.
			parseAndAssertNoError.ruleInvocations.get(index)
		val variable = xbaseCompiler.declareResultVariable(xexp, appendable)
		Assert::assertEquals(expectedVariableName, variable)
	}
	
	def void checkCompilationOfAllPremises(CharSequence inputCode, CharSequence expected) {
		val rule = inputCode.firstRule
		val result = rule.createJvmModelGeneratorConfiguredAppendable
		val xexp = rule.rulePremisesAsBlock
		xbaseCompiler.toJavaStatement(xexp, result, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkCompilationOfAllPremisesOfCheckRule(CharSequence inputCode, CharSequence expected) {
		val rule = inputCode.firstCheckRule
		val result = rule.createAppendable
		val xexp = rule.rulePremisesAsBlock
		xbaseCompiler.toJavaStatement(xexp, result, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkCompilationOfXExpression(CharSequence inputCode, int index,
		CharSequence expected) {
		val rule = inputCode.firstRule
		val xexp = rule.rulePremises.get(index)
		val result = rule.createAppendable
		xbaseCompiler.toJavaStatement(xexp, result, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkCompilationOfEnvironmentSpecfication(CharSequence inputCode, CharSequence expected) {
		val rule = inputCode.firstRule
		val xexp = rule.environmentSpecificationOfRuleInvocation
		val result = rule.createAppendable
		xbaseCompiler.generateEnvironmentSpecificationAsExpression(xexp, result)
		assertEqualsStrings(expected, result)
	}

}