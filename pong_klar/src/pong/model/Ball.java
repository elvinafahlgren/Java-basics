package pong.model;

import pong.event.EventBus;
import pong.event.ModelEvent;

import java.util.Random;

import static pong.model.Pong.*;

/**
 * A Ball for the Pong game
 * A model class
 **/

public class Ball extends AbstractPositionable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;
    private double dx; // Speed and direction on the x-axis.
    private double dy; // Speed and direction on the y-axis.

    /** Constructor **/
    public Ball() {
        // A ball is created. Placed in the very middle of the canvas with random speed and random direction.
        super(GAME_WIDTH/2 - WIDTH/2, GAME_HEIGHT/2 - HEIGHT/2, HEIGHT, WIDTH);
        randDxAndDy(); // Randomizes speed and direction.
    }

    /** Methods **/
    public void move() {
        // Constantly changes the value of x and y in AbstractPositionable.
        setX( getX() + dx );
        setY( getY() + dy );
    }
    public void incSpeed() {
        dx = dx * BALL_SPEED_FACTOR;
        dy = dy * BALL_SPEED_FACTOR;
    }

    private void randDxAndDy() {
        Random rand = new Random();

        int[] directions = {-1,1};
        int randDirX = directions[rand.nextInt(2)]; // Generate a random direction (-1, 1).
        int randDirY = directions[rand.nextInt(2)]; // Generate a random direction (-1, 1).
        int randSpeedX = 3 + rand.nextInt(2);       // Generate a random speed on the X-axis (3,4).
        int randSpeedY = 2 + rand.nextInt(2);       // Generate a random speed on the Y-axis (2,3).

        dx = randDirX * randSpeedX;
        dy = randDirY * randSpeedY;
    }

    public double getDx() {
        return this.dx;
    }

    public void bounce(boolean bouncedX) {
        // Switches direction for the movement on X- or Y-axis.
        if (bouncedX) {
            // Ball hit a paddle. Increase speed and play sound.
            EventBus.INSTANCE.publish(ModelEvent.Type.BALL_HIT_PADDLE);
            dx = -1 * dx;
            incSpeed();
        }
        else{
            // Ball hit floor och ceiling.
            dy = -1 * dy;
        }
    }

}
