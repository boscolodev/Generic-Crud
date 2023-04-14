package br.com.gbs.financal.services;

import br.com.gbs.financal.model.dto.TipoRequestDTO;
import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.repositories.TipoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoTeste implements GenericService<Tipo, Long> {

    private final TipoRepository repository;

    public TipoTeste(TipoRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Tipo, Long> getRepository() {
        return repository;
    }
}
