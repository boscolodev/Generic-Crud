package br.com.gbs.financal.services;

import br.com.gbs.financal.exceptions.DataBaseException;
import br.com.gbs.financal.util.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface GenericService<T, ID> {

    JpaRepository<T, ID> getRepository();

    @Transactional(readOnly = true)
    default T findById(final ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new DataBaseException("Erro ao localizar o registro " + id));
    }

    default void delete(final ID id) {
        findById(id);
        getRepository().deleteById(id);
    }

    @Transactional
    default T save(final T entity) {
        beforeSave();
        return getRepository().save(entity);
    }

    @Transactional
    default T update(final ID id, final T entity) {
        T result = findById(id);
        MapperUtil.copyEntity(entity, result);
        return save(result);
    }

    @Transactional(readOnly = true)
    default Page<T> findAll(final Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default void beforeSave() {
    }

}
