package au.org.consumerdatastandards;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

@Component
public class OffsetDateTimeConverter implements Converter<String, OffsetDateTime> {

    @Override
    public OffsetDateTime convert(String s) {
        //TODO implement me
        // convert "'yyyy-MM-dd HH:mm:ss.SSS Z' or '-1y -2M -3d 5H 3m 45s 8S'" to OffsetDateTime
        return null;
    }
}
