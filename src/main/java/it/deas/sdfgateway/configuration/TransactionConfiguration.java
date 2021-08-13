package it.deas.sdfgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

@Configuration
public class TransactionConfiguration {
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslatorPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
