package exercises.ex2asteroids;

public abstract class MoveableInSpace {

    private double x;      // x, y upper left corner
    private double y;
    private final double width;
    private final double height;

    private double dx;   // Speed
    private double dy;

    public MoveableInSpace(double x, double y, double width, double height, double dx, double dy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getMaxX() {
        return x + width;
    }

    public double getMaxY() {
        return y + height;
    }

    public void stop() {
        dx = dy = 0;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}

