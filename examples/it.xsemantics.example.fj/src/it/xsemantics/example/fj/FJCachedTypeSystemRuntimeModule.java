/**
 * 
 */
package it.xsemantics.example.fj;

import it.xsemantics.example.fj.typing.FjCachedTypeSystem;
import it.xsemantics.example.fj.typing.FjTypeSystem;

/**
 * Uses the alternate version (type inference and type check) of
 * the {@link FjTypeSystem}
 * 
 * @author Lorenzo Bettini
 *
 */
public class FJCachedTypeSystemRuntimeModule extends FJRuntimeModule {
	public Class<? extends FjTypeSystem> bindFjTypeSystem() {
		return FjCachedTypeSystem.class;
	}
}
