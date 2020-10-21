package pong.model;


import pong.event.EventBus;
import pong.event.ModelEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 **/

public class Pong {

    public static final double GAME_WIDTH = 600;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.02;
    //public static final long HALF_SEC = 500_000_000;
    private final Paddle rightPaddle;
    private final Paddle leftPaddle;
    private double rightPaddleSpeed;
    private double leftPaddleSpeed;
    private final Ceiling ceiling;
    private final Floor floor;
    private Ball ball;
    private int pointsLeft;
    private int pointsRight;

    /** Constructor **/
    public Pong(Ball ball, Paddle rightPaddle, Paddle leftPaddle, Floor floor, Ceiling ceiling) {
        this.ball = ball;
        this.rightPaddle = rightPaddle;
        this.leftPaddle = leftPaddle;
        this.floor = floor;
        this.ceiling = ceiling;
    }

    /** Methods **/

    private void movePaddle(Paddle p, double paddleSpeed){
        double paddleNewY = p.getY() + paddleSpeed;

        p.setY(paddleNewY);
        // Check if new position intersects, if it does, get previous position to paddle
        if(intersects(ceiling, p) || intersects(floor, p))
            p.setY(p.getY() - paddleSpeed);
    }

    private void givePoints() {
        if (ball.getX() < 0) {
            // Ball escaped on the left side. Right side wins.
            pointsRight++;
        }
        else {  // Ball escaped on the right side. Left side wins.
            pointsLeft++;
        }
    }

    private void collision() {
        if (intersects(floor, ball) || intersects(ceiling, ball)) {
            // Ball hit floor or ceiling. Bounce off.
            ball.bounce(false);
        }
        else if ( (intersects(leftPaddle, ball) && ball.getDx() < 0) || (intersects(rightPaddle, ball) && 0 < ball.getDx()) ) {
            // Ball hit left or right paddle. Bounce off if the ball is moving towards the paddle.
            ball.bounce(true);
        }
    }
    private boolean intersects (AbstractPositionable object1, AbstractPositionable object2) {
        /*
         * Checks if the ball is above, below, leftOf or rightOf the object.
         * Returns true if the ball is inside the object. That will say, neither of the booleans.
         */
        boolean above = object1.getMaxY() < object2.getY();
        boolean below = object2.getMaxY() < object1.getY();
        boolean leftOf = object1.getMaxX() < object2.getX();
        boolean rightOf = object2.getMaxX() < object1.getX();

        return !( above || below || leftOf || rightOf );
    }

    private boolean escaped() {
        return ball.getX() < -ball.getWidth() || ball.getX() > GAME_WIDTH;
    }

    // --------  Game Logic -------------

    //private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        movePaddle(rightPaddle, rightPaddleSpeed);
        movePaddle(leftPaddle, leftPaddleSpeed);
        ball.move();
        collision(); // If the ball collided with an object, bounce off the objects surface.
        if (escaped()) {
            givePoints();
            this.ball = new Ball(); // Create a new ball.
        }
    }

    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        drawables.add(ball);
        drawables.add(rightPaddle);
        drawables.add(leftPaddle);
        return drawables;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }
    public int getPointsRight() {
        return pointsRight;
    }

    public void setSpeedRightPaddle(double dy) {
        rightPaddleSpeed = dy;
    }

    public void setSpeedLeftPaddle(double dy) {
        leftPaddleSpeed = dy;
    }


}
