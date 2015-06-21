package org.test.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * @author dominik.mengelt@gmail.com
 */
@Entity
@Table(name = "simple_tweet")
public class Message {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String text;

    private Message(){}

    public Message(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
