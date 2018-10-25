package com.staff.validator;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component("dateValidator")
public class DateValidator {
    public  String[] validPatterns = {"dd.MM.yyyy","dd/MM/yyyy","dd-MM-yyyy","dd/mm/yy","yyyy-MM-dd"};
    private String validDatePattern;

    public boolean valid(final String value) {

        if (value == null )
            return false;
        String validDatePattern = getValidDatePattern(value);
        if ( validDatePattern == null ) {
            return false;
        }
        return true;
    }

    private String getValidDatePattern (String value) {
        // returns valid pattern which may be used for convert string to date
        SimpleDateFormat formatter = new SimpleDateFormat();
        for (int i=0; i<validPatterns.length;i++) {
            try {
                formatter.applyPattern(validPatterns[i]);
                formatter.setLenient(false);
                formatter.parse(value);
                validDatePattern = validPatterns[i];
            } catch (ParseException e) {
                // nothing to do
            }
        }
        return validDatePattern;
    }
}
