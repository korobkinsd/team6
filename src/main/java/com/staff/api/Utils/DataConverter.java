package com.staff.api.Utils;

import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataConverter {

    public static Date toDate (String value) {
        String[] validPatterns = {"dd.MM.yyyy","dd/MM/yyyy","dd-MM-yyyy","dd/mm/yy","yyyy-MM-dd"};
        SimpleDateFormat formatter = new SimpleDateFormat();
        for (String validPattern : validPatterns) {
            try {
                formatter.applyPattern(validPattern);
                formatter.setLenient(false);
                return new Date(formatter.parse(value).getTime());
            } catch (ParseException e) {
                //ok, just take next pattern
            }
        }
        return null;
    }

    public static String toStr(Date value) {
        if (value != null) {
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(value);
        } else {
            return null;
        }
    }
}
