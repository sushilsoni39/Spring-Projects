package org.example.controller;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter implements FactoryBean<java.util.Date> {
    @Value("${format}")
    private String format;
    @Value("${date}")
    private String date;
    @Override
    public Date getObject() throws Exception {
//        return new Date();
        return new SimpleDateFormat(format).parse(date);
    }
    @Override
    public Class<?> getObjectType() {
        return java.util.Date.class;
    }
    @Override
    public boolean isSingleton() {
        return false;
    }
    @Override
    public String toString() {
        return format + '\'' +
                ", date='" + date ;
    }
}