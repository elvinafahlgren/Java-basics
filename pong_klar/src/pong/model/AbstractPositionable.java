package pong.model;

public abstract class AbstractPositionable implements IPositionable {

    private double x;
    private double y;
    private final double height;
    private final double width;

    /** Constructor **/
    public AbstractPositionable (double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /** Methods **/
    public double getMaxX() {
        return x + width;
    }
    public double getMaxY() {
        return y + height;
    }

    /** Getters **/
    public double getX() { return x; }
    public double getY() { return y; }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    /** Setters **/
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

}
