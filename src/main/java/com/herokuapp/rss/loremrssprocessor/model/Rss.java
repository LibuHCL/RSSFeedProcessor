
package com.herokuapp.rss.loremrssprocessor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"xmlns:atom", "xmlns:content", "xmlns:dc", "version"})
@JsonPropertyOrder({
        "channel"

})
public class Rss {

    @JsonProperty("channel")
    private Channel channel;

    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
