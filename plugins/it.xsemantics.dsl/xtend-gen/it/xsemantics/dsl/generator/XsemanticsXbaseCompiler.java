package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

@SuppressWarnings("all")
public class XsemanticsXbaseCompiler {
  @Inject
  protected XsemanticsXExpressionCompiler xbaseCompiler;
  
  public ITreeAppendable compile(final XExpression xExpression, final ITreeAppendable result, final boolean isReferenced) {
    ITreeAppendable _xblockexpression = null;
    {
      this.xbaseCompiler.toJavaStatement(xExpression, result, isReferenced);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void compileAsJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
    this.xbaseCompiler.toJavaExpression(obj, appendable);
  }
}
