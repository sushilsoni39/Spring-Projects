package org.example.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateFormatter implements FactoryBean<java.util.Date> {
    @Value("${format}")
    private String format;

    @Value("${date}")
    private String date;

    @Override
    public Date getObject() throws Exception {
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
}

