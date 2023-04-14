package br.com.gbs.financal.model.dto;

import br.com.gbs.financal.model.entities.Tipo;
import br.com.gbs.financal.util.MapperUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoCadatroDTO {

    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    public Tipo toEntity() {
        return MapperUtil.converte(this, Tipo.class);
    }
}
