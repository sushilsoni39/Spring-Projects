package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    private String date;
    private String format;
    private Date dateObj;
    private Date date1;


    public Date formatter(String data) throws ParseException {
        String[] val = data.split("\\|");
        this.date = val[0];
        this.format = val[1];
        date1 = new SimpleDateFormat(format).parse(date);
        this.dateObj = date1;
        return dateObj;
    }
}

