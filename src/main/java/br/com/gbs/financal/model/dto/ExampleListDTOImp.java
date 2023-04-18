package br.com.gbs.financal.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExampleListDTOImp implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private Instant createdAt;
    private Instant updatedAt;
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleListDTOImp that = (ExampleListDTOImp) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, createdAt, updatedAt, version);
    }
}
