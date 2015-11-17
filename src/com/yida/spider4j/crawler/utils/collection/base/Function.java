package com.yida.spider4j.crawler.utils.collection.base;

public interface Function<F, T> {
	/**
	   * Returns the result of applying this function to {@code input}. This method is <i>generally
	   * expected</i>, but not absolutely required, to have the following properties:
	   *
	   * <ul>
	   * <li>Its execution does not cause any observable side effects.
	   * <li>The computation is <i>consistent with equals</i>; that is, {@link Objects#equal
	   *     Objects.equal}{@code (a, b)} implies that {@code Objects.equal(function.apply(a),
	   *     function.apply(b))}.
	   * </ul>
	   *
	   * @throws NullPointerException if {@code input} is null and this function does not accept null
	   *     arguments
	   */
	  T apply(F input);

	  /**
	   * Indicates whether another object is equal to this function.
	   *
	   * <p>Most implementations will have no reason to override the behavior of {@link Object#equals}.
	   * However, an implementation may also choose to return {@code true} whenever {@code object} is a
	   * {@link Function} that it considers <i>interchangeable</i> with this one. "Interchangeable"
	   * <i>typically</i> means that {@code Objects.equal(this.apply(f), that.apply(f))} is true for all
	   * {@code f} of type {@code F}). Note that a {@code false} result from this method does not imply
	   * that the functions are known <i>not</i> to be interchangeable.
	   */
	  boolean equals(Object object);
}
