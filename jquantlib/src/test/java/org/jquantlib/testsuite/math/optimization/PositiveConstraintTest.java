/*
 Copyright (C) 2008 
  
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

package org.jquantlib.testsuite.math.optimization;

import static org.junit.Assert.fail;

import org.jquantlib.math.Closeness;
import org.jquantlib.math.matrixutilities.Array;
import org.jquantlib.math.optimization.PositiveConstraint;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 */

//TODO: comments, license, code review
public class PositiveConstraintTest {

    private final static Logger logger = LoggerFactory.getLogger(PositiveConstraintTest.class);

    private final PositiveConstraint pc;

    public PositiveConstraintTest() {
        logger.info("\n\n::::: " + this.getClass().getSimpleName() + " :::::");
        this.pc = new PositiveConstraint();
    }

    @Test
    public void testTest() {
        if (!pc.test(new Array()))
            fail("PositiveConstraint test method failed");
    }

    @Test
    public void testUpdate() {
        Array params = new Array(new double[] { 1.0, 1.1, 1.3 });
        Array direction = new Array(new double[] { 0.1, 0.3, 1.1 });
        double beta = -2.0;
        pc.update(params, direction, beta);
        logger.info("params after co.update = {}", params);
        
        // if (!params.operatorEquals(new double[]{0.9,0.8,0.2}))
        if (!isArrayEqual(params, new Array(new double[] { 0.9, 0.8, 0.2 }), 0.000001))
            fail("PositiveConstraint update method failed");
    }

    private boolean isArrayEqual(Array one, Array two, double precision) {
        Array diffArray = one.sub(two);
        logger.info("diffArray = {}", diffArray);
        return Closeness.isCloseEnough(diffArray.dotProduct(diffArray), precision * precision);
    }
    
}
