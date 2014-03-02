/**
 * 
 */
package it.xsemantics.example.fj.ui;

import it.xsemantics.example.fj.ui.internal.FJActivator;

import com.google.inject.Injector;

/**
 * Activates FJ editors with different type system implementations.
 * 
 * @author Lorenzo Bettini
 */
public class FJCachedExecutableExtensionFactory extends FJExecutableExtensionFactory {

	@Override
	protected Injector getInjector() {
		return FJActivator.getInstance().getInjector(FJActivatorCustom.IT_XSEMANTICS_EXAMPLE_FJ_CACHED_TYPESYSTEM);
	}
}
