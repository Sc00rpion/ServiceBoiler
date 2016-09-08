package database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:/database/database.properties")
public class DataSourceConfiguration {

	@Autowired
	Environment env;

	// @Profile("development")
	// @Bean
	// public DataSource embeddedDataSource() {
	// return new
	// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql")
	// .addScript("classpath:test-data.sql").build();
	// }

	// @Profile("qa")
	@Bean
	public DataSource dataSource() {
		String url = env.getProperty("mysql.url");
		String username = env.getProperty("mysql.username");
		String password = env.getProperty("mysql.password");
		
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(
				"jdbc:mysql://" + url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
