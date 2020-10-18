package exercises.ex1inheritance;

import javafx.scene.paint.Color;

public class Car extends Vehicle{

    // TODO

    public Car(Person p, String id, double topSpeed){
        super(p, id, topSpeed);
    }

    @Override
    public String toString() {
        return "Car{topSpeed=" +
                getTopSpeed() +
                "{owner=" + getPerson() +
                ", id='" + getId() +
                "'}}";
    }
}
