package it.xsemantics.example.fjcached.performance

import it.xsemantics.example.fjcached.FjcachedInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjcachedInjectorProvider))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
abstract class AbstractFjPerformanceTest {

	@Test def void aWarmUp() {
		testPerformance(3)
	}
	
	@Test def void test003() {
		testPerformance(3)
	}

	@Test def void test010() {
		testPerformance(10)
	}

	@Test def void test050() {
		testPerformance(50)
	}

	@Test def void test100() {
		testPerformance(100)
	}

	@Test def void test200() {
		testPerformance(200)
	}

	@Test def void test300() {
		testPerformance(300)
	}

	/**
	 * Generates input of the shape
	 * 
	 *  <pre>
	 *  class A_0 {
			Object f;
		}
		class A_1 extends A_0 {
		}
		class A_2 extends A_1 {
		}
		class A_3 extends A_2 {
		}
		
		new A_3(
			new A_2(
			new A_1(
			new A_1(new A_0(new Object()))
		)))
		</pre>
	 */
	def protected testPerformance(int n) {
		validateInput('''
			class Object {}
		
			class A_0 {
				Object field;
				Object getField() { return this.field; }
			}
			«FOR i : 1..n»
			class A_«i» extends A_«i-1» {
			}
			«ENDFOR»
			
			new A_«n»(
				«FOR i : n..2»
				new A_«i-1»(
				«ENDFOR»
				new A_1(new A_0(new Object()))
			)
			«FOR i : n..2»)«ENDFOR»
		''')
	}

	def abstract void validateInput(CharSequence input);
}