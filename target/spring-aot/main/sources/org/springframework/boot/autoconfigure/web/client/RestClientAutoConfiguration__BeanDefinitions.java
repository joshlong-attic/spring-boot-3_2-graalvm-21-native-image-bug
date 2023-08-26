package org.springframework.boot.autoconfigure.web.client;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.client.RestClient;

/**
 * Bean definitions for {@link RestClientAutoConfiguration}.
 */
public class RestClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'restClientAutoConfiguration'.
   */
  public static BeanDefinition getRestClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RestClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'httpMessageConvertersRestClientCustomizer'.
   */
  private static BeanInstanceSupplier<HttpMessageConvertersRestClientCustomizer> getHttpMessageConvertersRestClientCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HttpMessageConvertersRestClientCustomizer>forFactoryMethod(RestClientAutoConfiguration.class, "httpMessageConvertersRestClientCustomizer", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestClientAutoConfiguration.class).httpMessageConvertersRestClientCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'httpMessageConvertersRestClientCustomizer'.
   */
  public static BeanDefinition getHttpMessageConvertersRestClientCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(HttpMessageConvertersRestClientCustomizer.class);
    beanDefinition.setInstanceSupplier(getHttpMessageConvertersRestClientCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restClientBuilder'.
   */
  private static BeanInstanceSupplier<RestClient.Builder> getRestClientBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RestClient.Builder>forFactoryMethod(RestClientAutoConfiguration.class, "restClientBuilder", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RestClientAutoConfiguration.class).restClientBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'restClientBuilder'.
   */
  public static BeanDefinition getRestClientBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(RestClient.Builder.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setInstanceSupplier(getRestClientBuilderInstanceSupplier());
    return beanDefinition;
  }
}
