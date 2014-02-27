/**
 * 
 */
package it.xsemantics.runtime;

import it.xsemantics.runtime.caching.XsemanticsCache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsRuntimeSystem {

	// The first two params are RuleEnvironment and RuleApplicationTrace
	protected static final int INDEX_OF_RULE_PARAMETERS = 2;

	// The first param is the RuleApplicationTrace
	protected static final int INDEX_OF_AUX_PARAMETERS = 1;

	@Inject
	protected StringRepresentation stringRepresentation;

	@Inject
	private Provider<XsemanticsCache> cacheProvider;

	@Inject
	private XsemanticsCache cache;

	public StringRepresentation getStringRepresentation() {
		return stringRepresentation;
	}

	public void setStringRepresentation(
			StringRepresentation stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	/**
	 * @since 1.5
	 */
	public XsemanticsCache getCache() {
		if (cache == null)
			cache = cacheProvider.get();
		return cache;
	}

	protected Predicate<Method> getPredicate(String methodName, int numOfArgs) {
		return PolymorphicDispatcher.Predicates.forName(methodName, numOfArgs);
	}

	protected <T> PolymorphicDispatcher<T> buildPolymorphicDispatcher(
			final String methodName, int numOfArgs) {
		PolymorphicDispatcher<T> dispatcher = new PolymorphicDispatcher<T>(
				Collections.singletonList(this), getPredicate(methodName,
						numOfArgs)) {
			@Override
			protected T handleNoSuchMethod(Object... params) {
				return org.eclipse.xtext.util.Exceptions
						.throwUncheckedException(noSuchMethodException(
								methodName, params));
			}
		};
		return dispatcher;
	}

	protected <T> PolymorphicDispatcher<Result<T>> buildPolymorphicDispatcher1(
			String methodName, int numOfArgs, final String judgmentSymbol,
			final String... relationSymbols) {
		PolymorphicDispatcher<Result<T>> dispatcher = new PolymorphicDispatcher<Result<T>>(
				Collections.singletonList(this), getPredicate(methodName,
						numOfArgs)) {
			@Override
			protected Result<T> handleNoSuchMethod(Object... params) {
				return org.eclipse.xtext.util.Exceptions
						.throwUncheckedException(noSuchMethodException(
								judgmentSymbol, Arrays.asList(relationSymbols),
								params));
			}
		};
		return dispatcher;
	}

	protected <FirstT, SecondT> PolymorphicDispatcher<Result2<FirstT, SecondT>> buildPolymorphicDispatcher2(
			String methodName, int numOfArgs, final String judgmentSymbol,
			final String... relationSymbols) {
		PolymorphicDispatcher<Result2<FirstT, SecondT>> dispatcher = new PolymorphicDispatcher<Result2<FirstT, SecondT>>(
				Collections.singletonList(this), getPredicate(methodName,
						numOfArgs)) {
			@Override
			protected Result2<FirstT, SecondT> handleNoSuchMethod(
					Object... params) {
				return org.eclipse.xtext.util.Exceptions
						.throwUncheckedException(noSuchMethodException(
								judgmentSymbol, Arrays.asList(relationSymbols),
								params));
			}
		};
		return dispatcher;
	}

	protected <FirstT, SecondT, ThirdT> PolymorphicDispatcher<Result3<FirstT, SecondT, ThirdT>> buildPolymorphicDispatcher3(
			String methodName, int numOfArgs, final String judgmentSymbol,
			final String... relationSymbols) {
		PolymorphicDispatcher<Result3<FirstT, SecondT, ThirdT>> dispatcher = new PolymorphicDispatcher<Result3<FirstT, SecondT, ThirdT>>(
				Collections.singletonList(this), getPredicate(methodName,
						numOfArgs)) {
			@Override
			protected Result3<FirstT, SecondT, ThirdT> handleNoSuchMethod(
					Object... params) {
				return org.eclipse.xtext.util.Exceptions
						.throwUncheckedException(noSuchMethodException(
								judgmentSymbol, Arrays.asList(relationSymbols),
								params));
			}
		};
		return dispatcher;
	}

	public boolean isResultAssignableTo(Object result, Class<?> destinationClass) {
		return destinationClass.isAssignableFrom(result.getClass());
	}

	public void checkAssignableTo(Object result, Class<?> destinationClass)
			throws RuleFailedException {
		if (!isResultAssignableTo(result, destinationClass))
			throw newRuleFailedException(stringRep(result)
					+ " cannot be assigned to " + stringRep(destinationClass));
	}

	public void checkParamsNotNull(Object... objects)
			throws RuleFailedException {
		for (int i = 0; i < objects.length; i++) {
			Object object = objects[i];
			checkNotNull(object);
		}
	}

	public void checkNotNull(Object object) throws RuleFailedException {
		if (object == null)
			throw newRuleFailedException("passed null object to system");
	}

	public String stringRep(Object object) {
		return stringRepresentation.string(object);
	}

	protected String stringRepForEnv(RuleEnvironment ruleEnvironment) {
		if (ruleEnvironment == null)
			return "[]";
		return stringRepresentation.string(ruleEnvironment);
	}

	protected String stringRepForParams(Object[] params,
			Iterable<String> relationSymbols) {
		StringBuilder builder = new StringBuilder();
		Iterator<String> it = relationSymbols.iterator();
		for (int i = INDEX_OF_RULE_PARAMETERS; i < params.length; i++) {
			builder.append(stringRep(params[i]));
			if (it.hasNext())
				builder.append(" " + it.next() + " ");
		}
		return builder.toString();
	}

	protected String stringRepForParams(Object[] params) {
		StringBuilder builder = new StringBuilder();
		for (int i = INDEX_OF_AUX_PARAMETERS; i < params.length; i++) {
			if (builder.length() > 0)
				builder.append(", ");
			builder.append(stringRep(params[i]));
		}
		return builder.toString();
	}

	protected RuleFailedException noSuchMethodException(
			final String judgmentSymbol,
			final Iterable<String> relationSymbols, Object... params) {
		return newRuleFailedException("cannot find a rule for "
				+ judgmentSymbol + " "
				+ stringRepForParams(params, relationSymbols));
	}

	protected RuleFailedException noSuchMethodException(final String name,
			Object... params) {
		return newRuleFailedException("cannot find an implementation for "
				+ name + "(" + stringRepForParams(params) + ")");
	}

	public void sneakyThrowRuleFailedException(Exception e) {
		Exceptions.sneakyThrow(extractRuleFailedException(e));
	}

	public void sneakyThrowRuleFailedException(String message) {
		Exceptions.sneakyThrow(newRuleFailedException(message, null));
	}

	public void throwForExplicitFail() {
		Exceptions.sneakyThrow(newRuleFailedException());
	}

	public void throwForExplicitFail(String message,
			ErrorInformation errorInformation) {
		final RuleFailedException ex = newRuleFailedException(message);
		ex.addErrorInformation(errorInformation);
		Exceptions.sneakyThrow(ex);
	}

	public void throwRuleFailedException(String message, String issue,
			Throwable t, ErrorInformation... errorInformations)
			throws RuleFailedException {
		throw newRuleFailedException(message, issue, t, errorInformations);
	}

	/**
	 * @since 1.5
	 */
	public RuleFailedException newRuleFailedException() {
		return createRuleFailedException(null, null, null);
	}

	/**
	 * @since 1.5
	 */
	public RuleFailedException newRuleFailedException(Throwable t) {
		return createRuleFailedException(t.toString(), null, t);
	}

	/**
	 * @since 1.5
	 */
	public RuleFailedException newRuleFailedException(String message) {
		return createRuleFailedException(message, null, null);
	}

	public RuleFailedException newRuleFailedException(String message,
			String issue, ErrorInformation... errorInformations) {
		return newRuleFailedException(message, issue, null, errorInformations);
	}

	public RuleFailedException newRuleFailedException(String message,
			String issue, Throwable t, ErrorInformation... errorInformations) {
		final RuleFailedException ruleFailedException = createRuleFailedException(
				failed(message), issue, t);
		ruleFailedException.addErrorInformations(errorInformations);
		return ruleFailedException;
	}

	/**
	 * This factory method can be overridden if one needs to provide a custom implementation
	 * of {@link RuleFailedException}.
	 * 
	 * @param message
	 * @param issue
	 * @param t
	 * @return
	 * 
	 * @since 1.5
	 */
	protected RuleFailedException createRuleFailedException(String message,
			String issue, Throwable t) {
		return new RuleFailedException(message, issue, t);
	}

	public RuleFailedException extractRuleFailedException(Exception e) {
		if (e instanceof WrappedException) {
			WrappedException wrappedException = (WrappedException) e;
			Exception exception = wrappedException.exception();
			if (exception instanceof RuleFailedException) {
				RuleFailedException ruleFailedException = (RuleFailedException) exception;
				return ruleFailedException;
			}
		} else if (e instanceof RuleFailedException) {
			return (RuleFailedException) e;
		}
		return newRuleFailedException(e);
	}

	protected <T> Result<T> resultForFailure(Exception e) {
		return new Result<T>(extractRuleFailedException(e));
	}

	protected <FirstT, SecondT> Result2<FirstT, SecondT> resultForFailure2(
			Exception e) {
		return new Result2<FirstT, SecondT>(extractRuleFailedException(e));
	}

	protected <FirstT, SecondT, ThirdT> Result3<FirstT, SecondT, ThirdT> resultForFailure3(
			Exception e) {
		return new Result3<FirstT, SecondT, ThirdT>(extractRuleFailedException(e));
	}

	protected String failed(String message) {
		return "failed: " + trimIfNotNull(message);
	}

	protected String trimIfNotNull(String message) {
		return message != null ? message.trim() : message;
	}

	protected String ruleName(String ruleName) {
		return trimIfNotNull(ruleName) + ": ";
	}
	
	protected String auxFunName(String ruleName) {
		return trimIfNotNull(ruleName);
	}

	public void addToTrace(RuleApplicationTrace ruleApplicationTrace,
			Object traceElement) {
		if (ruleApplicationTrace != null)
			ruleApplicationTrace.addToTrace(traceElement);
	}

	public RuleApplicationTrace newTrace(
			RuleApplicationTrace ruleApplicationTrace) {
		if (ruleApplicationTrace != null)
			return new RuleApplicationTrace();
		return null;
	}

	public void addAsSubtrace(RuleApplicationTrace ruleApplicationTrace,
			RuleApplicationTrace subTrace) {
		if (ruleApplicationTrace != null)
			ruleApplicationTrace.addAsSubtrace(subTrace);
	}

	/**
	 * This method replaces the previous keyword 'env' in Xsemantics grammar
	 * (before version 1.5.0).
	 * 
	 * It is useless to have such element in the grammar, since it has
	 * exactly the same syntax of this Java method invocation.
	 * 
	 * @param environment
	 * @param key
	 * @param clazz
	 * @return
	 * @throws RuleFailedException
	 * @since 1.5
	 */
	public <T> T env(RuleEnvironment environment, Object key,
			Class<? extends T> clazz) throws RuleFailedException {
		return environmentAccess(environment, key, clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> T environmentAccess(RuleEnvironment environment, Object key,
			Class<? extends T> clazz) throws RuleFailedException {
		if (environment == null)
			throw newRuleFailedException("access to null environment");
		Object value = environment.get(key);
		if (value == null)
			throw newRuleFailedException("no mapping in the environment for: "
					+ stringRep(key));
		if (clazz.isAssignableFrom(value.getClass()))
			return (T) value;
		else
			throw newRuleFailedException("mapped value " + stringRep(value)
					+ " cannot be assigned to " + stringRep(clazz));
	}

	public <T extends EObject> T clone(T eObject) {
		return EcoreUtil.copy(eObject);
	}

	public RuleEnvironment emptyEnvironment() {
		return new RuleEnvironment();
	}

	public RuleEnvironment environmentEntry(Object key, Object value) {
		return new RuleEnvironment(new RuleEnvironmentEntry(key, value));
	}

	public RuleEnvironment environmentComposition(RuleEnvironment environment,
			RuleEnvironment environment2) {
		if (environment == null)
			return new RuleEnvironment(environment2);
		return new RuleEnvironment(environment, environment2);
	}

	public <T> List<T> getAll(EObject eObject, EStructuralFeature mainFeature,
			EStructuralFeature extendFeature, Class<? extends T> clazz) {
		List<T> list = new LinkedList<T>();

		if (eObject != null) {
			// get all the stuff from the main object
			addToList(list, eObject.eGet(mainFeature), clazz);

			// follow the extend feature performing the closure
			List<EObject> nodesInRelation = getAllNodesInRelation(eObject,
					extendFeature);
			for (EObject object : nodesInRelation) {
				if (object != null) {
					addToList(list, object.eGet(mainFeature), clazz);
				}
			}
		}

		return list;
	}

	public List<EObject> getAllNodesInRelation(EObject eObject,
			EStructuralFeature extendFeature) {
		List<EObject> nodes = new LinkedList<EObject>();
		Set<EObject> seen = new HashSet<EObject>();

		getAllNodesInRelation(eObject, extendFeature, nodes, seen);

		return nodes;
	}

	protected void getAllNodesInRelation(EObject eObject,
			EStructuralFeature extendFeature, List<EObject> nodes,
			Set<EObject> seen) {
		if (eObject != null) {
			// follow the extend feature performing the closure
			List<Object> objectsToFollow = getList(eObject.eGet(extendFeature));

			for (Object object : objectsToFollow) {
				EObject toFollow = getEObject(object);
				if (toFollow != null && !seen.contains(toFollow)) {
					seen.add(toFollow);
					nodes.add(toFollow);
					getAllNodesInRelation(toFollow, extendFeature, nodes, seen);
				}
			}
		}
	}

	/**
	 * If the object is a list returns the list itself, otherwise returns a list
	 * with only the passed object as element.
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getList(Object object) {
		if (object == null)
			return Lists.newArrayList();

		if (object instanceof List) {
			return (List<Object>) object;
		} else {
			return Lists.newArrayList(object);
		}
	}

	public EObject getEObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		}
		return null;
	}

	/**
	 * Adds the object (or if the object is a list itself, all its elements,
	 * recursively) to the list, if the object can be assigned to the passed
	 * clazz.
	 * 
	 * @param list
	 * @param o
	 * @param clazz
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> void addToList(List<T> list, Object o, Class<? extends T> clazz) {
		if (o == null)
			return;
		if (o instanceof List) {
			List objectList = (List) o;
			for (Object object : objectList) {
				addToList(list, object, clazz);
			}
		} else {
			if (clazz.isAssignableFrom(o.getClass()))
				list.add((T) o);
		}
	}
}
