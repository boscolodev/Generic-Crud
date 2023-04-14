package br.com.gbs.financal.model.dto;

import br.com.gbs.financal.util.MapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class GenericDTO<D> implements Serializable {

    public GenericDTO convert(D entity){
        return MapperUtil.converte(entity, GenericDTO.class);
    }
}
