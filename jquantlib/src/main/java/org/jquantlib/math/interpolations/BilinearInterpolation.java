/*
 Copyright (C) 2008 Richard Gomes

 This source code is release under the BSD License.
 
 This file is part of JQuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://jquantlib.org/

 JQuantLib is free software: you can redistribute it and/or modify it
 under the terms of the JQuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <jquant-devel@lists.sourceforge.net>. The license is also available online at
 <http://www.jquantlib.org/index.php/LICENSE.TXT>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.
 
 JQuantLib is based on QuantLib. http://quantlib.org/
 When applicable, the original copyright notice follows this notice.
 */

package org.jquantlib.math.interpolations;

import org.jquantlib.math.interpolations.factories.Bilinear;
import org.jquantlib.math.matrixutilities.Array;
import org.jquantlib.math.matrixutilities.Matrix;


/**
 * Bilinear interpolation between discrete points
 * <p>
 * Interpolations are not instantiated directly by applications, but via a factory class.
 *
 * @see Bilinear
 * 
 * @author Richard Gomes
 */
public class BilinearInterpolation extends AbstractInterpolation2D {

    //
    // private constructors
    //
    
    /**
     * Constructor for a bilinear interpolation between discrete points
     * <p>
     * Interpolations are not instantiated directly by applications, but via a factory class.
     * 
     * @see Bilinear
     */
    private BilinearInterpolation() {
    	// access denied to public default constructor
	}

	
    //
    // static methods
    //
    
    /**
     * This is a factory method intended to create this interpolation.
     * 
     * @see Bilinear
     */
    static public Interpolator2D getInterpolator() {
        BilinearInterpolation bilinearInterpolation = new BilinearInterpolation();
        return new BilinearInterpolationImpl(bilinearInterpolation);
    }

    
    //
    // overrides AbstractInterpolation2D
    //
    
    @Override
    public double evaluateImpl(double x, double y) /* @ReadOnly */{
        int i = locateX(x);
        int j = locateY(y);

        double z1 = mz.get(j, i);
        double z2 = mz.get(j, i+1);
        double z3 = mz.get(j+1, i);
        double z4 = mz.get(j+1, i+1);

        double t = (x - vx.get(i)) / (vx.get(i+1) - vx.get(i));
        double u = (y - vy.get(j)) / (vy.get(j+1) - vy.get(j));

        return (1.0 - t) * (1.0 - u) * z1 + t * (1.0 - u) * z2 + (1.0 - t) * u * z3 + t * u * z4;
    }

    
	//
    // inner classes
    //
    
    /**
	 * This class is a default implementation for {@link BilinearInterpolation} instances.
	 * 
	 * @author Richard Gomes
	 */
	private static class BilinearInterpolationImpl implements Interpolator2D {
		private BilinearInterpolation delegate;
		
		public BilinearInterpolationImpl(final BilinearInterpolation delegate) {
			this.delegate = delegate;
		}

		@Override
		public Interpolation2D interpolate(final Array x, final Array y, final Matrix z) {
			delegate.vx = x;
			delegate.vy = y;
			delegate.mz = z;
			delegate.reload();
			return delegate;
		}

	}

}
