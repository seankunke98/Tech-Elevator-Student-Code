package com.techelevator.demo;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNameAndAge(){
        return this.name +  " " + this.age +" means you are really old!!";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj){
        //because obj is accessing Object, we need to convert obj to Person
        Person other = (Person) obj; //downcasting - more on this next week
        return this.name.equals(other.getName());
    }

    @Override
    public String toString(){
        return this.name + ", " + this.age;
    }

//    @Override
//    public int hashCode(){
//        return this.age;
//    }
}
