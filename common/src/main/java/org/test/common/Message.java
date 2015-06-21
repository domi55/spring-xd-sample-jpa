package org.test.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author dominik.mengelt@gmail.com
 */
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

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
