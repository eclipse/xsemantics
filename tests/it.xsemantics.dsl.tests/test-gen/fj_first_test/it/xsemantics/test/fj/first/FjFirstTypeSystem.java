/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/
package it.xsemantics.test.fj.first;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.Cast;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Constant;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.example.fj.fj.IntConstant;
import it.xsemantics.example.fj.fj.Member;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.fj.StringConstant;
import it.xsemantics.example.fj.fj.This;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.fj.TypedElement;
import it.xsemantics.example.fj.util.FjTypeUtils;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FjFirstTypeSystem extends XsemanticsRuntimeSystem {
  public final static String SUPERCLASSES = "it.xsemantics.test.fj.first.Superclasses";
  
  public final static String TTYPEDELEMENT = "it.xsemantics.test.fj.first.TTypedElement";
  
  public final static String TTHIS = "it.xsemantics.test.fj.first.TThis";
  
  public final static String TNEW = "it.xsemantics.test.fj.first.TNew";
  
  public final static String TPARAMREF = "it.xsemantics.test.fj.first.TParamRef";
  
  public final static String TSTRINGCONSTANT = "it.xsemantics.test.fj.first.TStringConstant";
  
  public final static String TINTCONSTANT = "it.xsemantics.test.fj.first.TIntConstant";
  
  public final static String TBOOLCONSTANT = "it.xsemantics.test.fj.first.TBoolConstant";
  
  public final static String TSELECTION = "it.xsemantics.test.fj.first.TSelection";
  
  public final static String TCAST = "it.xsemantics.test.fj.first.TCast";
  
  public final static String TEXPRESSIONCLASSTYPE = "it.xsemantics.test.fj.first.TExpressionClassType";
  
  public final static String BASICSUBTYPING = "it.xsemantics.test.fj.first.BasicSubtyping";
  
  public final static String CLASSSUBTYPING = "it.xsemantics.test.fj.first.ClassSubtyping";
  
  public final static String SUBCLASSING = "it.xsemantics.test.fj.first.Subclassing";
  
  public final static String BASICEQUALS = "it.xsemantics.test.fj.first.BasicEquals";
  
  public final static String CLASSEQUALS = "it.xsemantics.test.fj.first.ClassEquals";
  
  public final static String SUBTYPESEQUENCE = "it.xsemantics.test.fj.first.SubtypeSequence";
  
  public final static String FIELDS = "it.xsemantics.test.fj.first.Fields";
  
  public final static String METHODS = "it.xsemantics.test.fj.first.Methods";
  
  public final static String CHECKCONSTANT = "it.xsemantics.test.fj.first.CheckConstant";
  
  public final static String CHECKTYPEDELEMENT = "it.xsemantics.test.fj.first.CheckTypedElement";
  
  public final static String CHECKPARAMREF = "it.xsemantics.test.fj.first.CheckParamRef";
  
  public final static String CHECKTHIS = "it.xsemantics.test.fj.first.CheckThis";
  
  public final static String CHECKMETHOD = "it.xsemantics.test.fj.first.CheckMethod";
  
  public final static String CHECKNEW = "it.xsemantics.test.fj.first.CheckNew";
  
  public final static String CHECKSELECTION = "it.xsemantics.test.fj.first.CheckSelection";
  
  public final static String CHECKCAST = "it.xsemantics.test.fj.first.CheckCast";
  
  public final static String CHECKCLASS = "it.xsemantics.test.fj.first.CheckClass";
  
  @Inject
  private FjTypeUtils fjTypeUtils;
  
  private PolymorphicDispatcher<List<it.xsemantics.example.fj.fj.Class>> superclassesDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<ClassType>> classtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typedeclDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> equalstypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypesequenceDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subclassDispatcher;
  
  private PolymorphicDispatcher<Result<List<Field>>> fieldsDispatcher;
  
  private PolymorphicDispatcher<Result<List<Method>>> methodsDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> checkDispatcher;
  
  public FjFirstTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    classtypeDispatcher = buildPolymorphicDispatcher1(
    	"classtypeImpl", 3, "||~", ":");
    typedeclDispatcher = buildPolymorphicDispatcher1(
    	"typedeclImpl", 3, "||-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
    equalstypeDispatcher = buildPolymorphicDispatcher1(
    	"equalstypeImpl", 4, "|-", "~~");
    subtypesequenceDispatcher = buildPolymorphicDispatcher1(
    	"subtypesequenceImpl", 5, "|-", ":", "<<");
    subclassDispatcher = buildPolymorphicDispatcher1(
    	"subclassImpl", 4, "|-", "<|");
    fieldsDispatcher = buildPolymorphicDispatcher1(
    	"fieldsImpl", 3, "||-", ">>");
    methodsDispatcher = buildPolymorphicDispatcher1(
    	"methodsImpl", 3, "||~", ">>");
    checkDispatcher = buildPolymorphicDispatcher1(
    	"checkImpl", 3, "|-");
    superclassesDispatcher = buildPolymorphicDispatcher(
    	"superclassesImpl", 2);
  }
  
  public FjTypeUtils getFjTypeUtils() {
    return this.fjTypeUtils;
  }
  
  public void setFjTypeUtils(final FjTypeUtils fjTypeUtils) {
    this.fjTypeUtils = fjTypeUtils;
  }
  
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return superclasses(null, cl);
  }
  
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return superclassesInternal(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	throw extractRuleFailedException(_e_superclasses);
    }
  }
  
  public Result<Type> type(final Expression expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final Expression expression) {
    return type(_environment_, null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return typeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<ClassType> classtype(final Expression expression) {
    return classtype(new RuleEnvironment(), null, expression);
  }
  
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final Expression expression) {
    return classtype(_environment_, null, expression);
  }
  
  public Result<ClassType> classtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return classtypeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	return resultForFailure(_e_classtype);
    }
  }
  
  public Result<Type> typedecl(final TypedElement element) {
    return typedecl(new RuleEnvironment(), null, element);
  }
  
  public Result<Type> typedecl(final RuleEnvironment _environment_, final TypedElement element) {
    return typedecl(_environment_, null, element);
  }
  
  public Result<Type> typedecl(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypedElement element) {
    try {
    	return typedeclInternal(_environment_, _trace_, element);
    } catch (Exception _e_typedecl) {
    	return resultForFailure(_e_typedecl);
    }
  }
  
  public Result<Boolean> subtype(final Type left, final Type right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtype(_environment_, null, left, right);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }
  
  public Boolean subtypeSucceeded(final Type left, final Type right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }
  
  public Result<Boolean> equalstype(final Type left, final Type right) {
    return equalstype(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstype(_environment_, null, left, right);
  }
  
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return equalstypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_equalstype) {
    	return resultForFailure(_e_equalstype);
    }
  }
  
  public Boolean equalstypeSucceeded(final Type left, final Type right) {
    return equalstypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	equalstypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_equalstype) {
    	return false;
    }
  }
  
  public Result<Boolean> subtypesequence(final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequence(new RuleEnvironment(), null, owner, expressions, elements);
  }
  
  public Result<Boolean> subtypesequence(final RuleEnvironment _environment_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequence(_environment_, null, owner, expressions, elements);
  }
  
  public Result<Boolean> subtypesequence(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	return subtypesequenceInternal(_environment_, _trace_, owner, expressions, elements);
    } catch (Exception _e_subtypesequence) {
    	return resultForFailure(_e_subtypesequence);
    }
  }
  
  public Boolean subtypesequenceSucceeded(final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequenceSucceeded(new RuleEnvironment(), null, owner, expressions, elements);
  }
  
  public Boolean subtypesequenceSucceeded(final RuleEnvironment _environment_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    return subtypesequenceSucceeded(_environment_, null, owner, expressions, elements);
  }
  
  public Boolean subtypesequenceSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	subtypesequenceInternal(_environment_, _trace_, owner, expressions, elements);
    	return true;
    } catch (Exception _e_subtypesequence) {
    	return false;
    }
  }
  
  public Result<Boolean> subclass(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(new RuleEnvironment(), null, candidate, superclass);
  }
  
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(_environment_, null, candidate, superclass);
  }
  
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	return subclassInternal(_environment_, _trace_, candidate, superclass);
    } catch (Exception _e_subclass) {
    	return resultForFailure(_e_subclass);
    }
  }
  
  public Boolean subclassSucceeded(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(new RuleEnvironment(), null, candidate, superclass);
  }
  
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(_environment_, null, candidate, superclass);
  }
  
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	subclassInternal(_environment_, _trace_, candidate, superclass);
    	return true;
    } catch (Exception _e_subclass) {
    	return false;
    }
  }
  
  public Result<List<Field>> fields(final it.xsemantics.example.fj.fj.Class cl) {
    return fields(new RuleEnvironment(), null, cl);
  }
  
  public Result<List<Field>> fields(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class cl) {
    return fields(_environment_, null, cl);
  }
  
  public Result<List<Field>> fields(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	return fieldsInternal(_environment_, _trace_, cl);
    } catch (Exception _e_fields) {
    	return resultForFailure(_e_fields);
    }
  }
  
  public Result<List<Method>> methods(final it.xsemantics.example.fj.fj.Class cl) {
    return methods(new RuleEnvironment(), null, cl);
  }
  
  public Result<List<Method>> methods(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class cl) {
    return methods(_environment_, null, cl);
  }
  
  public Result<List<Method>> methods(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	return methodsInternal(_environment_, _trace_, cl);
    } catch (Exception _e_methods) {
    	return resultForFailure(_e_methods);
    }
  }
  
  public Result<Boolean> check(final EObject obj) {
    return check(new RuleEnvironment(), null, obj);
  }
  
  public Result<Boolean> check(final RuleEnvironment _environment_, final EObject obj) {
    return check(_environment_, null, obj);
  }
  
  public Result<Boolean> check(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	return checkInternal(_environment_, _trace_, obj);
    } catch (Exception _e_check) {
    	return resultForFailure(_e_check);
    }
  }
  
  public Boolean checkSucceeded(final EObject obj) {
    return checkSucceeded(new RuleEnvironment(), null, obj);
  }
  
  public Boolean checkSucceeded(final RuleEnvironment _environment_, final EObject obj) {
    return checkSucceeded(_environment_, null, obj);
  }
  
  public Boolean checkSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	checkInternal(_environment_, _trace_, obj);
    	return true;
    } catch (Exception _e_check) {
    	return false;
    }
  }
  
  public Result<Boolean> checkMain(final Program program) {
    return checkMain(null, program);
  }
  
  public Result<Boolean> checkMain(final RuleApplicationTrace _trace_, final Program program) {
    try {
    	return checkMainInternal(_trace_, program);
    } catch (Exception _e_CheckMain) {
    	return resultForFailure(_e_CheckMain);
    }
  }
  
  protected Result<Boolean> checkMainInternal(final RuleApplicationTrace _trace_, final Program program) throws RuleFailedException {
    /* program.main == null or empty |- program.main */
    {
      RuleFailedException previousFailure = null;
      try {
        Expression _main = program.getMain();
        boolean _equals = Objects.equal(_main, null);
        /* program.main == null */
        if (!_equals) {
          sneakyThrowRuleFailedException("program.main == null");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* empty |- program.main */
        Expression _main_1 = program.getMain();
        checkInternal(emptyEnvironment(), _trace_, _main_1);
      }
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    return checkClassOk(null, clazz);
  }
  
  public Result<Boolean> checkClassOk(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) {
    try {
    	return checkClassOkInternal(_trace_, clazz);
    } catch (Exception _e_CheckClassOk) {
    	return resultForFailure(_e_CheckClassOk);
    }
  }
  
  protected Result<Boolean> checkClassOkInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    /* empty |- clazz */
    checkInternal(emptyEnvironment(), _trace_, clazz);
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkMethodBody(final Method method) {
    return checkMethodBody(null, method);
  }
  
  public Result<Boolean> checkMethodBody(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodBodyInternal(_trace_, method);
    } catch (Exception _e_CheckMethodBody) {
    	return resultForFailure(_e_CheckMethodBody);
    }
  }
  
  protected Result<Boolean> checkMethodBodyInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkField(final Field field) {
    return checkField(null, field);
  }
  
  public Result<Boolean> checkField(final RuleApplicationTrace _trace_, final Field field) {
    try {
    	return checkFieldInternal(_trace_, field);
    } catch (Exception _e_CheckField) {
    	return resultForFailure(_e_CheckField);
    }
  }
  
  protected Result<Boolean> checkFieldInternal(final RuleApplicationTrace _trace_, final Field field) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkMethodOverride(final Method method) {
    return checkMethodOverride(null, method);
  }
  
  public Result<Boolean> checkMethodOverride(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodOverrideInternal(_trace_, method);
    } catch (Exception _e_CheckMethodOverride) {
    	return resultForFailure(_e_CheckMethodOverride);
    }
  }
  
  protected Result<Boolean> checkMethodOverrideInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    return checkClassHierachyNotCyclic(null, cl);
  }
  
  public Result<Boolean> checkClassHierachyNotCyclic(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	return checkClassHierachyNotCyclicInternal(_trace_, cl);
    } catch (Exception _e_CheckClassHierachyNotCyclic) {
    	return resultForFailure(_e_CheckClassHierachyNotCyclic);
    }
  }
  
  protected Result<Boolean> checkClassHierachyNotCyclicInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> superclassesInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return superclassesDispatcher.invoke(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	sneakyThrowRuleFailedException(_e_superclasses);
    	return null;
    }
  }
  
  protected void superclassesThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return typeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<ClassType> classtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return classtypeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_classtype) {
    	sneakyThrowRuleFailedException(_e_classtype);
    	return null;
    }
  }
  
  protected void classtypeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> typedeclInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypedElement element) {
    try {
    	checkParamsNotNull(element);
    	return typedeclDispatcher.invoke(_environment_, _trace_, element);
    } catch (Exception _e_typedecl) {
    	sneakyThrowRuleFailedException(_e_typedecl);
    	return null;
    }
  }
  
  protected void typedeclThrowException(final String _error, final String _issue, final Exception _ex, final TypedElement element, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }
  
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> equalstypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return equalstypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_equalstype) {
    	sneakyThrowRuleFailedException(_e_equalstype);
    	return null;
    }
  }
  
  protected void equalstypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> subtypesequenceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements) {
    try {
    	checkParamsNotNull(owner, expressions, elements);
    	return subtypesequenceDispatcher.invoke(_environment_, _trace_, owner, expressions, elements);
    } catch (Exception _e_subtypesequence) {
    	sneakyThrowRuleFailedException(_e_subtypesequence);
    	return null;
    }
  }
  
  protected void subtypesequenceThrowException(final String _error, final String _issue, final Exception _ex, final Expression owner, final List<Expression> expressions, final List<? extends TypedElement> elements, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	checkParamsNotNull(candidate, superclass);
    	return subclassDispatcher.invoke(_environment_, _trace_, candidate, superclass);
    } catch (Exception _e_subclass) {
    	sneakyThrowRuleFailedException(_e_subclass);
    	return null;
    }
  }
  
  protected void subclassThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<List<Field>> fieldsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return fieldsDispatcher.invoke(_environment_, _trace_, cl);
    } catch (Exception _e_fields) {
    	sneakyThrowRuleFailedException(_e_fields);
    	return null;
    }
  }
  
  protected void fieldsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<List<Method>> methodsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    try {
    	checkParamsNotNull(cl);
    	return methodsDispatcher.invoke(_environment_, _trace_, cl);
    } catch (Exception _e_methods) {
    	sneakyThrowRuleFailedException(_e_methods);
    	return null;
    }
  }
  
  protected void methodsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> checkInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	checkParamsNotNull(obj);
    	return checkDispatcher.invoke(_environment_, _trace_, obj);
    } catch (Exception _e_check) {
    	sneakyThrowRuleFailedException(_e_check);
    	return null;
    }
  }
  
  protected void checkThrowException(final String _error, final String _issue, final Exception _ex, final EObject obj, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> superclassesImpl(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final List<it.xsemantics.example.fj.fj.Class> _result_ = applyAuxFunSuperclasses(_subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("superclasses") + "(" + stringRep(cl)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunSuperclasses) {
    	superclassesThrowException(auxFunName("superclasses") + "(" + stringRep(cl)+ ")",
    		SUPERCLASSES,
    		e_applyAuxFunSuperclasses, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> applyAuxFunSuperclasses(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return this.<it.xsemantics.example.fj.fj.Class>getAll(cl, 
      FjPackage.eINSTANCE.getClass_Superclass(), 
      FjPackage.eINSTANCE.getClass_Superclass(), 
      it.xsemantics.example.fj.fj.Class.class);
  }
  
  protected Result<Type> typedeclImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTTypedElement(G, _subtrace_, typedElement);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TTypedElement") + stringRepForEnv(G) + " ||- " + stringRep(typedElement) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTTypedElement) {
    	typedeclThrowException(ruleName("TTypedElement") + stringRepForEnv(G) + " ||- " + stringRep(typedElement) + " : " + "Type",
    		TTYPEDELEMENT,
    		e_applyRuleTTypedElement, typedElement, new ErrorInformation[] {new ErrorInformation(typedElement)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTTypedElement(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTTypedElement_1(G, typedElement));
  }
  
  private Type _applyRuleTTypedElement_1(final RuleEnvironment G, final TypedElement typedElement) throws RuleFailedException {
    Type _type = typedElement.getType();
    return _type;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTThis(G, _subtrace_, _this);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTThis) {
    	typeThrowException(ruleName("TThis") + stringRepForEnv(G) + " |- " + stringRep(_this) + " : " + "ClassType",
    		TTHIS,
    		e_applyRuleTThis, _this, new ErrorInformation[] {new ErrorInformation(_this)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTThis(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTThis_1(G, _this));
  }
  
  private ClassType _applyRuleTThis_1(final RuleEnvironment G, final This _this) throws RuleFailedException {
    ClassType _env = this.<ClassType>env(G, "this", ClassType.class);
    return _env;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTNew) {
    	typeThrowException(ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + "ClassType",
    		TNEW,
    		e_applyRuleTNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTNew_1(G, newExp));
  }
  
  private ClassType _applyRuleTNew_1(final RuleEnvironment G, final New newExp) throws RuleFailedException {
    ClassType _type = newExp.getType();
    return _type;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTParamRef(G, _subtrace_, paramref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTParamRef) {
    	typeThrowException(ruleName("TParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref) + " : " + "Type",
    		TPARAMREF,
    		e_applyRuleTParamRef, paramref, new ErrorInformation[] {new ErrorInformation(paramref)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    Type type = null; // output parameter
    /* G ||- paramref.parameter : type */
    Parameter _parameter = paramref.getParameter();
    Result<Type> result = typedeclInternal(G, _trace_, _parameter);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTStringConstant(G, _subtrace_, s);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTStringConstant) {
    	typeThrowException(ruleName("TStringConstant") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + "BasicType",
    		TSTRINGCONSTANT,
    		e_applyRuleTStringConstant, s, new ErrorInformation[] {new ErrorInformation(s)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTStringConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringConstant s) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTStringConstant_1(G, s));
  }
  
  private BasicType _applyRuleTStringConstant_1(final RuleEnvironment G, final StringConstant s) throws RuleFailedException {
    BasicType _xblockexpression = null;
    {
      final BasicType result = FjFactory.eINSTANCE.createBasicType();
      result.setBasic("String");
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTIntConstant(G, _subtrace_, i);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTIntConstant) {
    	typeThrowException(ruleName("TIntConstant") + stringRepForEnv(G) + " |- " + stringRep(i) + " : " + "BasicType",
    		TINTCONSTANT,
    		e_applyRuleTIntConstant, i, new ErrorInformation[] {new ErrorInformation(i)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTIntConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntConstant i) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTIntConstant_1(G, i));
  }
  
  private BasicType _applyRuleTIntConstant_1(final RuleEnvironment G, final IntConstant i) throws RuleFailedException {
    BasicType _createIntType = this.fjTypeUtils.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTBoolConstant(G, _subtrace_, b);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTBoolConstant) {
    	typeThrowException(ruleName("TBoolConstant") + stringRepForEnv(G) + " |- " + stringRep(b) + " : " + "BasicType",
    		TBOOLCONSTANT,
    		e_applyRuleTBoolConstant, b, new ErrorInformation[] {new ErrorInformation(b)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTBoolConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BoolConstant b) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTBoolConstant_1(G, b));
  }
  
  private BasicType _applyRuleTBoolConstant_1(final RuleEnvironment G, final BoolConstant b) throws RuleFailedException {
    final Function1<BasicType, BasicType> _function = new Function1<BasicType, BasicType>() {
      public BasicType apply(final BasicType t) {
        BasicType _xblockexpression = null;
        {
          t.setBasic("boolean");
          _xblockexpression = t;
        }
        return _xblockexpression;
      }
    };
    BasicType _apply = _function.apply(FjFactory.eINSTANCE.createBasicType());
    return _apply;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTSelection(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTSelection) {
    	typeThrowException(ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + "Type",
    		TSELECTION,
    		e_applyRuleTSelection, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    Type type = null; // output parameter
    /* G ||- selection.message : type */
    Member _message = selection.getMessage();
    Result<Type> result = typedeclInternal(G, _trace_, _message);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTCast(G, _subtrace_, cast);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTCast) {
    	typeThrowException(ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + "ClassType",
    		TCAST,
    		e_applyRuleTCast, cast, new ErrorInformation[] {new ErrorInformation(cast)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTCast_1(G, cast));
  }
  
  private ClassType _applyRuleTCast_1(final RuleEnvironment G, final Cast cast) throws RuleFailedException {
    ClassType _type = cast.getType();
    return _type;
  }
  
  protected Result<ClassType> classtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<ClassType> _result_ = applyRuleTExpressionClassType(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TExpressionClassType") + stringRepForEnv(G) + " ||~ " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTExpressionClassType) {
    	classtypeThrowException(ruleName("TExpressionClassType") + stringRepForEnv(G) + " ||~ " + stringRep(expression) + " : " + "ClassType",
    		TEXPRESSIONCLASSTYPE,
    		e_applyRuleTExpressionClassType, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }
  
  protected Result<ClassType> applyRuleTExpressionClassType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression expression) throws RuleFailedException {
    ClassType classType = null; // output parameter
    /* G |- expression : classType */
    Result<Type> result = typeInternal(G, _trace_, expression);
    checkAssignableTo(result.getFirst(), ClassType.class);
    classType = (ClassType) result.getFirst();
    
    return new Result<ClassType>(classType);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleBasicSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BasicSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBasicSubtyping) {
    	subtypeThrowException(ruleName("BasicSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		BASICSUBTYPING,
    		e_applyRuleBasicSubtyping, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    /* left.basic.equals(right.basic) */
    if (!left.getBasic().equals(right.getBasic())) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleClassSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassSubtyping) {
    	subtypeThrowException(ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		CLASSSUBTYPING,
    		e_applyRuleClassSubtyping, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    /* G |- left.classref <| right.classref */
    it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
    it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
    subclassInternal(G, _trace_, _classref, _classref_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subclassImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class class1, final it.xsemantics.example.fj.fj.Class class2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubclassing(G, _subtrace_, class1, class2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Subclassing") + stringRepForEnv(G) + " |- " + stringRep(class1) + " <| " + stringRep(class2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubclassing) {
    	subclassThrowException(ruleName("Subclassing") + stringRepForEnv(G) + " |- " + stringRep(class1) + " <| " + stringRep(class2),
    		SUBCLASSING,
    		e_applyRuleSubclassing, class1, class2, new ErrorInformation[] {new ErrorInformation(class1), new ErrorInformation(class2)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSubclassing(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class class1, final it.xsemantics.example.fj.fj.Class class2) throws RuleFailedException {
    /* class1 == class2 or class2.name == "Object" or { class1.superclass != null G |- class1.superclass <| class2 } */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _equals = Objects.equal(class1, class2);
        /* class1 == class2 */
        if (!_equals) {
          sneakyThrowRuleFailedException("class1 == class2");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* class2.name == "Object" or { class1.superclass != null G |- class1.superclass <| class2 } */
        {
          try {
            String _name = class2.getName();
            boolean _equals_1 = Objects.equal(_name, "Object");
            /* class2.name == "Object" */
            if (!_equals_1) {
              sneakyThrowRuleFailedException("class2.name == \"Object\"");
            }
          } catch (Exception e_1) {
            previousFailure = extractRuleFailedException(e_1);
            it.xsemantics.example.fj.fj.Class _superclass = class1.getSuperclass();
            boolean _notEquals = (!Objects.equal(_superclass, null));
            /* class1.superclass != null */
            if (!_notEquals) {
              sneakyThrowRuleFailedException("class1.superclass != null");
            }
            /* G |- class1.superclass <| class2 */
            it.xsemantics.example.fj.fj.Class _superclass_1 = class1.getSuperclass();
            subclassInternal(G, _trace_, _superclass_1, class2);
          }
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleBasicEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBasicEquals) {
    	equalstypeThrowException(ruleName("BasicEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		BASICEQUALS,
    		e_applyRuleBasicEquals, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleBasicEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BasicType left, final BasicType right) throws RuleFailedException {
    /* left.basic.equals(right.basic) */
    if (!left.getBasic().equals(right.getBasic())) {
      sneakyThrowRuleFailedException("left.basic.equals(right.basic)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalstypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleClassEquals(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassEquals) {
    	equalstypeThrowException(ruleName("ClassEquals") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		CLASSEQUALS,
    		e_applyRuleClassEquals, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleClassEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _classref = left.getClassref();
    it.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
    /* left.classref == right.classref */
    if (!Objects.equal(_classref, _classref_1)) {
      sneakyThrowRuleFailedException("left.classref == right.classref");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypesequenceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubtypeSequence(G, _subtrace_, owner, expressions, typedElements);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " : " + stringRep(expressions) + " << " + stringRep(typedElements);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubtypeSequence) {
    	subtypesequenceThrowException(ruleName("SubtypeSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " : " + stringRep(expressions) + " << " + stringRep(typedElements),
    		SUBTYPESEQUENCE,
    		e_applyRuleSubtypeSequence, owner, expressions, typedElements, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSubtypeSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression owner, final List<Expression> expressions, final List<TypedElement> typedElements) throws RuleFailedException {
    int _size = expressions.size();
    int _size_1 = typedElements.size();
    boolean _equals = (_size == _size_1);
    /* expressions.size == typedElements.size */
    if (!_equals) {
      sneakyThrowRuleFailedException("expressions.size == typedElements.size");
    }
    final Iterator<TypedElement> typedElementsIterator = typedElements.iterator();
    for (final Expression exp : expressions) {
      Type expressionType = null;
      /* G |- exp : expressionType */
      Result<Type> result = typeInternal(G, _trace_, exp);
      checkAssignableTo(result.getFirst(), Type.class);
      expressionType = (Type) result.getFirst();
      
      Type typedElementType = null;
      /* G ||- typedElementsIterator.next : typedElementType */
      TypedElement _next = typedElementsIterator.next();
      Result<Type> result_1 = typedeclInternal(G, _trace_, _next);
      checkAssignableTo(result_1.getFirst(), Type.class);
      typedElementType = (Type) result_1.getFirst();
      
      /* G |- expressionType <: typedElementType */
      subtypeInternal(G, _trace_, expressionType, typedElementType);
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<List<Field>> fieldsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<List<Field>> _result_ = applyRuleFields(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Fields") + stringRepForEnv(G) + " ||- " + stringRep(cl) + " >> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFields) {
    	fieldsThrowException(ruleName("Fields") + stringRepForEnv(G) + " ||- " + stringRep(cl) + " >> " + "List<Field>",
    		FIELDS,
    		e_applyRuleFields, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result<List<Field>> applyRuleFields(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    List<Field> fields = null; // output parameter
    final List<it.xsemantics.example.fj.fj.Class> superclasses = this.superclassesInternal(_trace_, cl);
    Collections.reverse(superclasses);
    fields = CollectionLiterals.<Field>newArrayList();
    for (final it.xsemantics.example.fj.fj.Class superclass : superclasses) {
      List<Field> _typeSelect = EcoreUtil2.<Field>typeSelect(
        superclass.getMembers(), 
        Field.class);
      Iterables.<Field>addAll(fields, _typeSelect);
    }
    /* fields += EcoreUtil2::typeSelect( cl.members, typeof(Field) ) or true */
    {
      RuleFailedException previousFailure = null;
      try {
        List<Field> _typeSelect_1 = EcoreUtil2.<Field>typeSelect(
          cl.getMembers(), 
          Field.class);
        boolean _add = Iterables.<Field>addAll(fields, _typeSelect_1);
        /* fields += EcoreUtil2::typeSelect( cl.members, typeof(Field) ) */
        if (!_add) {
          sneakyThrowRuleFailedException("fields += EcoreUtil2::typeSelect( cl.members, typeof(Field) )");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* true */
      }
    }
    return new Result<List<Field>>(fields);
  }
  
  protected Result<List<Method>> methodsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<List<Method>> _result_ = applyRuleMethods(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Methods") + stringRepForEnv(G) + " ||~ " + stringRep(cl) + " >> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMethods) {
    	methodsThrowException(ruleName("Methods") + stringRepForEnv(G) + " ||~ " + stringRep(cl) + " >> " + "List<Method>",
    		METHODS,
    		e_applyRuleMethods, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result<List<Method>> applyRuleMethods(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    List<Method> methods = null; // output parameter
    final LinkedList<Method> result = new LinkedList<Method>();
    final List<Method> allMethods = this.<Method>getAll(cl, 
      FjPackage.eINSTANCE.getClass_Members(), 
      FjPackage.eINSTANCE.getClass_Superclass(), 
      Method.class);
    final Consumer<Method> _function = new Consumer<Method>() {
      public void accept(final Method method) {
        final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
          public Boolean apply(final Method it) {
            String _name = it.getName();
            String _name_1 = method.getName();
            return Boolean.valueOf(Objects.equal(_name, _name_1));
          }
        };
        boolean _exists = IterableExtensions.<Method>exists(result, _function);
        boolean _not = (!_exists);
        if (_not) {
          result.add(method);
        }
      }
    };
    allMethods.forEach(_function);
    methods = result;
    return new Result<List<Method>>(methods);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Constant _const) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckConstant(G, _subtrace_, _const);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckConstant) {
    	checkThrowException(ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const),
    		CHECKCONSTANT,
    		e_applyRuleCheckConstant, _const, new ErrorInformation[] {new ErrorInformation(_const)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Constant _const) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckTypedElement(G, _subtrace_, typedElement);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckTypedElement) {
    	checkThrowException(ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement),
    		CHECKTYPEDELEMENT,
    		e_applyRuleCheckTypedElement, typedElement, new ErrorInformation[] {new ErrorInformation(typedElement)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckTypedElement(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckParamRef(G, _subtrace_, paramref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckParamRef) {
    	checkThrowException(ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref),
    		CHECKPARAMREF,
    		e_applyRuleCheckParamRef, paramref, new ErrorInformation[] {new ErrorInformation(paramref)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckThis(G, _subtrace_, _this);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckThis) {
    	checkThrowException(ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this),
    		CHECKTHIS,
    		e_applyRuleCheckThis, _this, new ErrorInformation[] {new ErrorInformation(_this)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckThis(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    ClassType _env = this.<ClassType>env(G, "this", ClassType.class);
    /* env(G, 'this', ClassType) != null */
    if (!(!Objects.equal(_env, null))) {
      sneakyThrowRuleFailedException("env(G, \'this\', ClassType) != null");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckMethod(G, _subtrace_, method);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckMethod) {
    	checkThrowException(ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method),
    		CHECKMETHOD,
    		e_applyRuleCheckMethod, method, new ErrorInformation[] {new ErrorInformation(method)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckMethod(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    final ClassType typeForThis = this.fjTypeUtils.createClassType(
      EcoreUtil2.<it.xsemantics.example.fj.fj.Class>getContainerOfType(method, it.xsemantics.example.fj.fj.Class.class));
    Type bodyType = null;
    /* G, 'this' <- typeForThis |- method.body.expression : bodyType */
    Expression _expression = method.getBody().getExpression();
    Result<Type> result = typeInternal(environmentComposition(
      G, environmentEntry("this", typeForThis)
    ), _trace_, _expression);
    checkAssignableTo(result.getFirst(), Type.class);
    bodyType = (Type) result.getFirst();
    
    /* G |- bodyType <: method.type */
    Type _type = method.getType();
    subtypeInternal(G, _trace_, bodyType, _type);
    /* G, 'this' <- typeForThis |- method.body.expression */
    Expression _expression_1 = method.getBody().getExpression();
    checkInternal(environmentComposition(
      G, environmentEntry("this", typeForThis)
    ), _trace_, _expression_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckNew) {
    	checkThrowException(ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp),
    		CHECKNEW,
    		e_applyRuleCheckNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    List<Field> fields = null;
    /* G ||- newExp.type.classref >> fields */
    it.xsemantics.example.fj.fj.Class _classref = newExp.getType().getClassref();
    Result<List<Field>> result = fieldsInternal(G, _trace_, _classref);
    checkAssignableTo(result.getFirst(), List.class);
    fields = (List<Field>) result.getFirst();
    
    /* G |- newExp : newExp.args << fields */
    EList<Expression> _args = newExp.getArgs();
    subtypesequenceInternal(G, _trace_, newExp, _args, fields);
    final Consumer<Expression> _function = new Consumer<Expression>() {
      public void accept(final Expression it) {
        /* G |- it */
        checkInternal(G, _trace_, it);
      }
    };
    newExp.getArgs().forEach(_function);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckSelection(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckSelection) {
    	checkThrowException(ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection),
    		CHECKSELECTION,
    		e_applyRuleCheckSelection, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    /* G |- selection.receiver */
    Expression _receiver = selection.getReceiver();
    checkInternal(G, _trace_, _receiver);
    final Member message = selection.getMessage();
    boolean _matched = false;
    if (message instanceof Method) {
      _matched=true;
      /* G |- selection : selection.args << message.params */
      EList<Expression> _args = selection.getArgs();
      EList<Parameter> _params = ((Method)message).getParams();
      subtypesequenceInternal(G, _trace_, selection, _args, _params);
      EList<Expression> _args_1 = selection.getArgs();
      for (final Expression arg : _args_1) {
        /* G |- arg */
        checkInternal(G, _trace_, arg);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckCast(G, _subtrace_, cast);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckCast) {
    	checkThrowException(ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast),
    		CHECKCAST,
    		e_applyRuleCheckCast, cast, new ErrorInformation[] {new ErrorInformation(cast)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    Type expType = null;
    /* G |- cast.expression : expType */
    Expression _expression = cast.getExpression();
    Result<Type> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), Type.class);
    expType = (Type) result.getFirst();
    
    /* G |- cast.type <: expType or G |- expType <: cast.type */
    {
      RuleFailedException previousFailure = null;
      try {
        /* G |- cast.type <: expType */
        ClassType _type = cast.getType();
        subtypeInternal(G, _trace_, _type, expType);
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* G |- expType <: cast.type */
        ClassType _type_1 = cast.getType();
        subtypeInternal(G, _trace_, expType, _type_1);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckClass(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckClass) {
    	checkThrowException(ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl),
    		CHECKCLASS,
    		e_applyRuleCheckClass, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    it.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
    boolean _notEquals = (!Objects.equal(_superclass, null));
    if (_notEquals) {
      List<it.xsemantics.example.fj.fj.Class> superClasses = null;
      superClasses = this.superclassesInternal(_trace_, cl);
      boolean _contains = superClasses.contains(cl);
      boolean _not = (!_contains);
      /* !superClasses.contains(cl) */
      if (!_not) {
        sneakyThrowRuleFailedException("!superClasses.contains(cl)");
      }
      List<Field> inheritedFields = null;
      /* G ||- cl.superclass >> inheritedFields */
      it.xsemantics.example.fj.fj.Class _superclass_1 = cl.getSuperclass();
      Result<List<Field>> result = fieldsInternal(G, _trace_, _superclass_1);
      checkAssignableTo(result.getFirst(), List.class);
      inheritedFields = (List<Field>) result.getFirst();
      
      final Consumer<Field> _function = new Consumer<Field>() {
        public void accept(final Field inheritedField) {
          List<Field> _typeSelect = EcoreUtil2.<Field>typeSelect(cl.getMembers(), Field.class);
          for (final Field field : _typeSelect) {
            String _name = field.getName();
            String _name_1 = inheritedField.getName();
            /* field.name != inheritedField.name */
            if (!(!Objects.equal(_name, _name_1))) {
              sneakyThrowRuleFailedException("field.name != inheritedField.name");
            }
          }
        }
      };
      inheritedFields.forEach(_function);
      List<Method> inheritedMethods = null;
      /* G ||~ cl.superclass >> inheritedMethods */
      it.xsemantics.example.fj.fj.Class _superclass_2 = cl.getSuperclass();
      Result<List<Method>> result_1 = methodsInternal(G, _trace_, _superclass_2);
      checkAssignableTo(result_1.getFirst(), List.class);
      inheritedMethods = (List<Method>) result_1.getFirst();
      
      final Consumer<Method> _function_1 = new Consumer<Method>() {
        public void accept(final Method inheritedMethod) {
          final Consumer<Method> _function = new Consumer<Method>() {
            public void accept(final Method it) {
              /* it.name != inheritedMethod.name or { G |- it.type ~~ inheritedMethod.type it.params.size == inheritedMethod.params.size val inheritedMethodParamsIt = inheritedMethod.params.iterator for (param : it.params) { G |- param.type ~~ inheritedMethodParamsIt.next.type } } */
              {
                RuleFailedException previousFailure = null;
                try {
                  String _name = it.getName();
                  String _name_1 = inheritedMethod.getName();
                  boolean _notEquals = (!Objects.equal(_name, _name_1));
                  /* it.name != inheritedMethod.name */
                  if (!_notEquals) {
                    sneakyThrowRuleFailedException("it.name != inheritedMethod.name");
                  }
                } catch (Exception e) {
                  previousFailure = extractRuleFailedException(e);
                  /* G |- it.type ~~ inheritedMethod.type */
                  Type _type = it.getType();
                  Type _type_1 = inheritedMethod.getType();
                  equalstypeInternal(G, _trace_, _type, _type_1);
                  int _size = it.getParams().size();
                  int _size_1 = inheritedMethod.getParams().size();
                  boolean _equals = (_size == _size_1);
                  /* it.params.size == inheritedMethod.params.size */
                  if (!_equals) {
                    sneakyThrowRuleFailedException("it.params.size == inheritedMethod.params.size");
                  }
                  final Iterator<Parameter> inheritedMethodParamsIt = inheritedMethod.getParams().iterator();
                  EList<Parameter> _params = it.getParams();
                  for (final Parameter param : _params) {
                    /* G |- param.type ~~ inheritedMethodParamsIt.next.type */
                    Type _type_2 = param.getType();
                    Type _type_3 = inheritedMethodParamsIt.next().getType();
                    equalstypeInternal(G, _trace_, _type_2, _type_3);
                  }
                }
              }
            }
          };
          EcoreUtil2.<Method>typeSelect(cl.getMembers(), Method.class).forEach(_function);
        }
      };
      inheritedMethods.forEach(_function_1);
    }
    return new Result<Boolean>(true);
  }
}
