package swp4.koch.ue05.ex1.app.dao.jdbc;

import java.util.List;

public interface Dao<T> {

    T readEntryByte(Long identity);
    List<T> readAllEntries();
    boolean insertEntry(T entity);
    boolean updateEntry(Long identity);
    boolean deleteEntry(Long identity);


}
