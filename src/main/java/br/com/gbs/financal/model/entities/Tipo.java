package br.com.gbs.financal.model.entities;

import br.com.gbs.financal.model.BaseEntity;
import br.com.gbs.financal.model.dto.TipoCadatroDTO;
import br.com.gbs.financal.model.dto.TipoListagemDTO;
import br.com.gbs.financal.util.MapperUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "tipo", schema = "gbs")
public class Tipo extends BaseEntity {

    @Column(nullable = false)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tipo tipo = (Tipo) o;
        return getId() != null && Objects.equals(getId(), tipo.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public TipoListagemDTO toListagemDTO() {
        return MapperUtil.converte(this, TipoListagemDTO.class);
    }
    public TipoCadatroDTO toCadastroDTO() {
        return MapperUtil.converte(this, TipoCadatroDTO.class);
    }
}
