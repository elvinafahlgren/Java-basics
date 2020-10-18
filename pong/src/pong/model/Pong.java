package pong.model;


import pong.event.ModelEvent;
import pong.event.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 */
public class Pong {

    Random rand = new Random();

    public static final double GAME_WIDTH = 600;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.02;
    public static final long HALF_SEC = 500_000_000;



    // TODO More attributes
    private int pointsLeft;
    private int pointsRight;
    private Paddle rightPaddle;
    private Paddle leftPaddle;
    private Ball ball;
    private double rightPaddleSpeed;
    private double leftPaddleSpeed;
    // Random speed direction for ball
    private double ballSpeedX = -BALL_SPEED_FACTOR + rand.nextDouble() * (2 * BALL_SPEED_FACTOR);
    private double ballSpeedY = -BALL_SPEED_FACTOR + rand.nextDouble() * (2 * BALL_SPEED_FACTOR);



    // TODO Constructor

    public Pong(Paddle rightPaddle, Paddle leftPaddle, Ball ball){
        this.rightPaddle = rightPaddle;
        this.leftPaddle = leftPaddle;
        this.ball = ball;
    }

    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
       // tODO Gamelogic here
        movePaddles();
        moveBall();
        ball.inc();
    }



    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        // TODO
        //lägga till allt som skall målas upp
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


    public void setSpeedRightPaddle(double speed) {
        rightPaddleSpeed = speed;
    }

    public void setSpeedLeftPaddle(double speed) {
        leftPaddleSpeed = speed;
    }

    // Return if the new Y values is in the playing field (CEILING and FLOOR)
    private boolean canSetY(Moveable object, double y){
        if(0 > y || GAME_HEIGHT <= (y + object.HEIGHT))
            return false;
        return true;
    }


    /*
    private boolean canSetX(Moveable object, double x){
        if(0 > x || GAME_WIDTH <= (x + object.WIDTH))
            return false;
        return true;
    }

     */


    private void movePaddles(){
        double rightPaddleNewY = rightPaddle.getY() + rightPaddleSpeed;
        double leftPaddleNewY = leftPaddle.getY() + leftPaddleSpeed;

        // If the new value Y of paddle is in the playing field we want to set
        if(canSetY(rightPaddle, rightPaddleNewY))
            rightPaddle.setY(rightPaddleNewY);

        if(canSetY(leftPaddle, leftPaddleNewY))
            leftPaddle.setY(leftPaddleNewY);
    }

    private void moveBall(){
        double increase = 0.05;
        double newX = ball.getX() + ballSpeedX;
        double newY = ball.getY() + ballSpeedY;


        if(canSetY(ball, newY))
            ball.setY(newY);
        else
            ballSpeedY = -ballSpeedY;

        if(ball.intersects(rightPaddle) || ball.intersects(leftPaddle)){
            ballSpeedX = -ballSpeedX;
            ballSpeedY = -ballSpeedY;
        }
        else
            ball.setX(newX);


        /*
        *if ball is outside field
        *       new ball
        *
         */
    }
}
