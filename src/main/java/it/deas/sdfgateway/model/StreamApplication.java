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
@Table(name="stream_applications")
public class StreamApplication {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer deploymentCount;
    private Integer deploymentMemory;
    @ElementCollection
    private Map<String, String> deploymentOtherParam;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="stream_id")
    private Stream stream;
}
