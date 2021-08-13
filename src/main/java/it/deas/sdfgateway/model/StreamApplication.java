package it.deas.sdfgateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StreamApplication {
    @Id
    @SequenceGenerator(name="StreamApplicationSeq", sequenceName="JPA_SA_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StreamApplicationSeq")
    private Integer id;
    private String name;
    private Integer deploymentCount;
    private Integer deploymentMemory;
    @ElementCollection
    private Map<String, String> deploymentOtherParam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream_id")
    private Stream stream;
}
