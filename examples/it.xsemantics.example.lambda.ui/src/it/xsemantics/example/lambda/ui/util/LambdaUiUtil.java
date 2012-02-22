/**
 * 
 */
package it.xsemantics.example.lambda.ui.util;

import it.xsemantics.example.lambda.ui.internal.LambdaActivator;

import com.google.inject.Injector;

/**
 * @author bettini
 * 
 */
public class LambdaUiUtil {

	public static Injector getInjector() {
		return LambdaActivator.getInstance().getInjector(
				"it.xsemantics.example.lambda.Lambda");
	}
}
