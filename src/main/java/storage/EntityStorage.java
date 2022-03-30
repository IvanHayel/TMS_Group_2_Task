package storage;

import entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityStorage<T extends Entity> {
    private List<T> storage = new ArrayList<>();

    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    public boolean save(T entity) {
        return storage.add(entity);
    }

    public T find(int id) {
        return storage.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean remove(int id) {
        T entityToRemove = find(id);
        return storage.remove(entityToRemove);
    }

    public T update(T entity) {
        T entityToUpdate = find(entity.getId());
        entityToUpdate = entity;
        return entityToUpdate;
    }
}