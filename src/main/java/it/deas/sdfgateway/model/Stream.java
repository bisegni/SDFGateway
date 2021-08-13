package it.deas.sdfgateway.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "streams")
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(
            mappedBy = "stream",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    List<StreamApplication> applications;
}
