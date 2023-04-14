package br.com.gbs.financal.services;

import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.repositories.TipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoTeste implements GenericService<Tipo, Long> {

    private final TipoRepository repository;

    @Override
    public void beforeSave() {
        // Vazio pois eh implementado somente na classe
    }

    @Override
    public JpaRepository<Tipo, Long> getRepository() {
        return repository;
    }
}
