package app.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

@Converter
public class EventDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        Date date = Date.from(instant);
        return new Timestamp(date.getTime());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        Instant instant =timestamp.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
