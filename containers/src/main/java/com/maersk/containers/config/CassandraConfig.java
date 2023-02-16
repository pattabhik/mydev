package com.maersk.containers.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * cassandra db configuration
 * 
 * @author Pattabhi
 *
 */
@Configuration
@EnableCassandraRepositories(basePackages = { "com.maersk.containers.dao" })
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.contact-points}")
	private String contactPoints;

	@Value("${spring.data.cassandra.port}")
	private int port;

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpace;

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "com.maersk.containers.entity" };
	}

}
