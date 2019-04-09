package com.herokuapp.rss.loremrssprocessor.service;

import java.util.List;

import com.herokuapp.rss.loremrssprocessor.model.Rss;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;

public interface RSSFeedService {
  void insertRSSFeed(RssFeed rssFeed);

  List<Rss> getAllFeeds();
}
