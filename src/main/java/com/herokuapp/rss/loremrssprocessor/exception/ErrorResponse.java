package com.herokuapp.rss.loremrssprocessor.exception;

public final class ErrorResponse {

  private final String correlation;
  private final String description;
  private final String exception;

  public ErrorResponse(final String correlation, final String description, final Exception exception) {
    this.correlation = correlation;
    this.description = description;
    this.exception = exception.getMessage();
  }

  public String getCorrelation() {
    return correlation;
  }

  public String getDescription() {
    return description;
  }

  public String getException() {
    return exception;
  }
}
