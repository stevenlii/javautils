package com.paymoon.demo.java8.stream;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import reactor.util.annotation.Nullable;


@SuppressWarnings("rawtypes")
public class MyTuple2<T1, T2> implements Iterable<Object>, Serializable {

	private static final long serialVersionUID = -3518082018884860684L;

	T1 t1;
	T2 t2;

	public MyTuple2() {
	}

	public MyTuple2(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public MyTuple2(reactor.util.function.Tuple2<Optional<T1>, Optional<T2>> objects) {
		this.t1 = objects.getT1().orElse(null);
		this.t2 = objects.getT2().orElse(null);
	}

	/**
	 * Type-safe way to get the fist object of this {@link Tuples}.
	 *
	 * @return The first object
	 */
	public T1 getT1() {
		return t1;
	}

	/**
	 * Type-safe way to get the second object of this {@link Tuples}.
	 *
	 * @return The second object
	 */
	public T2 getT2() {
		return t2;
	}

	public void setT1(T1 t1) {
		this.t1 = t1;
	}

	public void setT2(T2 t2) {
		this.t2 = t2;
	}

	/**
	 * Map the left-hand part (T1) of this {@link reactor.util.function.Tuple2} into a different value and type,
	 * keeping the right-hand part (T2).
	 *
	 * @param mapper the mapping {@link Function} for the left-hand part
	 * @param <R> the new type for the left-hand part
	 * @return a new {@link reactor.util.function.Tuple2} with a different left (T1) value
	 */
	public <R> MyTuple2<R, T2> mapT1(Function<T1, R> mapper) {
		return new MyTuple2<>(mapper.apply(t1), t2);
	}

	/**
	 * Map the right-hand part (T2) of this {@link reactor.util.function.Tuple2} into a different value and type,
	 * keeping the left-hand part (T1).
	 *
	 * @param mapper the mapping {@link Function} for the right-hand part
	 * @param <R> the new type for the right-hand part
	 * @return a new {@link reactor.util.function.Tuple2} with a different right (T2) value
	 */
	public <R> MyTuple2<T1, R> mapT2(Function<T2, R> mapper) {
		return new MyTuple2<>(t1, mapper.apply(t2));
	}

	/**
	 * Get the object at the given index.
	 *
	 * @param index The index of the object to retrieve. Starts at 0.
	 * @return The object or {@literal null} if out of bounds.
	 */
	@Nullable
	public Object get(int index) {
		switch (index) {
			case 0:
				return t1;
			case 1:
				return t2;
			default:
				return null;
		}
	}

	/**
	 * Turn this {@code Tuple} into a {@link List List&lt;Object&gt;}.
	 * The list isn't tied to this Tuple but is a <strong>copy</strong> with limited
	 * mutability ({@code add} and {@code remove} are not supported, but {@code set} is).
	 *
	 * @return A copy of the tuple as a new {@link List List&lt;Object&gt;}.
	 */
	public List<Object> toList() {
		return Arrays.asList(toArray());
	}

	/**
	 * Turn this {@code Tuple} into a plain {@code Object[]}.
	 * The array isn't tied to this Tuple but is a <strong>copy</strong>.
	 *
	 * @return A copy of the tuple as a new {@link Object Object[]}.
	 */
	public Object[] toArray() {
		return new Object[]{t1, t2};
	}

	/**
	 * Return an <strong>immutable</strong> {@link Iterator Iterator&lt;Object&gt;} around
	 * the content of this {@code Tuple}.
	 *
	 * @implNote As an {@link Iterator} is always tied to its {@link Iterable} source by
	 * definition, the iterator cannot be mutable without the iterable also being mutable.
	 * Since {@link Tuples} are <strong>immutable</strong>, so is the {@link Iterator}
	 * returned by this method.
	 *
	 * @return An unmodifiable {@link Iterator} over the elements in this Tuple.
	 */
	@Override
	public Iterator<Object> iterator() {
		return Collections.unmodifiableList(toList()).iterator();
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MyTuple2<?, ?> tuple2 = (MyTuple2<?, ?>) o;

		return t1.equals(tuple2.t1) && t2.equals(tuple2.t2);

	}

	@Override
	public int hashCode() {
		int result = size();
		result = 31 * result + t1.hashCode();
		result = 31 * result + t2.hashCode();
		return result;
	}

	/**
	 * Return the number of elements in this {@literal Tuples}.
	 *
	 * @return The size of this {@literal Tuples}.
	 */
	public int size() {
		return 2;
	}

	/**
	 * A Tuple String representation is the comma separated list of values, enclosed
	 * in square brackets.
	 * @return the Tuple String representation
	 */
	@Override
	public final String toString() {
		return "";
	}
}
