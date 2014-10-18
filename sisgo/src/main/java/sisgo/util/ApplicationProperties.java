package sisgo.util;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationProperties {

	private final Properties properties;

	public ApplicationProperties(Properties properties) {
		this.properties = properties;
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRootPath() {
		return this.properties.getProperty("application.rootPath");
	}
	
}