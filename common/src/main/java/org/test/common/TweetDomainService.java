package org.test.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dominik.mengelt@gmail.com
 */
@Service
public class TweetDomainService {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetDomainService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public void save(SimpleTweet simpleTweet) {
        tweetRepository.save(simpleTweet);
    }


}
