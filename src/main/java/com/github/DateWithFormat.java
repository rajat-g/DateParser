package com.github;

import java.util.Date;

public class DateWithFormat {
    Date date;
    String format;

    public DateWithFormat(Date date, String format) {
        this.date = date;
        this.format = format;
    }

    public Date getDate() {
        return date;
    }

    public String getFormat() {
        return format;
    }
}

