package org.academiadecodigo.groupproject.pacman.keyboard;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    /**
     * @Movable - uppon assigning our player to this KeyboardListener, this shape will become movable.
     */
    private Movable movable;

    public KeyboardListener(Movable movable){
        this.movable = movable;

        //Creating a keyboard to be able to move our shape.
        Keyboard keyboard = new Keyboard(this);

        //Setting our keys to control the player.
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();

        //All keys will be pressed ONCE and the player will move until we press another key. This key will change the current direction.
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);




    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
