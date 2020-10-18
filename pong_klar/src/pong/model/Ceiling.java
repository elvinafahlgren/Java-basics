package pong.model;

import static pong.model.Pong.GAME_WIDTH;

/**
 * A Ceiling for the Pong game
 * A model class
 **/

public class Ceiling extends AbstractPositionable {

    /** Constructor **/
    // Y and width are never used.
    public Ceiling() {
        super(0, 0, 0, GAME_WIDTH);
    }

}
