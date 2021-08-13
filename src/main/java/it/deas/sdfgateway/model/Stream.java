package it.deas.sdfgateway.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // Lombok: adds getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stream {
    @Id
    @SequenceGenerator(name="StreamSeq", sequenceName="JPA_S_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StreamSeq")
    private Integer id;
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    List<StreamApplication> applications;
}
