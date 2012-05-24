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
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsRuleGenerator ruleGenerator;
  
  @Inject
  protected XsemanticsSystemGenerator tsGenerator;
  
  public ITreeAppendable createAppendable(final Rule rule) {
    ImportManager _createImportManager = this.createImportManager();
    TreeAppendable _createAndConfigureAppendable = this.ruleGenerator.createAndConfigureAppendable(rule, _createImportManager);
    return _createAndConfigureAppendable;
  }
  
  public ITreeAppendable createAppendable(final CheckRule rule) {
    ImportManager _createImportManager = this.createImportManager();
    TreeAppendable _createAndConfigureAppendable = this.ruleGenerator.createAndConfigureAppendable(rule, _createImportManager);
    return _createAndConfigureAppendable;
  }
  
  public FakeTreeAppendable createAppendable() {
    ImportManager _createImportManager = this.createImportManager();
    FakeTreeAppendable _fakeTreeAppendable = new FakeTreeAppendable(_createImportManager);
    return _fakeTreeAppendable;
  }
  
  public ImportManager createImportManager() {
    ImportManager _importManager = new ImportManager(true);
    return _importManager;
  }
}
