package org.test.xd.module;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.xd.dirt.server.singlenode.SingleNodeApplication;
import org.springframework.xd.dirt.test.SingleNodeIntegrationTestSupport;
import org.springframework.xd.dirt.test.SingletonModuleRegistry;
import org.springframework.xd.dirt.test.process.SingleNodeProcessingChain;
import org.springframework.xd.module.ModuleType;
import org.springframework.xd.test.RandomConfigurationSupport;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.xd.dirt.test.process.SingleNodeProcessingChainSupport.chain;

public class LeetAppenderIntegrationTest {

	private static SingleNodeApplication application;

	private static int RECEIVE_TIMEOUT = 10000;

	private static String moduleName = "timestamp-appender";

	@BeforeClass
	public static void setUp() {
		RandomConfigurationSupport randomConfigSupport = new RandomConfigurationSupport();
		application = new SingleNodeApplication().run();
		SingleNodeIntegrationTestSupport singleNodeIntegrationTestSupport = new SingleNodeIntegrationTestSupport
				(application);
		singleNodeIntegrationTestSupport.addModuleRegistry(new SingletonModuleRegistry(ModuleType.processor,
				moduleName));
	}

	@Test
	public void test() {
		String streamName = "appenderTest";
		String processingChainUnderTest = moduleName;
		SingleNodeProcessingChain chain = chain(application, streamName, processingChainUnderTest);
		chain.sendPayload("hello");
		String result = (String) chain.receivePayload(RECEIVE_TIMEOUT);
		assertThat(result, containsString("_"));
		chain.destroy();
	}

}
