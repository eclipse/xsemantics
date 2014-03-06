package it.xsemantics.example.fjcached.tests

import com.google.inject.Inject
import it.xsemantics.example.fjcached.FjcachedInjectorProvider
import it.xsemantics.example.fjcached.fjcached.Program
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjcachedInjectorProvider))
class FjCachedTest {
	
	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testFjPair() {
		'''
		/*
		 * This is an example FJ program
		 */
		
		class MyObject { }
		
		class A extends MyObject { }
		class B extends MyObject { }
		
		class Pair extends MyObject {
		    MyObject fst;
		    MyObject snd;
		
		    Pair setfst(MyObject newfst) {
		        return new Pair(newfst, this.snd);
		    }
		
		    Pair setsnd(MyObject newscd) {
		        return new Pair(this.fst, newscd);
		    }
		}
		
		// the main expression
		new Pair(new A(), new B()).setfst(new B()).fst
		'''.parse.assertNoErrors
	}
}