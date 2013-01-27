package it.xsemantics.dsl.tests.input;

import it.xsemantics.dsl.tests.input.XsemanticsTestFiles;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class FjTypeSystemFiles extends XsemanticsTestFiles {
  public CharSequence fjTypeSystem() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system it.xsemantics.test.Fj");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence fjTypeSystemWithImports() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _fjTypeSystem = this.fjTypeSystem();
    _builder.append(_fjTypeSystem, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import it.xsemantics.example.fj.fj.*");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence fjJudgmentDescriptions() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _fjTypeSystem = this.fjTypeSystem();
    _builder.append(_fjTypeSystem, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import it.xsemantics.example.fj.fj.Expression");
    _builder.newLine();
    _builder.append("import it.xsemantics.example.fj.fj.Type");
    _builder.newLine();
    _builder.append("import it.xsemantics.example.fj.fj.New");
    _builder.newLine();
    _builder.append("import it.xsemantics.example.fj.fj.BasicType");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- Expression expression : output Type");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subtype |- Type left <: Type right");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence fjExpressionTypeRules() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _fjJudgmentDescriptions = this.fjJudgmentDescriptions();
    _builder.append(_fjJudgmentDescriptions, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom TNew");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- New newExp : newExp.type");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule BasicSubtyping");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("derives G |- BasicType left <: BasicType right");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("left.basic.equals(right.basic)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
