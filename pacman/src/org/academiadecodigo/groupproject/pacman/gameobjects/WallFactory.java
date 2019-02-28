package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Jorge
 */

public class WallFactory {

    private Rectangle walls;
    private final static int CELL_SIZE = 10;
    private final static int PADDING = 10;


    public static Rectangle[] createGameField() {

        return new Rectangle[]{
                createWall(5, 9, 1, 42),
                createWall(54, 9, 1, 42),
                createWall(5, 9, 50, 1),
                createWall(5, 50, 50, 1),
                createWall(8, 12, 2, 6),
                createWall(12, 12, 12, 2),
                createWall(26, 12, 12, 2),
                createWall(26, 12, 12, 2),
                createWall(40, 12, 12, 2),
                createWall(36, 12, 2, 10),
                createWall(40, 12, 2, 10),
                createWall(12, 16, 22, 2),
                createWall(12, 16, 2, 12),
                createWall(44, 16, 8, 2),
                createWall(8, 20, 2, 14),
                createWall(16, 20, 6, 8),
                createWall(24, 20, 6, 2),
                createWall(32, 20, 6, 2),
                createWall(40, 20, 12, 2),
                createWall(24, 24, 6, 2),
                createWall(34, 24, 6, 2),
                createWall(42, 24, 12, 2),
                createWall(24, 24, 2, 8),
                createWall(38, 24, 2, 8),
                createWall(8, 30, 8, 2),
                createWall(18, 30, 4, 2),
                createWall(24, 30, 16, 2),
                createWall(42, 30, 2, 2),
               // createWall(18, 30, 2, 10),
                createWall(46, 32, 8, 2),
                createWall(42, 28, 10, 2),
                createWall(12, 34, 8, 6),
                createWall(22, 34, 6, 6),
                createWall(30, 34, 2, 6),
                createWall(34, 34, 4, 2),
                createWall(40, 34, 4, 2),
                createWall(42, 36, 2, 2),
                createWall(46, 36, 6, 4),
                createWall(8, 36, 2, 8),
                createWall(30, 38, 6, 2),
                createWall(38, 38, 2, 4),
                createWall(42, 40, 2, 2),
                createWall(12, 42, 2, 6),
                createWall(16, 42, 8, 2),
                createWall(26, 42, 8, 2),
                createWall(42, 42, 12, 2),
                createWall(36, 44, 4, 4),
                createWall(8, 46, 10, 2),
                createWall(20, 46, 10, 2),
                createWall(40, 46, 6, 2),
                createWall(48, 46, 4, 2),
                createWall(32, 42, 2, 8),
        };

    }


    private static Rectangle createWall(int x, int y, int width, int height) {

        Rectangle rectangle = new Rectangle((x * CELL_SIZE) + PADDING, y * (CELL_SIZE) + PADDING, width * CELL_SIZE, height * CELL_SIZE);
        rectangle.setColor(new Color(55, 28, 71));


        rectangle.fill();
        return rectangle;

    }


}
