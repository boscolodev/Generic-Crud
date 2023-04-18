package br.com.gbs.financal.model.dto;

import br.com.gbs.financal.model.entities.ExampleEntity;
import br.com.gbs.financal.util.MapperUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExampleSaveImpDTOImp implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    private Instant createdAt;
    private Instant updatedAt;
    private Long version;

    public ExampleEntity toEntity() {
        return MapperUtil.converte(this, ExampleEntity.class);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleSaveImpDTOImp that = (ExampleSaveImpDTOImp) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, createdAt, updatedAt, version);
    }
}
