package com.herokuapp.rss.loremrssprocessor.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;

@Component
public class RSSFeedScheduler {
  private static final Logger logger = LoggerFactory.getLogger(RSSFeedScheduler.class);
  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

  @Value("${rssfeed.url}")
  private static String rssFeedUrl = "https://lorem-rss.herokuapp.com/feed?unit=second";

  @Scheduled(fixedDelay = 180000)
  public void getLoremRSSFeed() throws IOException {
    logger.info("RSSFeed Feed polling :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    getRSSFeed();
  }

  protected RssFeed getRSSFeed() throws IOException {
    TypeReference<RssFeed> typeReference = new TypeReference<RssFeed>() {
    };
    InputStream xml = getInputStreamFromURL(rssFeedUrl);
    byte[] byteArray = IOUtils.toByteArray(xml);
    String xmlString = new String(byteArray);
    JSONObject xmlToJsonObject = XML.toJSONObject(xmlString);
    String jsonString = xmlToJsonObject.toString();
    byte[] jsonStringAsByteArray = jsonString.getBytes("UTF-8");
    String retValue = new String(jsonStringAsByteArray, "UTF-8");
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    RssFeed rssFeed = objectMapper.readValue(retValue, typeReference);
    return rssFeed;
  }

  private InputStream getInputStreamFromURL(String rssFeedURL) {
    URLConnection connection;
    HttpURLConnection httpConnection;
    InputStream content = null;
    try {
      connection = new URL(rssFeedURL).openConnection();
      connection.setReadTimeout(5000);
      connection.setConnectTimeout(8000);
      connection.setRequestProperty("User-Agent", "Mozilla/5.0");
      httpConnection = (HttpURLConnection) connection;
      int responseCode = httpConnection.getResponseCode();
      content = (InputStream) httpConnection.getInputStream();
      logger.info("RSSFeed Feed call :: Success at - {} :: Status code - {}", dateTimeFormatter.format(LocalDateTime.now()), responseCode);
    } catch (IOException e) {
      logger.error("Error in call to rssFeed", e);
    }
    return content;
  }
}
