package it.xsemantics.dsl.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsXExpressionCompiler;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;

@SuppressWarnings("all")
public class XsemanticsXbaseCompiler {
  @Inject
  protected XsemanticsXExpressionCompiler xbaseCompiler;
  
  public IAppendable compile(final XExpression xExpression, final IAppendable result, final boolean isReferenced) {
    IAppendable _xblockexpression = null;
    {
      this.xbaseCompiler.toJavaStatement(xExpression, result, isReferenced);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void compileAsJavaExpression(final XExpression obj, final IAppendable appendable) {
    this.xbaseCompiler.toJavaExpression(obj, appendable);
  }
}
