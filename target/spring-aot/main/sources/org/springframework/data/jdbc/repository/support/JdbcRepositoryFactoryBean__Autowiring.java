package org.springframework.data.jdbc.repository.support;

import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;
import org.springframework.data.jdbc.repository.QueryMappingConfiguration;

/**
 * Autowiring for {@link JdbcRepositoryFactoryBean}.
 */
public class JdbcRepositoryFactoryBean__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static JdbcRepositoryFactoryBean apply(RegisteredBean registeredBean,
      JdbcRepositoryFactoryBean instance) {
    AutowiredMethodArgumentsResolver.forMethod("setQueryMappingConfiguration", QueryMappingConfiguration.class).resolve(registeredBean, args -> instance.setQueryMappingConfiguration(args.get(0)));
    return instance;
  }
}
