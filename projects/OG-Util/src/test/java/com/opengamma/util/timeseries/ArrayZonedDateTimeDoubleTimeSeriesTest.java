/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.util.timeseries;

import java.util.List;

import org.testng.annotations.Test;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.util.timeseries.zoneddatetime.ArrayZonedDateTimeDoubleTimeSeries;
import com.opengamma.util.timeseries.zoneddatetime.ZonedDateTimeDoubleTimeSeries;

@Test(groups = "unit")
public class ArrayZonedDateTimeDoubleTimeSeriesTest extends ZonedDateTimeDoubleTimeSeriesTest {

  @Override
  protected ZonedDateTimeDoubleTimeSeries createEmptyTimeSeries() {
    return new ArrayZonedDateTimeDoubleTimeSeries(ZoneOffset.UTC);
  }

  @Override
  protected ZonedDateTimeDoubleTimeSeries createTimeSeries(ZonedDateTime[] times, double[] values) {
    return new ArrayZonedDateTimeDoubleTimeSeries(ZoneOffset.UTC, times, values);
  }

  @Override
  protected ZonedDateTimeDoubleTimeSeries createTimeSeries(List<ZonedDateTime> times, List<Double> values) {
    return new ArrayZonedDateTimeDoubleTimeSeries(ZoneOffset.UTC, times, values);
  }

  @Override
  protected ZonedDateTimeDoubleTimeSeries createTimeSeries(DoubleTimeSeries<ZonedDateTime> dts) {
    return new ArrayZonedDateTimeDoubleTimeSeries(ZoneOffset.UTC, dts);
  }

}
