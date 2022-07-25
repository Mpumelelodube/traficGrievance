package com.madara.service;

import com.madara.model.GenericNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class IService <E extends GenericNameEntity, R extends JpaRepository<E, Long>>{
    private E entity;
    protected R repository;

    public IService(R repository) {
        this.repository = repository;
    }

    public E save(E e){
        return repository.save(e);
    }

    /**
     * Partially update an entity.
     *
     * @param e the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<E> partialUpdate(E e) {
        // log.debug("Request to partially update e : {}", e);

        return repository
                .findById(e.getId())

                .map(repository::save);

    }

    @Transactional(readOnly = true)
    public List<E> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<E> findOne(Long id) {
        // log.debug("Request to get VillageWorker : {}", id);
        return repository.findById(id);
    }

    /**
     * Delete the villageWorker by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        // log.debug("Request to delete entity : {}", id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public int countAll() {
        // log.debug("Request to get count. ");
        return repository.findAll().size();
    }
}
