package my.custom.transformer;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.transformer.MessageTransformationException;
import org.test.common.SimpleTweet;
import org.test.common.TweetDomainService;

@MessageEndpoint
public class TweetTransformer {
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private TweetDomainService tweetDomainService;

	@Transformer(inputChannel = "input", outputChannel = "output")
	public String transform(String payload) {
		try {
			Map<String, Object> tweet = mapper.readValue(payload, new TypeReference<Map<String, Object>>() {
			});

			String text =  tweet.get("text").toString();
			tweetDomainService.save(new SimpleTweet(text));
			return text;
		}
		catch (IOException e) {
			throw new MessageTransformationException("Unable to transform tweet: " + e.getMessage(), e);
		}
	}
}
