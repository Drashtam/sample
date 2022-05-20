package com.example.sugar;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Unique;

public class Person extends SugarRecord {

//    public Person(){}

    @Unique
    @Column(name="id")
    int id = 0;

    @Column(name="name")
    String name = "";

    @Column(name = "age")
    int age = 0;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}
