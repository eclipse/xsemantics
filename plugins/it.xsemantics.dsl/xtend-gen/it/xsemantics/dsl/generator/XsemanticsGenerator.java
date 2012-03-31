package it.xsemantics.dsl.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.generator.XsemanticsSystemGenerator;
import it.xsemantics.dsl.generator.XsemanticsValidatorGenerator;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class XsemanticsGenerator implements IGenerator {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private Provider<XsemanticsSystemGenerator> systemGeneratorProvider;
  
  @Inject
  private Provider<XsemanticsValidatorGenerator> validatorGeneratorProvider;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    TreeIterator<EObject> _allContents = resource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<XsemanticsSystem> _filter = Iterables.<XsemanticsSystem>filter(_iterable, XsemanticsSystem.class);
    for (final XsemanticsSystem ts : _filter) {
      {
        String _javaClassFile = this._xsemanticsGeneratorExtensions.toJavaClassFile(ts);
        XsemanticsSystemGenerator _get = this.systemGeneratorProvider.get();
        CharSequence _compile = _get.compile(ts);
        fsa.generateFile(_javaClassFile, _compile);
        String _validatorJavaClassFile = this._xsemanticsGeneratorExtensions.toValidatorJavaClassFile(ts);
        XsemanticsValidatorGenerator _get_1 = this.validatorGeneratorProvider.get();
        CharSequence _compile_1 = _get_1.compile(ts);
        fsa.generateFile(_validatorJavaClassFile, _compile_1);
      }
    }
  }
}
