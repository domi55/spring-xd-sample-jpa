##### Works (integration test)
```zsh
mvn clean package
```

##### Doesn't work
Running the module on 1.2.0.RC1 singlenode
```xd-shell
xd:>module upload --file spring-xd-sample/module/target/org.test.xd.module-1.2.0.RC1.jar --name xd-sample-processor --type processor
xd:>stream create --name ticktock --definition "time | xd-sample-processor | log" --deploy
```
Exception:
```
2015-06-16T22:33:59+0200 1.2.0.RC1 INFO DeploymentsPathChildrenCache-0 container.DeploymentListener - Deploying module [ModuleDescriptor@4599917d moduleName = 'xd-sample-processor', moduleLabel = 'xd-sample-processor', group = 'test', sourceChannelName = [null], sinkChannelName = [null], index = 1, type = processor, parameters = map[[empty]], children = list[[empty]]]
2015-06-16T22:34:00+0200 1.2.0.RC1 ERROR DeploymentsPathChildrenCache-0 boot.SpringApplication - Application startup failed
java.lang.IllegalStateException: Error processing condition on org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration.jpaVendorAdapter
	at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:58) ~[spring-boot-autoconfigure-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.context.annotation.ConditionEvaluator.shouldSkip(ConditionEvaluator.java:102) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForBeanMethod(ConfigurationClassBeanDefinitionReader.java:190) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:148) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:124) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:318) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:239) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:254) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:94) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:606) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:462) ~[spring-context-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:686) ~[spring-boot-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:320) ~[spring-boot-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.boot.builder.SpringApplicationBuilder.run(SpringApplicationBuilder.java:139) [spring-boot-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.xd.module.core.SimpleModule.initialize(SimpleModule.java:213) [spring-xd-module-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.module.ModuleDeployer.doDeploy(ModuleDeployer.java:217) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.module.ModuleDeployer.deploy(ModuleDeployer.java:200) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.server.container.DeploymentListener.deployModule(DeploymentListener.java:365) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.server.container.DeploymentListener.deployStreamModule(DeploymentListener.java:334) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.server.container.DeploymentListener.onChildAdded(DeploymentListener.java:181) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.springframework.xd.dirt.server.container.DeploymentListener.childEvent(DeploymentListener.java:149) [spring-xd-dirt-1.2.0.RC1.jar:1.2.0.RC1]
	at org.apache.curator.framework.recipes.cache.PathChildrenCache$5.apply(PathChildrenCache.java:509) [curator-recipes-2.6.0.jar:na]
	at org.apache.curator.framework.recipes.cache.PathChildrenCache$5.apply(PathChildrenCache.java:503) [curator-recipes-2.6.0.jar:na]
	at org.apache.curator.framework.listen.ListenerContainer$1.run(ListenerContainer.java:92) [curator-framework-2.6.0.jar:na]
	at com.google.common.util.concurrent.MoreExecutors$SameThreadExecutorService.execute(MoreExecutors.java:297) [guava-16.0.1.jar:na]
	at org.apache.curator.framework.listen.ListenerContainer.forEach(ListenerContainer.java:83) [curator-framework-2.6.0.jar:na]
	at org.apache.curator.framework.recipes.cache.PathChildrenCache.callListeners(PathChildrenCache.java:500) [curator-recipes-2.6.0.jar:na]
	at org.apache.curator.framework.recipes.cache.EventOperation.invoke(EventOperation.java:35) [curator-recipes-2.6.0.jar:na]
	at org.apache.curator.framework.recipes.cache.PathChildrenCache$10.run(PathChildrenCache.java:762) [curator-recipes-2.6.0.jar:na]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_45]
	at java.util.concurrent.FutureTask.run(FutureTask.java:266) [na:1.8.0_45]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_45]
	at java.util.concurrent.FutureTask.run(FutureTask.java:266) [na:1.8.0_45]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_45]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_45]
	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_45]
Caused by: java.lang.IllegalArgumentException: @ConditionalOnMissingBean annotations must specify at least one bean (type, name or annotation)
	at org.springframework.util.Assert.isTrue(Assert.java:65) ~[spring-core-4.1.6.RELEASE.jar:4.1.6.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition$BeanSearchSpec.<init>(OnBeanCondition.java:223) ~[spring-boot-autoconfigure-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.getMatchOutcome(OnBeanCondition.java:92) ~[spring-boot-autoconfigure-1.2.3.RELEASE.jar:1.2.3.RELEASE]
	at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:45) ~[spring-boot-autoconfigure-1.2.3.RELEASE.jar:1.2.3.RELEASE]
```
