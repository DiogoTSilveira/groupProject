package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.CollisionDetector;
import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.groupproject.pacman.gameobjects.WallFactory;
import org.academiadecodigo.groupproject.pacman.peripherals.KeyboardListener;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public static final int PADDING = 0;
    private Picture background;
    private int cols;
    private int rows;
    private int cellSize;
    private Player player;
    private Ghost[] ghost;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;
    private Picture restart;
    private Picture gameName;
    private Picture menu;
    private Picture pacmanRunning;
    private Picture mcsRunning;

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
        restart = new Picture(120 + PADDING, 420 + PADDING, "resources/restart.png");
        createBackgroundAndField();
        initializeCollisionDetector();
        initializeGameEntities();
        gameName = new Picture(50, 50, "resources/mcsHunter.png");
        menu = new Picture(PADDING, PADDING, "resources/Background/Screen Shot 2019-03-04 at 18.58.33.png");
        pacmanRunning = new Picture(600, 520, "resources/pacman running.png");
        mcsRunning = new Picture(-400, 520, "resources/pacman eating.png");
        menu.draw();
        gameName.draw();
        pacmanRunning.draw();

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
        keyboardListener = new KeyboardListener(player, this);


        Ghost ghost = new Ghost(262, collisionDetector, "resources/mcs/chapeu jojo.png");
        Ghost ghost1 = new Ghost(282, collisionDetector, "resources/mcs/chapeu nuno.png");
        Ghost ghost2 = new Ghost(302, collisionDetector, "resources/mcs/chapeu ruben.png");
        Ghost ghost3 = new Ghost(322, collisionDetector, "resources/mcs/chapeu rudy.png");
        Ghost ghost4 = new Ghost(342, collisionDetector, "resources/mcs/chapeu seringa.png");
        Ghost ghost5 = new Ghost(362, collisionDetector, "resources/mcs/chapeu xico.png");
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
            Thread.sleep(50);


            if (mcsRunning.getX() < 640) {
                mcsRunning.translate(5, 0);
                mcsRunning.draw();
            } else if (pacmanRunning.getX() + pacmanRunning.getWidth() > -10) {
                pacmanRunning.translate(-5, 0);
            } else {

                mcsRunning.translate(-400 - mcsRunning.getX(), 520 - mcsRunning.getY());
                pacmanRunning.translate(600 - pacmanRunning.getX(), 520 - pacmanRunning.getY());

            }

            if (player.getDirection() == null) {
                continue;
            }
            mcsRunning.delete();
            pacmanRunning.delete();
            menu.delete();
            gameName.delete();


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
        restart.draw();
    }

    public void moveGhosts() {
        for (Ghost ghost : ghost) {
            ghost.move();
        }
    }


}