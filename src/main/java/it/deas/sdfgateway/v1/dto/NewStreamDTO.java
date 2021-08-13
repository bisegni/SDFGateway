package it.deas.sdfgateway.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewStreamDTO {
    private String name;
    @Builder.Default
    private List<StreamApplicationDTO> applications = new LinkedList<>();
}
