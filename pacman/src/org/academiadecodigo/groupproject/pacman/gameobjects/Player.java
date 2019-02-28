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

    private CollisionDetector collisionDetector;
    private Direction direction;

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
        this.direction = direction;
        switch (direction){
            case UP:
                player.setColor(Color.BLUE);
                this.direction = Direction.UP;
                System.out.println(direction.getCol() + " " + direction.getRow());
                break;

            case DOWN:
                player.setColor(Color.YELLOW);
                this.direction = Direction.DOWN;
                break;

            case RIGHT:
                player.setColor(Color.BLACK);
                this.direction = Direction.RIGHT;
                break;

            case LEFT:
                player.setColor(Color.CYAN);
                this.direction = Direction.LEFT;
                break;

        }
    }

    public void move(){
        if(direction == null){
            player.translate(0,0);
            return;
        }
        player.translate(direction.getCol(), direction.getRow());

    }
}
