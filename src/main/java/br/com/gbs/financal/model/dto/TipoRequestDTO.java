package br.com.gbs.financal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoRequestDTO {

    @NotBlank(message = "Campo obrigatório")
    private String descricao;
}
