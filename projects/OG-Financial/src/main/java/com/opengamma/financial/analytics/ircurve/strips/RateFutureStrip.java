/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.ircurve.strips;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.id.ExternalId;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.time.Tenor;

/**
 *
 */
@BeanDefinition
public class RateFutureStrip extends CurveStrip {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The future number.
   */
  @PropertyDefinition
  private int _futureNumber;

  /**
   * The start tenor.
   */
  @PropertyDefinition(validate = "notNull")
  private Tenor _startTenor;

  /**
   * The future tenor.
   */
  @PropertyDefinition(validate = "notNull")
  private Tenor _futureTenor;

  /**
   * The underlying tenor.
   */
  @PropertyDefinition(validate = "notNull")
  private Tenor _underlyingTenor;

  /**
   * The future convention.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _futureConvention;

  /**
   * The underlying convention.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _underlyingConvention;

  /* package */ RateFutureStrip() {
    super();
  }

  public RateFutureStrip(final int futureNumber, final Tenor startTenor, final Tenor futureTenor, final Tenor underlyingTenor, final ExternalId futureConvention,
      final ExternalId underlyingConvention, final String curveSpecificationName) {
    super(curveSpecificationName);
    ArgumentChecker.notNegativeOrZero(futureNumber, "future number");
    setFutureNumber(futureNumber);
    setStartTenor(startTenor);
    setFutureTenor(futureTenor);
    setUnderlyingTenor(underlyingTenor);
    setFutureConvention(futureConvention);
    setUnderlyingConvention(underlyingConvention);
  }

  @Override
  protected Tenor getResolvedMaturity() {
    final int m = getFutureTenor().getPeriod().getMonths(); //TODO this is not right
    return new Tenor(getStartTenor().getPeriod().plusMonths(m * getFutureNumber()));
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code RateFutureStrip}.
   * @return the meta-bean, not null
   */
  public static RateFutureStrip.Meta meta() {
    return RateFutureStrip.Meta.INSTANCE;
  }
  static {
    JodaBeanUtils.registerMetaBean(RateFutureStrip.Meta.INSTANCE);
  }

  @Override
  public RateFutureStrip.Meta metaBean() {
    return RateFutureStrip.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(final String propertyName, final boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1052030700:  // futureNumber
        return getFutureNumber();
      case -1583746178:  // startTenor
        return getStartTenor();
      case -515187011:  // futureTenor
        return getFutureTenor();
      case -824175261:  // underlyingTenor
        return getUnderlyingTenor();
      case 1736486292:  // futureConvention
        return getFutureConvention();
      case -268325202:  // underlyingConvention
        return getUnderlyingConvention();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(final String propertyName, final Object newValue, final boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1052030700:  // futureNumber
        setFutureNumber((Integer) newValue);
        return;
      case -1583746178:  // startTenor
        setStartTenor((Tenor) newValue);
        return;
      case -515187011:  // futureTenor
        setFutureTenor((Tenor) newValue);
        return;
      case -824175261:  // underlyingTenor
        setUnderlyingTenor((Tenor) newValue);
        return;
      case 1736486292:  // futureConvention
        setFutureConvention((ExternalId) newValue);
        return;
      case -268325202:  // underlyingConvention
        setUnderlyingConvention((ExternalId) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_startTenor, "startTenor");
    JodaBeanUtils.notNull(_futureTenor, "futureTenor");
    JodaBeanUtils.notNull(_underlyingTenor, "underlyingTenor");
    JodaBeanUtils.notNull(_futureConvention, "futureConvention");
    JodaBeanUtils.notNull(_underlyingConvention, "underlyingConvention");
    super.validate();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      final RateFutureStrip other = (RateFutureStrip) obj;
      return JodaBeanUtils.equal(getFutureNumber(), other.getFutureNumber()) &&
          JodaBeanUtils.equal(getStartTenor(), other.getStartTenor()) &&
          JodaBeanUtils.equal(getFutureTenor(), other.getFutureTenor()) &&
          JodaBeanUtils.equal(getUnderlyingTenor(), other.getUnderlyingTenor()) &&
          JodaBeanUtils.equal(getFutureConvention(), other.getFutureConvention()) &&
          JodaBeanUtils.equal(getUnderlyingConvention(), other.getUnderlyingConvention()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getFutureNumber());
    hash += hash * 31 + JodaBeanUtils.hashCode(getStartTenor());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFutureTenor());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUnderlyingTenor());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFutureConvention());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUnderlyingConvention());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the future number.
   * @return the value of the property
   */
  public int getFutureNumber() {
    return _futureNumber;
  }

  /**
   * Sets the future number.
   * @param futureNumber  the new value of the property
   */
  public void setFutureNumber(final int futureNumber) {
    this._futureNumber = futureNumber;
  }

  /**
   * Gets the the {@code futureNumber} property.
   * @return the property, not null
   */
  public final Property<Integer> futureNumber() {
    return metaBean().futureNumber().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the start tenor.
   * @return the value of the property, not null
   */
  public Tenor getStartTenor() {
    return _startTenor;
  }

  /**
   * Sets the start tenor.
   * @param startTenor  the new value of the property, not null
   */
  public void setStartTenor(final Tenor startTenor) {
    JodaBeanUtils.notNull(startTenor, "startTenor");
    this._startTenor = startTenor;
  }

  /**
   * Gets the the {@code startTenor} property.
   * @return the property, not null
   */
  public final Property<Tenor> startTenor() {
    return metaBean().startTenor().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the future tenor.
   * @return the value of the property, not null
   */
  public Tenor getFutureTenor() {
    return _futureTenor;
  }

  /**
   * Sets the future tenor.
   * @param futureTenor  the new value of the property, not null
   */
  public void setFutureTenor(final Tenor futureTenor) {
    JodaBeanUtils.notNull(futureTenor, "futureTenor");
    this._futureTenor = futureTenor;
  }

  /**
   * Gets the the {@code futureTenor} property.
   * @return the property, not null
   */
  public final Property<Tenor> futureTenor() {
    return metaBean().futureTenor().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying tenor.
   * @return the value of the property, not null
   */
  public Tenor getUnderlyingTenor() {
    return _underlyingTenor;
  }

  /**
   * Sets the underlying tenor.
   * @param underlyingTenor  the new value of the property, not null
   */
  public void setUnderlyingTenor(final Tenor underlyingTenor) {
    JodaBeanUtils.notNull(underlyingTenor, "underlyingTenor");
    this._underlyingTenor = underlyingTenor;
  }

  /**
   * Gets the the {@code underlyingTenor} property.
   * @return the property, not null
   */
  public final Property<Tenor> underlyingTenor() {
    return metaBean().underlyingTenor().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the future convention.
   * @return the value of the property, not null
   */
  public ExternalId getFutureConvention() {
    return _futureConvention;
  }

  /**
   * Sets the future convention.
   * @param futureConvention  the new value of the property, not null
   */
  public void setFutureConvention(final ExternalId futureConvention) {
    JodaBeanUtils.notNull(futureConvention, "futureConvention");
    this._futureConvention = futureConvention;
  }

  /**
   * Gets the the {@code futureConvention} property.
   * @return the property, not null
   */
  public final Property<ExternalId> futureConvention() {
    return metaBean().futureConvention().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying convention.
   * @return the value of the property, not null
   */
  public ExternalId getUnderlyingConvention() {
    return _underlyingConvention;
  }

  /**
   * Sets the underlying convention.
   * @param underlyingConvention  the new value of the property, not null
   */
  public void setUnderlyingConvention(final ExternalId underlyingConvention) {
    JodaBeanUtils.notNull(underlyingConvention, "underlyingConvention");
    this._underlyingConvention = underlyingConvention;
  }

  /**
   * Gets the the {@code underlyingConvention} property.
   * @return the property, not null
   */
  public final Property<ExternalId> underlyingConvention() {
    return metaBean().underlyingConvention().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code RateFutureStrip}.
   */
  public static class Meta extends CurveStrip.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code futureNumber} property.
     */
    private final MetaProperty<Integer> _futureNumber = DirectMetaProperty.ofReadWrite(
        this, "futureNumber", RateFutureStrip.class, Integer.TYPE);
    /**
     * The meta-property for the {@code startTenor} property.
     */
    private final MetaProperty<Tenor> _startTenor = DirectMetaProperty.ofReadWrite(
        this, "startTenor", RateFutureStrip.class, Tenor.class);
    /**
     * The meta-property for the {@code futureTenor} property.
     */
    private final MetaProperty<Tenor> _futureTenor = DirectMetaProperty.ofReadWrite(
        this, "futureTenor", RateFutureStrip.class, Tenor.class);
    /**
     * The meta-property for the {@code underlyingTenor} property.
     */
    private final MetaProperty<Tenor> _underlyingTenor = DirectMetaProperty.ofReadWrite(
        this, "underlyingTenor", RateFutureStrip.class, Tenor.class);
    /**
     * The meta-property for the {@code futureConvention} property.
     */
    private final MetaProperty<ExternalId> _futureConvention = DirectMetaProperty.ofReadWrite(
        this, "futureConvention", RateFutureStrip.class, ExternalId.class);
    /**
     * The meta-property for the {@code underlyingConvention} property.
     */
    private final MetaProperty<ExternalId> _underlyingConvention = DirectMetaProperty.ofReadWrite(
        this, "underlyingConvention", RateFutureStrip.class, ExternalId.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "futureNumber",
        "startTenor",
        "futureTenor",
        "underlyingTenor",
        "futureConvention",
        "underlyingConvention");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(final String propertyName) {
      switch (propertyName.hashCode()) {
        case 1052030700:  // futureNumber
          return _futureNumber;
        case -1583746178:  // startTenor
          return _startTenor;
        case -515187011:  // futureTenor
          return _futureTenor;
        case -824175261:  // underlyingTenor
          return _underlyingTenor;
        case 1736486292:  // futureConvention
          return _futureConvention;
        case -268325202:  // underlyingConvention
          return _underlyingConvention;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends RateFutureStrip> builder() {
      return new DirectBeanBuilder<RateFutureStrip>(new RateFutureStrip());
    }

    @Override
    public Class<? extends RateFutureStrip> beanType() {
      return RateFutureStrip.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code futureNumber} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Integer> futureNumber() {
      return _futureNumber;
    }

    /**
     * The meta-property for the {@code startTenor} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Tenor> startTenor() {
      return _startTenor;
    }

    /**
     * The meta-property for the {@code futureTenor} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Tenor> futureTenor() {
      return _futureTenor;
    }

    /**
     * The meta-property for the {@code underlyingTenor} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Tenor> underlyingTenor() {
      return _underlyingTenor;
    }

    /**
     * The meta-property for the {@code futureConvention} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> futureConvention() {
      return _futureConvention;
    }

    /**
     * The meta-property for the {@code underlyingConvention} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> underlyingConvention() {
      return _underlyingConvention;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
