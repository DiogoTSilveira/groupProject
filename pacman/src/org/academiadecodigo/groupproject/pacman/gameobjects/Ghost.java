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
    private int col;
    private int row;

    public Ghost(int x, CollisionDetector collisionDetector) {
        super(new Ellipse(x,280,20,20 ),null );
        this.collisionDetector =collisionDetector;
        ghost = (Ellipse) super.shape;
        ghost.setColor(Color.GREEN);
        Picture nuno = new Picture(x, 280, "resources/Webp.net-resizeimage.png");

        ghost.fill();
    }

    /*  public void setDirection(){
        direction = Direction.randomDirection();

        switch (direction){
            case UP:
                ghost.setColor(Color.BLUE);;
                row = -1;
                col = 0;
                break;

            case DOWN:
                ghost.setColor(Color.YELLOW);
                row = 1;
                col = 0;
                break;

            case RIGHT:
                ghost.setColor(Color.BLACK);
                row = 0;
                col = 1;
                break;

            case LEFT:
                ghost.setColor(Color.CYAN);
                row = 0;
                col = -1;
                break;

        }
    }*/

    /**
     * The Ghost will get a random direction from Direction. This Ghost will not be able to change direction
     * until he faces an obstacle ahead of him. Uppon hitting a wall for example, the Ghost will not return from where he came.
     * */
    public void  move() {

        if (direction == null) {
            direction = Direction.UP;
            return;
        }
        if (Math.random() < 0.09 ) {
            this.direction = direction.changeDirection();
            if(Math.random() < 0.2){
                direction.getOpposite();
            }
        }

        if(collisionDetector.checkCollisionWithWalls(this)) {
            move();
            return;
        }

        ghost.translate(direction.getCol()-1, direction.getRow()-1);
    }
}
