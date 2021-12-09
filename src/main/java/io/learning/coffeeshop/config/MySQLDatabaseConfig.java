package io.learning.coffeeshop.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import dev.miku.r2dbc.mysql.constant.SslMode;
import dev.miku.r2dbc.mysql.constant.ZeroDateOption;
import io.r2dbc.spi.ConnectionFactory;

/**
 * 
 * @author Anil Jaglan
 *
 */
@Profile("mysql")
@Configuration
@EnableR2dbcRepositories
public class MySQLDatabaseConfig extends AbstractR2dbcConfiguration {

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
		return MySqlConnectionFactory.from(configuration());
	}
	
	private MySqlConnectionConfiguration  configuration() {
		MySqlConnectionConfiguration config = MySqlConnectionConfiguration
				.builder()
				.host(host)
				.port(port)
				.user(username)
				.password(secret)
				.database(database)
				.connectTimeout(Duration.ofSeconds(timeout))
				.sslMode(SslMode.DISABLED)
				.zeroDateOption(ZeroDateOption.USE_ROUND)
				.build();
		return config;
	}

}
