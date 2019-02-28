package org.academiadecodigo.groupproject.pacman;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(60,60);
        game.init();

        game.start();
    }


}
