package model;

import exceptions.InvalidAgeException;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;

    public void setAge(int age) {
        if (age <= 0)
            throw new InvalidAgeException("Age must be positive");
        this.age = age;
    }

    public abstract void display();
}
