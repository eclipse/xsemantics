package it.xsemantics.dsl.tests.input;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XsemanticsTestFiles {
  public CharSequence typeSystemQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system it.xsemantics.test.TypeSystem");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence typeSystemNoQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system TypeSystem");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testFileWithImports() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _typeSystemQualifiedName = this.typeSystemQualifiedName();
    _builder.append(_typeSystemQualifiedName, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.net.*");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptions() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<String> list : java.util.Set<Integer> set");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptions3() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<String> list : java.util.Set<Integer> set : Boolean b");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithDuplicates() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<String> list : java.util.Set<Integer> set");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type ||- List<String> list2 : java.util.Set<Integer> set2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithDuplicateSymbols() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<String> list : java.util.Set<Integer> set");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type2 |- List<String> list : Object o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type3 ||- List<String> list : Object o");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsRelatedToXsemantics() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import it.xsemantics.dsl.xsemantics.Import");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<Import> list : ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("java.util.Set<it.xsemantics.dsl.xsemantics.JudgmentDescription> set");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsReferringToUnknownTypes() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<foo.bar.FooBar> list : it.unknown.MyClass foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsReferringToEcore() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : EObject o");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsReferringToEcoreWithOutput() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : output EObject");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsEObjectEClass() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject c : output EClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithErrorSpecification() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject c : output EClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this \" + c + \" made an error!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("feature c.eClass.eContainingFeature");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject c : output EClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this \" + c + \" made an error!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithCollectionOutput() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : output java.util.List<EStructuralFeature>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsReferringToEcore3() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : EObject o : EStructuralFeature f");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subtype ||- EObject o <: EClass c :> EStructuralFeature f");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsReferringToEcore3WithOutput() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : output EObject : EStructuralFeature f");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type2 ||- EClass c : output EObject : output EStructuralFeature");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subtype ||- output EObject <: EClass c :> EStructuralFeature f");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWith2OutputParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : output EObject : output EStructuralFeature");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWith3OutputParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass c : output EObject : output EStructuralFeature : output String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testJudgmentDescriptionsWithNoInputParam() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- output EClass : output EObject");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithOutputParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object : feat");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithCollectionOutputParam() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsWithCollectionOutput = this.testJudgmentDescriptionsWithCollectionOutput();
    _builder.append(_testJudgmentDescriptionsWithCollectionOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule Features derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : List<EStructuralFeature> features");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : features");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithTwoOutputParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- eClass : object : feat");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithOutputParamsAndExplicitAssignment() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var EObject objectResult");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object = objectResult");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithOutputArgAsLocalVariable() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var EObject objectResult");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : objectResult : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var EObject myObject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myObject = objectResult");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithAssignmentToOutputParam() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var EObject objectResult");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : objectResult : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object = objectResult");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithAssignmentToInputParam() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testJudgmentDescriptionsReferringToEcore3WithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3WithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObjectEStructuralFeature derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass = object.eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSimpleAxiom() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom eClassEObject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSimpleRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \"bar\".toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testDuplicateRuleNames() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom Foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G1 |- EClass o : EClass o2");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testDuplicateCheckRuleNames() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("checkrule Foo for");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject o1");
    _builder.newLine();
    _builder.append("from {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("checkrule Foo for");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass o");
    _builder.newLine();
    _builder.append("from {}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testDuplicateRuleAndCheckRuleNames() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom Foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("checkrule Foo for");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass o");
    _builder.newLine();
    _builder.append("from {}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testDuplicateParamsInRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithExpressionInConclusion() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testJudgmentDescriptionsReferringToEcoreWithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcoreWithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EcoreFactory::eINSTANCE.createEObject()");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testJudgmentDescriptionsReferringToEcoreWithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcoreWithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass _createEObject : EcoreFactory::eINSTANCE.createEObject()");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithBlockExpressionInConclusion() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testJudgmentDescriptionsReferringToEcoreWithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcoreWithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result = EcoreFactory::eINSTANCE.createEClass();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithExpressionInConclusion2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EcoreFactory::eINSTANCE.createEClass() : EObject eObject");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesWithSameEnvironmentNames() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom Foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Foo2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass o : EClass o2");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvokingAnotherRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \"bar\".toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object.eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(eC.name == \'MyEClass2\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name.length < 10");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithFeatureCalls() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() || \'bar\' == new String()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() && \'bar\' == new String()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' != new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\'.contains(\'f\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\'.concat(\'f\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(\'foo\'.contains(\'f\'))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleOnlyInvokingRules() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object.eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testWithEnvironmentAccess() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("env(G, \'this\', EClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("env(G, eClass.name, EClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// env as an expression");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == env(G, eClass.name, EClass).getInstanceClassName()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvokingAnotherRule3() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore3 = this.testJudgmentDescriptionsReferringToEcore3();
    _builder.append(_testJudgmentDescriptionsReferringToEcore3, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object : EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object.eClass : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(feat.name == \'MyEClass\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name.length < 10");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvokingAnotherRuleWith3Params() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testRuleInvokingAnotherRule3 = this.testRuleInvokingAnotherRule3();
    _builder.append(_testRuleInvokingAnotherRule3, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule ESub derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- EObject object <: EClass eClass :> EStructuralFeature feat");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- object <: eClass :> feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object.eClass : feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(feat.name == \'MyEClass\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name.length < 10");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvokingAnotherRuleNotValid() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : object.eClass.name == [ s | s.toFirstLower ].apply(\'foo\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("!(eC.name == \'MyEClass\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name.length < 10");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvocationsWithOperatorsConflictingXbase() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type1 |- EClass c : EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type2 |- EClass c <: EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type3 |- EClass c :> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type4 |- EClass c << EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type5 |- EClass c >> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type6 |- EClass c <| EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type7 |- EClass c ~~ EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type8 |- EClass c |> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type9 |- EClass c --> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type10 |- EClass c <- EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type11 |- EClass c <~ EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type12 |- EClass c ~> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type13 |- EClass c <! EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type14 |- EClass c !> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type15 |- EClass c <<! EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type16 |- EClass c !>> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type17 |- EClass c <~! EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type18 |- EClass c !~> EObject o");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type19 ||- EClass c >> EObject o");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// :: as relation symbol disabled due to ambiguities with xbase static access");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//G |- object.eClass :: eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//G |- (eClass) :: eClass // we need () otherwise interpreted as static access");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//G |- (eClass) :: object.eClass.name == [ s | s.toFirstLower ].apply(\'foo\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass <: eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass :> eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass << eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass >> eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass <| eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass ~~ eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass |> eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) --> (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) <- (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) <~ (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) ~> (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) <! (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) !> (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) <<! (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) !>> (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) <~! (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- (object.eClass) !~> (eClass)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- object.eClass >> eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithoutJudgmentDescription() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testSimpleRule = this.testSimpleRule();
    _builder.append(_testSimpleRule, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule NoJudgmentDescription derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G  ||- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val EClass eC = EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eC.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == eC");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvocationWithoutJudgmentDescription() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule NoJudgmentDescription derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G  |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G ||- eClass : object");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass.name = \'MyEClass\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithConclusionNotSubtype() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// note that only the left parameter raises an error (EObject not <: EClass)");
    _builder.newLine();
    _builder.append("// while the right is acceptable since EClass <: EObject");
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject object : EClass eClass ");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass == object.eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithConclusionNotSubtypeBoth() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testJudgmentDescriptionsReferringToEcoreWithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcoreWithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject object : object.eClass.name");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvocationWithWrongOutputArg() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject object : EClass eClass ");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// this is OK");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// this is NOT: not valid output argument");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object : object.eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvocationWithInputParamPassedAsOutput() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testJudgmentDescriptionsReferringToEcoreWithOutput();
    _builder.append(_testJudgmentDescriptionsReferringToEcoreWithOutput, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule PassInputParamAsOutput derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// can\'t pass eClass input param as output");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesOfTheSameKind() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- Object o1 : Object o2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subtype |- Object o1 <: Object o2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Type1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String s1 : Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Type2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- Boolean b1 : Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom SubType1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String s1 <: Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom SubType2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- Boolean b1 <: Integer i2");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesOfTheSameKindWithSameArgumentTypes() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- Object o1 : Object o2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("subtype |- Object o1 <: Object o2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Type1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String s1 : Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Type2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String b1 : int i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom SubType1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- Object s1 <: Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom SubType2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- Object b1 <: Integer i2");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesOfTheSameKindWithSameInputArgumentTypes() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- Object o1 : output Object");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom Type1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String s1 : Integer i2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// output params do not make two rules different");
    _builder.newLine();
    _builder.append("axiom Type2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- String b1 : String i2");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleWithErrorSpecifications() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this \" + stringRep(object) + \" made an error!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source object.eClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("feature object.eClass.eContainingFeature");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// some expressions from Xbase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' == new String() + \'bar\'.toFirstUpper");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testErrorSpecificationSourceNotEObject() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"Conclusion error\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source object.eClass.name");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testErrorSpecificationFeatureNotEStructuralFeature() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"Conclusion error\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("feature object.eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpression() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass.name == \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass.name == \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass.name == \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpressionWithBlocks() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{eClass.name == \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass.name == \'foo\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{object.eClass.name == \'bar\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpressionWithRuleInvocations() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{eClass.name == \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpressionWithRuleInvocations2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOrExpressionWithManyBranches() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("or");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("object.eClass.name == \'bar\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testEmptyEnvironment() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testEnvironmentComposition() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty, G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testEnvironmentComposition2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty, G, empty, G |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testSingleEnvironmentMapping() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'this\' <- object |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testEnvironmentCompositionWithMapping() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G, \'this\' <- object |- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testEnvironmentMapping2() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testJudgmentDescriptionsReferringToEcore();
    _builder.append(_testJudgmentDescriptionsReferringToEcore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EClassEObject derives");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : EObject object");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G, \'this\' <- object, object <- EcoreFactory::eINSTANCE.createEClass()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|- object.eClass : eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesWithNonEObjectParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EClass e : String s");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom EClassString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass e : String s");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRulesWithOnlyNonEObjectParams() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- List<String> l : String s");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("axiom OnlyNonEObject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- List<String> l : String s");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testCheckRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject object : object.eClass");
    _builder.newLine();
    _builder.newLine();
    _builder.append("checkrule CheckEObject for");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject obj");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var EClass result");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty |- obj : result");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testStringRep() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject c : output EClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this \" + stringRep(c) + \" made an error!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("feature c.eClass.eContainingFeature");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForFail() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty |- obj : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fail");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForFailWithErrorSpecification() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("empty |- obj : eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fail");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this is the error\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source obj");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForClosures() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type |- EClass c");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("useless ||- EStructuralFeature f");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rule TestForClosures");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("G |- EClass eClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// boolean expressions inside closures will not");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// throw exception if they fail");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eClass.EStructuralFeatures.forall [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("it.name != \'foo\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// boolean expressions inside blocks inside closures will still");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// throw exception if they fail");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eClass.EStructuralFeatures.forall [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{ it.name != \'foo\' }");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// rule invocations inside closures will still");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// throw exception if they fail");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eClass.EStructuralFeatures.forall [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("G ||- it");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("eClass.EStructuralFeatures.get(0).name != \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rule Useless");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("G ||- EStructuralFeature feat");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fail");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForScopeOfThisInRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// clone is in the base runtime system");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// it should be visible through this");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("eClass = clone(obj.eClass)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForScopeOfThisInCheckRule() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("checkrule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for EObject obj");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// clone is in the base runtime system");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// it should be visible through this");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val eClass = clone(obj.eClass)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForScopeOfThisInJudgmentDescription() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testFileWithImports = this.testFileWithImports();
    _builder.append(_testFileWithImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("judgments {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type |- EObject c : output EClass");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("error \"this \" + clone(c.eClass) + \" made an error!\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("source clone(c)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("feature clone(c.eClass).eContainingFeature");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testOutputParamFromInputParam() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("axiom EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EClass eClass : eClass");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testVariableDeclarationAsOutputArgument() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- o : var EClass e");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testScopingForVariableDeclarationAsOutputArgument() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- o : var EClass e");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("e.name == \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForBooleanVariableDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var Boolean b");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testForNonBooleanPremises() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var Boolean b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b = false");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (b) { true } else { false }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (oo : o.eContents) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("c.name == \'bar\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testWrongVariableDeclarationAsOutputArgument() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- o : var EClass e = o.eClass");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testWrongVariableDeclarationAsInputArgument() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject o : EClass c");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- var EObject o2 : c");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testRuleInvocationWithOutputArgInsideClosure() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("obj.eClass.EAllStructuralFeatures.forEach [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("G |- obj : eClass // cannot access output arg in closure");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testWrongReturnInPremises() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("obj == obj");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return obj");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence testWrongThrowInPremises() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testJudgmentDescriptionsEObjectEClass();
    _builder.append(_testJudgmentDescriptionsEObjectEClass, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("rule EObjectEClass");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("G |- EObject obj : EClass eClass");
    _builder.newLine();
    _builder.append("from {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("obj == obj");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw new Exception(\'foo\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
