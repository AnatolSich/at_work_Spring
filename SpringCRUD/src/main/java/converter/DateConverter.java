package converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static Constants.Constants.DATE_PATTERN;

@Converter
public class DateConverter  implements AttributeConverter <Date,Timestamp>{
    @Override
    public Timestamp convertToDatabaseColumn(Date date) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(date!=null)
         timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    @Override
    public Date convertToEntityAttribute(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        Date date = new Date().from(instant);
        return date;
    }
}
