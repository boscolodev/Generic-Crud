package br.com.gbs.financal.services;

import br.com.gbs.financal.exceptions.DataBaseException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<T, ID> {

    JpaRepository<T, ID> getRepository();

     default T findByID(ID id){

        return getRepository().findById(id).orElseThrow( () -> new DataBaseException("Erro ao localizar o registro"));


    }

}
