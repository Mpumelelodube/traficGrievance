package com.madara.services;

import com.madara.model.GenericNamedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public class IService<E extends GenericNamedEntity, R extends JpaRepository<E, Long>> {
    protected R repository;
    private E entity;
    // private final Logger log = LoggerFactory.getLogger("logger");


    public IService(R repository) {
        this.repository = repository;
    }

    /**
     * Save a villageWorker.
     *
     * @param e the entity to save.
     * @return the persisted entity.
     */
    public E save(E e) {
        // log.debug("Request to save : {}", e);
        System.err.println(e.getName());

        this.entity = repository.save(e);
        return e;
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
    public List<E> findAll() {
        // log.debug("Request to get all VillageWorkers");
        return repository.findAll();
    }


    /**
     * Get one villageWorker by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
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

    // Count Data

    @Transactional(readOnly = true)
    public int countAll() {
        // log.debug("Request to get count. ");
        return repository.findAll().size();
    }

}
