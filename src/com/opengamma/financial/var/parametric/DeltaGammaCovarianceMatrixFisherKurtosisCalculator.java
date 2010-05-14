/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.var.parametric;

import com.opengamma.math.function.Function1D;
import com.opengamma.math.matrix.DoubleMatrix1D;
import com.opengamma.math.matrix.DoubleMatrix2D;
import com.opengamma.math.matrix.Matrix;
import com.opengamma.math.matrix.MatrixAlgebra;

/**
 * 
 */
public class DeltaGammaCovarianceMatrixFisherKurtosisCalculator extends Function1D<ParametricVaRDataBundle, Double> {
  private final MatrixAlgebra _algebra;
  private final Function1D<ParametricVaRDataBundle, Double> _std;
  private static final int FIRST_ORDER = 1;
  private static final int SECOND_ORDER = 2;

  public DeltaGammaCovarianceMatrixFisherKurtosisCalculator(final MatrixAlgebra algebra) {
    if (algebra == null)
      throw new IllegalArgumentException("Matrix algebra calculator was null");
    _algebra = algebra;
    _std = new DeltaGammaCovarianceMatrixStandardDeviationCalculator(algebra);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.opengamma.math.function.Function1D#evaluate(java.lang.Object)
   */
  @Override
  public Double evaluate(final ParametricVaRDataBundle data) {
    if (data == null)
      throw new IllegalArgumentException("Data were null");
    final DoubleMatrix1D delta = (DoubleMatrix1D) data.getSensitivityData(FIRST_ORDER);
    final Matrix<?> gamma = data.getSensitivityData(SECOND_ORDER);
    if (gamma == null || gamma.getNumberOfElements() == 0)
      return 0.;
    final DoubleMatrix2D gammaMatrix = (DoubleMatrix2D) gamma;
    final DoubleMatrix2D deltaCovariance = data.getCovarianceMatrix(FIRST_ORDER);
    if (gammaMatrix.getNumberOfColumns() != deltaCovariance.getNumberOfColumns())
      throw new IllegalArgumentException("Gamma matrix and covariance matrix were incompatible sizes");
    final Matrix<?> product = _algebra.multiply(gammaMatrix, deltaCovariance);
    final double std = _std.evaluate(data);
    final double numerator = _algebra.getTrace(_algebra.getPower(product, 4)) + 12
        * _algebra.getInnerProduct(delta, _algebra.multiply(_algebra.multiply(deltaCovariance, _algebra.getPower(product, 2)), delta)) + 3 * std * std;
    final double denominator = Math.pow(0.5 * _algebra.getTrace(_algebra.getPower(product, 2)) + _algebra.getInnerProduct(delta, _algebra.multiply(deltaCovariance, delta)), 2);
    return numerator / denominator - 3;
  }
}
