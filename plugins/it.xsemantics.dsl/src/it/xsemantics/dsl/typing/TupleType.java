/**
 * 
 */
package it.xsemantics.dsl.typing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Lorenzo Bettini
 * 
 */
public class TupleType extends ArrayList<JvmTypeReference> {

	private static final long serialVersionUID = 1L;

	/**
	 * Redefined so that we use the referred JvmType
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;
		Iterator<JvmTypeReference> i = iterator();
		while (i.hasNext()) {
			JvmType type = i.next().getType();
			if (type != null && !type.eIsProxy()) {
				hashCode = 31 * hashCode + (type == null ? 0 : type.hashCode());
			}
		}
		return hashCode;
	}

	/**
	 * Redefined so that we use the referred JvmType
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		ListIterator<JvmTypeReference> e1 = listIterator();
		ListIterator<JvmTypeReference> e2 = ((TupleType) o).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			JvmTypeReference o1 = e1.next();
			JvmTypeReference o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.getType().equals(o2.getType()))) {
				return false;
			}
		}
		return !(e1.hasNext() || e2.hasNext());
	}

}
