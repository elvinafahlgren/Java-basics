package exercises.ex1inheritance;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Vehicle {

    public Person p;
    public String id;
    public double topSpeed;

    public Vehicle(Person p, String id, double topSpeed){
        this.p = p;
        this.id = id;
        this.topSpeed = topSpeed;
    }

    public String getId(){
        return id;
    }

    public Person getPerson(){
        return p;
    }

    public double getTopSpeed(){
        return topSpeed;
    }

}
