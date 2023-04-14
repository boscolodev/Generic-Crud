package br.com.gbs.financal.controller;

import br.com.gbs.financal.model.dto.TipoCadatroDTO;
import br.com.gbs.financal.model.dto.TipoListagemDTO;
import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.services.TipoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/tipos")
@RequiredArgsConstructor
public class TipoController {

    private final TipoService service;

    @GetMapping
    public Page<TipoListagemDTO> findAll(final Pageable pageable, final Tipo tipo) {
        return service.findAll(pageable).map(Tipo::toListagemDTO);
    }

    @GetMapping("/{id}")
    public TipoCadatroDTO findById(@Valid @PathVariable final Long id) {
        return service.findById(id).toCadastroDTO();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipoCadatroDTO save(@Valid @RequestBody final TipoCadatroDTO request) {
        return service.save(request.toEntity())
                .toCadastroDTO();
    }

    @PutMapping("/{id}")
    public void update(@Valid @PathVariable final Long id,
                       @Valid @RequestBody final TipoCadatroDTO request) {
        service.update(id, request.toEntity());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable final Long id) {
        service.delete(id);
    }

}
