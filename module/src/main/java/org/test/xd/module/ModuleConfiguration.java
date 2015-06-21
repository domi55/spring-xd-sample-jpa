package org.test.xd.module;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@Import(HibernateJpaAutoConfiguration.class)
@ComponentScan({"my.custom.transformer", "org.test.common"})
@EnableJpaRepositories("org.test.common")
@EntityScan("org.test.common")
public class ModuleConfiguration {
	@Bean
	MessageChannel input() {
		return new DirectChannel();
	}
	@Bean
	MessageChannel output() {
		return new DirectChannel();
	}

	@Bean
	LeetAppender appender() {
		return new LeetAppender();
	}
}
