package pong.model;

import java.util.Random;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball extends Moveable{

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;

    public Ball(double x, double y) {
        super(WIDTH, HEIGHT, x, y);

    }
    public Ball() {
        super(WIDTH, HEIGHT, GAME_WIDTH / 2, GAME_HEIGHT / 2);
    }

    public void inc(){

    }

}
