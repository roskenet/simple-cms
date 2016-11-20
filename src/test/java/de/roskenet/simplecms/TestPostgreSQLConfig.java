package de.roskenet.simplecms;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
public class TestPostgreSQLConfig {

	@Bean
	public DataSource dataSource() throws IOException {
		EmbeddedPostgres postgreSQL = EmbeddedPostgres.start();
		return postgreSQL.getPostgresDatabase();
	}
}
