package org.test.xd.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.test.common.Message;
import org.test.common.MessageDomainService;

@MessageEndpoint
public class LeetAppender {

	private static final String TEXT = "_1337";

	@Autowired
	private MessageDomainService messageDomainService;

	@Transformer(inputChannel = "input", outputChannel = "output")
	public String append(String payload) {
		String text = payload + TEXT;
		messageDomainService.save(new Message(text));
		return  text;
	}
}
