/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.graph;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.inject.Provider;

import com.opengamma.sesame.engine.ComponentMap;
import com.opengamma.sesame.function.Parameter;
import com.opengamma.util.ArgumentChecker;

/**
 * TODO isValid()? all impls except exceptionNode return true?
 */
public abstract class Node {

  /** the parameter this node satisfies, null if it's the root node */
  private final Parameter _parameter;
  /** The expected type of the object created by this node, not null. */
  private final Class<?> _type;

  protected Node(Class<?> type, Parameter parameter) {
    _type = ArgumentChecker.notNull(type, "type");
    _parameter = parameter;
  }

  /**
   * Returns the object represented by the node, creating if necessary.
   * If this node's object is a {@link Provider} this method should return it, not the results of calling
   * {@link Provider#get()}. This class will use the expected type to decide whether to call {@code get()} or
   * to inject the provider instance directly.
   * @param componentMap Infrastructure components
   * @param dependencies This node's dependencies
   * @return The object represented by this node
   */
  protected abstract Object doCreate(ComponentMap componentMap, List<Object> dependencies);

  public Object create(ComponentMap componentMap, List<Object> dependencies) {
    Object object = doCreate(componentMap, dependencies);
    if (!(object instanceof Provider)) {
      return object;
    }
    // TODO some slightly more robust checking of compatibility of types
    // TODO what's the logic I actually need here?
    if (Provider.class.isAssignableFrom(_type)) {
      return object;
    } else {
      return ((Provider) object).get();
    }
  }

  public List<Node> getDependencies() {
    return Collections.emptyList();
  }

  public String prettyPrint() {
    return toString();
  }

  public Parameter getParameter() {
    return _parameter;
  }

  protected final String getParameterName() {
    if (getParameter() == null) {
      return "";
    } else {
      return getParameter().getName() + ": ";
    }
  }

  public Class<?> getType() {
    return _type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(_type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final Node other = (Node) obj;
    return Objects.equals(this._type, other._type);
  }
}
