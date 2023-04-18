package br.com.gbs.financal.controller;

import br.com.gbs.financal.model.dto.ExampleSaveImpDTOImp;
import br.com.gbs.financal.model.dto.ExampleListDTOImp;
import br.com.gbs.financal.model.entities.ExampleEntity;

import br.com.gbs.financal.services.ExampleServiceImp;
import br.com.gbs.financal.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/tipos")
@RequiredArgsConstructor
public class ExampleControllerImp {

    private final ExampleServiceImp service;

    @GetMapping
    public Page<ExampleListDTOImp> findAll(final Pageable pageable) {
        return service.findAll(pageable).map(ExampleEntity::toListagemDTO);
    }

    @GetMapping("/{id}")
    public ExampleSaveImpDTOImp findById(@Valid @PathVariable final Long id) {
        return service.findById(id).toCadastroDTO();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ExampleSaveImpDTOImp save(@Valid @RequestBody final ExampleSaveImpDTOImp request) {
        return service.save(request.toEntity())
                .toCadastroDTO();
    }

    @PutMapping("/{id}")
    public ExampleListDTOImp update(@Valid @PathVariable final Long id,
                                    @Valid @RequestBody final ExampleSaveImpDTOImp request) {

        ExampleEntity entity = MapperUtil.converte(request, ExampleEntity.class);
        entity.setId(id);
        return service.update(id, entity).toListagemDTO();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable final Long id) {
        service.delete(id);
    }

}
