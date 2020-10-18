package pong.model;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;

/**
 * A Floor for the Pong game
 * A model class
 **/

public class Floor extends AbstractPositionable {

    /** Constructor **/
    public Floor() {
        super(0, GAME_HEIGHT, 0, GAME_WIDTH);
    }

}
