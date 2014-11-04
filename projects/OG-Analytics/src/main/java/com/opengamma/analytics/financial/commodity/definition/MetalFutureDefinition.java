/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.analytics.financial.commodity.definition;

import org.threeten.bp.ZonedDateTime;

import com.opengamma.analytics.financial.commodity.derivative.MetalFuture;
import com.opengamma.analytics.financial.instrument.InstrumentDefinitionVisitor;
import com.opengamma.analytics.util.time.TimeCalculator;
import com.opengamma.id.ExternalId;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.money.Currency;

/**
 * Metal future definition
 */
public class MetalFutureDefinition extends CommodityFutureDefinition<MetalFuture> {

  /**
   * Constructor for futures with delivery dates (i.e. physical settlement)
   *
   * @param expiryDate  the time and the day that a particular delivery month of a futures contract stops trading, as well as the final settlement price for that contract
   * @param underlying  identifier of the underlying commodity
   * @param unitAmount  size of a unit
   * @param firstDeliveryDate  date of first delivery - PHYSICAL settlement
   * @param lastDeliveryDate  date of last delivery - PHYSICAL settlement
   * @param amount  number of units
   * @param unitName  description of unit size
   * @param settlementType  settlement type - PHYSICAL or CASH
   * @param referencePrice reference price
   * @param currency currency
   * @param settlementDate settlement date
   */
  public MetalFutureDefinition(final ZonedDateTime expiryDate, final ExternalId underlying, final double unitAmount, final ZonedDateTime firstDeliveryDate,
      final ZonedDateTime lastDeliveryDate, final double amount, final String unitName,
      final SettlementType settlementType, final double referencePrice, final Currency currency, final ZonedDateTime settlementDate) {
    super(expiryDate, underlying, unitAmount, firstDeliveryDate, lastDeliveryDate, amount, unitName, settlementType, referencePrice, currency, settlementDate);
  }

  /**
   * Constructor for futures without delivery dates (e.g. cash settlement)
   *
   * @param expiryDate  the time and the day that a particular delivery month of a futures contract stops trading, as well as the final settlement price for that contract
   * @param underlying  identifier of the underlying commodity
   * @param unitAmount  size of a unit
   * @param amount  number of units
   * @param unitName description of unit size
   * @param referencePrice reference price
   * @param currency currency
   * @param settlementDate settlement date
   */
  public MetalFutureDefinition(final ZonedDateTime expiryDate, final ExternalId underlying, final double unitAmount, final double amount, final String unitName, final double referencePrice,
      final Currency currency, final ZonedDateTime settlementDate) {
    this(expiryDate, underlying, unitAmount, null, null, amount, unitName, SettlementType.CASH, referencePrice, currency, settlementDate);
  }

  /**
   * Static constructor method for cash settled future
   *
   * @param expiryDate  the time and the day that a particular delivery month of a forwards contract stops trading, as well as the final settlement price for that contract
   * @param underlying  identifier of the underlying commodity
   * @param unitAmount  size of a unit
   * @param amount  number of units
   * @param unitName  description of unit size
   * @param referencePrice Number of units
   * @param currency Currency
   * @param settlementDate Settlement date
   * @return the forward
   */
  public static MetalFutureDefinition withCashSettlement(final ZonedDateTime expiryDate, final ExternalId underlying, final double unitAmount, final double amount, final String unitName,
      final double referencePrice, final Currency currency, final ZonedDateTime settlementDate) {
    return new MetalFutureDefinition(expiryDate, underlying, unitAmount, null, null, amount, unitName, SettlementType.CASH, referencePrice, currency, settlementDate);
  }

  /**
   * Static constructor method for physical settlement futures
   *
   * @param expiryDate  the time and the day that a particular delivery month of a forwards contract stops trading, as well as the final settlement price for that contract
   * @param underlying  identifier of the underlying commodity
   * @param unitAmount  size of a unit
   * @param firstDeliveryDate  date of first delivery - PHYSICAL settlement
   * @param lastDeliveryDate  date of last delivery - PHYSICAL settlement
   * @param amount  number of units
   * @param unitName  description of unit size
   * @param referencePrice reference price
   * @param currency currency
   * @param settlementDate settlement date
   * @return the forward
   */
  public static MetalFutureDefinition withPhysicalSettlement(final ZonedDateTime expiryDate, final ExternalId underlying, final double unitAmount,
      final ZonedDateTime firstDeliveryDate, final ZonedDateTime lastDeliveryDate,
      final double amount, final String unitName, final double referencePrice, final Currency currency, final ZonedDateTime settlementDate) {
    return new MetalFutureDefinition(expiryDate, underlying, unitAmount, firstDeliveryDate, lastDeliveryDate, amount, unitName, SettlementType.PHYSICAL, referencePrice, currency, settlementDate);
  }

  /**
   * {@inheritDoc}
   * @deprecated Use the method that does not take yield curve names.
   */
  @Deprecated
  @Override
  public MetalFuture toDerivative(final ZonedDateTime date, final String... yieldCurveNames) {
    throw new UnsupportedOperationException();
  }

  /**
   * {@inheritDoc}
   * @deprecated Use the method that does not take yield curve names.
   */
  @Deprecated
  @Override
  public MetalFuture toDerivative(final ZonedDateTime date, final Double referencePrice, final String... yieldCurveNames) {
    return toDerivative(date, referencePrice);
  }

  @Override
  public MetalFuture toDerivative(final ZonedDateTime date) {
    ArgumentChecker.inOrderOrEqual(date, this.getExpiryDate(), "date", "expiry date");
    final double timeToFixing = TimeCalculator.getTimeBetween(date, this.getExpiryDate());
    final double timeToSettlement = TimeCalculator.getTimeBetween(date, this.getSettlementDate());
    return new MetalFuture(timeToFixing, getUnderlying(), getUnitAmount(), getFirstDeliveryDate(), getLastDeliveryDate(), getAmount(), getUnitName(), getSettlementType(), timeToSettlement,
        getReferencePrice(), getCurrency());
  }

  @Override
  public MetalFuture toDerivative(final ZonedDateTime date, final Double referencePrice) {
    ArgumentChecker.inOrderOrEqual(date, this.getExpiryDate(), "date", "expiry date");
    final double timeToFixing = TimeCalculator.getTimeBetween(date, this.getExpiryDate());
    final double timeToSettlement = TimeCalculator.getTimeBetween(date, this.getSettlementDate());
    return new MetalFuture(timeToFixing, getUnderlying(), getUnitAmount(), getFirstDeliveryDate(), getLastDeliveryDate(), getAmount(), getUnitName(), getSettlementType(), timeToSettlement,
        referencePrice.doubleValue(), getCurrency());
  }

  @Override
  public <U, V> V accept(final InstrumentDefinitionVisitor<U, V> visitor, final U data) {
    ArgumentChecker.notNull(visitor, "visitor");
    return visitor.visitMetalFutureDefinition(this, data);
  }

  @Override
  public <V> V accept(final InstrumentDefinitionVisitor<?, V> visitor) {
    ArgumentChecker.notNull(visitor, "visitor");
    return visitor.visitMetalFutureDefinition(this);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof MetalFutureDefinition)) {
      return false;
    }
    return super.equals(obj);
  }


}
