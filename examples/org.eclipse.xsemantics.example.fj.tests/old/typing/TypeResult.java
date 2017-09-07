/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

/**
 * 
 */
package org.eclipse.xsemantics.example.fj.typing;

import org.eclipse.xsemantics.example.fj.fj.BasicType;
import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.example.fj.lookup.AuxiliaryFunctions;
import org.eclipse.xsemantics.example.fj.util.FjTypeUtils;
import it.xtypes.runtime.TypeSystemResult;

/**
 * Represents the result of the typing, this is superseded by TypeSystemResult,
 * and it's still here for old tests.
 * 
 * @author bettini
 * 
 */
public class TypeResult {
	Type type;

	String diagnostic;

	public TypeResult(Type type) {
		super();
		this.type = type;
	}

	public TypeResult(String diagnostic) {
		super();
		this.diagnostic = diagnostic;
	}

	public TypeResult() {
	}

	public TypeResult(Class containingClass) {
		if (containingClass == null) {
			this.type = null;
		} else {
			this.type = FjTypeUtils.createClassType(containingClass);
		}
	}

	public TypeResult(TypeSystemResult<Type> typeAsType) {
		if (typeAsType.getValue() != null)
			this.type = typeAsType.getValue();
		else
			this.diagnostic = typeAsType.getFailure().getMessage();
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public void addDiagnostic(String diagnostic) {
		if (this.diagnostic == null) {
			this.diagnostic = diagnostic;
		} else {
			this.diagnostic.concat("\n" + diagnostic);
		}
	}

	public String toString() {
		if (type != null) {
			return FjTypeUtils.typeToString(type);
		} else {
			return diagnostic;
		}
	}

	/**
	 * If the type is not null then returns the class type, otherwise returns
	 * null
	 * 
	 * @return
	 */
	public Class getClassref() {
		ClassType classType = AuxiliaryFunctions.getClassType(type);
		return (classType != null ? classType.getClassref() : null);
	}

	/**
	 * If the type is not null then returns the basic type, otherwise returns
	 * null
	 * 
	 * @return
	 */
	public String getBasicType() {
		BasicType basicType = AuxiliaryFunctions.getBasicType(type);
		return (basicType != null ? basicType.getBasic() : null);
	}

}
