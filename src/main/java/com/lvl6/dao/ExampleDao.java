package com.lvl6.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDao  {

	
	private static final Logger log = LoggerFactory.getLogger(ExampleDao.class);

	protected JdbcTemplate template;
	

	@Autowired(required=true)
	public void setDatasource(DataSource datasource) {
		log.info("Creating jdbc template");
		template = new JdbcTemplate(datasource);
	}
	
	
	public void createATable() {
		try {
			template.execute("create table exampletable (id integer, name varchar(100))");
		}catch(Exception e) {
			log.error("Error creating table", e);
		}
	}
	
	public void doSomeQueries() {
		template.execute("insert into exampletable (id, name) values (1, 'somename');");
	}
	
}
