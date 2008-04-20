/*
 Copyright (C) 2007 Richard Gomes

 This file is part of JQuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://jquantlib.org/

 JQuantLib is free software: you can redistribute it and/or modify it
 under the terms of the QuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <jquantlib-dev@lists.sf.net>. The license is also available online at
 <http://jquantlib.org/license.shtml>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.
 
 JQuantLib is based on QuantLib. http://quantlib.org/
 When applicable, the originating copyright notice follows below.
 */

/*
 Copyright (C) 2003 RiskMap srl

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

package org.jquantlib.testsuite.termstructures;

import org.jquantlib.termstructures.YieldTermStructure;
import org.jquantlib.time.Calendar;
import org.jquantlib.time.TimeUnit;

public class TermStructuresTest {

	
	//
	// global data
	//
	private Calendar calendar_;
	private int settlementDays_;
	private YieldTermStructure termStructure_;
	private YieldTermStructure dummyTermStructure_;

	
	//
	// utilities
	//
	private class Datum {
	    public int n;
	    public TimeUnit units;
	    public /*@Rate*/ double rate;
	}

	
//	void setup() {
//	    calendar_ = Target.getCalendar();
//	    settlementDays_ = 2;
//	    Date today = calendar_.adjust(Date::todaysDate());
//	    Settings::instance().evaluationDate() = today;
//	    Date settlement = calendar_.advance(today,settlementDays_,Days);
//	    Datum depositData[] = {
//	        { 1, Months, 4.581 },
//	        { 2, Months, 4.573 },
//	        { 3, Months, 4.557 },
//	        { 6, Months, 4.496 },
//	        { 9, Months, 4.490 }
//	    };
//	    Datum swapData[] = {
//	        {  1, Years, 4.54 },
//	        {  5, Years, 4.99 },
//	        { 10, Years, 5.47 },
//	        { 20, Years, 5.89 },
//	        { 30, Years, 5.96 }
//	    };
//	    Size deposits = LENGTH(depositData),
//	         swaps = LENGTH(swapData);
//
//	    std::vector<boost::shared_ptr<RateHelper> > instruments(deposits+swaps);
//	    Size i;
//	    for (i=0; i<deposits; i++) {
//	        instruments[i] = boost::shared_ptr<RateHelper>(
//	                 new DepositRateHelper(depositData[i].rate/100,
//	                                       depositData[i].n*depositData[i].units,
//	                                       settlementDays_, calendar_,
//	                                       ModifiedFollowing, true,
//	                                       settlementDays_, Actual360()));
//	    }
//	    boost::shared_ptr<IborIndex> index(new IborIndex("dummy",
//	                                             6*Months,
//	                                             settlementDays_,
//	                                             Currency(),
//	                                             calendar_,
//	                                             ModifiedFollowing,
//	                                             false,
//	                                             Actual360()));
//	    for (i=0; i<swaps; i++) {
//	        instruments[i+deposits] = boost::shared_ptr<RateHelper>(
//	                          new SwapRateHelper(swapData[i].rate/100,
//	                                             swapData[i].n*swapData[i].units,
//	                                             settlementDays_, calendar_,
//	                                             Annual, Unadjusted, Thirty360(),
//	                                             index));
//	    }
//	    termStructure_ = boost::shared_ptr<YieldTermStructure>(
//	                    new PiecewiseYieldCurve<Discount,LogLinear>(settlement,
//	                                                                instruments,
//	                                                                Actual360()));
//	    dummyTermStructure_ = boost::shared_ptr<YieldTermStructure>(
//	                    new PiecewiseYieldCurve<Discount,LogLinear>(settlement,
//	                                                                instruments,
//	                                                                Actual360()));
//	}
//
//	void teardown() {
//	    Settings::instance().evaluationDate() = Date();
//	}
//
////	QL_END_TEST_LOCALS(TermStructureTest)
////
////
//	void TermStructureTest::testReferenceChange() {
//
//	    BOOST_MESSAGE("Testing term structure against evaluation date change...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    termStructure_ = boost::shared_ptr<YieldTermStructure>(
//	         new FlatForward(settlementDays_, NullCalendar(), 0.03, Actual360()));
//
//	    Date today = Settings::instance().evaluationDate();
//	    Integer days[] = { 10, 30, 60, 120, 360, 720 };
//	    Size i;
//
//	    std::vector<DiscountFactor> expected(LENGTH(days));
//	    for (i=0; i<LENGTH(days); i++)
//	        expected[i] = termStructure_->discount(today+days[i]);
//
//	    Settings::instance().evaluationDate() = today+30;
//	    std::vector<DiscountFactor> calculated(LENGTH(days));
//	    for (i=0; i<LENGTH(days); i++)
//	        calculated[i] = termStructure_->discount(today+30+days[i]);
//
//	    for (i=0; i<LENGTH(days); i++) {
//	        if (!close(expected[i],calculated[i]))
//	            BOOST_ERROR("\n  Discount at " << days[i] << " days:\n"
//	                        << std::setprecision(12)
//	                        << "    before date change: " << expected[i] << "\n"
//	                        << "    after date change:  " << calculated[i]);
//	    }
//
//	    QL_TEST_TEARDOWN
//	}

	
	
	
	
	
	
	
	
//
//	void TermStructureTest::testImplied() {
//
//	    BOOST_MESSAGE("Testing consistency of implied term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    Real tolerance = 1.0e-10;
//	    Date today = Settings::instance().evaluationDate();
//	    Date newToday = today + 3*Years;
//	    Date newSettlement = calendar_.advance(newToday,settlementDays_,Days);
//	    Date testDate = newSettlement + 5*Years;
//	    boost::shared_ptr<YieldTermStructure> implied(
//	        new ImpliedTermStructure(Handle<YieldTermStructure>(termStructure_),
//	                                 newSettlement));
//	    DiscountFactor baseDiscount = termStructure_->discount(newSettlement);
//	    DiscountFactor discount = termStructure_->discount(testDate);
//	    DiscountFactor impliedDiscount = implied->discount(testDate);
//	    if (std::fabs(discount - baseDiscount*impliedDiscount) > tolerance)
//	        BOOST_ERROR(
//	            "unable to reproduce discount from implied curve\n"
//	            << QL_FIXED << std::setprecision(10)
//	            << "    calculated: " << baseDiscount*impliedDiscount << "\n"
//	            << "    expected:   " << discount);
//
//	    QL_TEST_TEARDOWN
//	}

//	void TermStructureTest::testImpliedObs() {
//
//	    BOOST_MESSAGE("Testing observability of implied term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    Date today = Settings::instance().evaluationDate();
//	    Date newToday = today + 3*Years;
//	    Date newSettlement = calendar_.advance(newToday,settlementDays_,Days);
//	    RelinkableHandle<YieldTermStructure> h;
//	    boost::shared_ptr<YieldTermStructure> implied(
//	                                  new ImpliedTermStructure(h, newSettlement));
//	    Flag flag;
//	    flag.registerWith(implied);
//	    h.linkTo(termStructure_);
//	    if (!flag.isUp())
//	        BOOST_ERROR("Observer was not notified of term structure change");
//
//	    QL_TEST_TEARDOWN
//	}
//
//	void TermStructureTest::testFSpreaded() {
//
//	    BOOST_MESSAGE("Testing consistency of forward-spreaded term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    Real tolerance = 1.0e-10;
//	    boost::shared_ptr<Quote> me(new SimpleQuote(0.01));
//	    Handle<Quote> mh(me);
//	    boost::shared_ptr<YieldTermStructure> spreaded(
//	        new ForwardSpreadedTermStructure(
//	            Handle<YieldTermStructure>(termStructure_),mh));
//	    Date testDate = termStructure_->referenceDate() + 5*Years;
//	    DayCounter tsdc  = termStructure_->dayCounter();
//	    DayCounter sprdc = spreaded->dayCounter();
//	    Rate forward = termStructure_->forwardRate(testDate, testDate, tsdc,
//	                                               Continuous, NoFrequency);
//	    Rate spreadedForward = spreaded->forwardRate(testDate, testDate, sprdc,
//	                                                 Continuous, NoFrequency);
//	    if (std::fabs(forward - (spreadedForward-me->value())) > tolerance)
//	        BOOST_ERROR(
//	            "unable to reproduce forward from spreaded curve\n"
//	            << std::setprecision(10)
//	            << "    calculated: "
//	            << io::rate(spreadedForward-me->value()) << "\n"
//	            << "    expected:   " << io::rate(forward));
//
//	    QL_TEST_TEARDOWN
//	}
//
//	void TermStructureTest::testFSpreadedObs() {
//
//	    BOOST_MESSAGE("Testing observability of forward-spreaded "
//	                  "term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    boost::shared_ptr<SimpleQuote> me(new SimpleQuote(0.01));
//	    Handle<Quote> mh(me);
//	    RelinkableHandle<YieldTermStructure> h; //(dummyTermStructure_);
//	    boost::shared_ptr<YieldTermStructure> spreaded(
//	        new ForwardSpreadedTermStructure(h,mh));
//	    Flag flag;
//	    flag.registerWith(spreaded);
//	    h.linkTo(termStructure_);
//	    if (!flag.isUp())
//	        BOOST_ERROR("Observer was not notified of term structure change");
//	    flag.lower();
//	    me->setValue(0.005);
//	    if (!flag.isUp())
//	        BOOST_ERROR("Observer was not notified of spread change");
//
//	    QL_TEST_TEARDOWN
//	}
//
//	void TermStructureTest::testZSpreaded() {
//
//	    BOOST_MESSAGE("Testing consistency of zero-spreaded term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    Real tolerance = 1.0e-10;
//	    boost::shared_ptr<Quote> me(new SimpleQuote(0.01));
//	    Handle<Quote> mh(me);
//	    boost::shared_ptr<YieldTermStructure> spreaded(
//	        new ZeroSpreadedTermStructure(
//	            Handle<YieldTermStructure>(termStructure_),mh));
//	    Date testDate = termStructure_->referenceDate() + 5*Years;
//	    DayCounter rfdc  = termStructure_->dayCounter();
//	    Rate zero = termStructure_->zeroRate(testDate, rfdc,
//	                                         Continuous, NoFrequency);
//	    Rate spreadedZero = spreaded->zeroRate(testDate, rfdc,
//	                                           Continuous, NoFrequency);
//	    if (std::fabs(zero - (spreadedZero-me->value())) > tolerance)
//	        BOOST_ERROR(
//	            "unable to reproduce zero yield from spreaded curve\n"
//	            << std::setprecision(10)
//	            << "    calculated: " << io::rate(spreadedZero-me->value()) << "\n"
//	            << "    expected:   " << io::rate(zero));
//
//	    QL_TEST_TEARDOWN
//	}
//
//	void TermStructureTest::testZSpreadedObs() {
//
//	    BOOST_MESSAGE("Testing observability of zero-spreaded term structure...");
//
//	    QL_TEST_BEGIN
//	    QL_TEST_SETUP
//
//	    boost::shared_ptr<SimpleQuote> me(new SimpleQuote(0.01));
//	    Handle<Quote> mh(me);
//	    RelinkableHandle<YieldTermStructure> h(dummyTermStructure_);
//
//	    boost::shared_ptr<YieldTermStructure> spreaded(
//	        new ZeroSpreadedTermStructure(h,mh));
//	    Flag flag;
//	    flag.registerWith(spreaded);
//	    h.linkTo(termStructure_);
//	    if (!flag.isUp())
//	        BOOST_ERROR("Observer was not notified of term structure change");
//	    flag.lower();
//	    me->setValue(0.005);
//	    if (!flag.isUp())
//	        BOOST_ERROR("Observer was not notified of spread change");
//
//	    QL_TEST_TEARDOWN
//	}
	
	
	
}