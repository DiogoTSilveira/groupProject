package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.groupproject.pacman.gameobjects.WallFactory;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle rectangle;
    private Player player;
    private Ghost ghost;
    private int cols;
    private int rows;
    private int cellSize;
    private CollisionDetector collisionDetector;
    private KeyboardListener keyboardListener;
    public static final int PADDING = 10;



    public Game(int cols, int rows){
        player = new Player();
        this.cols = cols;
        this.rows = rows;
        cellSize = 10;
    }


    public void init(){
        this.rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        Rectangle background = new Rectangle(6 * cellSize + PADDING,10 * cellSize + PADDING, 48 * cellSize,40 * cellSize);
        background.setColor(new Color(41,191,161));
        background.fill();
        player = new Player();
        WallFactory.createGameField();
        keyboardListener = new KeyboardListener(player);

        ghost = new Ghost();

    }

    public void start() throws InterruptedException {

        while(true){

            Thread.sleep(30);
            player.move();
            //ghost.setDirection();
            ghost.move();

        }
    }

    public void moveGhosts(){
        ghost.move();
    }
}
