package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

abstract class Moveable implements IPositionable{

    public double WIDTH;
    public double HEIGHT;
    private double x;
    private double y;

    public Moveable(double WIDHT, double HEIGHT, double x, double y){
        this.WIDTH = WIDHT;
        this.HEIGHT = HEIGHT;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX(){
        return x;
    }

    @Override
    public double getY(){
        return y;
    }

    @Override
    public double getWidth(){
        return WIDTH;
    }

    @Override
    public double getHeight(){
        return HEIGHT;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

    public boolean intersects(Moveable object){
        if(object.getX() >= x && object.getX() <= x + WIDTH ||
           object.getX() + object.getWidth() >= x && object.getX() + object.getWidth() <= x + WIDTH)
            if(object.getY() >= y && object.getY() <= y + HEIGHT ||
                    object.getY() + object.getHeight() >= y && object.getY() + object.getHeight() <= y + HEIGHT)
                return true;
        return false;
    }
}
