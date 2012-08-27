package it.xsemantics.example.expressions.tests

import com.google.inject.Inject
import it.xsemantics.example.expressions.expressions.ExpressionsPackage
import it.xsemantics.example.expressions.expressions.Model
import it.xsemantics.example.expressions.typing.ExpressionsSemantics
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProviderCustom))
class ExpressionsValidatorTests extends ExpressionsBaseTests {

	@Inject extension ParseHelper<Model>
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testInt() {
		'''i = 10 - 5 - 1'''.parse.assertNoErrors
	}
	
	@Test
	def void testArithmeticSignedWithString() {
		'''i = -('zzz')'''.parse.
			assertError(
				ExpressionsPackage::eINSTANCE.arithmeticSigned,
				ExpressionsSemantics::ARITHMETICSIGNED
			)
	}
}