
package com.herokuapp.rss.loremrssprocessor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "copyright",
    "item",
    "lastBuildDate",
    "link",
    "description",
    "generator",
    "title",
    "pubDate",
    "ttl"
})
public class Channel {

  @JsonProperty("copyright")
  private String copyright;
  @JsonProperty("item")
  private List<Item> item = null;
  @JsonProperty("lastBuildDate")
  private String lastBuildDate;
  @JsonProperty("link")
  private String link;
  @JsonProperty("description")
  private String description;
  @JsonProperty("generator")
  private String generator;
  @JsonProperty("title")
  private String title;
  @JsonProperty("pubDate")
  private String pubDate;
  @JsonProperty("ttl")
  private Integer ttl;

  @JsonProperty("copyright")
  public String getCopyright() {
    return copyright;
  }

  @JsonProperty("copyright")
  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  @JsonProperty("item")
  public List<Item> getItem() {
    return item;
  }

  @JsonProperty("item")
  public void setItem(List<Item> item) {
    this.item = item;
  }

  @JsonProperty("lastBuildDate")
  public String getLastBuildDate() {
    return lastBuildDate;
  }

  @JsonProperty("lastBuildDate")
  public void setLastBuildDate(String lastBuildDate) {
    this.lastBuildDate = lastBuildDate;
  }

  @JsonProperty("link")
  public String getLink() {
    return link;
  }

  @JsonProperty("link")
  public void setLink(String link) {
    this.link = link;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("generator")
  public String getGenerator() {
    return generator;
  }

  @JsonProperty("generator")
  public void setGenerator(String generator) {
    this.generator = generator;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonProperty("pubDate")
  public String getPubDate() {
    return pubDate;
  }

  @JsonProperty("pubDate")
  public void setPubDate(String pubDate) {
    this.pubDate = pubDate;
  }

  @JsonProperty("ttl")
  public Integer getTtl() {
    return ttl;
  }

  @JsonProperty("ttl")
  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }
}
