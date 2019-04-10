package com.herokuapp.rss.loremrssprocessor.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.herokuapp.rss.loremrssprocessor.dao.RSSFeedDao;
import com.herokuapp.rss.loremrssprocessor.model.Channel;
import com.herokuapp.rss.loremrssprocessor.model.Item;
import com.herokuapp.rss.loremrssprocessor.model.Rss;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;

@Repository
public class RssFeedDaoImpl implements RSSFeedDao {

  @Autowired
  JdbcTemplate jdbcTemplate;


  @Override
  public void saveRSSFeed(RssFeed rssFeed) {
    Channel channel = rssFeed.getRss().getChannel();
    List<Item> itemList = channel.getItem();
    String rssSaveQuery = "INSERT INTO RSSCHANNELFEED " +
        "(COPYRIGHT, LASTBUILDDATE, LINK, DESCRIPTION, GENERATOR, TITLE, PUBLISHED_DATE, TTL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String rssItemQuery = "INSERT INTO RSSCHANNELITEM " +
        "(LINK, DESCRIPTION, TITLE, PUBLISHED_DATE, GUID_CONTENT, FEED_ID) VALUES (?, ?, ?, ?, ?, ?)";
    String currentFeedIdQuery = "SELECT FEED_ID FROM RSSCHANNELFEED ORDER BY FEED_ID DESC LIMIT ?";
    jdbcTemplate.update(rssSaveQuery, channel.getCopyright(), channel.getLastBuildDate(), channel.getLink(), channel.getDescription(), channel.getGenerator(),
        channel.getTitle(), channel.getPubDate(), channel.getTtl());
    Integer currentFeedId = (Integer) jdbcTemplate.queryForObject(
        currentFeedIdQuery, new Object[]{ 1 }, Integer.class);
    jdbcTemplate.batchUpdate(rssItemQuery, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        Item item = itemList.get(i);
        ps.setString(1, item.getLink());
        ps.setString(2, item.getDescription());
        ps.setString(3, item.getTitle());
        ps.setString(4, item.getPubDate());
        ps.setString(5, item.getGuid().getContent());
        ps.setInt(6, currentFeedId);
      }

      @Override
      public int getBatchSize() {
        return itemList.size();
      }
    });
  }

  @Override
  public Rss getRSSFeed() {
    Rss rss = new Rss();
    Channel channel = new Channel();
    List<Item> items = jdbcTemplate.query("SELECT * FROM RSSCHANNELITEM", new BeanPropertyRowMapper<>(Item.class));
    List<Channel> rssFeeds = jdbcTemplate.query("SELECT * FROM RSSCHANNELFEED", new BeanPropertyRowMapper<>(Channel.class));
    channel.setItem(items);
    rss.setChannel(channel);
    return rss;
  }
}
