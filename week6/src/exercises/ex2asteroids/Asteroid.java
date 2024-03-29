package exercises.ex2asteroids;

/*
    Class representing a single Asteroid

 */
public class Asteroid extends MoveableInSpace {

    private double x;      // x, y upper left corner
    private double y;

    public Asteroid(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height, dx, dy);
    }

}
