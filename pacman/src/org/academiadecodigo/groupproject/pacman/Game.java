package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle rectangle;
    private Player player;
    private Ghost ghost;

    private CollisionDetector collisionDetector;


    public void init(){

    }

    public void start(){

    }

    public void moveGhosts(){
        ghost.move();
    }
}
