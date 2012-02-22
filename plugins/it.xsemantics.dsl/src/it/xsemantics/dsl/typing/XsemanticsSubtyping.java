/**
 * 
 */
package it.xsemantics.dsl.typing;

import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OutputParameter;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.inject.Inject;

/**
 * @author bettini
 * 
 */
@SuppressWarnings("restriction")
public class XsemanticsSubtyping {

	@Inject
	protected TypeConformanceComputer conformanceComputer;

	@Inject
	protected TypeReferences typeReferences;

	public boolean isConformant(List<JudgmentParameter> judgmentParameters,
			TupleType tupleType) {
		if (judgmentParameters.size() != tupleType.size())
			return false;
		Iterator<JudgmentParameter> judgmentParametersIt = judgmentParameters.iterator();
		for (JvmTypeReference jvmTypeReference : tupleType) {
			if (!isConformant(getJvmTypeReference(judgmentParametersIt.next()),
					jvmTypeReference))
				return false;
		}
		return true;
	}

	public JvmTypeReference getJvmTypeReference(JudgmentParameter judgmentParameter) {
		if (judgmentParameter instanceof InputParameter) {
			return ((InputParameter) judgmentParameter).getParameter()
					.getParameterType();
		}
		if (judgmentParameter instanceof OutputParameter) {
			return ((OutputParameter) judgmentParameter).getJvmTypeReference();
		}
		return null;
	}

	public boolean isConformant(JvmTypeReference expected,
			JvmTypeReference actual) {
		return conformanceComputer.isConformant(expected, actual);
	}

	public boolean equals(TupleType tupleType1, TupleType tupleType2) {
		if (tupleType1.size() != tupleType2.size())
			return false;
		Iterator<JvmTypeReference> judgmentParametersIt = tupleType1.iterator();
		for (JvmTypeReference jvmTypeReference : tupleType2) {
			if (!equals(judgmentParametersIt.next(), jvmTypeReference))
				return false;
		}
		return true;
	}

	public boolean equals(JvmTypeReference t1, JvmTypeReference t2) {
		return isConformant(t1, t2) && isConformant(t2, t1);
	}

	/**
	 * Whether the passed type corresponds to an EObject
	 * 
	 * @param type
	 * @param context
	 * @return
	 */
	public boolean isEObject(JvmTypeReference type, EObject context) {
		return isConformant(
				typeReferences.getTypeForName(EObject.class, context), type);
	}

	/**
	 * Whether the passed type corresponds to an EStructuralFeature
	 * 
	 * @param type
	 * @param context
	 * @return
	 */
	public boolean isEStructuralFeature(JvmTypeReference type, EObject context) {
		return isConformant(typeReferences.getTypeForName(
				EStructuralFeature.class, context), type);
	}

}
