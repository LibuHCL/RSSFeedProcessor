package com.herokuapp.rss.loremrssprocessor.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.rss.loremrssprocessor.dao.RSSFeedDao;
import com.herokuapp.rss.loremrssprocessor.model.Rss;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;
import com.herokuapp.rss.loremrssprocessor.service.RSSFeedService;

@Service
public class RSSFeedServiceImpl implements RSSFeedService {

  @Autowired
  private RSSFeedDao rssFeedDao;

  @Override
  @Transactional
  public void insertRSSFeed(final RssFeed rssFeed) {
    rssFeedDao.saveRSSFeed(rssFeed);
  }

  @Override
  public Rss getAllFeeds() {
    return rssFeedDao.getRSSFeed();

  }
}
