/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.function.scenarios;

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
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.util.ArgumentChecker;

/**
 * Key for {@link ScenarioArgument} instances used in {@link ScenarioDefinition}.
 */
@BeanDefinition
public class ScenarioArgumentKey implements ImmutableBean {

  /** The name of the column or output to which the argument applies. */
  @PropertyDefinition(validate = "notEmpty")
  private final String _name;

  /** The scenario function that consumes the argument. */
  @PropertyDefinition(validate = "notNull")
  private final Class<? extends ScenarioFunction<?>> _functionType;

  @ImmutableConstructor
  public ScenarioArgumentKey(String name, Class<? extends ScenarioFunction<?>> functionType) {
    _name = ArgumentChecker.notEmpty(name, "name");
    _functionType = ArgumentChecker.notNull(functionType, "functionType");
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ScenarioArgumentKey}.
   * @return the meta-bean, not null
   */
  public static ScenarioArgumentKey.Meta meta() {
    return ScenarioArgumentKey.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ScenarioArgumentKey.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ScenarioArgumentKey.Builder builder() {
    return new ScenarioArgumentKey.Builder();
  }

  @Override
  public ScenarioArgumentKey.Meta metaBean() {
    return ScenarioArgumentKey.Meta.INSTANCE;
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
   * Gets the name of the column or output to which the argument applies.
   * @return the value of the property, not empty
   */
  public String getName() {
    return _name;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the scenario function that consumes the argument.
   * @return the value of the property, not null
   */
  public Class<? extends ScenarioFunction<?>> getFunctionType() {
    return _functionType;
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
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ScenarioArgumentKey other = (ScenarioArgumentKey) obj;
      return JodaBeanUtils.equal(getName(), other.getName()) &&
          JodaBeanUtils.equal(getFunctionType(), other.getFunctionType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getName());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFunctionType());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("ScenarioArgumentKey{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("name").append('=').append(JodaBeanUtils.toString(getName())).append(',').append(' ');
    buf.append("functionType").append('=').append(JodaBeanUtils.toString(getFunctionType())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ScenarioArgumentKey}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code name} property.
     */
    private final MetaProperty<String> _name = DirectMetaProperty.ofImmutable(
        this, "name", ScenarioArgumentKey.class, String.class);
    /**
     * The meta-property for the {@code functionType} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Class<? extends ScenarioFunction<?>>> _functionType = DirectMetaProperty.ofImmutable(
        this, "functionType", ScenarioArgumentKey.class, (Class) Class.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "name",
        "functionType");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return _name;
        case -211170510:  // functionType
          return _functionType;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ScenarioArgumentKey.Builder builder() {
      return new ScenarioArgumentKey.Builder();
    }

    @Override
    public Class<? extends ScenarioArgumentKey> beanType() {
      return ScenarioArgumentKey.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code name} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> name() {
      return _name;
    }

    /**
     * The meta-property for the {@code functionType} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Class<? extends ScenarioFunction<?>>> functionType() {
      return _functionType;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return ((ScenarioArgumentKey) bean).getName();
        case -211170510:  // functionType
          return ((ScenarioArgumentKey) bean).getFunctionType();
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
   * The bean-builder for {@code ScenarioArgumentKey}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<ScenarioArgumentKey> {

    private String _name;
    private Class<? extends ScenarioFunction<?>> _functionType;

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(ScenarioArgumentKey beanToCopy) {
      this._name = beanToCopy.getName();
      this._functionType = beanToCopy.getFunctionType();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          return _name;
        case -211170510:  // functionType
          return _functionType;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3373707:  // name
          this._name = (String) newValue;
          break;
        case -211170510:  // functionType
          this._functionType = (Class<? extends ScenarioFunction<?>>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ScenarioArgumentKey build() {
      return new ScenarioArgumentKey(
          _name,
          _functionType);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code name} property in the builder.
     * @param name  the new value, not empty
     * @return this, for chaining, not null
     */
    public Builder name(String name) {
      JodaBeanUtils.notEmpty(name, "name");
      this._name = name;
      return this;
    }

    /**
     * Sets the {@code functionType} property in the builder.
     * @param functionType  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder functionType(Class<? extends ScenarioFunction<?>> functionType) {
      JodaBeanUtils.notNull(functionType, "functionType");
      this._functionType = functionType;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("ScenarioArgumentKey.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("name").append('=').append(JodaBeanUtils.toString(_name)).append(',').append(' ');
      buf.append("functionType").append('=').append(JodaBeanUtils.toString(_functionType)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
