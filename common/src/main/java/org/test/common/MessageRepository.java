package org.test.common;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dominik.mengelt@gmail.com
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
