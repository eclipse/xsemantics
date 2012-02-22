package it.xsemantics.example.lambda.xsemantics;

import com.google.inject.Inject;
import com.google.inject.Provider;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Type;

public class LambdaStringRepresentationWithTypeBeautifier extends
		LambdaStringRepresentation {

	@Inject
	protected Provider<LambdaTypeBeautifier> lambdaTypeBeautifierProvider;

	@Override
	protected String stringRep(ArrowType arrowType) {
		return getBeautifiedType(arrowType);
	}

	protected String stringRep(Type type) {
		return getBeautifiedType(type);
	}

	protected String getBeautifiedType(Type type) {
		return lambdaTypeBeautifierProvider.get().getBeautifiedString(type);
	}
}
