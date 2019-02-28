package org.academiadecodigo.groupproject.pacman.gameobjects;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Diogo
 */

public class Player{

    private CollisionDetector collisionDetector;
    private Direction direction;
    private Picture picture;

    private Ellipse player;

    public Player(CollisionDetector collisionDetector){
        this.collisionDetector = collisionDetector;
        player = new Ellipse(310,330,20, 20);
        picture = new Picture(310,330,"resources/Pacman/RIGHT.png");

        picture.draw();
    }

    public Direction getDirection() {
        return direction;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * This method will use the keyboard to set movement to the Player.
     * @param direction - Which direction is the Player going.
     */

    public void setDirection(Direction direction){
        this.direction = direction;
        switch (direction){
            case UP:

                player.setColor(Color.BLUE);
                this.direction = Direction.UP;

                picture.delete();
                picture = new Picture(player.getX(), player.getY(), "resources/Pacman/UP.png" );
                picture.draw();

                break;

            case DOWN:

                player.setColor(Color.YELLOW);
                this.direction = Direction.DOWN;

                picture.delete();
                picture = new Picture(player.getX(), player.getY(), "resources/Pacman/DOWN.png" );
                picture.draw();

                break;

            case RIGHT:

                player.setColor(Color.BLACK);
                this.direction = Direction.RIGHT;

                picture.delete();
                picture = new Picture(player.getX(), player.getY(), "resources/Pacman/RIGHT.png" );
                picture.draw();

                break;

            case LEFT:

                player.setColor(Color.CYAN);
                this.direction = Direction.LEFT;

                picture.delete();
                picture = new Picture(player.getX(), player.getY(), "resources/Pacman/LEFT.png" );
                picture.draw();

                break;

        }
    }

    public void move(){


        if(direction == null){

            player.translate(0,0);
            picture.translate(0,0);

            return;

        }
        System.out.println("Player Direction: " + direction);

        player.translate(direction.getCol(), direction.getRow());
        picture.translate(direction.getCol(),direction.getRow());

        System.out.println("Player sprite x and y: " + player.getX() + ", " + player.getY());

        collisionDetector.setPlayerPosition(player.getX(),player.getY());
    }

    public int getCol() {
        return direction.getCol();
    }

    public int getRow(){
        return direction.getRow();
    }
}
