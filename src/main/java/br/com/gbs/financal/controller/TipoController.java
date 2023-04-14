package br.com.gbs.financal.controller;

import br.com.gbs.financal.model.dto.GenericDTO;
import br.com.gbs.financal.model.dto.TipoRequestDTO;
import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.services.TipoService;
import br.com.gbs.financal.services.TipoTeste;
import br.com.gbs.financal.util.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tipos")
public class TipoController {

    private final TipoService service;

    public TipoController(TipoService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<TipoRequestDTO> findAll(final Pageable pageable){

        return (Page<TipoRequestDTO>) MapperUtil.converte(service.findAll(pageable), TipoRequestDTO.class);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Tipo findById(@Valid @PathVariable final Long id){
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipoRequestDTO insert(@Valid @RequestBody final TipoRequestDTO request){
        return service.insert(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public TipoRequestDTO update(@Valid @RequestBody final TipoRequestDTO request){
        return service.update(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void insert(@Valid @PathVariable final Long id){
        service.delete(id);
    }

}
