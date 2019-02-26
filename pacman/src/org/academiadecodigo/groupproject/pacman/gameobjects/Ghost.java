package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.Direction;

/**
 * Diogo
 *
 * Give implementations after finishing the Player.
 */

public class Ghost extends GameObject{

    private Direction direction;
    private CollisionDetector collisionDetector;

    public Ghost(){
    }


    /*
    * The Ghost will get a random direction from Direction. This Ghost will not be able to change direction
    * until he faces an obstacle ahead of him. Uppon hitting a wall for example, the Ghost will not return from where he came.
    * */
    public void move(){
        //direction.getRandomDirection();
    }
}
