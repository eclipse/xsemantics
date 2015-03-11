package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.EmfFactoryUtils
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.classes.TestableCache
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheTest extends XsemanticsBaseTest {
	
	@Inject extension EmfFactoryUtils
	
	@Inject TestableCache cache

	@Test
	def void testEffectiveCaching() {
		val resource = createResourceSet.createResource[]
		val key1 = createEObject
		val key2 = createEObject
		resource.contents += key1
		resource.contents += key2
		
		val provider = [| new Object ]
		val o1 = cache.internalGet("test", provider, key1)
		val o2 = cache.internalGet("test", provider, key1)
		o1.assertSame(o2)
		
		val o3 = cache.internalGet("test", provider, key2)
		o1.assertNotSame(o3)
	}
}