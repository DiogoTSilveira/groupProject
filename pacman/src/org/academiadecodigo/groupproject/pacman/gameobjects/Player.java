package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;

/**
 * Diogo
 */

public class Player extends GameObject{

    private Direction direction;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;

    public Player(){
        //keyboardListener = new KeyboardListener();
    }

    /**
     * This method will use the keyboard to set movement to the Player.
     * @param direction - Which direction is the Player going.
     */
    public void move(Direction direction){



    }


}
