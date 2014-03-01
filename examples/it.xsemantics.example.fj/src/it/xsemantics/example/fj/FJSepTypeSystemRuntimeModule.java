/**
 * 
 */
package it.xsemantics.example.fj;

import it.xsemantics.example.fj.typing.FjSepTypeSystem;
import it.xsemantics.example.fj.typing.FjTypeSystem;

/**
 * Uses the alternate version (type inference and type check) of
 * the {@link FjTypeSystem}
 * 
 * @author Lorenzo Bettini
 *
 */
public class FJSepTypeSystemRuntimeModule extends FJRuntimeModule {
	public Class<? extends FjTypeSystem> bindFjTypeSystem() {
		return FjSepTypeSystem.class;
	}
}
