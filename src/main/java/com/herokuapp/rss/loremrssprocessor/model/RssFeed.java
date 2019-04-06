
package com.herokuapp.rss.loremrssprocessor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rss"
})
public class RssFeed {

  @JsonProperty("rss")
  private Rss rss;

  @JsonProperty("rss")
  public Rss getRss() {
    return rss;
  }

  @JsonProperty("rss")
  public void setRss(Rss rss) {
    this.rss = rss;
  }



}
