package menu;

import exception.InvalidAgeException;
import interfaces.Menu;
import model.*;
import java.util.*;

public class MenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();

    public MenuManager() {
        try {
            Doctor defaultDoctor = new Doctor("Dr. House", 50, "Diagnostics");
            doctors.add(defaultDoctor);

            patients.add(new Patient("Alice", 25, new MedicalRecord("Flu", true)));
            patients.add(new Patient("Bob", 40, new MedicalRecord("Headache", false)));
            patients.add(new Patient("Charlie", 33, new MedicalRecord("Back Pain", true)));

        } catch (InvalidAgeException e) {
            throw new RuntimeException("Initialization error: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n HOSPITAL MANAGEMENT MENU ");
        System.out.println("1. Register Patient");
        System.out.println("2. Show All Patients");
        System.out.println("3. Doctor Treats Patient");
        System.out.println("4. Register Doctor");
        System.out.println("5. Show All Doctors");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    @Override
    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> registerPatient();
                    case 2 -> displayPatients();
                    case 3 -> treatPatients();
                    case 4 -> registerDoctor();
                    case 5 -> displayDoctors();
                    case 0 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void registerPatient() throws InvalidAgeException {
        System.out.print("Enter patient's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patient's age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Is the patient in hospital? (true/false): ");
        boolean inHospital = Boolean.parseBoolean(scanner.nextLine());

        MedicalRecord record = new MedicalRecord(diagnosis, inHospital);
        Patient patient = new Patient(name, age, record);
        patients.add(patient);

        System.out.println("Patient registered: " + patient);
    }

    private void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            System.out.println("Registered Patients");
            patients.forEach(System.out::println);
        }
    }

    private void registerDoctor() throws InvalidAgeException {
        System.out.print("Enter doctor's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter doctor's age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, age, specialization);
        doctors.add(doctor);
        System.out.println("Doctor registered: " + doctor);
    }

    private void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            System.out.println("--- Registered Doctors ---");
            doctors.forEach(System.out::println);
        }
    }

    private void treatPatients() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available to treat patients.");
            return;
        }

        System.out.println("--- Doctors on Duty ---");

        for (Doctor d : doctors) {
            d.treat();
        }
    }
}