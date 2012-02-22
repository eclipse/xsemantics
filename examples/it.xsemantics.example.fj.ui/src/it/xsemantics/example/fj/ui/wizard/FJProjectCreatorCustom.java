/**
 * 
 */
package it.xsemantics.example.fj.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author bettini
 * 
 */
public class FJProjectCreatorCustom extends FJProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}

}
