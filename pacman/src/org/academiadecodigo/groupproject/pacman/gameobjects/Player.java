package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;
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
        player = new Ellipse(50,50,10,10);
        player.fill();
        player.draw();
    }

    /**
     * This method will use the keyboard to set movement to the Player.
     * @param direction - Which direction is the Player going.
     */
    public void move(Direction direction){

    }

    public void move(){

        keyboardListener = new KeyboardListener(player);
    }


}
