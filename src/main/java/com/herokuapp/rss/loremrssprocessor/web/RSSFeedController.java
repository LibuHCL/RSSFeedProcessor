package com.herokuapp.rss.loremrssprocessor.web;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.rss.loremrssprocessor.exception.ErrorResponse;
import com.herokuapp.rss.loremrssprocessor.exception.NotFoundException;
import com.herokuapp.rss.loremrssprocessor.model.Rss;
import com.herokuapp.rss.loremrssprocessor.service.RSSFeedService;


@RestController
@RequestMapping("/loream")
public class RSSFeedController {

  private static final Logger logger = LoggerFactory.getLogger(RSSFeedController.class);

  @Autowired
  RSSFeedService rssFeedService;

  @GetMapping(value = "/feeds", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<Rss>> getAllLoreamRSSFeeds() {
    List<Rss> feeds = rssFeedService.getAllFeeds();
    if (feeds == null) {
      logger.debug("Feeds with channel not found at '{}'", LocalDate.now());
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<List<Rss>>(feeds, HttpStatus.OK);
  }

  @RequestMapping(value = "/**")
  public void getRedirectedToHome(final HttpServletRequest request) throws NotFoundException {
    throw new NotFoundException("Invalid request: " + request.getMethod() + " " + request.getRequestURI());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse notFoundExceptionHandler(final Exception e) {
    final String correlationId = UUID.randomUUID().toString();
    return new ErrorResponse(correlationId, "URL is not found", e);
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse applicationExceptionHandler(final Exception e) {
    final String correlationId = UUID.randomUUID().toString();
    return new ErrorResponse(correlationId, "An exception occurred", e);
  }

}
