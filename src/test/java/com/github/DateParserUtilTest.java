package com.github;


import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DateParserUtilTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022",false, false);
        assertEquals("MMM dd, yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test2() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22",false, false);
        assertEquals("MMM dd, yyyy hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test2_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 23:22",false, false);
        assertEquals("MMM dd, yyyy HH:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 23:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test2_2() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22",false, true);
        assertEquals("MMM dd, yyyy HH:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test3() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22 pm",false, false);
        assertEquals("MMM dd, yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 23:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test3_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22 am",false, false);
        assertEquals("MMM dd, yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test4() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22:33",false, false);
        assertEquals("MMM dd, yyyy hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test5() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22:33 am",false, false);
        assertEquals("MMM dd, yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test5_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("Mar 22, 2022 11:22:33 pm",false, false);
        assertEquals("MMM dd, yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 23:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test6() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022",false, false);
        assertEquals("dd/MM/yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test6_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022",true, false);
        assertEquals("dd/MM/yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test7() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022 11:22",false, false);
        assertEquals("dd/MM/yyyy hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test7_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022 11:22",false, true);
        assertEquals("dd/MM/yyyy HH:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test8() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022 11:22 am",false, false);
        assertEquals("dd/MM/yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test9() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022 11:22:33",false, false);
        assertEquals("dd/MM/yyyy hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test10() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22/03/2022 11:22:33 am",false, false);
        assertEquals("dd/MM/yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test11() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22-03-2022",false, false);
        assertEquals("dd-MM-yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test12() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22-03-2022 11:22",false, false);
        assertEquals("dd-MM-yyyy hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test13() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22-03-2022 11:22 am",false, false);
        assertEquals("dd-MM-yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test14() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22-03-2022 11:22:33",false, false);
        assertEquals("dd-MM-yyyy hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test15() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("22-03-2022 11:22:33 am",false, false);
        assertEquals("dd-MM-yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test16() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03/22/2022",true, false);
        assertEquals("MM/dd/yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test17() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03/22/2022 11:22",true, false);
        assertEquals("MM/dd/yyyy hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test18() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03/22/2022 11:22 am",true, false);
        assertEquals("MM/dd/yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test19() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03/22/2022 11:22:33",true, false);
        assertEquals("MM/dd/yyyy hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test20() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03/22/2022 11:22:33 am",true, false);
        assertEquals("MM/dd/yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test21() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03-22-2022",true, false);
        assertEquals("MM-dd-yyyy",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test22() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03-22-2022 11:22",true, false);
        assertEquals("MM-dd-yyyy hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test23() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03-22-2022 11:22 am",true, false);
        assertEquals("MM-dd-yyyy hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test24() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03-22-2022 11:22:33",true, false);
        assertEquals("MM-dd-yyyy hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test25() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("03-22-2022 11:22:33 am",true, false);
        assertEquals("MM-dd-yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test25_1() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("13-13-2022 11:22:33 am",true, false);
        assertEquals("MM-dd-yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2023-01-13 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test25_2() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("13-13-2022 11:22:33 am",false, false);
        assertEquals("dd-MM-yyyy hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2023-01-13 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test26() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022-03-22",true, false);
        assertEquals("yyyy-MM-dd",dateWithFormat.getFormat());
        assertEquals("2022-03-22 00:00:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test27() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022-03-22 11:22",true, false);
        assertEquals("yyyy-MM-dd hh:mm",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }


    @Test
    public void test28() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022-03-22 11:22 am",true, false);
        assertEquals("yyyy-MM-dd hh:mm a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:00",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test29() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022-03-22 11:22:33",true, false);
        assertEquals("yyyy-MM-dd hh:mm:ss",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test30() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022-03-22 11:22:33 am",true, false);
        assertEquals("yyyy-MM-dd hh:mm:ss a",dateWithFormat.getFormat());
        assertEquals("2022-03-22 11:22:33",simpleDateFormat.format(dateWithFormat.getDate()));
    }

    @Test
    public void test31() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat(null,true, false);
        assertNull(dateWithFormat);
    }

    @Test
    public void test32() {
        DateWithFormat dateWithFormat = DateParserUtil.getDateWithFormat("2022;03;22",true, false);
        assertNull(dateWithFormat);
    }
}

