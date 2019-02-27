package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.groupproject.pacman.gameobjects.WallFactory;
import org.academiadecodigo.groupproject.pacman.keyboard.KeyboardListener;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Game {

    private Rectangle rectangle;
    private CollisionDetector collisionDetector;
    private Player player;
    private Ghost ghost;
    private KeyboardListener keyboardListener;
    private int cols;
    private int rows;
    private int cellSize;
    public static final int PADDING = 10;



    public Game(int cols, int rows){
        player = new Player();
        this.cols = cols;
        this.rows = rows;
        cellSize = 10;
    }


    public void init(){
        this.rectangle = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        rectangle.draw();
        WallFactory.createGameField();

        player = new Player();
        keyboardListener = new KeyboardListener(player);

    }

    public void start(){

    }

    public void moveGhosts(){
        ghost.move();
    }
}
