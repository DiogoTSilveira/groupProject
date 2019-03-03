package org.academiadecodigo.groupproject.pacman.gameobjects;

//import org.academiadecodigo.groupproject.pacman.CollisionDetector;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Diogo
 * <p>
 * Give implementations after finishing the Player.
 */

public class Ghost extends GameObject {

    private CollisionDetector collisionDetector;
    private Picture picture;
    private Ellipse ghost;
    private boolean dead;
    private int col;
    private int row;

    public Ghost(int x, CollisionDetector collisionDetector, String string) {
        super(new Ellipse(x, 274 + 10, 12, 12), null);
        this.collisionDetector = collisionDetector;
        ghost = (Ellipse) super.shape;
        ghost.setColor(Color.GREEN);
        this.picture = new Picture(x, 280, string);

        this.picture.draw();
        //ghost.fill();
    }


    /**
     * The Ghost will get a random direction from Direction. This Ghost will not be able to change direction
     * until he faces an obstacle ahead of him. Uppon hitting a wall for example, the Ghost will not return from where he came.
     */
    public void move() {

        if (direction == null) {
            direction = Direction.UP;
            return;
        }

        if (Math.random() < 0.009) {
            direction = direction.randomDirection();
        }

        ghost.translate(direction.getX(), direction.getY());
        picture.translate(direction.getX(), direction.getY());

        if (collisionDetector.checkCollisionWithWalls(this)) {
            ghost.translate(-direction.getX(), -direction.getY());
            picture.translate(-direction.getX(), -direction.getY());
            direction = direction.changeDirection();
            while (collisionDetector.checkCollisionWithWalls(this)){
                ghost.translate(direction.getX(), direction.getY());
                picture.translate(direction.getX(), direction.getY());
            }

        }
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }

    public void die(){
        direction = null;
        picture.delete();
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }
}

