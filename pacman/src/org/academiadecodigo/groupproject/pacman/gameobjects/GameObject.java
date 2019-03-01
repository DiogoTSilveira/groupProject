package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

public class GameObject {
    protected Shape shape;
    protected Direction direction;


    public GameObject(Shape shape, Direction direction) {
        this.direction = direction;
        this.shape = shape;

    }

    public int getX() {
        return shape.getX();
    }
    public int getY(){
        return shape.getY();
    }
    public int getWidth(){
        return shape.getWidth();
    }
    public int getHeight(){
        return shape.getHeight();
    }

    public Direction getDirection() {
        return direction;
    }
}
