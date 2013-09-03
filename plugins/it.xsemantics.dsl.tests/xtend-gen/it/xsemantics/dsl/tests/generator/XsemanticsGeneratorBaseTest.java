package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsGeneratorBaseTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private JvmModelGenerator jvmModelGenerator;
  
  @Inject
  private JvmModelAssociator associator;
  
  @Inject
  private GeneratorConfigProvider generatorConfigProvider;
  
  public ITreeAppendable createAppendable(final Rule rule) {
    ImportManager _createImportManager = this.createImportManager();
    FakeTreeAppendable _createAndConfigureAppendable = this.createAndConfigureAppendable(rule, _createImportManager);
    return _createAndConfigureAppendable;
  }
  
  public ITreeAppendable createAppendable(final CheckRule rule) {
    TreeAppendable _createJvmModelGeneratorConfiguredAppendable = this.createJvmModelGeneratorConfiguredAppendable(rule);
    return _createJvmModelGeneratorConfiguredAppendable;
  }
  
  public FakeTreeAppendable createAndConfigureAppendable(final Rule rule, final ImportManager importManager) {
    FakeTreeAppendable _xblockexpression = null;
    {
      final FakeTreeAppendable appendable = this.createAppendable();
      this.configureAppendable(rule, appendable);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public void configureAppendable(final Rule rule, final ITreeAppendable appendable) {
    List<RuleParameter> _ruleParams = this._xsemanticsUtils.ruleParams(rule);
    final Procedure1<RuleParameter> _function = new Procedure1<RuleParameter>() {
      public void apply(final RuleParameter it) {
        JvmFormalParameter _parameter = it.getParameter();
        JvmFormalParameter _parameter_1 = it.getParameter();
        String _simpleName = _parameter_1.getSimpleName();
        appendable.declareVariable(_parameter, _simpleName);
      }
    };
    IterableExtensions.<RuleParameter>forEach(_ruleParams, _function);
  }
  
  public TreeAppendable createJvmModelGeneratorConfiguredAppendable(final Rule rule) {
    TreeAppendable _xblockexpression = null;
    {
      final TreeAppendable appendable = this.createJvmModelGeneratorAppendable(rule);
      this.configureAppendable(rule, appendable);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public TreeAppendable createJvmModelGeneratorConfiguredAppendable(final CheckRule rule) {
    TreeAppendable _xblockexpression = null;
    {
      final TreeAppendable appendable = this.createJvmModelGeneratorAppendable(rule);
      RuleParameter _element = rule.getElement();
      JvmFormalParameter _parameter = _element.getParameter();
      RuleParameter _element_1 = rule.getElement();
      JvmFormalParameter _parameter_1 = _element_1.getParameter();
      String _simpleName = _parameter_1.getSimpleName();
      appendable.declareVariable(_parameter, _simpleName);
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public TreeAppendable createJvmModelGeneratorAppendable(final EObject context) {
    TreeAppendable _xblockexpression = null;
    {
      final JvmIdentifiableElement container = this.associator.getNearestLogicalContainer(context);
      ImportManager _createImportManager = this.createImportManager();
      GeneratorConfig _generatorConfig = this.generatorConfig();
      TreeAppendable _createAppendable = this.jvmModelGenerator.createAppendable(container, _createImportManager, _generatorConfig);
      _xblockexpression = (_createAppendable);
    }
    return _xblockexpression;
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
  
  public GeneratorConfig generatorConfig() {
    GeneratorConfig _get = this.generatorConfigProvider.get(null);
    return _get;
  }
}
