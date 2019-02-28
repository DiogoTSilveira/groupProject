package org.academiadecodigo.groupproject.pacman.gameobjects;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Wall {

    protected Rectangle wall;

    public Wall(Rectangle wall){

        this.wall = wall;

        this.wall.getColor().getRed();

        this.wall.setColor(new org.academiadecodigo.simplegraphics.graphics.Color(255, 105, 180));

        this.wall.fill();
    }
}
