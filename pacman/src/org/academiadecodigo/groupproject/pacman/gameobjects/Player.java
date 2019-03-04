package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.Direction;
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
    private Direction oldDirection;
    private Picture oldPicture;
    private Direction nextDirection;

    public Player(CollisionDetector collisionDetector) {
        super(new Ellipse(304 + 10, 324 + 10, 12, 12), null);
        this.collisionDetector = collisionDetector;
        player = (Ellipse) super.shape;
        right = new Picture(310, 330, "resources/Pacman/RIGHT.png");
        down = new Picture(310, 330, "resources/Pacman/DOWN.png");
        up = new Picture(310, 330, "resources/Pacman/UP.png");
        left = new Picture(310, 330, "resources/Pacman/Left.png");
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

    public void move() throws InterruptedException {
        if (direction == null) {
            player.translate(0, 0);
            picture.translate(0, 0);
            return;
        }
        tryDirection();
        player.translate(direction.getX() * 2, direction.getY() * 2);
        picture.translate(direction.getX() * 2, direction.getY() * 2);

        if (collisionDetector.checkCollisionWithWalls(this)) {
            player.translate(-direction.getX() * 2, -direction.getY() * 2);
            picture.translate(-direction.getX() * 2, -direction.getY() * 2);
            if (picture == null || oldPicture == null) {
                return;
            }
            direction = oldDirection;
            newPicture(oldPicture);
            return;
        }
        oldPicture = picture;
        newPicture(getPicture(direction.name()));
        oldDirection = direction;
    }

    private void translatePicture(Picture picture) {
        int initialXPosition = picture.getX();
        int initialYPosition = picture.getY();
        picture.translate(player.getX() - initialXPosition - 4, player.getY() - initialYPosition - 4);

    }

    private void newPicture(Picture picture) {
        this.picture.delete();
        translatePicture(picture);
        this.picture = picture;
        this.picture.draw();


    }

    private Picture getPicture(String picture) {
        if (picture == "UP") {
            return up;
        }
        if (picture == "DOWN") {
            return down;
        }
        if (picture == "LEFT") {
            return left;
        }
        return right;

    }

    private boolean tryDirection() {
        player.translate(nextDirection.getX() * 2, nextDirection.getY() * 2);

        if (collisionDetector.checkCollisionWithWalls(this)) {
            player.translate(-nextDirection.getX() * 2, -nextDirection.getY() * 2);
            return false;
        }
        player.translate(-nextDirection.getX() * 2, -nextDirection.getY() * 2);
        if (direction != nextDirection) {
            player.translate(direction.getX() * 2, direction.getY() * 2);
        }
        direction = nextDirection;
        return true;

    }

    public int dash(Boolean isdash) {
        if (isdash) {
            return 2;
        }
        return 1;
    }


}
