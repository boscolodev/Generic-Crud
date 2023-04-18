package br.com.gbs.financal.services;

import br.com.gbs.financal.model.entities.ExampleEntity;
import br.com.gbs.financal.repositories.ExampleRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleServiceImp implements GenericService<ExampleEntity, Long> {

    private final ExampleRepositoryImp repository;

    @Override
    public void beforeSave() {
        // Vazio pois eh implementado somente na classe
    }

    @Override
    public JpaRepository<ExampleEntity, Long> getRepository() {
        return repository;
    }
}
