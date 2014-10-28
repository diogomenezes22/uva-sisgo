package sisgo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;

@Convert(Date.class)
@ApplicationScoped
public class DateConverter implements Converter<Date> {

	@Override
	public Date convert(String data, Class<? extends Date> arg1) {
		
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
			return (Date) format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
        return null;
	}

}
