package br.com.gbs.financal.services;

import br.com.gbs.financal.exceptions.DataBaseException;
import br.com.gbs.financal.util.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<T, ID> {

    JpaRepository<T, ID> getRepository();

    default T findById(final ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new DataBaseException("Erro ao localizar o registro " + id));
    }

    default void delete(final ID id) {
        findById(id);
        getRepository().deleteById(id);
    }

    default T save(final T entity) {
        beforeSave();
        return getRepository().save(entity);
    }

    default void update(final ID id, final T entity) {
        var entityDB = findById(id);
        MapperUtil.copyEntity(entity, entityDB);
        save(entity);
    }

    default Page<T> findAll(final Pageable pageable) {
        return findAll(pageable);
    }

    default void beforeSave() {}

}
