package it.xsemantics.example.expressions.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class ExpressionsProjectCreatorCustom extends ExpressionsProjectCreator {

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT);
	}
}
