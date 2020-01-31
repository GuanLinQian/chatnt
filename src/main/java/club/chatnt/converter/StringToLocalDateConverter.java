package club.chatnt.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * 时间:20:42
 * 作者：Maibenben
 **/
@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String s) {
        System.out.println("---------开始转换-----"+s);
        return LocalDate.parse(s);
    }
}
