package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
    private Rectangle player;
    private Direction oldDirection;
    private Picture oldPicture;
    private Direction nextDirection;
    private boolean dash;
    private int speed;

    public Player(CollisionDetector collisionDetector) {
        super(new Rectangle(301, 321, 18 , 18), null);
        speed = 1;
        this.collisionDetector = collisionDetector;
        player = (Rectangle) super.shape;
        right = new Picture(301, 321, "resources/Pacman/RIGHT.png");
        down = new Picture(301, 321, "resources/Pacman/DOWN.png");
        up = new Picture(301, 321, "resources/Pacman/UP.png");
        left = new Picture(301, 321, "resources/Pacman/Left.png");
        picture = right;
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
                this.nextDirection = Direction.UP;
                break;

            case DOWN:
                this.nextDirection = Direction.DOWN;
                break;

            case RIGHT:
                this.nextDirection = Direction.RIGHT;
                break;

            case LEFT:
                this.nextDirection = Direction.LEFT;
                break;
        }
    }

    public void move() {
        if (direction == null) {
            return;
        }
        tryDirection();
        translate(direction);

        if (collisionDetector.checkCollisionWithWalls(this)) {
            translateBack(direction);


            if (picture == null || oldPicture == null) {
                return;
            }
            if (direction != oldDirection) {
                translate(oldDirection);
                if (collisionDetector.checkCollisionWithWalls(this)) {
                    translateBack(oldDirection);
                }
            }
            direction = oldDirection;
            newPicture(oldPicture);
            return;

        }
        oldPicture = picture;
        newPicture(getPicture(direction));
        oldDirection = direction;
    }

    private void translatePicture(Picture picture) {
        int initialXPosition = picture.getX();
        int initialYPosition = picture.getY();
        picture.translate(player.getX() - initialXPosition , player.getY() - initialYPosition);

    }

    private void newPicture(Picture picture) {
        this.picture.delete();
        translatePicture(picture);
        this.picture = picture;
        this.picture.draw();


    }

    private Picture getPicture(Direction direction) {
        switch (direction) {
            case RIGHT:
                return right;
            case UP:
                return up;
            case DOWN:
                return down;
            case LEFT:
                return left;
        }
        return null;
    }

    private void tryDirection() {
        translate(nextDirection);

        if (collisionDetector.checkCollisionWithWalls(this)) {
            translateBack(nextDirection);
            return;
        }
        translateBack(nextDirection);
        direction = nextDirection;
    }

    private void translate(Direction direction) {
        player.translate(direction.getX() * 2, direction.getY() * 2);
        picture.translate(direction.getX() * 2, direction.getY() * 2);

    }

    private void translateBack(Direction direction) {
        player.translate(-direction.getX() * 2, -direction.getY() * 2);
        picture.translate(-direction.getX() * 2, -direction.getY() * 2);

    }

    public void hidePlayer() {
        player.delete();
    }

    public boolean dash() {

return false;
    }

}
