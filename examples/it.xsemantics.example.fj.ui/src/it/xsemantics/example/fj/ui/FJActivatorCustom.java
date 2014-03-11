/**
 * 
 */
package it.xsemantics.example.fj.ui;

import it.xsemantics.example.fj.ui.internal.FJActivator;

import com.google.inject.Module;

/**
 * Activates FJ editors with different type system implementations.
 * 
 * @author Lorenzo Bettini
 *
 */
public class FJActivatorCustom extends FJActivator {

	public static final String IT_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM = "it.xsemantics.example.fj.FJ.Sep";
	
	@Override
	protected Module getRuntimeModule(String grammar) {
		if (IT_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM.equals(grammar)) {
			return new it.xsemantics.example.fj.FJSepTypeSystemRuntimeModule();
		}
		
		return super.getRuntimeModule(grammar);
	}

	@Override
	protected Module getUiModule(String grammar) {
		if (IT_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM.equals(grammar)) {
			return new it.xsemantics.example.fj.ui.FJUiModule(this);
		}
		
		return super.getUiModule(grammar);
	}
}
