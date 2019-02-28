package org.academiadecodigo.groupproject.pacman;

/**
 * Jorge
 */

public enum Direction {
    UP(0,-5),
    DOWN(0,5),
    LEFT(-5,0),
    RIGHT(5,0);
    private int col;
    private int row;

    Direction(int col, int row){
        this.col = col;
        this.row = row;
    }

    public static Direction randomDirection(){

        return Direction.values()[(int) (Math.random() * Direction.values().length)];
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
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
