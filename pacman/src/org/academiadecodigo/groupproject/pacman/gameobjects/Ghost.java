package org.academiadecodigo.groupproject.pacman.gameobjects;

//import org.academiadecodigo.groupproject.pacman.CollisionDetector;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.Main;
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
    private int col;
    private int row;

    public Ghost(int x, CollisionDetector collisionDetector) {
        super(new Ellipse(x, 274 + 10, 12, 12), null);
        this.collisionDetector = collisionDetector;
        ghost = (Ellipse) super.shape;
        ghost.setColor(Color.GREEN);

        Picture picture = new Picture(x, 280, "resources/Webp.net-resizeimage.png");
        picture.draw();
        ghost.fill();
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

        if(Math.random() < 0.01) {
            direction = direction.randomDirection();
        }
        //if (collisionDetector.checkCollisionWithWalls(this)) {
        //  this.direction = direction.changeDirection();
        //ghost.translate(direction.getCol(), direction.getRow());
        //if (collisionDetector.checkCollisionWithWalls(this)) {
        //  ghost.translate(-direction.getCol(), -direction.getRow());
        //this.direction = direction.getOpposite();
        //}else return;
        ghost.translate(direction.getCol(), direction.getRow());


        //}

        if (collisionDetector.checkCollisionWithWalls(this)) {
            System.out.println("collision");
            ghost.translate(-direction.getCol(), -direction.getRow());
            move();
            return;
        }
    }

}

