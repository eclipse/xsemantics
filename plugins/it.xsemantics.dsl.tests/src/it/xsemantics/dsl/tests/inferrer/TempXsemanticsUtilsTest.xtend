package it.xsemantics.dsl.tests.inferrer

import it.xsemantics.dsl.tests.XsemanticsUtilsTest
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer

@InjectWith(typeof(XsemanticsInjectorProviderForInferrer))
@RunWith(typeof(XtextRunner))
class TempXsemanticsUtilsTest extends XsemanticsUtilsTest {
	
}