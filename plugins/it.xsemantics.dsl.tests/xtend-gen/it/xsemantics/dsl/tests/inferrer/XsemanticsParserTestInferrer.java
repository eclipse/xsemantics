package it.xsemantics.dsl.tests.inferrer;

import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
import it.xsemantics.dsl.tests.XsemanticsParserTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProviderForInferrer.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsParserTestInferrer extends XsemanticsParserTest {
}
