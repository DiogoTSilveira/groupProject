package org.academiadecodigo.groupproject.pacman.peripherals;

import org.academiadecodigo.groupproject.pacman.gameobjects.*;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;

public class MouseListener implements MouseHandler {

    Player player;

    Mouse mouse;

    public MouseListener(Player player){

        this.player = player;

        mouse = new Mouse(this);


    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
       // mouse.addEventListener(mouseClicked());

        System.out.println("click");



    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
