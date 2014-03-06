/**
 * 
 */
package it.xsemantics.example.fj;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Lorenzo Bettini
 *
 */
public class FjCachedTypeSystemInjectorProvider extends FJInjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		return new FJStandaloneSetup() {
			public Injector createInjector() {
				return Guice.createInjector(new FJCachedTypeSystemRuntimeModule());
			};
		}
		.createInjectorAndDoEMFRegistration();
	}
}
