package it.xsemantics.dsl.util;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsSubtyping;
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
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class XsemanticsUtils {
  @Inject
  private XsemanticsSubtyping _xsemanticsSubtyping;
  
  public List<JvmTypeReference> getJvmTypes(final XsemanticsSystem ts) {
    List<JvmTypeReference> _allContentsOfType = EcoreUtil2.<JvmTypeReference>getAllContentsOfType(ts, org.eclipse.xtext.common.types.JvmTypeReference.class);
    return _allContentsOfType;
  }
  
  public List<Rule> getRules(final XsemanticsSystem ts) {
    List<Rule> _allContentsOfType = EcoreUtil2.<Rule>getAllContentsOfType(ts, it.xsemantics.dsl.xsemantics.Rule.class);
    return _allContentsOfType;
  }
  
  public List<JvmFormalParameter> getJvmParameters(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    List<JvmFormalParameter> _allContentsOfType = EcoreUtil2.<JvmFormalParameter>getAllContentsOfType(_conclusion, org.eclipse.xtext.common.types.JvmFormalParameter.class);
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
    List<XVariableDeclaration> _typeSelect = EcoreUtil2.<XVariableDeclaration>typeSelect(_map, org.eclipse.xtext.xbase.XVariableDeclaration.class);
    return _typeSelect;
  }
  
  public List<JvmFormalParameter> getJvmParameters(final JudgmentDescription jd) {
    List<JvmFormalParameter> _allContentsOfType = EcoreUtil2.<JvmFormalParameter>getAllContentsOfType(jd, org.eclipse.xtext.common.types.JvmFormalParameter.class);
    return _allContentsOfType;
  }
  
  public List<RuleInvocation> getRuleInvocations(final EObject element) {
    List<RuleInvocation> _allContentsOfType = EcoreUtil2.<RuleInvocation>getAllContentsOfType(element, it.xsemantics.dsl.xsemantics.RuleInvocation.class);
    return _allContentsOfType;
  }
  
  public List<OrExpression> getOrs(final EObject element) {
    List<OrExpression> _allContentsOfType = EcoreUtil2.<OrExpression>getAllContentsOfType(element, it.xsemantics.dsl.xsemantics.OrExpression.class);
    return _allContentsOfType;
  }
  
  public XsemanticsSystem containingTypeSystem(final EObject element) {
    XsemanticsSystem _containerOfType = EcoreUtil2.<XsemanticsSystem>getContainerOfType(element, it.xsemantics.dsl.xsemantics.XsemanticsSystem.class);
    return _containerOfType;
  }
  
  public Rule containingRule(final EObject element) {
    Rule _containerOfType = EcoreUtil2.<Rule>getContainerOfType(element, it.xsemantics.dsl.xsemantics.Rule.class);
    return _containerOfType;
  }
  
  public List<JudgmentDescription> getJudgmentDescriptions(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    Iterable<JudgmentDescription> _filterJudgmentDescriptions = this.filterJudgmentDescriptions(ts, judgmentSymbol, relationSymbols);
    ArrayList<JudgmentDescription> _newArrayList = Lists.<JudgmentDescription>newArrayList(_filterJudgmentDescriptions);
    return _newArrayList;
  }
  
  public Iterable<JudgmentDescription> filterJudgmentDescriptions(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    EList<JudgmentDescription> _judgmentDescriptions = ts.getJudgmentDescriptions();
    final Function1<JudgmentDescription,Boolean> _function = new Function1<JudgmentDescription,Boolean>() {
        public Boolean apply(final JudgmentDescription it) {
          boolean _operator_and = false;
          String _judgmentSymbol = it.getJudgmentSymbol();
          boolean _equals = _judgmentSymbol.equals(judgmentSymbol);
          if (!_equals) {
            _operator_and = false;
          } else {
            EList<String> _relationSymbols = it.getRelationSymbols();
            boolean _elementsEqual = IterableExtensions.elementsEqual(_relationSymbols, relationSymbols);
            _operator_and = BooleanExtensions.operator_and(_equals, _elementsEqual);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    Iterable<JudgmentDescription> _filter = IterableExtensions.<JudgmentDescription>filter(_judgmentDescriptions, _function);
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
      XsemanticsSystem _containingTypeSystem = this.containingTypeSystem(object);
      List<JudgmentDescription> _judgmentDescriptions = this.getJudgmentDescriptions(_containingTypeSystem, judgmentSymbol, relationSymbols);
      final List<JudgmentDescription> descriptions = _judgmentDescriptions;
      JudgmentDescription _xifexpression = null;
      int _size = descriptions.size();
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_size, 0);
      if (_operator_greaterThan) {
        JudgmentDescription _get = descriptions.get(0);
        _xifexpression = _get;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<Rule> rulesForJudgmentDescription(final JudgmentDescription judgmentDescription) {
    XsemanticsSystem _containingTypeSystem = this.containingTypeSystem(judgmentDescription);
    String _judgmentSymbol = judgmentDescription.getJudgmentSymbol();
    EList<String> _relationSymbols = judgmentDescription.getRelationSymbols();
    Iterable<Rule> _filterRulesByJudgmentDescription = this.filterRulesByJudgmentDescription(_containingTypeSystem, _judgmentSymbol, _relationSymbols);
    ArrayList<Rule> _newArrayList = Lists.<Rule>newArrayList(_filterRulesByJudgmentDescription);
    return _newArrayList;
  }
  
  public Iterable<Rule> filterRulesByJudgmentDescription(final XsemanticsSystem ts, final String judgmentSymbol, final Iterable<String> relationSymbols) {
    EList<Rule> _rules = ts.getRules();
    final Function1<Rule,Boolean> _function = new Function1<Rule,Boolean>() {
        public Boolean apply(final Rule it) {
          boolean _operator_and = false;
          RuleConclusion _conclusion = it.getConclusion();
          String _judgmentSymbol = _conclusion.getJudgmentSymbol();
          boolean _equals = _judgmentSymbol.equals(judgmentSymbol);
          if (!_equals) {
            _operator_and = false;
          } else {
            RuleConclusion _conclusion_1 = it.getConclusion();
            EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
            boolean _elementsEqual = IterableExtensions.elementsEqual(_relationSymbols, relationSymbols);
            _operator_and = BooleanExtensions.operator_and(_equals, _elementsEqual);
          }
          return Boolean.valueOf(_operator_and);
        }
      };
    Iterable<Rule> _filter = IterableExtensions.<Rule>filter(_rules, _function);
    return _filter;
  }
  
  public List<Rule> getRulesOfTheSameKind(final Rule rule) {
    XsemanticsSystem _containingTypeSystem = this.containingTypeSystem(rule);
    RuleConclusion _conclusion = rule.getConclusion();
    String _judgmentSymbol = _conclusion.getJudgmentSymbol();
    RuleConclusion _conclusion_1 = rule.getConclusion();
    EList<String> _relationSymbols = _conclusion_1.getRelationSymbols();
    Iterable<Rule> _filterRulesByJudgmentDescription = this.filterRulesByJudgmentDescription(_containingTypeSystem, _judgmentSymbol, _relationSymbols);
    ArrayList<Rule> _newArrayList = Lists.<Rule>newArrayList(_filterRulesByJudgmentDescription);
    return _newArrayList;
  }
  
  public boolean isOutputParameter(final JudgmentParameter j) {
    return (j instanceof OutputParameter);
  }
  
  public List<OutputParameter> outputJudgmentParameters(final JudgmentDescription judgmentDescription) {
    EList<JudgmentParameter> _judgmentParameters = judgmentDescription.getJudgmentParameters();
    List<OutputParameter> _typeSelect = EcoreUtil2.<OutputParameter>typeSelect(_judgmentParameters, it.xsemantics.dsl.xsemantics.OutputParameter.class);
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
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
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
    List<InputParameter> _typeSelect = EcoreUtil2.<InputParameter>typeSelect(_judgmentParameters, it.xsemantics.dsl.xsemantics.InputParameter.class);
    return _typeSelect;
  }
  
  public List<RuleParameter> inputParams(final Rule rule) {
    List<RuleParameter> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
      RuleConclusion _conclusion = rule.getConclusion();
      EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
      final Function1<RuleConclusionElement,Boolean> _function = new Function1<RuleConclusionElement,Boolean>() {
          public Boolean apply(final RuleConclusionElement it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            boolean _operator_not = BooleanExtensions.operator_not(_isOutputParameter);
            return Boolean.valueOf(_operator_not);
          }
        };
      Iterable<RuleConclusionElement> _filter = IterableExtensions.<RuleConclusionElement>filter(_conclusionElements, _function);
      ArrayList<RuleConclusionElement> _newArrayList = Lists.<RuleConclusionElement>newArrayList(_filter);
      List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_newArrayList, it.xsemantics.dsl.xsemantics.RuleParameter.class);
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
          boolean _isEObject = XsemanticsUtils.this._xsemanticsSubtyping.isEObject(_parameterType, rule);
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
      RuleParameter _containerOfType = EcoreUtil2.<RuleParameter>getContainerOfType(jvmFormalParameter, it.xsemantics.dsl.xsemantics.RuleParameter.class);
      final RuleParameter ruleParameter = _containerOfType;
      boolean _xifexpression = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(ruleParameter, null);
      if (_operator_notEquals) {
        boolean _isInputParam = this.isInputParam(ruleParameter);
        _xifexpression = _isInputParam;
      } else {
        _xifexpression = false;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<RuleParameter> outputParams(final Rule rule) {
    List<RuleParameter> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(rule);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
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
      List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_newArrayList, it.xsemantics.dsl.xsemantics.RuleParameter.class);
      _xblockexpression = (_typeSelect);
    }
    return _xblockexpression;
  }
  
  public boolean hasOutputParams(final Rule rule) {
    List<RuleParameter> _outputParams = this.outputParams(rule);
    boolean _isEmpty = _outputParams.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    return _operator_not;
  }
  
  public boolean hasOutputParams(final RuleInvocation ruleInvocation) {
    List<OutputParameter> _outputParams = this.outputParams(ruleInvocation);
    boolean _isEmpty = _outputParams.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    return _operator_not;
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
    List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_conclusionElements, it.xsemantics.dsl.xsemantics.RuleParameter.class);
    return _typeSelect;
  }
  
  public List<ExpressionInConclusion> expressionsInConclusion(final Rule rule) {
    RuleConclusion _conclusion = rule.getConclusion();
    List<ExpressionInConclusion> _allContentsOfType = EcoreUtil2.<ExpressionInConclusion>getAllContentsOfType(_conclusion, it.xsemantics.dsl.xsemantics.ExpressionInConclusion.class);
    return _allContentsOfType;
  }
  
  public List<RuleInvocationExpression> outputArgsExpressions(final RuleInvocation ruleInvocation) {
    ArrayList<RuleInvocationExpression> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
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
      XExpression _expression = ruleInvocationExpression.getExpression();
      final XExpression xexp = _expression;
      boolean matched = false;
      if (!matched) {
        if (xexp instanceof XFeatureCall) {
          final XFeatureCall _xFeatureCall = (XFeatureCall)xexp;
          matched=true;
          {
            JvmIdentifiableElement _feature = _xFeatureCall.getFeature();
            final JvmIdentifiableElement feature = _feature;
            if ((feature instanceof JvmFormalParameter)) {
              boolean _isInputParam = this.isInputParam(((JvmFormalParameter) feature));
              boolean _operator_not = BooleanExtensions.operator_not(_isInputParam);
              return _operator_not;
            }
            return true;
          }
        }
      }
      if (!matched) {
        if (xexp instanceof XVariableDeclaration) {
          final XVariableDeclaration _xVariableDeclaration = (XVariableDeclaration)xexp;
          matched=true;
          boolean _operator_and = false;
          boolean _isWriteable = _xVariableDeclaration.isWriteable();
          if (!_isWriteable) {
            _operator_and = false;
          } else {
            XExpression _right = _xVariableDeclaration.getRight();
            boolean _operator_equals = ObjectExtensions.operator_equals(_right, null);
            _operator_and = BooleanExtensions.operator_and(_isWriteable, _operator_equals);
          }
          return _operator_and;
        }
      }
      return false;
  }
  
  public boolean validInputArgExpression(final RuleInvocationExpression ruleInvocationExpression) {
    XExpression _expression = ruleInvocationExpression.getExpression();
    boolean _operator_not = BooleanExtensions.operator_not((_expression instanceof XVariableDeclaration));
    return _operator_not;
  }
  
  public List<RuleInvocationExpression> inputArgsExpressions(final RuleInvocation ruleInvocation) {
    ArrayList<RuleInvocationExpression> _xblockexpression = null;
    {
      JudgmentDescription _judgmentDescription = this.judgmentDescription(ruleInvocation);
      EList<JudgmentParameter> _judgmentParameters = _judgmentDescription.getJudgmentParameters();
      Iterator<JudgmentParameter> _iterator = _judgmentParameters.iterator();
      final Iterator<JudgmentParameter> judgmentParameters = _iterator;
      EList<RuleInvocationExpression> _expressions = ruleInvocation.getExpressions();
      final Function1<RuleInvocationExpression,Boolean> _function = new Function1<RuleInvocationExpression,Boolean>() {
          public Boolean apply(final RuleInvocationExpression it) {
            JudgmentParameter _next = judgmentParameters.next();
            boolean _isOutputParameter = XsemanticsUtils.this.isOutputParameter(_next);
            boolean _operator_not = BooleanExtensions.operator_not(_isOutputParameter);
            return Boolean.valueOf(_operator_not);
          }
        };
      Iterable<RuleInvocationExpression> _filter = IterableExtensions.<RuleInvocationExpression>filter(_expressions, _function);
      ArrayList<RuleInvocationExpression> _newArrayList = Lists.<RuleInvocationExpression>newArrayList(_filter);
      _xblockexpression = (_newArrayList);
    }
    return _xblockexpression;
  }
}
