package com.herokuapp.rss.loremrssprocessor.dao;

import java.util.List;

import com.herokuapp.rss.loremrssprocessor.model.Rss;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;

public interface RSSFeedDao {
  void saveRSSFeed(RssFeed rssFeed);

  List<Rss> getRSSFeed();
}
