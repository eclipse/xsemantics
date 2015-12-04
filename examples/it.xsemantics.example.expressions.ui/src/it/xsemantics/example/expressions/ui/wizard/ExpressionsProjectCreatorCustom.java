package it.xsemantics.example.expressions.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ExpressionsProjectCreatorCustom extends ExpressionsProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}

	@Override
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(DSL_GENERATOR_PROJECT_NAME);
	}
}
