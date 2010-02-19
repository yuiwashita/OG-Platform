/**
 * Copyright (C) 2009 - 2009 by OpenGamma Inc.
 * 
 * Please see distribution for license.
 */
package com.opengamma.math.statistics.descriptive;

import com.opengamma.math.function.Function1D;

/**
 * 
 * @author emcleod
 */
public class SampleFisherKurtosisCalculator extends Function1D<Double[], Double> {
  private final Function1D<Double[], Double> _mean = new MeanCalculator();
  private final Function1D<Double[], Double> _variance = new PopulationVarianceCalculator();

  @Override
  public Double evaluate(final Double[] x) {
    if (x == null)
      throw new IllegalArgumentException("Array was null");
    if (x.length < 4)
      throw new IllegalArgumentException("Need at least four points to calculate kurtosis");
    double sum = 0;
    final double mean = _mean.evaluate(x);
    final double variance = _variance.evaluate(x);
    for (final Double d : x) {
      sum += Math.pow(d - mean, 4);
    }
    final int n = x.length;
    return n * (n + 1.) * sum / ((n - 1.) * (n - 2.) * (n - 3.) * variance * variance) - 3 * (n - 1.) * (n - 1.) / ((n - 2.) * (n - 3.));
  }
}
