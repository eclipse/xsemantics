package it.xsemantics.example.lambda.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Application;
import it.xsemantics.example.lambda.lambda.Arithmetics;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntConstant;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.LambdaPackage;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.StringConstant;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.lambda.Variable;
import it.xsemantics.example.lambda.services.LambdaGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractLambdaSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected LambdaGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == LambdaPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case LambdaPackage.ABSTRACTION:
				if(context == grammarAccess.getAbstractionRule() ||
				   context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule()) {
					sequence_Abstraction(context, (Abstraction) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.APPLICATION:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule()) {
					sequence_Term(context, (Application) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.ARITHMETICS:
				if(context == grammarAccess.getArithmeticsRule() ||
				   context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule()) {
					sequence_Arithmetics(context, (Arithmetics) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.ARROW_TYPE:
				if(context == grammarAccess.getTerminalTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()) {
					sequence_Type(context, (ArrowType) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.INT_CONSTANT:
				if(context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getIntConstantRule() ||
				   context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule()) {
					sequence_IntConstant(context, (IntConstant) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.INT_TYPE:
				if(context == grammarAccess.getBasicTypeRule() ||
				   context == grammarAccess.getTerminalTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()) {
					sequence_Type(context, (IntType) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.PROGRAM:
				if(context == grammarAccess.getProgramRule()) {
					sequence_Program(context, (Program) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.STRING_CONSTANT:
				if(context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getStringConstantRule() ||
				   context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule()) {
					sequence_StringConstant(context, (StringConstant) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.STRING_TYPE:
				if(context == grammarAccess.getBasicTypeRule() ||
				   context == grammarAccess.getTerminalTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()) {
					sequence_Type(context, (StringType) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.TYPE_VARIABLE:
				if(context == grammarAccess.getTerminalTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getTypeVariableRule() ||
				   context == grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()) {
					sequence_TypeVariable(context, (TypeVariable) semanticObject); 
					return; 
				}
				else break;
			case LambdaPackage.VARIABLE:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTermAccess().getApplicationFunAction_1_0_0() ||
				   context == grammarAccess.getTerminalTermRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (param=Parameter term=Term)
	 */
	protected void sequence_Abstraction(EObject context, Abstraction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.ABSTRACTION__PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.ABSTRACTION__PARAM));
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.ABSTRACTION__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.ABSTRACTION__TERM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbstractionAccess().getParamParameterParserRuleCall_1_0(), semanticObject.getParam());
		feeder.accept(grammarAccess.getAbstractionAccess().getTermTermParserRuleCall_3_0(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     term=Term
	 */
	protected void sequence_Arithmetics(EObject context, Arithmetics semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.ARITHMETICS__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.ARITHMETICS__TERM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArithmeticsAccess().getTermTermParserRuleCall_1_0(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     int=INT
	 */
	protected void sequence_IntConstant(EObject context, IntConstant semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.INT_CONSTANT__INT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.INT_CONSTANT__INT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntConstantAccess().getIntINTTerminalRuleCall_0(), semanticObject.getInt());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=Type?)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     term=Term
	 */
	protected void sequence_Program(EObject context, Program semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.PROGRAM__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.PROGRAM__TERM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProgramAccess().getTermTermParserRuleCall_0(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     string=STRING
	 */
	protected void sequence_StringConstant(EObject context, StringConstant semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.STRING_CONSTANT__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.STRING_CONSTANT__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringConstantAccess().getStringSTRINGTerminalRuleCall_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (fun=Term_Application_1_0_0 arg=TerminalTerm)
	 */
	protected void sequence_Term(EObject context, Application semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.APPLICATION__FUN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.APPLICATION__FUN));
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.APPLICATION__ARG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.APPLICATION__ARG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTermAccess().getApplicationFunAction_1_0_0(), semanticObject.getFun());
		feeder.accept(grammarAccess.getTermAccess().getArgTerminalTermParserRuleCall_1_0_1_0(), semanticObject.getArg());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     typevarName=ID
	 */
	protected void sequence_TypeVariable(EObject context, TypeVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.TYPE_VARIABLE__TYPEVAR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.TYPE_VARIABLE__TYPEVAR_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeVariableAccess().getTypevarNameIDTerminalRuleCall_0(), semanticObject.getTypevarName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Type_ArrowType_1_0 right=Type)
	 */
	protected void sequence_Type(EObject context, ArrowType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.ARROW_TYPE__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.ARROW_TYPE__LEFT));
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.ARROW_TYPE__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.ARROW_TYPE__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getTypeAccess().getRightTypeParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {IntType}
	 */
	protected void sequence_Type(EObject context, IntType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {StringType}
	 */
	protected void sequence_Type(EObject context, StringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=[Parameter|ID]
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LambdaPackage.Literals.VARIABLE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LambdaPackage.Literals.VARIABLE__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAccess().getRefParameterIDTerminalRuleCall_0_1(), semanticObject.getRef());
		feeder.finish();
	}
}
