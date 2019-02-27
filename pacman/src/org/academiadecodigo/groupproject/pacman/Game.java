package org.academiadecodigo.groupproject.pacman;

/**
 * Raul
 */

import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.groupproject.pacman.gameobjects.WallFactory;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle rectangle;
    private Player player;
    private Ghost ghost;
    private int cols;
    private int rows;
    private int cellSize;
    private CollisionDetector collisionDetector;
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

    }

    public void start(){

    }

    public void moveGhosts(){
        ghost.move();
    }
}
