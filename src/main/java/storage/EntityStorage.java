package storage;

import entity.Entity;

import java.util.Collection;

public interface EntityStorage<E extends Entity> {
    Collection<E> getAll();

    boolean save(E entity);

    E getEntityById(int id);

    boolean deleteEntityById(int id);

    E updateEntity(E entity);
}