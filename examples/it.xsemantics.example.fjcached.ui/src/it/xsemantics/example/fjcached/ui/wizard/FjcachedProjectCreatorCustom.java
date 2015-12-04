/**
 * 
 */
package it.xsemantics.example.fjcached.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author bettini
 *
 */
public class FjcachedProjectCreatorCustom extends FjcachedProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}

	@Override
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(DSL_GENERATOR_PROJECT_NAME);
	}

}
