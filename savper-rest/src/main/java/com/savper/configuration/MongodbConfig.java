package com.savper.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by eriel.marimon on 1/15/18.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.savper.repository")
public class MongodbConfig extends AbstractMongoConfiguration {

  private final String DATABASE_NAME = "savper_beta";

  @Override
  protected String getDatabaseName() {
    return DATABASE_NAME;
  }

  @Override
  @Bean
  public Mongo mongo() throws Exception {
    String dbHost = System.getenv("DB_HOST");
    int dbPort = Integer.parseInt(System.getenv("DB_PORT"));

    dbHost = "localhost";
    dbPort = 27018;

    return new MongoClient(dbHost, dbPort);
  }
}
