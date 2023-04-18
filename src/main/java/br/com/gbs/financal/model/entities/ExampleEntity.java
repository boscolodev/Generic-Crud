package br.com.gbs.financal.model.entities;

import br.com.gbs.financal.model.BaseEntity;
import br.com.gbs.financal.model.dto.ExampleSaveImpDTOImp;
import br.com.gbs.financal.model.dto.ExampleListDTOImp;
import br.com.gbs.financal.util.MapperUtil;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "example")
public class ExampleEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String descricao;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PrePersist
    private void setCreatedAt(){
        createdAt = Instant.now();
    }

    @PreUpdate
    private void setUpdatedAt(){
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExampleEntity exampleEntity = (ExampleEntity) o;
        return getId() != null && Objects.equals(getId(), exampleEntity.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    public ExampleListDTOImp toListagemDTO() {
        return MapperUtil.converte(this, ExampleListDTOImp.class);
    }
    public ExampleSaveImpDTOImp toCadastroDTO() {
        return MapperUtil.converte(this, ExampleSaveImpDTOImp.class);
    }

}
