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

    public static final int PADDING = 10;
    private Picture background;
    private Rectangle rectangle;
    private int cols;
    private int rows;
    private int cellSize;
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

        menu();

    }

    private void menu() {

        background = new Picture(PADDING, PADDING, "resources/Background/oie_0AT68Uz38HJQ.jpg");
        background.draw();

        createBackgroundAndField();
        initializeCollisionDetector();
        initializeGameEntities();

    }

    private void createBackgroundAndField() {
        Rectangle field = new Rectangle(6 * cellSize + PADDING, 10 * cellSize + PADDING, 48 * cellSize, 40 * cellSize);
        field.setColor(new Color(41, 191, 161));
        field.fill();
    }

    private void initializeCollisionDetector() {
        collisionDetector = new CollisionDetector();
        collisionDetector.setWalls(WallFactory.createGameField());
    }

    private void initializeGameEntities() {
        player = new Player(collisionDetector);
        keyboardListener = new KeyboardListener(player);


        Ghost ghost = new Ghost(264 + 10, collisionDetector, "resources/mcs/chapeu jojo.png");
        Ghost ghost1 = new Ghost(294, collisionDetector, "resources/mcs/chapeu nuno.png");
        Ghost ghost2 = new Ghost(314, collisionDetector, "resources/mcs/chapeu ruben.png");
        Ghost ghost3 = new Ghost(334, collisionDetector, "resources/mcs/chapeu rudy.png");
        Ghost ghost4 = new Ghost(354, collisionDetector, "resources/mcs/chapeu seringa.png");
        Ghost ghost5 = new Ghost(374, collisionDetector, "resources/mcs/chapeu xico.png");
        this.ghost = new Ghost[]{ghost, ghost1, ghost2, ghost3, ghost4, ghost5};
    }

    /**
     * This method will set loop which never ends unless the player colides with a ghost.
     *
     * @throws InterruptedException if any thread has interrupted the current thread.
     *                              The interrupted status of the current thread is cleared when this exception is thrown.
     *                              <p>
     *                              Every time the player movement is null it will proceed to the next iteration of the loop. This happens in the beginning.
     *                              <p>
     *                              After the player moves, it will check collisions with other ghosts. If true, breaks the loop but if not, the ghosts will
     *                              move.
     */

    protected void start() throws InterruptedException {
        Sound wakawaka = new Sound("/resources/sound/wakawaka.wav");
        Sound theme = new Sound("/resources/sound/uka ukachaka.wav");

        while (true) {

            if (player.getDirection() == null) {
                continue;
            }

            Thread.sleep(50);
            player.move();
            theme.setLoop(-1);
            if (collisionDetector.checkCollisionWithGhosts(player, ghost)) {
                theme.close();

                Sound over = new Sound("/resources/sound/summarizersound.wav");
                over.play(true);

                Picture gameOver = new Picture(200, 200, "resources/Texts/gameover.png");
                gameOver.grow(100, 100);
                gameOver.draw();

                break;
            }
            moveGhosts();

        }

    }

    public void moveGhosts() throws InterruptedException {
        for (Ghost ghost : ghost) {
            ghost.move();
        }
    }
}