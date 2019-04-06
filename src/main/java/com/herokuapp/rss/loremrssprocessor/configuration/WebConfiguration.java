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

  /**
   * Configure the given {@link ServletContext} with any servlets, filters, listeners context-params and attributes necessary for initialization.
   *
   * @param servletContext the {@code ServletContext} to initialize
   * @throws ServletException if any call against the given {@code ServletContext} throws a {@code ServletException}
   */
  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    initH2Console(servletContext);
  }

  private void initH2Console(final ServletContext servletContext) {
    ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
    h2ConsoleServlet.addMapping("/loremDBConsole/*");
    h2ConsoleServlet.setLoadOnStartup(1);
  }
}

