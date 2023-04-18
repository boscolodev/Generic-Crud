package br.com.gbs.financal.repositories;

import br.com.gbs.financal.model.entities.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepositoryImp extends JpaRepository<ExampleEntity, Long> {
}
