package swp4.koch.ue05.ex1.app.dao.jdbc.impl;

import swp4.koch.ue05.ex1.app.dao.domain.Person;
import swp4.koch.ue05.ex1.app.dao.jdbc.AbstractDaoJdbc;
import swp4.koch.ue05.ex1.app.dao.jdbc.PersonDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbc extends AbstractDaoJdbc implements PersonDao {
    private static final String TABLE_NAME = "PERSON";
    @Override
    public Person readEntryByte(Long identity) {
        return null;
    }

    @Override
    public List<Person> readAllEntries() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Person> persons = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                persons.add(constructPersonResultSet(resultSet));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException();
        }
        return persons;
    }


    private Person constructPersonResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String city = resultSet.getString(4);
        Integer plz = resultSet.getInt(5);
        String address = resultSet.getString(6);
        String telephone = resultSet.getString(7);

        return new Person(id, firstName, lastName, city, plz, address, telephone);
    }

    @Override
    public boolean insertEntry(Person entity) {
        String sql = "INSERT INTO " + TABLE_NAME + " (firstName, lastName, city, plz, address, telephone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, entity.firstName());
            statement.setString(2, entity.lastName());
            statement.setInt(3, entity.plz());
            statement.setString(4, entity.address());
            statement.setString(5, entity.telephone());

            return statement.executeUpdate() > 0;

        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public boolean updateEntry(Long identity) {
        return false;
    }

    @Override
    public boolean deleteEntry(Long identity) {
        //TODO: statemtn mit ?, set die ID, execute mit delete
        return false;
    }
}
