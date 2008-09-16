/*
 Copyright (C) 2008 Anand Mani

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

package org.jquantlib.math.interpolation.factories;

import org.jquantlib.math.interpolation.ForwardFlatInterpolation;
import org.jquantlib.math.interpolation.Interpolation;
import org.jquantlib.math.interpolation.Interpolator;

/**
 * This class provides ForwardFlat interpolation factory and traits
 * 
 * @author Anand Mani
 */
public class ForwardFlat implements Interpolator {

	private Interpolator delegate;

	public ForwardFlat() {
		delegate = ForwardFlatInterpolation.getInterpolator();
	}

	//
	// implements Interpolator
	//

	public final Interpolation interpolate(final int size, final double[] x, final double[] y) /* @ReadOnly */{
		return delegate.interpolate(x, y);
	}

	public final Interpolation interpolate(final double[] x, final double[] y) /* @ReadOnly */{
		return delegate.interpolate(x, y);
	}

	public final boolean isGlobal() /* @ReadOnly */{
		return delegate.isGlobal();
	}

}