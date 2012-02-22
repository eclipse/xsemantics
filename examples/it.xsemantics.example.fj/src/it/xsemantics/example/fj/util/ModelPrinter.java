/**
 * 
 */
package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.FJStandaloneSetup;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.New;
import it.xsemantics.example.fj.fj.ParamRef;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.fj.TypedElement;
import it.xsemantics.example.fj.fj.util.FjSwitch;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * @author bettini
 * 
 */
public class ModelPrinter extends FjSwitch<String> {

	@Override
	public String caseField(Field object) {
		return "field: " + caseTypedElement(object);
	}

	@Override
	public String caseMethod(Method object) {
		return object.getName() + "()";
	}

	@Override
	public String caseNew(New object) {
		return "new " + object.getClass().getName();
	}

	@Override
	public String caseSelection(Selection object) {
		return doSwitch(object.getReceiver()) + "."
				+ doSwitch(object.getMessage());
	}

	@Override
	public String caseType(Type object) {
		return object.getClass().getName();
	}

	@Override
	public String caseTypedElement(TypedElement object) {
		return caseType(object.getType()) + " " + object.getName();
	}

	@Override
	public String caseParamRef(ParamRef object) {
		return "var: " + object.getParameter();
	}

	@Override
	public String defaultCase(EObject object) {
		return super.defaultCase(object);
	}

	@Override
	public String caseClass(Class object) {
		return "class "
				+ object.getName()
				+ (object.getSuperclass() != null ? " extends "
						+ object.getSuperclass().getName() : "");
	}

	@Override
	public String caseProgram(Program object) {
		String result = "program:\n";

		for (Class cl : object.getClasses()) {
			result += doSwitch(cl) + "\n";
		}

		return result;
	}

	@Override
	public String doSwitch(EObject theEObject) {
		// TODO Auto-generated method stub
		return super.doSwitch(theEObject);
	}

	public static void main(String[] args) throws IOException {
		Injector injector = new FJStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/example.fj"));
		InputStream in = new ByteArrayInputStream(
				"class A { A a; } class B extends A { B b; }".getBytes());
		resource.load(in, resourceSet.getLoadOptions());
		EObject program = resource.getContents().get(0);
		System.out.println(new ModelPrinter().doSwitch(program));
	}
}
