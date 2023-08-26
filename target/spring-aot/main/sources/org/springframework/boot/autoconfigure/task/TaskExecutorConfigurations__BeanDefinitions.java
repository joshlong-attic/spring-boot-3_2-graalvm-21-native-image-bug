package org.springframework.boot.autoconfigure.task;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.task.SimpleAsyncTaskExecutorBuilder;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Bean definitions for {@link TaskExecutorConfigurations}.
 */
public class TaskExecutorConfigurations__BeanDefinitions {
  /**
   * Bean definitions for {@link TaskExecutorConfigurations.TaskExecutorBuilderConfiguration}.
   */
  public static class TaskExecutorBuilderConfiguration {
    /**
     * Get the bean definition for 'taskExecutorBuilderConfiguration'.
     */
    public static BeanDefinition getTaskExecutorBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.TaskExecutorBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.TaskExecutorBuilderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'taskExecutorBuilder'.
     */
    private static BeanInstanceSupplier<TaskExecutorBuilder> getTaskExecutorBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TaskExecutorBuilder>forFactoryMethod(TaskExecutorConfigurations.TaskExecutorBuilderConfiguration.class, "taskExecutorBuilder", TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TaskExecutorConfigurations.TaskExecutorBuilderConfiguration.class).taskExecutorBuilder(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'taskExecutorBuilder'.
     */
    public static BeanDefinition getTaskExecutorBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(TaskExecutorBuilder.class);
      beanDefinition.setInstanceSupplier(getTaskExecutorBuilderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.TaskExecutorConfiguration}.
   */
  public static class TaskExecutorConfiguration {
    /**
     * Get the bean definition for 'taskExecutorConfiguration'.
     */
    public static BeanDefinition getTaskExecutorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.TaskExecutorConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.TaskExecutorConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'applicationTaskExecutor'.
     */
    private static BeanInstanceSupplier<SimpleAsyncTaskExecutor> getApplicationTaskExecutorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SimpleAsyncTaskExecutor>forFactoryMethod(TaskExecutorConfigurations.TaskExecutorConfiguration.class, "applicationTaskExecutorVirtualThreads", SimpleAsyncTaskExecutorBuilder.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TaskExecutorConfigurations.TaskExecutorConfiguration.class).applicationTaskExecutorVirtualThreads(args.get(0)));
    }

    /**
     * Get the bean definition for 'applicationTaskExecutor'.
     */
    public static BeanDefinition getApplicationTaskExecutorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(SimpleAsyncTaskExecutor.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setInstanceSupplier(getApplicationTaskExecutorInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration}.
   */
  public static class ThreadPoolTaskExecutorBuilderConfiguration {
    /**
     * Get the bean definition for 'threadPoolTaskExecutorBuilderConfiguration'.
     */
    public static BeanDefinition getThreadPoolTaskExecutorBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'threadPoolTaskExecutorBuilder'.
     */
    private static BeanInstanceSupplier<ThreadPoolTaskExecutorBuilder> getThreadPoolTaskExecutorBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ThreadPoolTaskExecutorBuilder>forFactoryMethod(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class, "threadPoolTaskExecutorBuilder", TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class).threadPoolTaskExecutorBuilder(args.get(0), args.get(1), args.get(2), args.get(3)));
    }

    /**
     * Get the bean definition for 'threadPoolTaskExecutorBuilder'.
     */
    public static BeanDefinition getThreadPoolTaskExecutorBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(ThreadPoolTaskExecutorBuilder.class);
      beanDefinition.setInstanceSupplier(getThreadPoolTaskExecutorBuilderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration}.
   */
  public static class SimpleAsyncTaskExecutorBuilderConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration'.
     */
    private static BeanInstanceSupplier<TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration> getSimpleAsyncTaskExecutorBuilderConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration>forConstructor(TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskExecutorBuilderConfiguration'.
     */
    public static BeanDefinition getSimpleAsyncTaskExecutorBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskExecutorBuilderConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'simpleAsyncTaskExecutorBuilder'.
     */
    private static BeanInstanceSupplier<SimpleAsyncTaskExecutorBuilder> getSimpleAsyncTaskExecutorBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SimpleAsyncTaskExecutorBuilder>forFactoryMethod(TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class, "simpleAsyncTaskExecutorBuilderVirtualThreads")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class).simpleAsyncTaskExecutorBuilderVirtualThreads());
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskExecutorBuilder'.
     */
    public static BeanDefinition getSimpleAsyncTaskExecutorBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(SimpleAsyncTaskExecutorBuilder.class);
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskExecutorBuilderInstanceSupplier());
      return beanDefinition;
    }
  }
}