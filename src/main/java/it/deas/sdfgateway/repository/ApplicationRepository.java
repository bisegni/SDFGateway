package it.deas.sdfgateway.repository;

import it.deas.sdfgateway.model.Application;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApplicationRepository  extends CrudRepository<Application, Integer> {
    Optional<Application> findByName(String name);
}
