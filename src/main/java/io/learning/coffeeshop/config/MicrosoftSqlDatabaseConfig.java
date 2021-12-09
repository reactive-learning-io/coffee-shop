package io.learning.coffeeshop.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

/**
 * 
 * @author Anil Jaglan
 *
 */
@Profile("mssql")
@Configuration
@EnableR2dbcRepositories
public class MicrosoftSqlDatabaseConfig extends AbstractR2dbcConfiguration {

	@Value("${spring.r2dbc.db.host}")
	private String host;
	@Value("${spring.r2dbc.db.port}")
	private int port;
	@Value("${spring.r2dbc.db.name}")
	private String database;
	@Value("${spring.r2dbc.db.username}")
	private String username;
	@Value("${spring.r2dbc.db.secret}")
	private String secret;
	@Value("${spring.r2dbc.db.connectionTimeoutInSec}")
	private long timeout;

	@Override
	@Bean
	public ConnectionFactory connectionFactory() {
		return new MssqlConnectionFactory(configuration());
	}
	
	private MssqlConnectionConfiguration configuration() {
		MssqlConnectionConfiguration config = MssqlConnectionConfiguration
				.builder()
				.host(host)
				.port(port)
				.username(username)
				.password(secret)
				.database(database)
				.connectTimeout(Duration.ofSeconds(timeout))
				.build();
		return config;
	}

}
