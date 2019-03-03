package org.academiadecodigo.groupproject.pacman.gameobjects;


import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Ze Diogo
 */

public class CollisionDetector {

    private Shape[] walls;

    public CollisionDetector() {
    }

    public void setWalls(Shape[] walls) {
        this.walls = walls;
    }

    public boolean checkCollisionWithWalls(GameObject gameObject) {
        return (checkTop(gameObject) ||
                checknBottom(gameObject) ||
                checkRight(gameObject) ||
                checkLeft(gameObject));

    }

    public boolean checkCollisionWithGhosts(Player player, Ghost[] ghosts) {
        return (checkGhostTop(player, ghosts) ||
                checkGhostBottom(player, ghosts) ||
                checkGhostRight(player, ghosts) ||
                checkGhostLeft(player, ghosts));
    }

    private boolean checkGhostTop(Player player, Ghost[] ghosts) {

        for (Ghost ghost : ghosts) {

            if (player.getY() == ghost.getY() + ghost.getHeight()) {

                if ((player.getX() > ghost.getX()
                        && player.getX() < ghost.getX() + ghost.getWidth())
                        || (player.getX() + player.getWidth() > ghost.getX()
                        && player.getX() + player.getWidth() < ghost.getX() + ghost.getWidth())) {
                    return true;
                }
                return false;
            }

        }

        return false;
    }

    private boolean checkGhostBottom(Player player, Ghost[] ghosts) {

        for (Ghost ghost : ghosts) {

            if (player.getY() + player.getHeight() == ghost.getY()) {

                if (player.getX() > ghost.getX() && player.getX() < ghost.getX() + ghost.getWidth() ||
                        player.getX() + player.getWidth() > ghost.getX() &&
                                player.getX() + player.getWidth() < ghost.getX() + ghost.getWidth()) {

                    return true;

                }

                return false;
            }

        }

        return false;
    }

    private boolean checkGhostRight(Player player, Ghost[] ghosts) {
        for (Ghost ghost : ghosts) {

            if (player.getX() + player.getWidth() == ghost.getX()) {
                if ((player.getY() + player.getHeight() > ghost.getY() &&
                        player.getY() + player.getHeight() < ghost.getY() + ghost.getHeight()) ||
                        player.getY() < ghost.getY() + ghost.getHeight() && player.getY() > ghost.getY()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean checkGhostLeft(Player player, Ghost[] ghosts) {
        for (Ghost ghost : ghosts) {
            if (player.getX() == ghost.getX() + ghost.getWidth()) {
                if ((player.getY() < ghost.getY() + ghost.getHeight() && player.getY() > ghost.getY()) ||
                        player.getY() + player.getHeight() > ghost.getY() &&
                                player.getY() + player.getHeight() < ghost.getY() + ghost.getHeight()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    private boolean checkTop(GameObject gameObject) {

        int yPlayer = gameObject.getY();

        for (int i = 0; i < walls.length; i++) {

            int wallBottom = walls[i].getY() + walls[i].getHeight();
            if (yPlayer == wallBottom) {

                if ((gameObject.getX() > walls[i].getX()
                        && gameObject.getX() < walls[i].getX() + walls[i].getWidth())
                        || (gameObject.getX() + gameObject.getWidth() > walls[i].getX()
                        && gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth())) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean checknBottom(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {
            if (gameObject.getY() + gameObject.getHeight() == walls[i].getY()) {

                if (gameObject.getX() > walls[i].getX() && gameObject.getX() < walls[i].getX() + walls[i].getWidth() ||
                        gameObject.getX() + gameObject.getWidth() > walls[i].getX() &&
                                gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth()) {

                    return true;

                }
            }


        }

        return false;
    }


    private boolean checkRight(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() + gameObject.getWidth() == walls[i].getX()) {
                if ((gameObject.getY() + gameObject.getHeight() > walls[i].getY() &&
                        gameObject.getY() + gameObject.getHeight() < walls[i].getY() + walls[i].getHeight()) ||
                        gameObject.getY() < walls[i].getY() + walls[i].getHeight() && gameObject.getY() > walls[i].getY()) {
                    return true;
                }

            }
        }

        return false;
    }


    private boolean checkLeft(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() == walls[i].getX() + walls[i].getWidth()) {
                if ((gameObject.getY() < walls[i].getY() + walls[i].getHeight() && gameObject.getY() > walls[i].getY()) ||
                        gameObject.getY() + gameObject.getHeight() > walls[i].getY() &&
                                gameObject.getY() + gameObject.getHeight() < walls[i].getY() + walls[i].getHeight()) {
                    return true;
                }
            }

        }
        return false;

    }
}
