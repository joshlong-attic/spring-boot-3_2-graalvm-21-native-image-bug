package com.example.service;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerHttpController}.
 */
public class CustomerHttpController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customerHttpController'.
   */
  private static BeanInstanceSupplier<CustomerHttpController> getCustomerHttpControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CustomerHttpController>forConstructor(CustomerRepository.class)
            .withGenerator((registeredBean, args) -> new CustomerHttpController(args.get(0)));
  }

  /**
   * Get the bean definition for 'customerHttpController'.
   */
  public static BeanDefinition getCustomerHttpControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomerHttpController.class);
    beanDefinition.setInstanceSupplier(getCustomerHttpControllerInstanceSupplier());
    return beanDefinition;
  }
}
