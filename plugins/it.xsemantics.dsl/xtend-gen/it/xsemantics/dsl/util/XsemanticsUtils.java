package it.xsemantics.dsl.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class XsemanticsUtils {
  @Inject
  private XsemanticsTypeSystem _xsemanticsTypeSystem;
  
  @Inject
  private IJvmModelAssociations associations;
  
  public List<JvmTypeReference> getJvmTypes(final XsemanticsSystem ts) {
    List<JvmTypeReference> _allContentsOfType = EcoreUtil2.<JvmTypeReference>getAllContentsOfType(ts, JvmTypeReference.class);
    return _allContentsOfType;
  }
  
  public List<Rule> getRules(final XsemanticsSystem ts) {
    List<Rule> _allContentsOfType = EcoreUtil2.<Rule>getAllContentsOfType(ts, Rule.class);
    return _allContentsOfType;
  }
  
  public List<JvmFormalParameter> getJvmParameters(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    List<JvmFormalParameter> _allContentsOfType = EcoreUtil2.<JvmFormalParameter>getAllContentsOfType(_conclusion, JvmFormalParameter.class);
    return _allContentsOfType;
  }
  
  public List<XVariableDeclaration> getVariableDeclarations(final RuleInvocation ruleInvocation) {
    EList<RuleInvocationExpression> _expressions = ruleInvocation.getExpressions();
    final Function1<RuleInvocationExpression,XExpression> _function = new Function1<RuleInvocationExpression,XExpression>() {
        public XExpression apply(final RuleInvocationExpression it) {
          XExpression _expression = it.getExpression();
          return _expression;
        }
      };
    List<XExpression> _map = ListExtensions.<RuleInvocationExpression, XExpression>map(_expressions, _function);
    List<XVariableDeclaration> _typeSelect = EcoreUtil2.<XVariableDeclaration>typeSelect(_map, XVariableDeclaration.class);
    return _typeSelect;
  }
  
  public List<JvmFormalParameter> getJvmParameters(final JudgmentDescription jd) {
    List<JvmFormalParameter> _allContentsOfType = EcoreUtil2.<JvmFormalParameter>getAllContentsOfType(jd, JvmFormalParameter.class);
    return _allContentsOfType;
  }
  
  public List<RuleInvocation> getRuleInvocations(final EObject element) {
    List<RuleInvocation> _allContentsOfType = EcoreUtil2.<RuleInvocation>getAllContentsOfType(element, RuleInvocation.class);
    return _allContentsOfType;
  }
  
  public List<OrExpression> getOrs(final EObject element) {
    List<OrExpression> _allContentsOfType = EcoreUtil2.<OrExpression>getAllContentsOfType(element, OrExpression.class);
    return _allContentsOfType;
  }
  
  public XsemanticsSystem containingSystem(final EObject element) {
    return EcoreUtil2.<XsemanticsSystem>getContainerOfType(element, XsemanticsSystem.class);
  }
  
  public Rule containingRule(final EObject element) {
    return EcoreUtil2.<Rule>getContainerOfType(element, Rule.class);
  }
  
  public JudgmentDescription containingJudgmentDescription(final EObject element) {
    return EcoreUtil2.<JudgmentDescription>getContainerOfType(element, JudgmentDescription.class);
  }
  
  public List<JudgmentDescription> getJudgmentDescriptions(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    Iterable<JudgmentDescription> _filterJudgmentDescriptions = this.filterJudgmentDescriptions(ts, judgmentSymbol, relationSymbols);
    ArrayList<JudgmentDescription> _newArrayList = Lists.<JudgmentDescription>newArrayList(_filterJudgmentDescriptions);
    return _newArrayList;
  }
  
  public Iterable<JudgmentDescription> filterJudgmentDescriptions(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
    Iterable<JudgmentDescription> _filterJudgmentDescriptions = this.filterJudgmentDescriptions(_judgmentDescriptions, judgmentSymbol, relationSymbols);
    return _filterJudgmentDescriptions;
  }
  
  public Iterable<JudgmentDescription> filterJudgmentDescriptions(final Iterable<JudgmentDescription> desc, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    final Function1<JudgmentDescription,Boolean> _function = new Function1<JudgmentDescription,Boolean>() {
        public Boolean apply(final JudgmentDescription it) {
          boolean _and = false;
          String _judgmentSymbol = it.getJudgmentSymbol();
          boolean _equals = _judgmentSymbol.equals(judgmentSymbol);
          if (!_equals) {
            _and = false;
          } else {
            EList<String> _relationSymbols = it.getRelationSymbols();
            boolean _elementsEqual = IterableExtensions.elementsEqual(_relationSymbols, relationSymbols);
            _and = (_equals && _elementsEqual);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<JudgmentDescription> _filter = IterableExtensions.<JudgmentDescription>filter(desc, _function);
    return _filter;
  }
  
  public JudgmentDescription judgmentDescription(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    String _judgmentSymbol = _conclusion.getJudgmentSymbol();
    RuleConclusion _conclusion_1 = rule.getConclusion();
    EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
    JudgmentDescription _judgmentDescription = this.judgmentDescription(rule, _judgmentSymbol, _relationSymbols);
    return _judgmentDescription;
  }
  
  public JudgmentDescription judgmentDescription(final RuleInvocation ruleInvocation) {
    String _judgmentSymbol = ruleInvocation.getJudgmentSymbol();
    EList<String> _relationSymbols = ruleInvocation.getRelationSymbols();
    JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation, _judgmentSymbol, _relationSymbols);
    return _judgmentDescription;
  }
  
  public JudgmentDescription judgmentDescription(final EObject object, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    JudgmentDescription _xblockexpression = null;
    {
      XsemanticsSystem _containingSystem = this.containingSystem(object);
      Iterable<JudgmentDescription> _allJudgments = this.allJudgments(_containingSystem, judgmentSymbol, relationSymbols);
      final ArrayList<JudgmentDescription> descriptions = Lists.<JudgmentDescription>newArrayList(_allJudgments);
      JudgmentDescription _xifexpression = null;
      int _size = descriptions.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        JudgmentDescription _get = descriptions.get(0);
        _xifexpression = _get;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<Rule> rulesForJudgmentDescription(final JudgmentDescription judgmentDescription) {
    XsemanticsSystem _containingSystem = this.containingSystem(judgmentDescription);
    String _judgmentSymbol = judgmentDescription.getJudgmentSymbol();
    EList<String> _relationSymbols = judgmentDescription.getRelationSymbols();
    Iterable<Rule> _filterRulesByJudgmentDescription = this.filterRulesByJudgmentDescription(_containingSystem, _judgmentSymbol, _relationSymbols);
    ArrayList<Rule> _newArrayList = Lists.<Rule>newArrayList(_filterRulesByJudgmentDescription);
    return _newArrayList;
  }
  
  public Iterable<Rule> filterRulesByJudgmentDescription(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    EList<Rule> _rules = ts.getRules();
    Iterable<Rule> _filterRulesByJudgmentDescription = this.filterRulesByJudgmentDescription(_rules, judgmentSymbol, relationSymbols);
    return _filterRulesByJudgmentDescription;
  }
  
  public Iterable<Rule> filterRulesByJudgmentDescription(final Iterable<Rule> rules, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _and = false;
          RuleConclusion _conclusion = it.getConclusion();
          String _judgmentSymbol = _conclusion.getJudgmentSymbol();
          boolean _equals = _judgmentSymbol.equals(judgmentSymbol);
          if (!_equals) {
            _and = false;
          } else {
            RuleConclusion _conclusion_1 = it.getConclusion();
            EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
            boolean _elementsEqual = IterableExtensions.elementsEqual(_relationSymbols, relationSymbols);
            _and = (_equals && _elementsEqual);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Rule> _filter = IterableExtensions.<Rule>filter(rules, _function);
    return _filter;
  }
  
  public List<Rule> allRulesOfTheSameKind(final Rule rule) {
    XsemanticsSystem _containingSystem = this.containingSystem(rule);
    List<Rule> _allRulesOfTheSameKind = this.allRulesOfTheSameKind(_containingSystem, rule);
    return _allRulesOfTheSameKind;
  }
  
  public List<Rule> allRulesOfTheSameKind(final XsemanticsSystem system, final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    String _judgmentSymbol = _conclusion.getJudgmentSymbol();
    RuleConclusion _conclusion_1 = rule.getConclusion();
    EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
    Iterable<Rule> _allRulesByJudgmentDescription = this.allRulesByJudgmentDescription(system, _judgmentSymbol, _relationSymbols);
    ArrayList<Rule> _newArrayList = Lists.<Rule>newArrayList(_allRulesByJudgmentDescription);
    return _newArrayList;
  }
  
  public boolean isOutputParameter(final JudgmentParameter j) {
    return (j instanceof OutputParameter);
  }
  
  public List<OutputParameter> outputJudgmentParameters(final JudgmentDescription judgmentDescription) {
    EList<JudgmentParameter> _judgmentParameters = judgmentDescription.getJudgmentParameters();
    List<OutputParameter> _typeSelect = EcoreUtil2.<OutputParameter>typeSelect(_judgmentParameters, OutputParameter.class);
    return _typeSelect;
  }
  
  public List<OutputParameter> outputJudgmentParameters(final Rule rule) {
    JudgmentDescription _judgmentDescription = this.judgmentDescription(rule);
    List<OutputParameter> _outputJudgmentParameters = this.outputJudgmentParameters(_judgmentDescription);
    return _outputJudgmentParameters;
  }
  
  public List<RuleConclusionElement> outputConclusionElements(final Rule rule) {
    ArrayList<RuleConclusionElement> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      RuleConclusion _conclusion = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
      final Function1<RuleConclusionElement,Boolean> _function = new Function1<RuleConclusionElement,Boolean>() {
          public Boolean apply(final RuleConclusionElement it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            return Boolean.valueOf(_isOutputParameter);
          }
        };
      Iterable<RuleConclusionElement> _filter = IterableExtensions.<RuleConclusionElement>filter(_conclusionElements, _function);
      ArrayList<RuleConclusionElement> _newArrayList = Lists.<RuleConclusionElement>newArrayList(_filter);
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  public List<OutputParameter> outputParams(final RuleInvocation ruleInvocation) {
    JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation);
    List<OutputParameter> _outputJudgmentParameters = this.outputJudgmentParameters(_judgmentDescription);
    return _outputJudgmentParameters;
  }
  
  public List<InputParameter> inputParams(final JudgmentDescription judgmentDescription) {
    EList<JudgmentParameter> _judgmentParameters = judgmentDescription.getJudgmentParameters();
    List<InputParameter> _typeSelect = EcoreUtil2.<InputParameter>typeSelect(_judgmentParameters, InputParameter.class);
    return _typeSelect;
  }
  
  public List<RuleParameter> inputParams(final Rule rule) {
    List<RuleParameter> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      RuleConclusion _conclusion = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
      final Function1<RuleConclusionElement,Boolean> _function = new Function1<RuleConclusionElement,Boolean>() {
          public Boolean apply(final RuleConclusionElement it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            boolean _not = (!_isOutputParameter);
            return Boolean.valueOf(_not);
          }
        };
      Iterable<RuleConclusionElement> _filter = IterableExtensions.<RuleConclusionElement>filter(_conclusionElements, _function);
      ArrayList<RuleConclusionElement> _newArrayList = Lists.<RuleConclusionElement>newArrayList(_filter);
      List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_newArrayList, RuleParameter.class);
      _xblockexpression = (_typeSelect);
    }
    return _xblockexpression;
  }
  
  public List<RuleParameter> inputEObjectParams(final Rule rule) {
    List<RuleParameter> _inputParams = this.inputParams(rule);
    final Function1<RuleParameter,Boolean> _function = new Function1<RuleParameter,Boolean>() {
        public Boolean apply(final RuleParameter it) {
          JvmFormalParameter _parameter = it.getParameter();
          JvmTypeReference _parameterType = _parameter.getParameterType();
          boolean _isEObject = XsemanticsUtils.this._xsemanticsTypeSystem.isEObject(_parameterType, rule);
          return Boolean.valueOf(_isEObject);
        }
      };
    Iterable<RuleParameter> _filter = IterableExtensions.<RuleParameter>filter(_inputParams, _function);
    ArrayList<RuleParameter> _newArrayList = Lists.<RuleParameter>newArrayList(_filter);
    return _newArrayList;
  }
  
  public boolean isInputParam(final RuleParameter ruleParameter) {
    Rule _containingRule = this.containingRule(ruleParameter);
    List<RuleParameter> _inputParams = this.inputParams(_containingRule);
    boolean _contains = _inputParams.contains(ruleParameter);
    return _contains;
  }
  
  public boolean isInputParam(final JvmFormalParameter jvmFormalParameter) {
    boolean _xblockexpression = false;
    {
      final RuleParameter ruleParameter = EcoreUtil2.<RuleParameter>getContainerOfType(jvmFormalParameter, RuleParameter.class);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(ruleParameter, null));
      if (_notEquals) {
        boolean _isInputParam = this.isInputParam(ruleParameter);
        _xifexpression = _isInputParam;
      } else {
        boolean _xblockexpression_1 = false;
        {
          final EObject sourceElement = this.associations.getPrimarySourceElement(jvmFormalParameter);
          boolean _xifexpression_1 = false;
          if ((sourceElement instanceof RuleParameter)) {
            boolean _isInputParam_1 = this.isInputParam(((RuleParameter) sourceElement));
            _xifexpression_1 = _isInputParam_1;
          } else {
            _xifexpression_1 = false;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<RuleParameter> outputParams(final Rule rule) {
    List<RuleParameter> _xblockexpression = null;
    {
      final JudgmentDescription judgmentDescription = this.judgmentDescription(rule);
      boolean _equals = Objects.equal(judgmentDescription, null);
      if (_equals) {
        return Lists.<RuleParameter>newArrayList();
      }
      EList<JudgmentParameter> _judgmentParameters = judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      RuleConclusion _conclusion = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
      final Function1<RuleConclusionElement,Boolean> _function = new Function1<RuleConclusionElement,Boolean>() {
          public Boolean apply(final RuleConclusionElement it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            return Boolean.valueOf(_isOutputParameter);
          }
        };
      Iterable<RuleConclusionElement> _filter = IterableExtensions.<RuleConclusionElement>filter(_conclusionElements, _function);
      ArrayList<RuleConclusionElement> _newArrayList = Lists.<RuleConclusionElement>newArrayList(_filter);
      List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_newArrayList, RuleParameter.class);
      _xblockexpression = (_typeSelect);
    }
    return _xblockexpression;
  }
  
  public boolean hasOutputParams(final Rule rule) {
    List<RuleParameter> _outputParams = this.outputParams(rule);
    boolean _isEmpty = _outputParams.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
  
  public boolean hasOutputParams(final RuleInvocation ruleInvocation) {
    List<OutputParameter> _outputParams = this.outputParams(ruleInvocation);
    boolean _isEmpty = _outputParams.isEmpty();
    boolean _not = (!_isEmpty);
    return _not;
  }
  
  public <T extends Object> void iterateIfThenElse(final Iterable<T> iterable, final Function1<? super T,? extends Boolean> predicate, final Procedure1<? super T> ifTrue, final Procedure1<? super T> ifFalse) {
    final Procedure1<T> _function = new Procedure1<T>() {
        public void apply(final T it) {
          Boolean _apply = predicate.apply(it);
          if ((_apply).booleanValue()) {
            ifTrue.apply(it);
          } else {
            ifFalse.apply(it);
          }
        }
      };
    IterableExtensions.<T>forEach(iterable, _function);
  }
  
  public List<RuleParameter> ruleParams(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_conclusionElements, RuleParameter.class);
    return _typeSelect;
  }
  
  public List<ExpressionInConclusion> expressionsInConclusion(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    List<ExpressionInConclusion> _allContentsOfType = EcoreUtil2.<ExpressionInConclusion>getAllContentsOfType(_conclusion, ExpressionInConclusion.class);
    return _allContentsOfType;
  }
  
  public List<RuleInvocationExpression> outputArgsExpressions(final RuleInvocation ruleInvocation) {
    ArrayList<RuleInvocationExpression> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      EList<RuleInvocationExpression> _expressions = ruleInvocation.getExpressions();
      final Function1<RuleInvocationExpression,Boolean> _function = new Function1<RuleInvocationExpression,Boolean>() {
          public Boolean apply(final RuleInvocationExpression it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            return Boolean.valueOf(_isOutputParameter);
          }
        };
      Iterable<RuleInvocationExpression> _filter = IterableExtensions.<RuleInvocationExpression>filter(_expressions, _function);
      ArrayList<RuleInvocationExpression> _newArrayList = Lists.<RuleInvocationExpression>newArrayList(_filter);
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  public boolean validOutputArgExpression(final RuleInvocationExpression ruleInvocationExpression) {
    final XExpression xexp = ruleInvocationExpression.getExpression();
    boolean _matched = false;
    if (!_matched) {
      if (xexp instanceof XFeatureCall) {
        final XFeatureCall _xFeatureCall = (XFeatureCall)xexp;
        _matched=true;
        final JvmIdentifiableElement feature = _xFeatureCall.getFeature();
        if ((feature instanceof JvmFormalParameter)) {
          boolean _isInputParam = this.isInputParam(((JvmFormalParameter) feature));
          return (!_isInputParam);
        }
        return true;
      }
    }
    if (!_matched) {
      if (xexp instanceof XVariableDeclaration) {
        final XVariableDeclaration _xVariableDeclaration = (XVariableDeclaration)xexp;
        _matched=true;
        boolean _and = false;
        boolean _isWriteable = _xVariableDeclaration.isWriteable();
        if (!_isWriteable) {
          _and = false;
        } else {
          XExpression _right = _xVariableDeclaration.getRight();
          boolean _equals = Objects.equal(_right, null);
          _and = (_isWriteable && _equals);
        }
        return _and;
      }
    }
    return false;
  }
  
  public boolean validInputArgExpression(final RuleInvocationExpression ruleInvocationExpression) {
    XExpression _expression = ruleInvocationExpression.getExpression();
    return (!(_expression instanceof XVariableDeclaration));
  }
  
  public List<RuleInvocationExpression> inputArgsExpressions(final RuleInvocation ruleInvocation) {
    ArrayList<RuleInvocationExpression> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      final Iterator<JudgmentParameter> judgmentParameters = _judgmentParameters.iterator();
      EList<RuleInvocationExpression> _expressions = ruleInvocation.getExpressions();
      final Function1<RuleInvocationExpression,Boolean> _function = new Function1<RuleInvocationExpression,Boolean>() {
          public Boolean apply(final RuleInvocationExpression it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            boolean _not = (!_isOutputParameter);
            return Boolean.valueOf(_not);
          }
        };
      Iterable<RuleInvocationExpression> _filter = IterableExtensions.<RuleInvocationExpression>filter(_expressions, _function);
      ArrayList<RuleInvocationExpression> _newArrayList = Lists.<RuleInvocationExpression>newArrayList(_filter);
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
  
  public ArrayList<JudgmentDescription> allJudgments(final XsemanticsSystem system) {
    EList<JudgmentDescription> _judgmentDescriptions = system.getJudgmentDescriptions();
    ArrayList<JudgmentDescription> _newArrayList = Lists.<JudgmentDescription>newArrayList(_judgmentDescriptions);
    final Procedure1<ArrayList<JudgmentDescription>> _function = new Procedure1<ArrayList<JudgmentDescription>>() {
        public void apply(final ArrayList<JudgmentDescription> it) {
          ArrayList<XsemanticsSystem> _allSuperSystemDefinitions = XsemanticsUtils.this.allSuperSystemDefinitions(system);
          final Function1<XsemanticsSystem,EList<JudgmentDescription>> _function = new Function1<XsemanticsSystem,EList<JudgmentDescription>>() {
              public EList<JudgmentDescription> apply(final XsemanticsSystem it) {
                EList<JudgmentDescription> _judgmentDescriptions = it.getJudgmentDescriptions();
                return _judgmentDescriptions;
              }
            };
          List<EList<JudgmentDescription>> _map = ListExtensions.<XsemanticsSystem, EList<JudgmentDescription>>map(_allSuperSystemDefinitions, _function);
          Iterable<JudgmentDescription> _flatten = Iterables.<JudgmentDescription>concat(_map);
          Iterables.<JudgmentDescription>addAll(it, _flatten);
        }
      };
    ArrayList<JudgmentDescription> _doubleArrow = ObjectExtensions.<ArrayList<JudgmentDescription>>operator_doubleArrow(_newArrayList, _function);
    return _doubleArrow;
  }
  
  public Iterable<JudgmentDescription> allJudgments(final XsemanticsSystem system, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    ArrayList<JudgmentDescription> _allJudgments = this.allJudgments(system);
    Iterable<JudgmentDescription> _filterJudgmentDescriptions = this.filterJudgmentDescriptions(_allJudgments, judgmentSymbol, relationSymbols);
    return _filterJudgmentDescriptions;
  }
  
  public ArrayList<Rule> allRules(final XsemanticsSystem system) {
    EList<Rule> _rules = system.getRules();
    ArrayList<Rule> _newArrayList = Lists.<Rule>newArrayList(_rules);
    final Procedure1<ArrayList<Rule>> _function = new Procedure1<ArrayList<Rule>>() {
        public void apply(final ArrayList<Rule> it) {
          ArrayList<XsemanticsSystem> _allSuperSystemDefinitions = XsemanticsUtils.this.allSuperSystemDefinitions(system);
          final Function1<XsemanticsSystem,EList<Rule>> _function = new Function1<XsemanticsSystem,EList<Rule>>() {
              public EList<Rule> apply(final XsemanticsSystem it) {
                EList<Rule> _rules = it.getRules();
                return _rules;
              }
            };
          List<EList<Rule>> _map = ListExtensions.<XsemanticsSystem, EList<Rule>>map(_allSuperSystemDefinitions, _function);
          Iterable<Rule> _flatten = Iterables.<Rule>concat(_map);
          Iterables.<Rule>addAll(it, _flatten);
        }
      };
    ArrayList<Rule> _doubleArrow = ObjectExtensions.<ArrayList<Rule>>operator_doubleArrow(_newArrayList, _function);
    return _doubleArrow;
  }
  
  public Iterable<Rule> allRulesByJudgmentDescription(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    ArrayList<Rule> _allRules = this.allRules(ts);
    Iterable<Rule> _filterRulesByJudgmentDescription = this.filterRulesByJudgmentDescription(_allRules, judgmentSymbol, relationSymbols);
    return _filterRulesByJudgmentDescription;
  }
  
  public ArrayList<CheckRule> allCheckRules(final XsemanticsSystem system) {
    EList<CheckRule> _checkrules = system.getCheckrules();
    ArrayList<CheckRule> _newArrayList = Lists.<CheckRule>newArrayList(_checkrules);
    final Procedure1<ArrayList<CheckRule>> _function = new Procedure1<ArrayList<CheckRule>>() {
        public void apply(final ArrayList<CheckRule> it) {
          ArrayList<XsemanticsSystem> _allSuperSystemDefinitions = XsemanticsUtils.this.allSuperSystemDefinitions(system);
          final Function1<XsemanticsSystem,EList<CheckRule>> _function = new Function1<XsemanticsSystem,EList<CheckRule>>() {
              public EList<CheckRule> apply(final XsemanticsSystem it) {
                EList<CheckRule> _checkrules = it.getCheckrules();
                return _checkrules;
              }
            };
          List<EList<CheckRule>> _map = ListExtensions.<XsemanticsSystem, EList<CheckRule>>map(_allSuperSystemDefinitions, _function);
          Iterable<CheckRule> _flatten = Iterables.<CheckRule>concat(_map);
          Iterables.<CheckRule>addAll(it, _flatten);
        }
      };
    ArrayList<CheckRule> _doubleArrow = ObjectExtensions.<ArrayList<CheckRule>>operator_doubleArrow(_newArrayList, _function);
    return _doubleArrow;
  }
  
  public List<JudgmentDescription> superSystemJudgments(final XsemanticsSystem system) {
    XsemanticsSystem _superSystemDefinition = this.superSystemDefinition(system);
    EList<JudgmentDescription> _judgmentDescriptions = _superSystemDefinition==null?(EList<JudgmentDescription>)null:_superSystemDefinition.getJudgmentDescriptions();
    ArrayList<JudgmentDescription> _newArrayList = Lists.<JudgmentDescription>newArrayList();
    List<JudgmentDescription> _elvis = ObjectExtensions.<List<JudgmentDescription>>operator_elvis(_judgmentDescriptions, _newArrayList);
    return _elvis;
  }
  
  public ArrayList<XsemanticsSystem> allSuperSystemDefinitions(final XsemanticsSystem system) {
    HashSet<XsemanticsSystem> _newHashSet = Sets.<XsemanticsSystem>newHashSet();
    ArrayList<XsemanticsSystem> _allSuperSystemDefinitionsInternal = this.allSuperSystemDefinitionsInternal(system, _newHashSet);
    return _allSuperSystemDefinitionsInternal;
  }
  
  protected ArrayList<XsemanticsSystem> allSuperSystemDefinitionsInternal(final XsemanticsSystem system, final Set<XsemanticsSystem> visited) {
    ArrayList<XsemanticsSystem> _xblockexpression = null;
    {
      boolean _contains = visited.contains(system);
      if (_contains) {
        return Lists.<XsemanticsSystem>newArrayList();
      }
      visited.add(system);
      ArrayList<XsemanticsSystem> _newArrayList = Lists.<XsemanticsSystem>newArrayList();
      final Procedure1<ArrayList<XsemanticsSystem>> _function = new Procedure1<ArrayList<XsemanticsSystem>>() {
          public void apply(final ArrayList<XsemanticsSystem> it) {
            final XsemanticsSystem superS = XsemanticsUtils.this.superSystemDefinition(system);
            boolean _notEquals = (!Objects.equal(superS, null));
            if (_notEquals) {
              it.add(superS);
              ArrayList<XsemanticsSystem> _allSuperSystemDefinitionsInternal = XsemanticsUtils.this.allSuperSystemDefinitionsInternal(superS, visited);
              Iterables.<XsemanticsSystem>addAll(it, _allSuperSystemDefinitionsInternal);
            }
          }
        };
      ArrayList<XsemanticsSystem> _doubleArrow = ObjectExtensions.<ArrayList<XsemanticsSystem>>operator_doubleArrow(_newArrayList, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public XsemanticsSystem superSystemDefinition(final XsemanticsSystem system) {
    JvmParameterizedTypeReference _superSystem = system.getSuperSystem();
    XsemanticsSystem _originalSystemDefinition = _superSystem==null?(XsemanticsSystem)null:this.originalSystemDefinition(_superSystem);
    return _originalSystemDefinition;
  }
  
  public XsemanticsSystem originalSystemDefinition(final JvmTypeReference typeReference) {
    JvmType _type = typeReference.getType();
    Set<EObject> _sourceElements = this.associations.getSourceElements(_type);
    Iterable<XsemanticsSystem> _filter = Iterables.<XsemanticsSystem>filter(_sourceElements, XsemanticsSystem.class);
    XsemanticsSystem _head = IterableExtensions.<XsemanticsSystem>head(_filter);
    return _head;
  }
  
  public Rule ruleByName(final Iterable<Rule> rules, final String n) {
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          String _name = it.getName();
          boolean _equals = Objects.equal(_name, n);
          return Boolean.valueOf(_equals);
        }
      };
    Rule _findFirst = IterableExtensions.<Rule>findFirst(rules, _function);
    return _findFirst;
  }
}
