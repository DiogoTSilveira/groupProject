package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Jorge
 */

public class WallFactory {

    private Rectangle walls;




    public void createGameField(){
        createWall(4, 8, 2, 42 );
        createWall(54, 8, 2, 42);

    }


    private Rectangle createWall(int x, int y, int weigth, int higth){

        Rectangle rectangle =  new Rectangle(x, y, weigth, higth);
        rectangle.fill();
        rectangle.draw();
        return rectangle;

    }




}
