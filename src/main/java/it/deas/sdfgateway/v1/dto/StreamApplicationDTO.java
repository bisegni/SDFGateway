package it.deas.sdfgateway.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StreamApplicationDTO {
    String name;
    List<String> applicationParameter = new LinkedList<>();
    private Integer deploymentCount;
    private Integer deploymentMemory;
    private Map<String, String> deploymentOtherParam;
}
