package it.xsemantics.dsl.tests;

import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.Method;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;

@SuppressWarnings("all")
public class EmfFactoryUtils {
  protected EcoreFactory factory = EcoreFactory.eINSTANCE;
  
  protected FjFactory fjFactory = FjFactory.eINSTANCE;
  
  public EObject createEObject() {
    EObject _createEObject = this.factory.createEObject();
    return _createEObject;
  }
  
  public EClass createEClass(final String name) {
    EClass _xblockexpression = null;
    {
      EClass _createEClass = this.factory.createEClass();
      final EClass e = _createEClass;
      e.setName(name);
      _xblockexpression = (e);
    }
    return _xblockexpression;
  }
  
  public EClass createEClass(final String name, final EClass superClass) {
    EClass _xblockexpression = null;
    {
      EClass _createEClass = this.createEClass(name);
      final EClass e = _createEClass;
      EList<EClass> _eSuperTypes = e.getESuperTypes();
      CollectionExtensions.<EClass>operator_add(_eSuperTypes, superClass);
      _xblockexpression = (e);
    }
    return _xblockexpression;
  }
  
  public it.xsemantics.example.fj.fj.Class createFjClass(final String name) {
    it.xsemantics.example.fj.fj.Class _xblockexpression = null;
    {
      it.xsemantics.example.fj.fj.Class _createClass = this.fjFactory.createClass();
      final it.xsemantics.example.fj.fj.Class c = _createClass;
      c.setName(name);
      _xblockexpression = (c);
    }
    return _xblockexpression;
  }
  
  public Field createFjField(final String name) {
    Field _xblockexpression = null;
    {
      Field _createField = this.fjFactory.createField();
      final Field f = _createField;
      f.setName(name);
      _xblockexpression = (f);
    }
    return _xblockexpression;
  }
  
  public Method createFjMethod(final String name) {
    Method _xblockexpression = null;
    {
      Method _createMethod = this.fjFactory.createMethod();
      final Method m = _createMethod;
      m.setName(name);
      _xblockexpression = (m);
    }
    return _xblockexpression;
  }
}
