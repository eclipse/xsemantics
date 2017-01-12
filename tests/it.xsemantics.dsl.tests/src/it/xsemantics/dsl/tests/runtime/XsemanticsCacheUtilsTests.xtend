package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.EmfFactoryUtils
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.runtime.caching.util.XsemanticsCacheUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheUtilsTests extends XsemanticsBaseTest {
	
	@Inject extension EmfFactoryUtils
	
	@Inject XsemanticsCacheUtils cacheUtils

	@Test
	def void testNoObjects() {
		cacheUtils.getResource().assertNull
	}

	@Test
	def void testNonEObject() {
		cacheUtils.getResource(new String()).assertNull
	}

	@Test
	def void testEObject() {
		val resource = createResourceSet.createResource[
			it.createEObject
			it.createEObject
		]
		cacheUtils.getResource(resource.contents.get(0), resource.contents.get(1)).assertNotNull
	}

	@Test
	def void testResourceOfTheFirstEObject() {
		val rs = createResourceSet
		val resource1 = rs.createResource[]
		val resource2 = rs.createResource[]
		val o1 = createEObject
		val o2 = createEObject
		resource1.contents += o1
		resource2.contents += o2
		// must return the resource of the first passed EObject
		cacheUtils.getResource(new String, 1, o2, o1).assertSame(resource2)
	}

	@Test
	def void testKeysWithOneElement() {
		"foo".assertEquals(cacheUtils.getKeys("foo"))
	}

	@Test
	def void testKeysWithSeveralElement() {
		("foo" -> 1).assertEquals(cacheUtils.getKeys("foo", 1))
		("foo" -> 1 -> true).assertEquals(cacheUtils.getKeys("foo", 1, true))
	}

}