package org.test.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dominik.mengelt@gmail.com
 */
@Service
public class MessageDomainService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageDomainService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message simpleTweet) {
        messageRepository.save(simpleTweet);
    }

}
