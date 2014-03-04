package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.EmfFactoryUtils
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.runtime.caching.XsemanticsCache
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheTest extends XsemanticsBaseTest {
	
	@Inject extension EmfFactoryUtils
	
	@Inject XsemanticsCache cache

	@Test
	def void testNoObjects() {
		cache.getResource().assertNull
	}

	@Test
	def void testNonEObject() {
		cache.getResource(new String()).assertNull
	}

	@Test
	def void testEObject() {
		val resource = createResource[
			it.createEObject
			it.createEObject
		]
		cache.getResource(resource.contents.get(0), resource.contents.get(1)).assertNotNull
	}

	@Test
	def void testResourceOfTheFirstEObject() {
		val resource1 = createResource[]
		val resource2 = createResource[]
		val o1 = createEObject
		val o2 = createEObject
		resource1.contents += o1
		resource2.contents += o2
		// must return the resource of the first passed EObject
		cache.getResource(new String, 1, o2, o1).assertSame(resource2)
	}

	@Test
	def void testKeysWithOneElement() {
		"foo".assertEquals(cache.getKeys("foo"))
	}

	@Test
	def void testKeysWithSeveralElement() {
		("foo" -> 1).assertEquals(cache.getKeys("foo", 1))
		("foo" -> 1 -> true).assertEquals(cache.getKeys("foo", 1, true))
	}

	@Test
	def void testEffectiveCaching() {
		val resource = createResource[]
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