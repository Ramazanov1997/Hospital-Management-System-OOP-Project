package menu;

import dao.PatientDAO;
import model.Patient;

import java.util.Scanner;

public class MenuManager {

    private final PatientDAO dao = new PatientDAO();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("""
            1. Add patient
            2. Show all
            3. Update
            4. Delete
            5. Search by name
            6. Search by age
            0. Exit
            """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> add();
                case 2 -> dao.getAll().forEach(Patient::display);
                case 3 -> update();
                case 4 -> delete();
                case 5 -> searchName();
                case 6 -> searchAge();
                case 0 -> System.exit(0);
            }
        }
    }

    private void add() {
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Diagnosis: ");
        String d = sc.nextLine();

        dao.insertPatient(new Patient(n, a, d));
    }

    private void update() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New name: ");
        String n = sc.nextLine();
        System.out.print("New age: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("New diagnosis: ");
        String d = sc.nextLine();

        dao.updatePatient(new Patient(id, n, a, d));
    }

    private void delete() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure? (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            dao.deleteById(id);
        }
    }

    private void searchName() {
        System.out.print("Name: ");
        dao.searchByName(sc.nextLine()).forEach(Patient::display);
    }

    private void searchAge() {
        System.out.print("Age from: ");
        dao.searchByAge(sc.nextInt()).forEach(Patient::display);
    }
}
