package exercises.ex1inheritance;

public class Van extends Vehicle{

    // TODO

    public Van(Person p, String id, double topSpeed) {
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
