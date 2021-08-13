package it.deas.sdfgateway.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.dataflow.core.ApplicationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDTO {
    private Integer id;
    private String name;
    private String uri;
    private ApplicationType type;
}
