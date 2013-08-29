package it.xsemantics.dsl.tests.ui.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XsemanticsTestFilesForContentAssist {
  public String inputForJudgmentSymbols() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system my.test.ts.TypeSystem");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type ");
    String _string = _builder.toString();
    return _string;
  }
  
  public String inputForRelationSymbols() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system my.test.ts.TypeSystem");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- Object o ");
    String _string = _builder.toString();
    return _string;
  }
  
  public String inputForInjections() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system my.test.ts.TypeSystem");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inject List<EClass> mylist");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject o : output EClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
  
  public String inputForRuleInvocation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system my.test.ts.TypeSystem");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EClass");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject o : output EClass : output EClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
}
