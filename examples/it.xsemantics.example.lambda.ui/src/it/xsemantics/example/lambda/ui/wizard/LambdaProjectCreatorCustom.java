/**
 * 
 */
package it.xsemantics.example.lambda.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author bettini
 *
 */
public class LambdaProjectCreatorCustom extends LambdaProjectCreator {

	@Override
	protected List<String> getAllFolders() {
        return ImmutableList.of(SRC_ROOT);
    }
}
