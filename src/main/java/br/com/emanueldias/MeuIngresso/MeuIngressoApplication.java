package br.com.emanueldias.MeuIngresso;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class MeuIngressoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuIngressoApplication.class, args);
	}


	//inicializa migrations
	@Bean
	public Flyway flyway(DataSource dataSource) {
		Flyway flyway = Flyway.configure()
				.dataSource(dataSource)
				.locations("classpath:db/migration")
				.load();

		flyway.migrate();

		try {
			dataSource.getConnection().close();
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		}
		return flyway;
	}

}
