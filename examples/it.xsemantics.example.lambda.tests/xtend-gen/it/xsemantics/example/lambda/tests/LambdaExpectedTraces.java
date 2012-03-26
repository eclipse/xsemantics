package it.xsemantics.example.lambda.tests;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LambdaExpectedTraces {
  public CharSequence notOccurTypeVariablesInArrowTypeFails() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: a occurs in ((X1 -> X2) -> (X3 -> a))");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: a occurs in (X3 -> a)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: a occurs in a");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: variable.typevarName != other.typevarName");
    return _builder;
  }
  
  public CharSequence unifyTypeVariableOccursInArrowTypeFails() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: UnifyTypeVariableArrowType: [] |- subst{} |> a ~~ ((X1 -> X2) -> (X3 -> a)) ~> ArrowType ~~ ArrowType");
    _builder.newLine();
    _builder.append(" ");
    CharSequence _notOccurTypeVariablesInArrowTypeFails = this.notOccurTypeVariablesInArrowTypeFails();
    _builder.append(_notOccurTypeVariablesInArrowTypeFails, " ");
    return _builder;
  }
  
  public CharSequence arithmeticsFails() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: AbstractionType: [] |- subst{} |> lambda x . (-\'foo\') : ArrowType");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: ArithmeticsType: [x <- X1] |- subst{} |> -\'foo\' : IntType");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: UnifyType: [x <- X1] |- subst{} |> String ~~ int ~> Type ~~ Type");
    return _builder;
  }
  
  public CharSequence omegaFails() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("failed: AbstractionType: [] |- subst{X1=(X2 -> X3)} |> lambda x . ((x x)) : ArrowType");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("failed: ApplicationType: [x <- X1] |- subst{X1=(X2 -> X3)} |> (x x) : Type");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("failed: UnifyTypeVariableArrowType: [x <- X1] |- subst{X1=(X2 -> X3)} |> X2 ~~ (X2 -> X3) ~> ArrowType ~~ ArrowType");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("failed: X2 occurs in (X2 -> X3)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("failed: X2 occurs in X2");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("failed: variable.typevarName != other.typevarName");
    return _builder;
  }
}
