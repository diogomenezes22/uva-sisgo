package sisgo.util;

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
		
        try {
			return (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			try {
				return (Date) new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
			}
			catch (ParseException e2) {
				e.printStackTrace();
			}
		}		
        return null;
	}

}
