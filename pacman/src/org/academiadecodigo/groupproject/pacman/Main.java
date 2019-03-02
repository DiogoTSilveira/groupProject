package org.academiadecodigo.groupproject.pacman;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(60,60);
        game.init();

        game.start();

    }


}
