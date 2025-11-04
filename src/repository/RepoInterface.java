package repository;

import java.util.List;

public interface RepoInterface<T> {

    void loadAll();
    List<T> getAll();
    void add(T object);
    void update(T object);
    void deleteById(int id);
    void syncChanges();
    default T getById(int id) { return null ;}

    
} 
