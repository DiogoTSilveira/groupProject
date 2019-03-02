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
            System.out.println("Player y: " + gameObject.getY() + " \n Wall y+Height: " + (walls[i].getY() + walls[i].getHeight()));
            if (yPlayer == wallBottom) {

                if ((gameObject.getX() > walls[i].getX()
                        && gameObject.getX() < walls[i].getX() + walls[i].getWidth()) || (gameObject.getX() + gameObject.getWidth() > walls[i].getX() &&
                        gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth())) {


                    System.out.println("HIT");
                    return true;


                }
            }
        }
        return false;
    }


    private boolean checkCollisionDown(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {
            if (gameObject.getY() + gameObject.getHeight() == walls[i].getY()) {

                if (gameObject.getX() > walls[i].getX() && gameObject.getX() < walls[i].getX() + walls[i].getWidth() ||

                        gameObject.getX() + gameObject.getWidth() > walls[i].getX()
                                && gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth()) {

                    System.out.println("hitDown");
                    return true;

                }
            }


        }

        return false;
    }


    private boolean checkCollisionRight(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() + gameObject.getWidth() == walls[i].getX() &&
                    gameObject.getY() > walls[i].getY() && gameObject.getY() < walls[i].getY() + walls[i].getHeight()) {
                System.out.println("Hit Right");
                return true;
            }

        }

        return false;
    }

    private boolean checkCollisionLeft(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() == walls[i].getX() + walls[i].getHeight() &&
                    gameObject.getY() > walls[i].getY() && gameObject.getY() < walls[i].getY() + walls[i].getHeight() &&
                    gameObject.getY() + gameObject.getWidth() > walls[i].getY() && gameObject.getY() + gameObject.getY() < walls[i].getY() + walls[i].getWidth()) {
                System.out.println("Hit Left");
                return true;
            }

        }
        return false;

    }
}
