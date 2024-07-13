package swp4.koch.ue05.ex1.app.ui.controller;

import swp4.koch.ue05.ex1.app.dao.domain.Person;
import swp4.koch.ue05.ex1.app.dao.jdbc.PersonDao;
import swp4.koch.ue05.ex1.app.dao.jdbc.impl.PersonDaoJdbc;
import swp4.koch.ue05.ex1.app.ui.model.PersonModel;
import swp4.koch.ue05.ex1.app.ui.view.ConsoleView;

public class ConsoleController {
    private PersonModel personModel;
    private ConsoleView consoleView;

    public ConsoleController() {
        personModel = new PersonModel();
        consoleView = new ConsoleView();
    }

    public void run() {
        boolean running = true;
        while (running) {
            consoleView.displayMenu();
            int choice = consoleView.getMenuChoice();

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> updatePerson();
                case 3 -> deletePerson();
                case 4 -> displayAllPersons();
                case 5 -> running = false;
                default -> consoleView.displayMessage("Invalid choice!");
            }
        }
    }

    private void addPerson() {
        Person person = consoleView.getPersonDetails();
        personModel.addPerson(person);
        consoleView.displayMessage("Person added successfully.");
    }

    private void updatePerson() {
        Long personId = consoleView.getPersonId();
        Person existingPerson = personModel.getPersonById(personId);

        if (existingPerson != null) {
            Person updatedPerson = consoleView.getPersonDetails();
            personModel.updatePerson(new Person(personId, updatedPerson.firstName(), updatedPerson.lastName(),
                    updatedPerson.city(), updatedPerson.plz(), updatedPerson.address(), updatedPerson.telephone()));
            consoleView.displayMessage("Person updated successfully.");
        } else {
            consoleView.displayMessage("Person not found.");
        }
    }

    private void deletePerson() {
        Long personId = consoleView.getPersonId();
        Person existingPerson = personModel.getPersonById(personId);

        if (existingPerson != null) {
            personModel.deletePerson(personId);
            consoleView.displayMessage("Person deleted successfully.");
        } else {
            consoleView.displayMessage("Person not found.");
        }
    }

    private void displayAllPersons() {
        consoleView.displayPersons(personModel.getPersons());
    }
}
