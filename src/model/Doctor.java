package model;

import exception.InvalidAgeException;
import interfaces.Treatable;

public class Doctor extends Person implements Treatable {
    private String specialization;

    public Doctor(String name, int age, String specialization) throws InvalidAgeException {
        super(name, age);
        setSpecialization(specialization);
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isBlank()) {
            this.specialization = "General";
        } else {
            this.specialization = specialization;
        }
    }

    @Override
    public void work() {
        System.out.println("Doctor " + getName() + " is treating patients in " + specialization + " department.");
    }

    @Override
    public void treat() {
        System.out.println(getName() + " is treating patients as a " + specialization + " doctor.");
    }

    @Override
    public String toString() {
        return "Doctor: " + getName() + ", Age: " + getAge() + ", Specialization: " + specialization;
    }
}
