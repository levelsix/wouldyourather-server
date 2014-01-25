package com.lvl6.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lvl6.dao.ExampleDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class ExampleTest {

	@Autowired
	protected ExampleDao dao;
	
	public ExampleDao getDao() {
		return dao;
	}

	public void setDao(ExampleDao dao) {
		this.dao = dao;
	}

	@Test
	public void exampleTest() {
		dao.createATable();
		dao.doSomeQueries();
	}
	
}
