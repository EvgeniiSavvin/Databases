package org.blackjackj.itmo.dbms.mongodb.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ConfigurationPropertiesBinding
public class StringToDateConverter implements Converter<String, Date> {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        try {
            return DATE_FORMATTER.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
