package com.lvl6.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lvl6.dao.ExampleDao;


@WebServlet(name="exampleServlet", urlPatterns="/example")
public class ExampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(ExampleServlet.class);
	
	@Autowired
	protected ExampleDao exampleDao;
	

	public ExampleDao getExampleDao() {
		return exampleDao;
	}

	public void setExampleDao(ExampleDao exampleDao) {
		this.exampleDao = exampleDao;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,	IOException {
		super.doGet(req, resp);
		getExampleDao().doSomeQueries();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	public void init(ServletConfig config) {
	    try {
			super.init(config);
		} catch (ServletException e) {
			log.error("Error creating example servlet", e);
		}
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	  }

}
