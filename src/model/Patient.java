package model;

import exception.InvalidAgeException;

public class Patient extends Person {
    private final MedicalRecord record;

    public Patient(String name, int age) throws InvalidAgeException {
        super(name, age);
        this.record = new MedicalRecord("Undiagnosed", false);
    }

    public Patient(String name, int age, MedicalRecord record) throws InvalidAgeException {
        super(name, age);
        this.record = record;
    }

    public MedicalRecord getRecord() {
        return record;
    }

    @Override
    public void work() {
        if (record.isInHospital()) {
            System.out.println("Patient " + getName() + " is staying in hospital with diagnosis: " + record.getDiagnosis());
        } else {
            System.out.println("Patient " + getName() + " is treated as outpatient");
        }
    }

    @Override
    public String toString() {
        return "Patient: " + getName() + ", Age: " + getAge() + ", " + record;
    }
}
