package com.behaviour.spring.bddcucumber.framework.config;

import com.behaviour.spring.bddcucumber.framework.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class OtherBeansConfigs {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Faker fakerBean() {
        return new Faker();
    }
}
