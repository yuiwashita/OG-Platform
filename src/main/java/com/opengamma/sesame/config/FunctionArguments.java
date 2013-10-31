/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableConstructor;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.BasicImmutableBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableMap;

/**
 *
 */
@BeanDefinition
public final class FunctionArguments implements ImmutableBean {

  public static final FunctionArguments EMPTY = new FunctionArguments(Collections.<String, Object>emptyMap());

  /**
   * User-specified function arguments keyed by parameter name.
   * TODO should these be the real objects or the string representation?
   */
  @PropertyDefinition(validate = "notNull")
  private final Map<String, Object> _arguments;

  @ImmutableConstructor
  public FunctionArguments(Map<String, Object> arguments) {
    JodaBeanUtils.notNull(arguments, "arguments");
    _arguments = ImmutableMap.copyOf(arguments);
  }

  public boolean hasArgument(String parameterName) {
    return _arguments.containsKey(parameterName);
  }

  public Object getArgument(String parameterName) {
    return _arguments.get(parameterName);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code FunctionArguments}.
   * @return the meta-bean, not null
   */
  public static FunctionArguments.Meta meta() {
    return FunctionArguments.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(FunctionArguments.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   *
   * @return the builder, not null
   */
  public static FunctionArguments.Builder builder() {
    return new FunctionArguments.Builder();
  }

  @Override
  public FunctionArguments.Meta metaBean() {
    return FunctionArguments.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets user-specified function arguments keyed by parameter name.
   * TODO should these be the real objects or the string representation?
   * @return the value of the property, not null
   */
  public Map<String, Object> getArguments() {
    return _arguments;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public FunctionArguments clone() {
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      FunctionArguments other = (FunctionArguments) obj;
      return JodaBeanUtils.equal(getArguments(), other.getArguments());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getArguments());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("FunctionArguments{");
    buf.append("arguments").append('=').append(JodaBeanUtils.toString(getArguments()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code FunctionArguments}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code arguments} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Map<String, Object>> _arguments = DirectMetaProperty.ofImmutable(
        this, "arguments", FunctionArguments.class, (Class) Map.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "arguments");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -2035517098:  // arguments
          return _arguments;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public FunctionArguments.Builder builder() {
      return new FunctionArguments.Builder();
    }

    @Override
    public Class<? extends FunctionArguments> beanType() {
      return FunctionArguments.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code arguments} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Map<String, Object>> arguments() {
      return _arguments;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -2035517098:  // arguments
          return ((FunctionArguments) bean).getArguments();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code FunctionArguments}.
   */
  public static final class Builder extends BasicImmutableBeanBuilder<FunctionArguments> {

    private Map<String, Object> _arguments = new HashMap<String, Object>();

    /**
     * Restricted constructor.
     */
    private Builder() {
      super(FunctionArguments.Meta.INSTANCE);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(FunctionArguments beanToCopy) {
      super(FunctionArguments.Meta.INSTANCE);
      this._arguments = new HashMap<String, Object>(beanToCopy.getArguments());
    }

    //-----------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -2035517098:  // arguments
          this._arguments = (Map<String, Object>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public FunctionArguments build() {
      return new FunctionArguments(
          _arguments);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code arguments} property in the builder.
     * @param arguments  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder arguments(Map<String, Object> arguments) {
      JodaBeanUtils.notNull(arguments, "arguments");
      this._arguments = arguments;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("FunctionArguments.Builder{");
      buf.append("arguments").append('=').append(_arguments);
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
