package br.com.gbs.financal.model.entities;

import br.com.gbs.financal.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tipo", schema = "gbs")
public class Tipo extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String descricao;

}
