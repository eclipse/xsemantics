package it.xsemantics.dsl.tests;

import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.XsemanticsRuntimeModule;
import it.xsemantics.dsl.XsemanticsStandaloneSetup;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.runtime.Result;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.common.base.Supplier;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class XsemanticsInjectorProviderCustomForPluginTest extends XsemanticsInjectorProvider {

	public Injector internalCreateInjector() {
			return new XsemanticsStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new XsemanticsRuntimeModule() {
						@Override
						public ClassLoader bindClassLoaderToInstance() {
							return XsemanticsInjectorProviderCustomForPluginTest.class
									.getClassLoader();
						}

						@SuppressWarnings("unused")
						public Class<? extends OnTheFlyJavaCompiler> bindOnTheFlyJavaCompiler() {
							try {
								if (ResourcesPlugin.getWorkspace() != null)
									return EclipseRuntimeDependentJavaCompiler.class;
							} catch (Exception e) {
								// ignore
							}
							return OnTheFlyJavaCompiler.class;
						}
						
						@SuppressWarnings("unused")
						public Class<? extends OnTheFlyJavaCompiler.ClassPathAssembler> bindClassPathAssembler() {
							return TestClassPathAssembler.class;
						}
					});
				}
			}.createInjectorAndDoEMFRegistration();
	}

	public static class TestClassPathAssembler extends
			OnTheFlyJavaCompiler.ClassPathAssembler {
		@Override
		public void assembleCompilerClassPath(OnTheFlyJavaCompiler compiler) {
			super.assembleCompilerClassPath(compiler);
			if (compiler instanceof EclipseRuntimeDependentJavaCompiler) {
				compiler.addClassPathOfClass(getClass());
				compiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
				compiler.addClassPathOfClass(Functions.class);
				compiler.addClassPathOfClass(Provider.class);
				compiler.addClassPathOfClass(Inject.class);
				compiler.addClassPathOfClass(javax.inject.Provider.class);
				compiler.addClassPathOfClass(Supplier.class);
				
				compiler.addClassPathOfClass(FjPackage.class);
				compiler.addClassPathOfClass(EcorePackage.class);
				compiler.addClassPathOfClass(Result.class);
				compiler.addClassPathOfClass(PolymorphicDispatcher.class);
				compiler.addClassPathOfClass(EList.class);
				compiler.addClassPathOfClass(EcoreUtil2.class);
				compiler.addClassPathOfClass(Check.class);
			}
		}
	}
}
