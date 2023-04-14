package br.com.gbs.financal.services;

import br.com.gbs.financal.exceptions.DataBaseException;
import br.com.gbs.financal.model.dto.TipoRequestDTO;
import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.repositories.TipoRepository;
import br.com.gbs.financal.util.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoService {

    private final TipoRepository repository;

    public TipoService(TipoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<TipoRequestDTO> findAll(Pageable pageable){
        Page<Tipo> pageList = repository.findAll(pageable);
        return (Page<TipoRequestDTO>) MapperUtil.converte(pageList, TipoRequestDTO.class);
    }

    @Transactional(readOnly = true)
    public Tipo findById(final Long id){
        return repository.findById(id).orElseThrow(()-> new DataBaseException("Erro ao localizar o registro"));
    }

    @Transactional
    public TipoRequestDTO insert(final TipoRequestDTO dto){
        repository.save(MapperUtil.converte(dto, Tipo.class));
        return dto;
    }

    @Transactional
    public TipoRequestDTO update(final TipoRequestDTO dto){
        repository.save(MapperUtil.converte(dto, Tipo.class));
        return dto;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
