package it.xsemantics.example.fj.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.Cast;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.example.fj.fj.IntConstant;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.MethodBody;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.fj.StringConstant;
import it.xsemantics.example.fj.fj.This;
import it.xsemantics.example.fj.services.FJGrammarAccess;
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
public class AbstractFJSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected FJGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == FjPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FjPackage.BASIC_TYPE:
				if(context == grammarAccess.getBasicTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_BasicType(context, (BasicType) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.BOOL_CONSTANT:
				if(context == grammarAccess.getBoolConstantRule() ||
				   context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_BoolConstant(context, (BoolConstant) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.CAST:
				if(context == grammarAccess.getCastRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_Cast(context, (Cast) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.CLASS:
				if(context == grammarAccess.getClassRule()) {
					sequence_Class(context, (it.xsemantics.example.fj.fj.Class) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.CLASS_TYPE:
				if(context == grammarAccess.getClassTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_ClassType(context, (ClassType) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.FIELD:
				if(context == grammarAccess.getFieldRule() ||
				   context == grammarAccess.getMemberRule() ||
				   context == grammarAccess.getTypedElementRule()) {
					sequence_Field(context, (Field) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.INT_CONSTANT:
				if(context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getIntConstantRule() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_IntConstant(context, (IntConstant) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.METHOD:
				if(context == grammarAccess.getMemberRule() ||
				   context == grammarAccess.getMethodRule() ||
				   context == grammarAccess.getTypedElementRule()) {
					sequence_Method(context, (Method) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.METHOD_BODY:
				if(context == grammarAccess.getMethodBodyRule()) {
					sequence_MethodBody(context, (MethodBody) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.NEW:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getNewRule() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_New(context, (New) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.PARAM_REF:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParamRefRule() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_ParamRef(context, (ParamRef) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule() ||
				   context == grammarAccess.getTypedElementRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.PROGRAM:
				if(context == grammarAccess.getProgramRule()) {
					sequence_Program(context, (Program) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.SELECTION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_Expression(context, (Selection) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.STRING_CONSTANT:
				if(context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getStringConstantRule() ||
				   context == grammarAccess.getTerminalExpressionRule()) {
					sequence_StringConstant(context, (StringConstant) semanticObject); 
					return; 
				}
				else break;
			case FjPackage.THIS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0() ||
				   context == grammarAccess.getParenRule() ||
				   context == grammarAccess.getTerminalExpressionRule() ||
				   context == grammarAccess.getThisRule()) {
					sequence_This(context, (This) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (basic='int' | basic='boolean' | basic='String')
	 */
	protected void sequence_BasicType(EObject context, BasicType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constant='true' | constant='false')
	 */
	protected void sequence_BoolConstant(EObject context, BoolConstant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=ClassType expression=TerminalExpression)
	 */
	protected void sequence_Cast(EObject context, Cast semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.CAST__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.CAST__TYPE));
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.CAST__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.CAST__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCastAccess().getTypeClassTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getCastAccess().getExpressionTerminalExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     classref=[Class|ID]
	 */
	protected void sequence_ClassType(EObject context, ClassType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.CLASS_TYPE__CLASSREF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.CLASS_TYPE__CLASSREF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassTypeAccess().getClassrefClassIDTerminalRuleCall_0_1(), semanticObject.getClassref());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID superclass=[Class|ID]? members+=Member*)
	 */
	protected void sequence_Class(EObject context, it.xsemantics.example.fj.fj.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (receiver=Expression_Selection_1_0_0 message=[Member|ID] (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_Expression(EObject context, Selection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Field(EObject context, Field semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.TYPED_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.TYPED_ELEMENT__TYPE));
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.TYPED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.TYPED_ELEMENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     constant=INT
	 */
	protected void sequence_IntConstant(EObject context, IntConstant semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.INT_CONSTANT__CONSTANT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.INT_CONSTANT__CONSTANT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntConstantAccess().getConstantINTTerminalRuleCall_0(), semanticObject.getConstant());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_MethodBody(EObject context, MethodBody semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.METHOD_BODY__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.METHOD_BODY__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMethodBodyAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID (params+=Parameter params+=Parameter*)? body=MethodBody)
	 */
	protected void sequence_Method(EObject context, Method semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=ClassType (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_New(EObject context, New semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     parameter=[Parameter|ID]
	 */
	protected void sequence_ParamRef(EObject context, ParamRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.PARAM_REF__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.PARAM_REF__PARAMETER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParamRefAccess().getParameterParameterIDTerminalRuleCall_0_1(), semanticObject.getParameter());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.TYPED_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.TYPED_ELEMENT__TYPE));
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.TYPED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.TYPED_ELEMENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (classes+=Class* main=Expression?)
	 */
	protected void sequence_Program(EObject context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     constant=STRING
	 */
	protected void sequence_StringConstant(EObject context, StringConstant semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.STRING_CONSTANT__CONSTANT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.STRING_CONSTANT__CONSTANT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringConstantAccess().getConstantSTRINGTerminalRuleCall_0(), semanticObject.getConstant());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     variable='this'
	 */
	protected void sequence_This(EObject context, This semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FjPackage.Literals.THIS__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FjPackage.Literals.THIS__VARIABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getThisAccess().getVariableThisKeyword_0(), semanticObject.getVariable());
		feeder.finish();
	}
}
