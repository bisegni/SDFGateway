package it.deas.sdfgateway.repository;

import it.deas.sdfgateway.model.Application;
import org.springframework.cloud.dataflow.rest.client.DataFlowTemplate;
import org.springframework.cloud.dataflow.rest.client.dsl.DeploymentPropertiesBuilder;
import org.springframework.cloud.dataflow.rest.client.dsl.Stream;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SDFRepositoryImpl implements SDFRepository {
    DataFlowTemplate dataFlowTemplate;

    public SDFRepositoryImpl(DataFlowTemplate dataFlowTemplate) {
        this.dataFlowTemplate = dataFlowTemplate;
    }

    @Override
    public void registerApplication(
            Application register) {
        dataFlowTemplate.appRegistryOperations().register(
                register.getName(),
                register.getType(),
                register.getUri(),
                null,
                false
        );
    }

    @Override
    public Stream createStream(
            String name,
            String definition) {
//        Map<String, String> prop = new DeploymentPropertiesBuilder()
//                .count("log", 2)
//                .count()
//                .memory("log", 512)
//                .put("app.splitter.producer.partitionKeyExpression", "payload")
//                .build();
        return Stream.builder(dataFlowTemplate)
                .name(name)
                .definition(definition)
                .create()
                .deploy();
    }

    public void findProcessor() {
        //dataFlowTemplate.appRegistryOperations().
    }
}
