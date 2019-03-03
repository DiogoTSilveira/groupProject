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
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Rectangle rectangle;
    private Player player;
    private Ghost[] ghost;
    private int cols;
    private int rows;
    private int cellSize;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;
    public static final int PADDING = 10;


    public Game(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cellSize = 10;
    }


    public void init() {
        //this.rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        //rectangle.setColor(Color.BLUE);
        //rectangle.fill();
        //Picture picture = new Picture( PADDING, PADDING,"resources/Pacman/Webp.net-resizeimage.jpg");
        Picture picture = new Picture(PADDING, PADDING, "resources/oie_0AT68Uz38HJQ.jpg");
        picture.draw();

        Rectangle background = new Rectangle(6 * cellSize + PADDING, 10 * cellSize + PADDING, 48 * cellSize, 40 * cellSize);
        background.setColor(new Color(41, 191, 161));
        background.fill();
        collisionDetector = new CollisionDetector();
        collisionDetector.setWalls(WallFactory.createGameField());
        player = new Player(collisionDetector);

        keyboardListener = new KeyboardListener(player);


        Ghost ghost = new Ghost(264 + 10, collisionDetector);
        Ghost ghost1 = new Ghost(294, collisionDetector);
        Ghost ghost2 = new Ghost(314, collisionDetector);
        Ghost ghost3 = new Ghost(334, collisionDetector);
        Ghost ghost4 = new Ghost(354, collisionDetector);
        Ghost ghost5 = new Ghost(374, collisionDetector);
        this.ghost = new Ghost[]{ghost, ghost1, ghost2, ghost3, ghost4, ghost5};


    }

    public void start() throws InterruptedException {

        while (true) {
            if (player.getDirection() == null) {
                continue;
            }

            Thread.sleep(30);
            player.move();
            if (collisionDetector.checkCollisionWithGhosts(player, ghost)) {

                //This is causing a IIOException: Can't read input file

                //Picture gameOver = new Picture(20,20, "resources/gameover.png");
                //gameOver.draw();

                break;
            }
            moveGhosts();

        }

    }

    public void moveGhosts() {
        for (int i = 0; i < ghost.length; i++) {
            ghost[i].move();
        }
    }
}