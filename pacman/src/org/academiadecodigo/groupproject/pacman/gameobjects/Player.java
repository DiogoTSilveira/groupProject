package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Diogo
 */

public class Player extends GameObject {

    private CollisionDetector collisionDetector;
    private Direction direction;
    private Picture picture;
    private Picture down;
    private Picture up;
    private Picture left;
    private Picture right;

    private Ellipse player;

    public Player(CollisionDetector collisionDetector) {
        super(new Ellipse(304 + 10, 324 + 10, 12, 12), null);
        this.collisionDetector = collisionDetector;
        player = (Ellipse) super.shape;
        player.draw();
        right = new Picture(310, 330, "resources/Pacman/RIGHT.png");
        picture = right;
        down = new Picture(310, 330, "resources/Pacman/DOWN.png");
        up = new Picture(310, 330, "resources/Pacman/UP.png");
        left = new Picture(310, 330, "resources/Pacman/Left.png");

        picture.draw();
    }


    public Direction getDirection() {
        return direction;
    }

    /**
     * This method will use the keyboard to set movement to the Player.
     *
     * @param direction - Which direction is the Player going.
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
        switch (direction) {
            case UP:
                this.direction = Direction.UP;
                newPicture(up);
                break;

            case DOWN:
                this.direction = Direction.DOWN;
                newPicture(down);
                break;

            case RIGHT:
                this.direction = Direction.RIGHT;
                newPicture(right);
                break;

            case LEFT:
                this.direction = Direction.LEFT;
                newPicture(left);
                break;

        }
    }

    public void move() {


        if (direction == null) {

            player.translate(0, 0);
            picture.translate(0, 0);

            return;

        }
        player.translate(direction.getCol(), direction.getRow());
        picture.translate(direction.getCol(), direction.getRow());

        if (collisionDetector.checkCollisionWithWalls(this)) {
            player.translate(-direction.getCol(), -direction.getRow());
            picture.translate(-direction.getCol(), -direction.getRow());
            return;
        }


    }

    public int getCol() {
        return direction.getCol();
    }

    public int getRow() {
        return direction.getRow();

    }
    private void translatePicture(Picture picture){
        int initialXPosition = picture.getX();
        int initialYPosition = picture.getY();
        picture.translate(player.getX() - initialXPosition-4, player.getY() - initialYPosition-4);

    }
    private void newPicture(Picture picture){
        //this.picture.delete();
        translatePicture(picture);
        this.picture = picture;
        this.picture.draw();


    }

}
