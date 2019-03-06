package org.academiadecodigo.groupproject.pacman.gameobjects;


import org.academiadecodigo.groupproject.pacman.Sound;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Ze Diogo
 */

public class CollisionDetector {

    private Shape[] walls;
    private Sound ping;

    public CollisionDetector() {
    }

    public void setWalls(Shape[] walls) {
        this.walls = walls;
    }

    public boolean checkCollisionWithWalls(GameObject gameObject) {
        return (checkTop(gameObject) ||
                checkBottom(gameObject) ||
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
            if (ghost.isDead()) {
                continue;
            }

            if (player.getY() <= ghost.getY() + ghost.getHeight() && player.getY() > ghost.getY()) {

                if ((player.getX() >= ghost.getX() &&
                        player.getX() <= ghost.getX() + ghost.getWidth()) ||
                        (player.getX() + player.getWidth() >= ghost.getX() &&
                                player.getX() + player.getWidth() <= ghost.getX() + ghost.getWidth())) {
                    System.out.println("Kill");

                    ghostDie(player, ghost);
                }
            }


        }
        return false;
    }

    private boolean checkGhostBottom(Player player, Ghost[] ghosts) {

        for (Ghost ghost : ghosts) {
            if (ghost.isDead()) {
                continue;
            }

            if (player.getY() + player.getHeight() >= ghost.getY() &&
                    player.getY() + player.getHeight() < ghost.getY() + ghost.getHeight()) {

                if (player.getX() >= ghost.getX() && player.getX() <= ghost.getX() + ghost.getWidth() ||
                        player.getX() + player.getWidth() >= ghost.getX() &&
                                player.getX() + player.getWidth() <= ghost.getX() + ghost.getWidth()) {
                    System.out.println("Kill");
                    return ghostDie(player, ghost);
                }


            }

        }

        return false;
    }


    private boolean checkGhostRight(Player player, Ghost[] ghosts) {
        for (Ghost ghost : ghosts) {
            if (ghost.isDead()) {
                continue;
            }
            if (player.getX() + player.getWidth() >= ghost.getX() && player.getX() < ghost.getX() + ghost.getWidth()) {
                if (player.getY() <= ghost.getY() && player.getY() >= ghost.getY() + ghost.getHeight() ||
                        player.getY() + player.getHeight() <= ghost.getY() &&
                                player.getY() + player.getHeight() >= ghost.getY() + player.getHeight()) {
                    System.out.println("Kill");
                    return ghostDie(player, ghost);
                }

            }


        }
        return false;
    }

    private boolean checkGhostLeft(Player player, Ghost[] ghosts) {
        for (Ghost ghost : ghosts) {
            if (ghost.isDead()) {
                continue;
            }
            if (player.getX() <= ghost.getX() + ghost.getWidth() && player.getX() > ghost.getX()) {
                if ((player.getY() <= ghost.getY() + ghost.getHeight() && player.getY() >= ghost.getY()) ||
                        player.getY() + player.getHeight() >= ghost.getY() &&
                                player.getY() + player.getHeight() <= ghost.getY() + ghost.getHeight()) {
                    System.out.println("Kill");
                    return ghostDie(player, ghost);

                }
            }
        }
        return false;
    }


    private boolean checkTop(GameObject gameObject) {

        int yPlayer = gameObject.getY();

        for (int i = 0; i < walls.length; i++) {

            int wallBottom = walls[i].getY() + walls[i].getHeight();
            if (yPlayer > wallBottom && gameObject.getY() < walls[i].getY()) {
                System.out.println(yPlayer + " " + wallBottom);

                if (checkVerticalCorner(gameObject, i)) {
                    System.out.println("collision top");

                    return true;
                }
            }
        }
        return false;
    }


    private boolean checkBottom(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {
            if (gameObject.getY() + gameObject.getHeight() < walls[i].getY() &&
                    gameObject.getY() + gameObject.getHeight() > walls[i].getY() + walls[i].getHeight()) {

                if (checkVerticalCorner(gameObject, i)) {
                    System.out.println("collision down");

                    return true;

                }
            }


        }

        return false;
    }


    private boolean checkRight(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() + gameObject.getWidth() > walls[i].getX() &&
                    gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth()) {
                if (chekHorizontalCorner(gameObject, i)) {
                    return true;
                }

            }
        }

        return false;
    }


    private boolean checkLeft(GameObject gameObject) {
        for (int i = 0; i < walls.length; i++) {

            if (gameObject.getX() < walls[i].getX() + walls[i].getWidth() &&
                    gameObject.getX() > walls[i].getX()) {
                if (chekHorizontalCorner(gameObject, i)) {
                    return true;
                }
            }

        }
        return false;

    }

    private boolean checkVerticalCorner(GameObject gameObject, int i) {
        return (gameObject.getX() > walls[i].getX() &&
                gameObject.getX() < walls[i].getX() + walls[i].getWidth()) ||
                (gameObject.getX() + gameObject.getWidth() > walls[i].getX() &&
                        gameObject.getX() + gameObject.getWidth() < walls[i].getX() + walls[i].getWidth());
    }

    private boolean chekHorizontalCorner(GameObject gameObject, int i) {
        return ((gameObject.getY() < walls[i].getY() + walls[i].getHeight() &&
                gameObject.getY() > walls[i].getY()) ||
                gameObject.getY() + gameObject.getHeight() > walls[i].getY() &&
                        gameObject.getY() + gameObject.getHeight() < walls[i].getY() + walls[i].getHeight());
    }

    private boolean ghostDie(GameObject player, Ghost ghost) {
        if (ghost.getDirection() == player.getDirection()) {

            ping = new Sound("/resources/sound/ping.wav");
            ping.play(true);
            System.out.println("ghost die");
            ghost.die();
            return false;
        }
        System.out.println("error");
        return true;


    }

}
