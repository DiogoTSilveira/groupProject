package org.academiadecodigo.groupproject.pacman.gameobjects;


import org.academiadecodigo.groupproject.pacman.Game;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Ze Diogo
 */

public class CollisionDetector {

    protected int playerX;
    protected int playerY;

    protected int ghostX;
    protected int ghostY;
    private Shape[] walls;

    public CollisionDetector() {
    }

    public void setWalls(Shape[] walls) {
        this.walls = walls;
    }

    public void setPlayerPosition(int x, int y) {
        playerX = x;
        playerY = y;
    }

    public void setGhostPosition(int x, int y) {
        ghostX = x;
        ghostY = y;
    }

    public boolean checkCollisionWithWalls(GameObject gameObject) {
        return (checkCollisionUp(gameObject) ||
                checkCollisionDown(gameObject) ||
                checkCollisionRight(gameObject) ||
                checkCollisionLeft(gameObject));

    }

    public boolean checkCollisionWithGhosts(Player player, Ghost[] ghosts) {

        return false;
    }


    private boolean checkCollisionUp(GameObject gameObject) {

        int yPlayer = gameObject.getY();

        for (int i = 0; i < walls.length; i++) {

        int wallBottom = walls[i].getY() + walls[i].getHeight();
            System.out.println(yPlayer-wallBottom);
            if (yPlayer < wallBottom &&  yPlayer-wallBottom   ) {
                System.out.println("HIT");
                return true;
            }
        }
        return false;
    }

    private boolean checkCollisionDown(GameObject gameObject) {
        return false;
    }

    private boolean checkCollisionRight(GameObject gameObject) {
        return false;
    }

    private boolean checkCollisionLeft(GameObject gameObject) {
        return false;
    }


}
