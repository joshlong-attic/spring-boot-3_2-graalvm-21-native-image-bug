package com.example.service;

import java.lang.Class;
import java.lang.Object;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean__Autowiring;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Bean definitions for {@link CustomerRepository}.
 */
public class CustomerRepository__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customerRepository'.
   */
  private static BeanInstanceSupplier<JdbcRepositoryFactoryBean> getCustomerRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JdbcRepositoryFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new JdbcRepositoryFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'customerRepository'.
   */
  public static BeanDefinition getCustomerRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcRepositoryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(JdbcRepositoryFactoryBean.class, CustomerRepository.class, Object.class, Object.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "com.example.service.CustomerRepository");
    beanDefinition.getPropertyValues().addPropertyValue("queryLookupStrategyKey", QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND);
    beanDefinition.getPropertyValues().addPropertyValue("lazyInit", false);
    beanDefinition.getPropertyValues().addPropertyValue("namedQueries", new RuntimeBeanReference("jdbc.named-queries#0"));
    beanDefinition.getPropertyValues().addPropertyValue("repositoryFragments", new RuntimeBeanReference("jdbc.CustomerRepository.fragments#0"));
    beanDefinition.getPropertyValues().addPropertyValue("transactionManager", "transactionManager");
    beanDefinition.getPropertyValues().addPropertyValue("mappingContext", new RuntimeBeanReference(JdbcMappingContext.class));
    beanDefinition.getPropertyValues().addPropertyValue("dialect", new RuntimeBeanReference(Dialect.class));
    beanDefinition.getPropertyValues().addPropertyValue("converter", new RuntimeBeanReference(JdbcConverter.class));
    InstanceSupplier<JdbcRepositoryFactoryBean> instanceSupplier = getCustomerRepositoryInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(JdbcRepositoryFactoryBean__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
