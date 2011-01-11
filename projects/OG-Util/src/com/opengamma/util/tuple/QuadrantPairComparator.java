/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.util.tuple;

import java.util.Comparator;

/**
 * A comparator for a pair of doubles that evaluates which quadrant the elements are in.
 * <p>
 * This comparator first calculates the quadrant from 1 to 4 for each pair treating
 * the first element as x and the second element as y.
 * If the quadrants differ then the result is returned based on the quadrant value.
 * If the quadrants are equal, {@link FirstThenSecondPairComparator} is used.
 * <p>
 * This comparator does not support {@code null} elements in the pair.
 */
public final class QuadrantPairComparator implements Comparator<Pair<Double, Double>> {

  /**
   * Singleton instance.
   */
  public static final QuadrantPairComparator INSTANCE = new QuadrantPairComparator();

  /**
   * Restrictive constructor.
   */
  private QuadrantPairComparator() {
  }

  @Override
  public int compare(Pair<Double, Double> p1, Pair<Double, Double> p2) {
    if (p1.equals(p2)) {
      return 0;
    }
    int firstQuadrant = getQuadrant(p1);
    int secondQuadrant = getQuadrant(p2);
    if (firstQuadrant == secondQuadrant) {
      return FirstThenSecondPairComparator.INSTANCE_DOUBLES.compare(p1, p2);
    }
    return firstQuadrant < secondQuadrant ? -1 : 1;
  }

  /**
   * Find the correct quadrant using standard numbering.
   * This returns 1 for x and y GE zero, 2 if only x is negative,
   * 3 if both are negative, and 4 if only y is negative.
   * @param pair  the pair to extract from, not null
   * @return the quadrant from 1 to 4
   */
  private int getQuadrant(Pair<Double, Double> pair) {
    double x = pair.getFirst();
    double y = pair.getSecond();
    if (x >= 0) {
      return (y >= 0 ? 1 : 4);
    } else {
      return (y >= 0 ? 2 : 3);
    }
  }

}
