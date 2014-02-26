package it.xsemantics.runtime.caching

import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleApplicationTrace

/**
 * @since 1.5
 */
@Data
class XsemanticsCachedData<T> {
	RuleEnvironment environment
	RuleApplicationTrace trace
	T result
}