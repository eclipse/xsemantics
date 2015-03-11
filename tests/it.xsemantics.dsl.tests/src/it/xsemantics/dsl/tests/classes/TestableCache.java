/**
 * 
 */
package it.xsemantics.dsl.tests.classes;

import com.google.inject.Provider;

import it.xsemantics.runtime.XsemanticsCacheDefaultImpl;

/**
 * Just for calling protected methods.
 * 
 * @author Lorenzo Bettini
 *
 */
public class TestableCache extends XsemanticsCacheDefaultImpl {

	@Override
	public <T> T internalGet(String methodName, Provider<T> provider,
			Object... elements) {
		return super.internalGet(methodName, provider, elements);
	}
}
