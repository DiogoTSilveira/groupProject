package org.academiadecodigo.groupproject.pacman.gameobjects;


import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Ze Diogo
 */

public class CollisionDetector {

    protected int playerX;
    protected int playerY;

    protected int ghostX;
    protected int ghostY;

    public CollisionDetector(){
    }

    public void setPlayerPosition(int x, int y){
        playerX = x;
        playerY = y;
    }

    public void setGhostPosition(int x, int y){
        ghostX = x;
        ghostY = y;
    }

    public void check(){
        System.out.println("Player x and y: " + playerX + ", " + playerY);
        System.out.println("Ghost x and y: " + ghostX + ", " + ghostY);

        if(playerX == ghostX && playerY == ghostY){
            System.out.println("HIT");
        }
    }

    public void collision() {

            /*if (player.getpos().equals(ghost.getpos())){ //Campare the position of the plyer with Ghost
                player.isDead;// if position of player and ghost are te same player dies. END GAME

            }else{  //in case the position is different both keep moving
                player.move;
                ghost.move
            }*/
    }


}
