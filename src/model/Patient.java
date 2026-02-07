package model;

import interfaces.Treatable;

public class Patient extends Person implements Treatable {

    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.diagnosis = diagnosis;
    }

    public Patient(String name, int age, String diagnosis) {
        this.name = name;
        setAge(age);
        this.diagnosis = diagnosis;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    @Override
    public void treat() {
        System.out.println("Patient is being treated");
    }

    @Override
    public void display() {
        System.out.println(id + " | " + name + " | " + age + " | " + diagnosis);
    }
}
