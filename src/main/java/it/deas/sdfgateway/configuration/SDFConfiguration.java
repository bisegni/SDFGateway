package it.deas.sdfgateway.configuration;

import org.springframework.cloud.dataflow.rest.client.DataFlowTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class SDFConfiguration {
    String sdfURI = "http://192.168.5.130:9393";

    @Bean
    public DataFlowTemplate dataflowTemplate() {
        return new DataFlowTemplate(URI.create(sdfURI));
    }
}
