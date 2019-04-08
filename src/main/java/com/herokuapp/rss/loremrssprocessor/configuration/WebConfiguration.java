package com.herokuapp.rss.loremrssprocessor.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.herokuapp.rss.loremrssprocessor")
public class WebConfiguration implements ServletContextInitializer {


  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    initH2Console(servletContext);
  }

  private void initH2Console(final ServletContext servletContext) {
    ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
    h2ConsoleServlet.addMapping("/*");
    h2ConsoleServlet.setLoadOnStartup(1);
  }
}

