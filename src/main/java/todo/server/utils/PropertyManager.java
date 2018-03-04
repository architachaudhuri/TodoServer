package todo.server.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Description : component to read property files currency.properties
 * 
 * @author vc28045
 *
 */
@Configuration
@PropertySource("classpath:database.properties")
public class PropertyManager {

	@Autowired
	private Environment env;

	/**
	 * method to retrieve property value from .properties file
	 * 
	 * @param propertyName
	 *            String propertyName
	 * @return String propertyName
	 */
	public String getProperty(String propertyName) {
		return env.getRequiredProperty(propertyName);
	}

	/**
	 * method to getNonMandateProperty
	 * 
	 * @param propertyName
	 *            String propertyName
	 * @return String propertyName
	 */
	public String getNonMandateProperty(String propertyName) {
		return env.getProperty(propertyName);
	}

}
