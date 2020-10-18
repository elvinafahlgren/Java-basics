package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/**
 * A Paddle for the Pong game
 * A model class
 *
 **/

public class Paddle extends AbstractPositionable {

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static double PADDLE_SPEED = 5;

    /** Constructor **/
    public Paddle(double xPosition, double yPosition) {
        super(xPosition, yPosition, PADDLE_HEIGHT, PADDLE_WIDTH);
    }

}
