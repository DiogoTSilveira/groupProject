package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Movable;

import java.awt.*;

/**
 * Diogo
 */

public class Player extends GameObject{

    private Direction currentDirection;
    private Direction newDirection;

    private CollisionDetector collisionDetector;

    private int col;
    private int row;

    Ellipse player;

    public Player(){
        player = new Ellipse(310,330,20, 20);
        player.setColor(Color.YELLOW);
        player.fill();
    }

    /**
     * This method will use the keyboard to set movement to the Player.
     * @param direction - Which direction is the Player going.
     */
    public void setDirection(Direction direction){
        switch (direction){
            case UP:
                player.setColor(Color.BLUE);;
                row = -1;
                col = 0;
                break;

            case DOWN:
                player.setColor(Color.YELLOW);
                row = 1;
                col = 0;
                break;

            case RIGHT:
                player.setColor(Color.BLACK);
                row = 0;
                col = 1;
                break;

            case LEFT:
                player.setColor(Color.CYAN);
                row = 0;
                col = -1;
                break;

        }
    }

    public void move(){
        player.translate(col, row);
    }
}
