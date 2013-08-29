package it.xsemantics.example.lambda.tests.ui;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.LambdaUiInjectorProvider;
import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.tests.util.LambdaTestsUtil;
import it.xsemantics.example.lambda.ui.internal.LambdaActivator;
import it.xsemantics.example.lambda.ui.typing.LambdaTermModifier;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaUiInjectorProvider.class)
@SuppressWarnings("all")
public class LambdaEditorTest extends AbstractEditorTest {
  private final String TEST_PROJECT = "mytestproject";
  
  @Inject
  private LambdaTermModifier lambdaTermModifier;
  
  protected String getEditorId() {
    return LambdaActivator.IT_XSEMANTICS_EXAMPLE_LAMBDA_LAMBDA;
  }
  
  @Before
  public void setUp() {
    try {
      super.setUp();
      this.createJavaProjectWithXtextNature();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createJavaProjectWithXtextNature() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject(this.TEST_PROJECT);
      final Procedure1<IJavaProject> _function = new Procedure1<IJavaProject>() {
          public void apply(final IJavaProject it) {
            try {
              IProject _project = it.getProject();
              IResourcesSetupUtil.addNature(_project, XtextProjectHelper.NATURE_ID);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      ObjectExtensions.<IJavaProject>operator_doubleArrow(_createJavaProject, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IFile createTestFile(final String contents) {
    try {
      String _plus = (this.TEST_PROJECT + "/src/test.lambda");
      IFile _createFile = IResourcesSetupUtil.createFile(_plus, contents);
      return _createFile;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEntitiesEditor() {
    try {
      IFile _createTestFile = this.createTestFile("lambda x . x");
      this.openEditor(_createTestFile);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLambdaEditorContentsAsModel() {
    XtextEditor _openEditorWithFile = this.openEditorWithFile("lambda x. x");
    Abstraction _abstractionFromEditor = this.abstractionFromEditor(_openEditorWithFile);
    Parameter _param = _abstractionFromEditor.getParam();
    String _name = _param.getName();
    Assert.assertEquals("x", _name);
  }
  
  @Test
  public void testInferAndModifyAbstractionType() throws Exception {
    this.inferAbstractionTypeAndExpect("lambda x. x", "a");
  }
  
  @Test
  public void testInferAndModifyComposeAbstractionType() {
    this.inferAbstractionTypeAndExpect("lambda f . lambda g. lambda x. (f (g x))", "a -> b");
  }
  
  @Test
  public void testInferAndModifyAbstractionWithExplicitType() {
    this.inferAbstractionTypeAndExpect("lambda x : int -> string. x", "a");
  }
  
  @Test
  public void testInferAndModifyNotTypableAbstractionWithType() {
    this.inferAbstractionTypeAndExpect("lambda x : int -> string. x x", "int -> string");
  }
  
  @Test
  public void testInferAndModifyTerm() {
    this.inferTypeAndExpect("lambda f . lambda g. lambda x. (f (g x))", 
      "lambda f : a -> b . lambda g : c -> a. lambda x : c. (f (g x))");
  }
  
  @Test
  public void testInferAndModifyWrongTerm() throws Exception {
    this.inferTypeAndExpect("lambda f . lambda g. lambda x. (f (f f))", 
      "lambda f . lambda g. lambda x. (f (f f))");
  }
  
  private void inferAbstractionTypeAndExpect(final String contents, final String expected) {
    try {
      Abstraction _modifyAbstractionWithInferredType = this.modifyAbstractionWithInferredType(contents);
      Parameter _param = _modifyAbstractionWithInferredType.getParam();
      Type _type = _param.getType();
      String _rep = LambdaTestsUtil.rep(_type);
      Assert.assertEquals(expected, _rep);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void inferTypeAndExpect(final String contents, final String expected) {
    try {
      final IFile file = this.createTestFile(contents);
      final XtextEditor editor = this.openEditor(file);
      this.modifyTermWithInferredType(editor);
      IXtextDocument _document = editor.getDocument();
      String _get = _document.get();
      Assert.assertEquals(expected, _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Abstraction modifyAbstractionWithInferredType(final String contents) throws Exception {
    Abstraction _xblockexpression = null;
    {
      final IFile file = this.createTestFile(contents);
      final XtextEditor editor = this.openEditor(file);
      this.modifyAbstractionWithInferredType(editor);
      Abstraction _abstractionFromEditor = this.abstractionFromEditor(editor);
      _xblockexpression = (_abstractionFromEditor);
    }
    return _xblockexpression;
  }
  
  private XtextEditor openEditorWithFile(final String contents) {
    try {
      IFile _createTestFile = this.createTestFile(contents);
      XtextEditor _openEditor = this.openEditor(_createTestFile);
      return _openEditor;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Abstraction abstractionFromEditor(final XtextEditor editor) {
    IXtextDocument _document = editor.getDocument();
    final IUnitOfWork<Program,XtextResource> _function = new IUnitOfWork<Program,XtextResource>() {
        public Program exec(final XtextResource it) throws Exception {
          EList<EObject> _contents = it.getContents();
          EObject _get = _contents.get(0);
          return ((Program) _get);
        }
      };
    Program _readOnly = _document.<Program>readOnly(_function);
    Term _term = _readOnly.getTerm();
    Abstraction _abstraction = LambdaTestsUtil.getAbstraction(_term);
    return _abstraction;
  }
  
  private void modifyAbstractionWithInferredType(final XtextEditor editor) {
    IXtextDocument _document = editor.getDocument();
    this.modifyAbstractionWithInferredType(_document);
  }
  
  private void modifyAbstractionWithInferredType(final IXtextDocument xtextDocument) {
    this.lambdaTermModifier.modifyAbstractionWithInferredType(xtextDocument);
  }
  
  private void modifyTermWithInferredType(final XtextEditor editor) {
    IXtextDocument _document = editor.getDocument();
    this.lambdaTermModifier.modifyTermWithInferredType(_document);
  }
}
