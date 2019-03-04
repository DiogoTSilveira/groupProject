package org.academiadecodigo.groupproject.pacman;

/**
 * Jorge
 */

public enum Direction {
    UP(0,-2),
    DOWN(0,2),
    LEFT(-2,0),
    RIGHT(2,0);
    private int x;
    private int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction randomDirection(){
        if (Math.random()< 0.25 ){
            return UP;
        }
        if (Math.random() < 0.5){
            return DOWN;

        }
        if(Math.random() < 0.75){
            return LEFT;
        }
        return RIGHT;
    }

    public  Direction changeDirection() {

        switch (this) {
            case UP:
                return changeFromVertical();

            case DOWN:
                return changeFromVertical();

            case LEFT:
                return changeFromHorizontal();

            case RIGHT:
                return changeFromHorizontal();
        }
        return null;
    }



    public Direction getOpposite() {
        switch (this) {
            case UP:
                return DOWN;

            case DOWN:
                return UP;

            case LEFT:
                return RIGHT;

            case RIGHT:
                return LEFT;
        }

        return null;
    }





    private Direction changeFromVertical() {

        if (Math.random() < 0.5) {
            return LEFT;
        }
        return RIGHT;

    }


    private Direction changeFromHorizontal() {

        if (Math.random() < 0.5) {
            return UP;
        }
        return DOWN;
    }

}
