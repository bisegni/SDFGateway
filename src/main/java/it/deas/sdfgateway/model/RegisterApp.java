package it.deas.sdfgateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.dataflow.core.ApplicationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterApp {
    private String name;
    private ApplicationType type;
    private String uri;
}
