/**
 * 
 */
package it.xsemantics.example.fjcached.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author bettini
 *
 */
public class FjcachedProjectCreatorCustom extends FjcachedProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}
}
