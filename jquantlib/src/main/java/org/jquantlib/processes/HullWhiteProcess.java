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

/*
 Copyright (C) 2006 Banca Profilo S.p.A.

 This file is part of QuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://quantlib.org/

 QuantLib is free software: you can redistribute it and/or modify it
 under the terms of the QuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <quantlib-dev@lists.sf.net>. The license is also available online at
 <http://quantlib.org/license.shtml>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.
 */
package org.jquantlib.processes;

import org.jquantlib.QL;
import org.jquantlib.math.Constants;
import org.jquantlib.quotes.Handle;
import org.jquantlib.termstructures.Compounding;
import org.jquantlib.termstructures.YieldTermStructure;
import org.jquantlib.time.Frequency;

/**
 * Hull-White stochastic processes
 * 
 * @category processes
 * 
 * @author Richard Gomes
 */
public class HullWhiteProcess extends StochasticProcess1D {

    protected OrnsteinUhlenbeckProcess   process;
    protected Handle<YieldTermStructure> h;
    protected double                     a;
    protected double                     sigma;

    public HullWhiteProcess(
            final Handle<YieldTermStructure> h,
            final double a,
            final double sigma) {
        super();
        this.process = new OrnsteinUhlenbeckProcess(a, sigma, h.currentLink().forwardRate(0.0, 0.0, Compounding.CONTINUOUS,
                Frequency.NO_FREQUENCY).rate());
        this.h = h;
        this.a = a;
        this.sigma = sigma;
        QL.require(this.a >= 0.0, "negative a given");
        QL.require(this.sigma >= 0.0, "negative sigma given");
    }

    //
    // public methods
    //

    public double a() /* @ReadOnly */{
        return a;
    }

    public double sigma() /* @ReadOnly */{
        return sigma;
    }

    public double alpha(
            /* @Time */final double t) /* @ReadOnly */{
        double alfa = a > Constants.QL_EPSILON ? (sigma / a) * (1 - Math.exp(-a * t)) : sigma * t;
        alfa *= 0.5 * alfa;
        alfa += h.currentLink().forwardRate(t, t, Compounding.CONTINUOUS, Frequency.NO_FREQUENCY).rate();
        return alfa;
    }

    //
    // extends StochasticProcess1D
    //

    @Override
    public double x0() /* @ReadOnly */{
        return process.x0();
    }

    @Override
    public double drift(
            /* @Time */final double t,
            final double x) /* @ReadOnly */{
        double alpha_drift = sigma * sigma / (2 * a) * (1 - Math.exp(-2 * a * t));
        final double shift = 0.0001;
        final double f = h.currentLink().forwardRate(t, t, Compounding.CONTINUOUS, Frequency.NO_FREQUENCY).rate();
        final double fup = h.currentLink().forwardRate(t + shift, t + shift, Compounding.CONTINUOUS, Frequency.NO_FREQUENCY).rate();
        final double f_prime = (fup - f) / shift;
        alpha_drift += a * f + f_prime;
        return process.drift(t, x) + alpha_drift;
    }

    @Override
    public double diffusion(
            /* @Time */final double t,
            final double x) /* @ReadOnly */{
        return process.diffusion(t, x);
    }

    @Override
    public double expectation(
            /* @Time */final double t0,
            final double x0, /* @Time */
            final double dt) /* @ReadOnly */{
        return process.expectation(t0, x0, dt) + alpha(t0 + dt) - alpha(t0) * Math.exp(-a * dt);
    }

    @Override
    public double stdDeviation(
            /* @Time */final double t0,
            final double x0, /* @Time */
            final double dt) /* @ReadOnly */{
        return process.stdDeviation(t0, x0, dt);
    }

    @Override
    public double variance(
            /* @Time */final double t0,
            final double x0, /* @Time */
            final double dt) /* @ReadOnly */{
        return process.variance(t0, x0, dt);
    }

}
