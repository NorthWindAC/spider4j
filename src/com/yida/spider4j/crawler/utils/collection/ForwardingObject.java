package com.yida.spider4j.crawler.utils.collection;

import java.io.Serializable;

import com.yida.spider4j.crawler.utils.collection.anno.GwtCompatible;

/**
 * An abstract base class for implementing the <a
 * href="http://en.wikipedia.org/wiki/Decorator_pattern">decorator pattern</a>.
 * The {@link #delegate()} method must be overridden to return the instance
 * being decorated.
 *
 * This class does <i>not</i> forward the {@code hashCode} and {@code equals}
 * methods through to the backing object, but relies on {@code Object}'s
 * implementation. This is necessary to preserve the symmetry of {@code equals}.
 * Custom definitions of equality are usually based on an interface, such as
 * {@code Set} or {@code List}, so that the implementation of {@code equals} can
 * cast the object being tested for equality to the custom interface. {@code
 * ForwardingObject} implements no such custom interfaces directly; they
 * are implemented only in subclasses. Therefore, forwarding {@code equals}
 * would break symmetry, as the forwarding object might consider itself equal to
 * the object being tested, but the reverse could not be true. This behavior is
 * consistent with the JDK's collection wrappers, such as
 * {@link java.util.Collections#unmodifiableCollection}. Use an
 * interface-specific subclass of {@code ForwardingObject}, such as {@link
 * ForwardingList}, to preserve equality behavior, or override {@code equals}
 * directly.
 *
 * <p>The {@code toString} method is forwarded to the delegate. Although this
 * class does not implement {@link Serializable}, a serializable subclass may be
 * created since this class has a parameter-less constructor.
 *
 * @author Mike Bostock
 * @since 2 (imported from Google Collections Library)
 */
@GwtCompatible
public abstract class ForwardingObject {

  /** Constructor for use by subclasses. */
  protected ForwardingObject() {}

  /**
   * Returns the backing delegate instance that methods are forwarded to.
   * Abstract subclasses generally override this method with an abstract method
   * that has a more specific return type, such as {@link
   * ForwardingSet#delegate}. Concrete subclasses override this method to supply
   * the instance being decorated.
   */
  protected abstract Object delegate();

  /**
   * Returns the string representation generated by the delegate's
   * {@code toString} method.
   */
  @Override public String toString() {
    return delegate().toString();
  }

  /* No equals or hashCode. See class comments for details. */
}
