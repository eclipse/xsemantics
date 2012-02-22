/**
 * 
 */
package it.xsemantics.dsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author bettini
 * 
 */
public class XsemanticsNodeModelUtils {

	public String getProgramText(EObject object) {
		final ICompositeNode node = NodeModelUtils.getNode(object);
		if (node == null)
			return null;
		return NodeModelUtils.getTokenText(node);
	}
}
