/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.var.parametric;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import com.opengamma.financial.sensitivity.Sensitivity;
import com.opengamma.math.function.Function1D;
import com.opengamma.math.matrix.ColtMatrixAlgebra;
import com.opengamma.math.matrix.DoubleMatrix1D;
import com.opengamma.math.matrix.DoubleMatrix2D;
import com.opengamma.math.matrix.Matrix;
import com.opengamma.math.matrix.MatrixAlgebra;

/**
 * @author emcleod
 * 
 */
public class DeltaCovarianceMatrixStandardDeviationCalculatorTest {
  private static final MatrixAlgebra ALGEBRA = new ColtMatrixAlgebra();
  private static final Function1D<ParametricVaRDataBundle, Double> F = new DeltaCovarianceMatrixStandardDeviationCalculator(ALGEBRA);
  private static final DoubleMatrix1D EMPTY_VECTOR = new DoubleMatrix1D(new double[0]);
  private static final DoubleMatrix1D VECTOR = new DoubleMatrix1D(new double[] { 3 });
  private static final DoubleMatrix2D MATRIX = new DoubleMatrix2D(new double[][] { new double[] { 5 } });

  @Test(expected = IllegalArgumentException.class)
  public void testNullAlgebra() {
    new DeltaCovarianceMatrixStandardDeviationCalculator(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullData() {
    F.evaluate((ParametricWithMeanVaRDataBundle) null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyValueDeltaVector() {
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR),
        Collections.<Sensitivity, Matrix<?>> singletonMap(Sensitivity.VALUE_DELTA, EMPTY_VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(Sensitivity.VALUE_DELTA,
            MATRIX));
    F.evaluate(data);
  }

  @Test
  public void test() {
    final ParametricWithMeanVaRDataBundle data = new ParametricWithMeanVaRDataBundle(Collections.<Sensitivity, DoubleMatrix1D> singletonMap(Sensitivity.VALUE_DELTA, VECTOR),
        Collections.<Sensitivity, Matrix<?>> singletonMap(Sensitivity.VALUE_DELTA, VECTOR), Collections.<Sensitivity, DoubleMatrix2D> singletonMap(Sensitivity.VALUE_DELTA, MATRIX));
    assertEquals(F.evaluate(data), Math.sqrt(45), 1e-9);
  }
}
