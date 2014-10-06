package it.xsemantics.example.maven.test.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import it.xsemantics.example.maven.test.model.MyModel;
import it.xsemantics.example.maven.test.typesystem.MyModelTypeSystem;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class MyExtendedTypeSystem extends MyModelTypeSystem {
  public final static String MYMODELSUBTYPE = "it.xsemantics.example.maven.test.typesystem.MyModelSubtype";
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  public MyExtendedTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
  }
  
  public Result<Boolean> subtype(final MyModel m1, final MyModel m2) {
    return subtype(new RuleEnvironment(), null, m1, m2);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final MyModel m1, final MyModel m2) {
    return subtype(_environment_, null, m1, m2);
  }
  
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final MyModel m1, final MyModel m2) {
    try {
    	return subtypeInternal(_environment_, _trace_, m1, m2);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }
  
  public Boolean subtypeSucceeded(final MyModel m1, final MyModel m2) {
    return subtypeSucceeded(new RuleEnvironment(), null, m1, m2);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final MyModel m1, final MyModel m2) {
    return subtypeSucceeded(_environment_, null, m1, m2);
  }
  
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final MyModel m1, final MyModel m2) {
    try {
    	subtypeInternal(_environment_, _trace_, m1, m2);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }
  
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final MyModel m1, final MyModel m2) {
    try {
    	checkParamsNotNull(m1, m2);
    	return subtypeDispatcher.invoke(_environment_, _trace_, m1, m2);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }
  
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final MyModel m1, final MyModel m2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(m1);
    String _plus = (_stringRep + " is not a subtype of ");
    String _stringRep_1 = this.stringRep(m2);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MyModel m1, final MyModel m2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleMyModelSubtype(G, _subtrace_, m1, m2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("MyModelSubtype") + stringRepForEnv(G) + " |- " + stringRep(m1) + " <: " + stringRep(m2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMyModelSubtype) {
    	subtypeThrowException(ruleName("MyModelSubtype") + stringRepForEnv(G) + " |- " + stringRep(m1) + " <: " + stringRep(m2),
    		MYMODELSUBTYPE,
    		e_applyRuleMyModelSubtype, m1, m2, new ErrorInformation[] {});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleMyModelSubtype(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MyModel m1, final MyModel m2) throws RuleFailedException {
    String _type = m1.getType();
    String _type_1 = m2.getType();
    /* m1.type == m2.type */
    if (!Objects.equal(_type, _type_1)) {
      sneakyThrowRuleFailedException("m1.type == m2.type");
    }
    return new Result<Boolean>(true);
  }
}
