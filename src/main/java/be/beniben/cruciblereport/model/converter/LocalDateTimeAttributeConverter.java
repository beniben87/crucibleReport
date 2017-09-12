package be.beniben.cruciblereport.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter
public class LocalDateTimeAttributeConverter  implements AttributeConverter<LocalDateTime, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(LocalDateTime locDateTime) {
        return (locDateTime == null ? null : BigDecimal.valueOf(Timestamp.valueOf(locDateTime).getTime()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(BigDecimal sqlTimestamp) {
        return (sqlTimestamp == null ? null :  new Timestamp(sqlTimestamp.longValue()).toLocalDateTime());
    }
}

