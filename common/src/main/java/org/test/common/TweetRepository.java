package org.test.common;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dominik.mengelt@gmail.com
 */
public interface TweetRepository extends JpaRepository<SimpleTweet, Long> {
}
