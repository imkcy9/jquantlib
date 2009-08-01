/*
 Copyright (C) 2007 Joon Tiang Heng

 This file is part of JQuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://jquantlib.org/

 JQuantLib is free software: you can redistribute it and/or modify it
 under the terms of the QuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <jquant-devel@lists.sourceforge.net>. The license is also available online at
 <http://www.jquantlib.org/index.php/LICENSE.TXT>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.

 JQuantLib is based on QuantLib. http://quantlib.org/
 When applicable, the original copyright notice follows this notice.
 */

package org.jquantlib.math.optimization;

import org.jquantlib.math.matrixutilities.Array;

/**
 * Base constraint class
 * 
 * @author Joon Tiang Heng
 */
//TODO: comments, license, code review
public abstract class Constraint {

    public abstract boolean test(final Array p);

    // take note of precision error when comparing Arrays, only compare difference dot product
    // this is due to representation of numbers such as 0.1 in binary
    public double update(final Array params, final Array direction, final double beta) {
        final boolean forever = true;

        double diff = beta;
        int icount = 0;
        do {
            final Array newParams = params.add(direction.mul(diff));
            if (test(newParams)) break;
            if (icount++ > 200) throw new ArithmeticException("can't update parameter vector"); // TODO: message
            diff *= 0.5;
        } while (forever);

        params.addAssign(direction.mul(diff));
        return diff;
    }

}
