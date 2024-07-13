package swp4.koch.ue05.ex1.app.ui.view;

import swp4.koch.ue05.ex1.app.dao.domain.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("=== Person Database ===");
        System.out.println("1. Add Person");
        System.out.println("2. Update Person");
        System.out.println("3. Delete Person");
        System.out.println("4. Display All Persons");
        System.out.println("5. Exit");
        System.out.print("Choice: ");
    }

    public void displayPersons(List<Person> persons) {
        System.out.println("=== Person List ===");
        for (Person person : persons) {
            displayPerson(person);
            System.out.println("---------------------");
        }
    }

    public void displayPerson(Person person) {
        System.out.println("ID: " + person.id());
        System.out.println("First Name: " + person.firstName());
        System.out.println("Last Name: " + person.lastName());
        System.out.println("City: " + person.city());
        System.out.println("PLZ: " + person.plz());
        System.out.println("Address: " + person.address());
        System.out.println("Phone Number: " + person.telephone());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getMenuChoice() {
        return scanner.nextInt();
    }

    public Person getPersonDetails() {
        System.out.print("First Name: ");
        String firstName = scanner.next();

        System.out.print("Last Name: ");
        String lastName = scanner.next();

        System.out.print("City: ");
        String city = scanner.next();

        System.out.print("Plz: ");
        int plz = scanner.nextInt();

        System.out.print("Address: ");
        String address = scanner.next();

        System.out.print("Phone Number: ");
        String telephone = scanner.next();

        return new Person(null, firstName, lastName, city, plz, address, telephone);
    }

    public long getPersonId() {
        System.out.print("Enter the ID of the person: ");
        return scanner.nextLong();
    }

}
