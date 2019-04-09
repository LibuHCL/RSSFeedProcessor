package com.herokuapp.rss.loremrssprocessor.exception;

public class NotFoundException extends Exception {

  private static final long serialVersionUID = 432805843375263114L;

  public NotFoundException(final String message) {
    super(message);
  }

  public NotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

}

