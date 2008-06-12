/*
 Copyright (C) 2007 Richard Gomes

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

package org.jquantlib.testsuite.math.solvers1D;

import static org.junit.Assert.fail;

import org.jquantlib.math.distributions.Derivative;
import org.jquantlib.math.solvers1D.Bisection;
import org.junit.Test;

/**
 * 
 * @author Dominik Holenstein
 *
 */

// TODO Make this test JUnit 4.4 conform.
public class BisectionTest {
	
	public BisectionTest() {
		System.out.println("\n\n::::: "+this.getClass().getSimpleName()+" :::::");
	}
	
	@Test
	public void testNewtonSafe() {
		
		double accuracy = 1.0e-15;
		double guess = 1.5;
		double xMin = 0.0;
		double xMax = 3.0;
		
		final Derivative f = new Derivative() {

			@Override
			public double evaluate(double x) {
				return x*x-1;
			}
			
			@Override
			public double derivative (double x) {
				return 2*x;
			}
		};
		
		Bisection bisection = new Bisection();
		
		double root = bisection.solve(f, accuracy, guess, xMin, xMax);
		
		// assertEquals(1.0, root, accuracy);
		if (Math.abs(1.0-root)> accuracy) {
			fail("expected: 1.0" + " but root is: " + root);
		}
		
		// assertEquals(100, bisection.getMaxEvaluations());
		if(bisection.getMaxEvaluations() != 100){
			fail("expected: 100" + " but was: " + bisection.getMaxEvaluations());
		}
		
		root = bisection.solve(f, accuracy, 0.01, 0.1);

		// assertEquals(1.0, root, accuracy);
		if (Math.abs(1.0-root)> accuracy) {
			fail("expected: 1.0" + " but root is: " + root);
		}
		
		// TODO Check why getNumEvalutions is 56 with guess = 0.01 and step = 0.1
		//assertEquals(56, bisection.getNumEvaluations());
		if(bisection.getNumEvaluations() != 56){
			fail("expected: 56" + " but was: " + bisection.getNumEvaluations());
		}
		
	}
}