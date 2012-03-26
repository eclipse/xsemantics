package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsRuleGenerator;
import it.xsemantics.dsl.generator.XsemanticsSystemGenerator;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Rule;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsRuleGenerator ruleGenerator;
  
  @Inject
  protected XsemanticsSystemGenerator tsGenerator;
  
  @BeforeClass
  public static void setNewLine() {
    System.setProperty("line.separator", "\n");
  }
  
  public StringBuilderBasedAppendable createAppendable(final Rule rule) {
    ImportManager _createImportManager = this.createImportManager();
    StringBuilderBasedAppendable _createAndConfigureAppendable = this.ruleGenerator.createAndConfigureAppendable(rule, _createImportManager);
    return _createAndConfigureAppendable;
  }
  
  public StringBuilderBasedAppendable createAppendable(final CheckRule rule) {
    ImportManager _createImportManager = this.createImportManager();
    StringBuilderBasedAppendable _createAndConfigureAppendable = this.ruleGenerator.createAndConfigureAppendable(rule, _createImportManager);
    return _createAndConfigureAppendable;
  }
  
  public StringBuilderBasedAppendable createAppendable() {
    ImportManager _createImportManager = this.createImportManager();
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(_createImportManager);
    return _stringBuilderBasedAppendable;
  }
  
  public ImportManager createImportManager() {
    ImportManager _importManager = new ImportManager(true);
    return _importManager;
  }
}
