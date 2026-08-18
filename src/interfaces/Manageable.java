package interfaces;

public interface Manageable {
    //add an entity, remove by id, get all.
    void add(Object item);
    boolean removeById(String id);
    Object[]getAll();
}
