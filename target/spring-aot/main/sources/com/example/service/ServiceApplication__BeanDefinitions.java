package com.example.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ServiceApplication}.
 */
public class ServiceApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'serviceApplication'.
   */
  public static BeanDefinition getServiceApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ServiceApplication.class);
    beanDefinition.setTargetType(ServiceApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(ServiceApplication.class);
    beanDefinition.setInstanceSupplier(ServiceApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
