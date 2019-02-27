package org.academiadecodigo.groupproject.pacman;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(70,70);
        game.init();

        game.start();
    }


}
