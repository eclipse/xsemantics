package it.xsemantics.example.fjcached.typing;

import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.typing.FjSepTypeSystem;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.caching.XsemanticsProvider;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * A version of the FJ system where type computation and
 * checking are separated.
 */
@SuppressWarnings("all")
public class FjCachedTypeSystem extends FjSepTypeSystem {
  public final static String SUPERCLASSES = "it.xsemantics.example.fjcached.typing.Superclasses";
  
  public final static String FIELDS = "it.xsemantics.example.fjcached.typing.Fields";
  
  public final static String METHODS = "it.xsemantics.example.fjcached.typing.Methods";
  
  private PolymorphicDispatcher<List<it.xsemantics.example.fj.fj.Class>> superclassesDispatcher;
  
  private PolymorphicDispatcher<List<Field>> fieldsDispatcher;
  
  private PolymorphicDispatcher<List<Method>> methodsDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> equalstypeDispatcher;
  
  public FjCachedTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
    equalstypeDispatcher = buildPolymorphicDispatcher1(
    	"equalstypeImpl", 4, "|-", "~~");
    superclassesDispatcher = buildPolymorphicDispatcher(
    	"superclassesImpl", 2);
    fieldsDispatcher = buildPolymorphicDispatcher(
    	"fieldsImpl", 2);
    methodsDispatcher = buildPolymorphicDispatcher(
    	"methodsImpl", 2);
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
  
  public List<Field> fields(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return fields(null, cl);
  }
  
  public List<Field> fields(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return fieldsInternal(_trace_, cl);
    } catch (Exception _e_fields) {
    	throw extractRuleFailedException(_e_fields);
    }
  }
  
  public List<Method> methods(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return methods(null, cl);
  }
  
  public List<Method> methods(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return methodsInternal(_trace_, cl);
    } catch (Exception _e_methods) {
    	throw extractRuleFailedException(_e_methods);
    }
  }
  
  @Override
  public Result<Type> type(final Expression expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  @Override
  public Result<Type> type(final RuleEnvironment _environment_, final Expression expression) {
    return type(_environment_, null, expression);
  }
  
  @Override
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return typeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  @Override
  public Result<Boolean> subtype(final Type left, final Type right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtype(_environment_, null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }
  
  @Override
  public Boolean subtypeSucceeded(final Type left, final Type right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }
  
  @Override
  public Result<Boolean> equalstype(final Type left, final Type right) {
    return equalstype(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstype(_environment_, null, left, right);
  }
  
  @Override
  public Result<Boolean> equalstype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return equalstypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_equalstype) {
    	return resultForFailure(_e_equalstype);
    }
  }
  
  @Override
  public Boolean equalstypeSucceeded(final Type left, final Type right) {
    return equalstypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return equalstypeSucceeded(_environment_, null, left, right);
  }
  
  @Override
  public Boolean equalstypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	equalstypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_equalstype) {
    	return false;
    }
  }
  
  protected List<it.xsemantics.example.fj.fj.Class> superclassesInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("superclassesInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<it.xsemantics.example.fj.fj.Class>>(null, _trace_) {
    		public List<it.xsemantics.example.fj.fj.Class> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return superclassesDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_superclasses) {
    				sneakyThrowRuleFailedException(_e_superclasses);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void superclassesThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<Field> fieldsInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("fieldsInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<Field>>(null, _trace_) {
    		public List<Field> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return fieldsDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_fields) {
    				sneakyThrowRuleFailedException(_e_fields);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void fieldsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected List<Method> methodsInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("methodsInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<Method>>(null, _trace_) {
    		public List<Method> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return methodsDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_methods) {
    				sneakyThrowRuleFailedException(_e_methods);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void methodsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    return getFromCache("typeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
    		public Result<Type> doGet() {
    			try {
    				checkParamsNotNull(expression);
    				return typeDispatcher.invoke(_environment_, _trace_, expression);
    			} catch (Exception _e_type) {
    				sneakyThrowRuleFailedException(_e_type);
    				return null;
    			}
    		}
    	}, expression);
  }
  
  @Override
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(expression);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  @Override
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    return getFromCache("subtypeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				checkParamsNotNull(left, right);
    				return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    			} catch (Exception _e_subtype) {
    				sneakyThrowRuleFailedException(_e_subtype);
    				return null;
    			}
    		}
    	}, left, right);
  }
  
  @Override
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not a subtype of ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  @Override
  protected Result<Boolean> equalstypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    return getFromCache("equalstypeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				checkParamsNotNull(left, right);
    				return equalstypeDispatcher.invoke(_environment_, _trace_, left, right);
    			} catch (Exception _e_equalstype) {
    				sneakyThrowRuleFailedException(_e_equalstype);
    				return null;
    			}
    		}
    	}, left, right);
  }
  
  @Override
  protected void equalstypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not the same type as ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
}
