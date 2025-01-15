package repository;

import model.HasID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * A repository implementation that stores data in memory.
 *
 * @param <T> The type of objects stored in the repository, which must implement HasId.
 */
public class Repo<T extends HasID> implements IRepository<T> {
    private final Map<Integer,T> data = new HashMap<>();
    private List<T> entities;
    /**
     * Creates a new object in the repository if it doesn't already exist.
     * If an object with the same ID already exists, it won't be added.
     *
     * @param obj The object to be created.
     */
    @Override
    public void create(T obj) {
        data.putIfAbsent(obj.getId(), obj);
    }
    /**
     * Retrieves all objects stored in the repository.
     *
     * @return A list of all objects in the repository.
     */
    @Override
    public List<T> readAll() {
        return data.values().stream().toList();
    }
    /**
     * Updates an existing object in the repository.
     * If an object with the same ID exists, it will be replaced by the new object.
     * @param obj The updated object to replace the existing one.
     */
    @Override
    public void update(T obj) {
        data.replace(obj.getId(), obj);
    }

    /**
     * Deletes an object from the repository by its ID.
     *
     * @param id The ID of the object to delete.
     */
    @Override
    public void delete(Integer id) {
        data.remove(id);
    }
    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param id The ID of the object to retrieve.
     * @return The object with the specified ID, or {@code null} if it doesn't exist.
     */
    @Override
    public T get(Integer id) {
        return data.get(id);
    }


    @Override
    public Set<Integer> getKeys() {
        return data.keySet();
    }


}
