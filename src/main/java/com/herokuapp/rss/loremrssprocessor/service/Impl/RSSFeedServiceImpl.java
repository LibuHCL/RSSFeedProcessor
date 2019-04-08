package com.herokuapp.rss.loremrssprocessor.service.Impl;

import com.herokuapp.rss.loremrssprocessor.dao.RSSFeedDao;
import com.herokuapp.rss.loremrssprocessor.model.RssFeed;
import com.herokuapp.rss.loremrssprocessor.service.RSSFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RSSFeedServiceImpl implements RSSFeedService {

    @Autowired
    RSSFeedDao rssFeedDao;

    @Override
    @Transactional
    public void insertRSSFeed(final RssFeed rssFeed) {
        rssFeedDao.saveRSSFeed(rssFeed);
    }
}
