package swp4.koch.ue05.ex1.app.ui.model;

import swp4.koch.ue05.ex1.app.dao.domain.Person;
import swp4.koch.ue05.ex1.app.dao.jdbc.PersonDao;
import swp4.koch.ue05.ex1.app.dao.jdbc.impl.PersonDaoJdbc;

import java.util.List;

public class PersonModel {
    private Person currentPerson;
    private List<Person> persons;
    private PersonDao personDao;

    public PersonModel() {
        personDao = new PersonDaoJdbc();
        loadPersons();
    }

    public void loadPersons() {
        persons = personDao.readAllEntries();
    }

    public void addPerson(Person person) {
        personDao.insertEntry(person);
        loadPersons();
    }

    public void updatePerson(Person person) {
        personDao.updateEntry(person.id());
        loadPersons();
    }

    public void deletePerson(Long personId) {
        personDao.deleteEntry(personId);
        loadPersons();
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public Person getPersonById(Long personId) {
        return persons.stream()
                .filter(person -> person.id().equals(personId))
                .findFirst()
                .orElse(null);
    }

    public void setCurrentPerson(Person person) {
        this.currentPerson = person;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
