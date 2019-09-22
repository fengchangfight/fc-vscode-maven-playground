package com.fcvscodemvn.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRelated {

    private static String formatDate(Date dt) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dtstr = df.format(dt);
        return dtstr;
    }

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(formatDate(today));
    }
}