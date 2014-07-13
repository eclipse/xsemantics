package it.xsemantics.runtime.util

import it.xsemantics.runtime.RuleFailedException
import static extension org.eclipse.xtext.util.Strings.*
import it.xsemantics.runtime.RuleApplicationTrace
import java.util.List
import java.util.LinkedList
import com.google.common.collect.Lists
import it.xsemantics.runtime.ErrorInformation
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class TraceUtils {
	
	def failureAsList(RuleFailedException e) {
		val list = newLinkedList(e)
		var ex = e.previous
		while (ex != null) {
			if (ex.message != null)
				list.add(ex)
			ex = ex.previous
		}
		list
	}
	
	def failureTraceAsStrings(RuleFailedException e) {
		val indent = new StringBuffer("")
		e.failureAsList.map [
			val listElem = indent.toString + it.message.removeIndentation
			indent.append(" ")
			listElem
		]
	}
	
	def failureTraceAsString(RuleFailedException e) {
		e.failureTraceAsStrings.join("\n")
	}
	
	def traceAsStrings(RuleApplicationTrace ruleTrace) {
		val result = new LinkedList<String>()
		for (e : ruleTrace.trace)
			buildTrace(result, e, 0)
		result
	}
	
	def void buildTrace(List<String> trace, Object element, int inc) {
		if (element instanceof RuleApplicationTrace) {
			for (e : element.trace) {
				buildTrace(trace, e, inc + 1)
			}
		} else {
			trace.add(increment(inc) + element.toString.removeIndentation)
		}
	}
	
	def traceAsString(RuleApplicationTrace ruleTrace) {
		ruleTrace.traceAsStrings.join("\n")
	}
	
	def String increment(int inc) {
		var buffer = new StringBuffer()
		var i = 0
		while (i < inc) {
			buffer.append(' ');
			i = i + 1
		}
		buffer.toString();
	}
	
	def allErrorInformation(RuleFailedException e) {
		val list = Lists::newLinkedList(e.errorInformations)
		var ex = e.previous
		while (ex != null) {
			list.addAll(ex.errorInformations)
			ex = ex.previous
		}
		list
	}
	
	def removeDuplicateErrorInformation(Iterable<ErrorInformation> errorInformations) {
		val List<ErrorInformation> noDuplicates = new LinkedList()
		for (errorInformation : errorInformations) {
			if (!noDuplicates.exists [ 
				it.source == errorInformation.source &&
				it.feature == errorInformation.feature
			]) 
			{
				noDuplicates.add(errorInformation)
			}
		}
		noDuplicates
	}
	
	def removeNonNodeModelSources(Iterable<ErrorInformation> errorInformations) {
		Lists::newLinkedList(errorInformations.filter [
			NodeModelUtils::getNode(it.source) != null
		])
	}
	
	def filteredErrorInformation(RuleFailedException e) {
		e.allErrorInformation.
			removeDuplicateErrorInformation.
				removeNonNodeModelSources
	}
	
	def innermostRuleFailedExceptionWithNodeModelSources(RuleFailedException e) {
		e.failureAsList.findLast [
			!it.filteredErrorInformation.empty
		]
	}

	/**
	 * @since 1.5
	 */
	def removeIndentation(String s) {
		s.removeLeadingWhitespace
	}

	/**
	 * Returns the last element in the trace that is not a RuleApplicationTrace
	 * @since 1.5
	 */
	def lastElementNotTrace(RuleApplicationTrace trace) {
		trace.trace.findLast[!(it instanceof RuleApplicationTrace)]
	}
}