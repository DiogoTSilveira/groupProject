package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.groupproject.pacman.gameobjects.WallFactory;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Rectangle rectangle;
    private Player player;
    private Ghost[] ghost;
    private int cols;
    private int rows;
    private int cellSize;
   // private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;
    public static final int PADDING = 10;


    public Game(int cols, int rows) {
        player = new Player(new CollisionDetector());
        this.cols = cols;
        this.rows = rows;
        cellSize = 10;
    }


    public void init() {
        this.rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        //Picture picture = new Picture( PADDING, PADDING,"resources/Pacman/Webp.net-resizeimage.jpg");
        Picture picture = new Picture(PADDING, PADDING, "resources/oie_0AT68Uz38HJQ.jpg");
        picture.draw();

        Rectangle background = new Rectangle(6 * cellSize + PADDING, 10 * cellSize + PADDING, 48 * cellSize, 40 * cellSize);
        background.setColor(new Color(41, 191, 161));
        background.fill();

        Rectangle[] gameField = WallFactory.createGameField();
        keyboardListener = new KeyboardListener(player);
        Ghost ghost = new Ghost(270);
        Ghost ghost1 = new Ghost(290);
        Ghost ghost2 = new Ghost(310);
        Ghost ghost3 = new Ghost(330);
        Ghost ghost4 = new Ghost(350);
        Ghost ghost5 = new Ghost(370);
        this.ghost = new Ghost[]{ghost, ghost1, ghost2, ghost3, ghost4, ghost5};


    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(30);
            player.move();
            //ghost.setDirection();
            if (player.getDirection() != null) {
                for (int i = 0; i < ghost.length; i++) {

                    ghost[i].move();
                }
            }
        }

    }

    public void moveGhosts() {
        for (int i = 0; i < ghost.length; i++) {
            ghost[i].move();
        }
    }
}
