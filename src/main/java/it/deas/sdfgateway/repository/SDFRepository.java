package it.deas.sdfgateway.repository;

import it.deas.sdfgateway.model.Application;
import org.springframework.cloud.dataflow.rest.client.dsl.Stream;

public interface SDFRepository {

    void registerApplication(
            Application register);

    Stream createStream(
            String name,
            String definition);
}
