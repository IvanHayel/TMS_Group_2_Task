package storage;

import entity.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class EntityStorageImpl<E extends Entity> implements EntityStorage<E> {
    private final Collection<E> COLLECTION;

    public EntityStorageImpl(Collection<E> collection) {
        COLLECTION = collection;
    }

    @Override
    public Collection<E> getAll() {
        return new ArrayList<>(COLLECTION);
    }

    @Override
    public boolean save(E entity) {
        return COLLECTION.add(entity);
    }

    @Override
    public E getEntityById(int id) {
        return COLLECTION.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteEntityById(int id) {
        return COLLECTION.removeIf(entity -> entity.getId() == id);
    }

    @Override
    public E updateEntity(E entity) {
        E entityToUpdate = COLLECTION.stream()
                .filter(e -> e.getId() == entity.getId())
                .findFirst()
                .orElse(null);
        entityToUpdate = entityToUpdate == null ? null : entity;
        return entityToUpdate;
    }
}