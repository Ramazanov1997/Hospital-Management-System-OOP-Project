package model;

import exception.InvalidAgeException;
import interfaces.Workable;

public abstract class Person implements Workable {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public abstract void work();

    @Override
    public abstract String toString();
}
