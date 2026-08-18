package interfaces;

public interface Searchable {
    //search by keyword, search by id
    Object[]search(String keyword);
    Object searchById(String id);
}
