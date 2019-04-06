
package com.herokuapp.rss.loremrssprocessor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "xmlns:atom", "xmlns:content", "xmlns:dc" })
@JsonPropertyOrder({
    "channel",
    "version"

})
public class Rss {

  @JsonProperty("channel")
  private Channel channel;

  @JsonProperty("version")
  private Integer version;

  @JsonProperty("channel")
  public Channel getChannel() {
    return channel;
  }

  @JsonProperty("channel")
  public void setChannel(Channel channel) {
    this.channel = channel;
  }

  @JsonProperty("version")
  public Integer getVersion() {
    return version;
  }

  @JsonProperty("version")
  public void setVersion(Integer version) {
    this.version = version;
  }


}
