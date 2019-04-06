
package com.herokuapp.rss.loremrssprocessor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isPermaLink",
    "content"
})
public class Guid {

  @JsonProperty("isPermaLink")
  private Boolean isPermaLink;
  @JsonProperty("content")
  private String content;

  @JsonProperty("isPermaLink")
  public Boolean getIsPermaLink() {
    return isPermaLink;
  }

  @JsonProperty("isPermaLink")
  public void setIsPermaLink(Boolean isPermaLink) {
    this.isPermaLink = isPermaLink;
  }

  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  @JsonProperty("content")
  public void setContent(String content) {
    this.content = content;
  }
}
