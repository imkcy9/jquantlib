/*
Copyright (C) 2008 Praneet Tiwari

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
package org.jquantlib.testsuite.calendars;

import static org.jquantlib.util.Month.APRIL;
import static org.jquantlib.util.Month.AUGUST;
import static org.jquantlib.util.Month.DECEMBER;
import static org.jquantlib.util.Month.JANUARY;
import static org.jquantlib.util.Month.MARCH;
import static org.jquantlib.util.Month.MAY;
import static org.jquantlib.util.Month.FEBRUARY;

import java.util.List;
import java.util.Vector;

import org.jquantlib.time.Calendar;
import org.jquantlib.time.calendars.UnitedKingdom;
import org.jquantlib.util.Date;
import org.jquantlib.util.DateFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Praneet Tiwari
 *
 */
public class UnitedKingdomCalendarTest {

    private Calendar metals = null;
    private Calendar settlement = null;
    private Calendar exchange = null;
    private List<Date> expectedHol = null;

    public UnitedKingdomCalendarTest() {
        System.out.println("\n\n::::: " + this.getClass().getSimpleName() + " :::::");
    }

    @Before
    public void setup() {
        metals = UnitedKingdom.getCalendar(UnitedKingdom.Market.METALS);
        settlement = UnitedKingdom.getCalendar(UnitedKingdom.Market.SETTLEMENT);
        exchange = UnitedKingdom.getCalendar(UnitedKingdom.Market.EXCHANGE);
        expectedHol = new Vector<Date>();
    }
    // 2004 - leap-year in the past
    @Test
    public void testUnitedKingdomMetalsYear2004() {
        int year = 2004;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January was a Thursday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(12, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        // Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2005 - year in the past
    @Test
    public void testUnitedKingdomMetalsYear2005() {
        int year = 2005;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January was a Saturday
        expectedHol.add(DateFactory.getFactory().getDate(3, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(25, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(28, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(2, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(30, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(29, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2006 - year in the past
    @Test
    public void testUnitedKingdomMetalsYear2006() {
        int year = 2006;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January was a Sunday
        expectedHol.add(DateFactory.getFactory().getDate(2, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(14, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(17, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(1, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(29, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(28, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2007 - year in the past
    @Test
    public void testUnitedKingdomMetalsYear2007() {
        int year = 2007;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January was a Monday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(6, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(7, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(28, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(27, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2008 - present year 
    @Test
    public void testUnitedKingdomMetalsYear2008() {
        int year = 2008;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January was a Tuesday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(21, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(24, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(5, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(26, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(25, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2009 - future year 
    @Test
    public void testUnitedKingdomMetalsYear2009() {
        int year = 2009;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January will be a Thursday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(10, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(13, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(4, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(25, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(31, AUGUST, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // 28 th, a Monday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // 2010 - future year 
    @Test
    public void testUnitedKingdomMetalsYear2010() {
        int year = 2010;
        System.out.println("Testing " + UnitedKingdom.Market.METALS + " holiday list for the year " + year + "...");

        // First January will be a Friday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(2, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(5, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        // 27 th DEC., a Monday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));
        // 28 th DEC., a Tuesday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, metals, year);

    }
    // test settlement dates now...
    public void testUnitedKingdomSettlementYear2004() {
        int year = 2004;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        // Let's check the first weekend
        expectedHol.add(DateFactory.getFactory().getDate(2, JANUARY, year));
        expectedHol.add(DateFactory.getFactory().getDate(3, JANUARY, year));
        // Check another weekend, incidentally V Day ;-)
        expectedHol.add(DateFactory.getFactory().getDate(14, FEBRUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(12, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2005 - year in the past
    @Test
    public void testUnitedKingdomSettlementYear2005() {
        int year = 2005;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January was a Saturday
        expectedHol.add(DateFactory.getFactory().getDate(3, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(25, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(28, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(2, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(30, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(29, AUGUST, year));
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2006 - year in the past
    @Test
    public void testUnitedKingdomSettlementYear2006() {
        int year = 2006;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January was a Sunday
        expectedHol.add(DateFactory.getFactory().getDate(2, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(14, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(17, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(1, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(29, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(28, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2007 - year in the past
    @Test
    public void testUnitedKingdomSettlementYear2007() {
        int year = 2007;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January was a Monday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(6, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(7, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(28, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(27, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));


        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2008 - present year 
    @Test
    public void testUnitedKingdomSettlementYear2008() {
        int year = 2008;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January was a Tuesday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(21, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(24, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(5, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(26, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(25, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2009 - future year 
    @Test
    public void testUnitedKingdomSettlementYear2009() {
        int year = 2009;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January will be a Thursday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(10, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(13, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(4, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(25, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(31, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // 28 th, a Monday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    // 2010 - future year 
    @Test
    public void testUnitedKingdomSettlementYear2010() {
        int year = 2010;
        System.out.println("Testing " + UnitedKingdom.Market.SETTLEMENT + " holiday list for the year " + year + "...");

        // First January will be a Friday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(2, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(5, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));
        // 28 th, a Tuesday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, settlement, year);

    }
    //test exchange dates...
    public void testUnitedKingdomExchangeYear2004() {
        int year = 2004;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January was a Thursday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        // Let's check the first weekend
        expectedHol.add(DateFactory.getFactory().getDate(2, JANUARY, year));
        expectedHol.add(DateFactory.getFactory().getDate(3, JANUARY, year));
        // Check another weekend, incidentally V Day ;-)
        expectedHol.add(DateFactory.getFactory().getDate(14, FEBRUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(12, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2005 - year in the past
    @Test
    public void testUnitedKingdomExchangeYear2005() {
        int year = 2005;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January was a Saturday
        expectedHol.add(DateFactory.getFactory().getDate(3, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(25, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(28, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(2, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(30, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(29, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        //	expectedHol.add(DateFactory.getFactory().getDate(25,DECEMBER,year));
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2006 - year in the past
    @Test
    public void testUnitedKingdomExchangeYear2006() {
        int year = 2006;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January was a Sunday
        expectedHol.add(DateFactory.getFactory().getDate(2, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(14, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(17, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(1, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(29, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(28, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2007 - year in the past
    @Test
    public void testUnitedKingdomExchangeYear2007() {
        int year = 2007;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January was a Monday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        // Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(6, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(9, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(7, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(28, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(27, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2008 - present year 
    @Test
    public void testUnitedKingdomExchangeYear2008() {
        int year = 2008;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January was a Tuesday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(21, MARCH, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(24, MARCH, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(5, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(26, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(25, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // Boxing Day, December 26th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(26, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2009 - future year 
    @Test
    public void testUnitedKingdomExchangeYear2009() {
        int year = 2009;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January will be a Thursday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(10, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(13, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(4, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(25, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(31, AUGUST, year));
        //Christmas Day, December 25th (possibly moved to Monday or Tuesday)
        expectedHol.add(DateFactory.getFactory().getDate(25, DECEMBER, year));
        // 28 th, a Monday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
    // 2010 - future year 
    @Test
    public void testUnitedKingdomExchangeYear2010() {
        int year = 2010;
        System.out.println("Testing " + UnitedKingdom.Market.EXCHANGE + " holiday list for the year " + year + "...");

        // First January will be a Friday
        expectedHol.add(DateFactory.getFactory().getDate(1, JANUARY, year));
        //Good Friday
        expectedHol.add(DateFactory.getFactory().getDate(2, APRIL, year));
        // Easter Monday
        expectedHol.add(DateFactory.getFactory().getDate(5, APRIL, year));
        // May Bank holiday, first Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(3, MAY, year));
        // Spring Bank Holiday, last Monday of May
        expectedHol.add(DateFactory.getFactory().getDate(31, MAY, year));
        // Summer Bank Holiday, last Monday of August
        expectedHol.add(DateFactory.getFactory().getDate(30, AUGUST, year));
        // 27 th, a Monday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(27, DECEMBER, year));
        // 28 th, a Tuesday should also be a holiday
        expectedHol.add(DateFactory.getFactory().getDate(28, DECEMBER, year));

        // Call the Holiday Check
        CalendarUtil cbt = new CalendarUtil();
        cbt.checkHolidayList(expectedHol, exchange, year);

    }
}