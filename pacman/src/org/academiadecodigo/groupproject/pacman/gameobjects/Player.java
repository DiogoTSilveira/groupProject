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

    private Direction direction;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;

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
    public void move(Direction direction){
        int col = player.getX();
        int row = player.getY();

        switch (direction){
            case UP:
                player.setColor(Color.BLUE);
                break;

            case DOWN:
                player.setColor(Color.YELLOW);
                break;

            case RIGHT:
                player.setColor(Color.BLACK);
                break;

            case LEFT:
                player.setColor(Color.CYAN);
        }

    }

    public void move(){



    }
}
