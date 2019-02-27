package org.academiadecodigo.groupproject.pacman;

import org.academiadecodigo.groupproject.pacman.gameobjects.GameObject;
import org.academiadecodigo.groupproject.pacman.gameobjects.Ghost;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;

/**
 * Ze Diogo
 */

public class CollisionDetector {
    private Player player;
    private Ghost ghost;

    private GameObject[] gameObject;

    public CollisionDetector(GameObject[] gameObject){
        this.gameObject = gameObject;

    }

    public void check(GameObject[] gameObject){
        for (int i = 0; i < gameObject.length; i++){
            if (gameObject[i] instanceof Player){//verify if Game Object is a player
                player =  (Player) gameObject[i];



            }if (gameObject[i] instanceof Ghost){//verify if Game Object  is a ghost
                ghost = (Ghost) gameObject[i];
            }

        }
    }
            public void collision(){

            /*if (player.getpos().equals(ghost.getpos())){ //Campare the position of the plyer with Ghost
                player.isDead;// if position of player and ghost are te same player dies. END GAME

            }else{  //in case the position is different both keep moving
                player.move;
                ghost.move
            }*/
        }





}
