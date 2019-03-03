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

    private int cols;
    private int rows;
    private int cellSize;
    public static final int PADDING = 10;

    private Player player;
    private Ghost[] ghost;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;


    public Game(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cellSize = 10;
    }

    /**
     * The init() will create the background and the actual field where the player and the ghosts will spawn.
     * The player will have a keyboardListener to set his directions and both player and ghosts will have a collision detector.
     */

    public void init() {
        //this.rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        //rectangle.setColor(Color.BLUE);
        //rectangle.fill();
        //Picture picture = new Picture( PADDING, PADDING,"resources/Pacman/Webp.net-resizeimage.jpg");

        createBackgroundAndField();
        initializeCollisionDetector();
        initializeGameEntities();

    }

    private void createBackgroundAndField() {
        Picture background = new Picture(PADDING, PADDING, "resources/oie_0AT68Uz38HJQ.jpg");
        background.draw();

        Rectangle field = new Rectangle(6 * cellSize + PADDING, 10 * cellSize + PADDING, 48 * cellSize, 40 * cellSize);
        field.setColor(new Color(41, 191, 161));
        field.fill();
    }

    public void initializeCollisionDetector(){
        collisionDetector = new CollisionDetector();
        collisionDetector.setWalls(WallFactory.createGameField());
    }

    private void initializeGameEntities() {
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

    /**
     * This method will set loop which never ends unless the player colides with a ghost.
     *
     * @throws InterruptedException if any thread has interrupted the current thread.
     * The interrupted status of the current thread is cleared when this exception is thrown.
     *
     * Every time the player movement is null it will proceed to the next iteration of the loop. This happens in the beginning.
     *
     * After the player moves, it will check collisions with other ghosts. If true, breaks the loop but if not, the ghosts will
     * move.
     */

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