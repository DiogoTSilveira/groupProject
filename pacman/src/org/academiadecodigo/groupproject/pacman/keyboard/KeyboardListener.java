package org.academiadecodigo.groupproject.pacman.keyboard;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    /**
     * @Movable - uppon assigning our player to this KeyboardListener, this shape will become movable.
     */

    private Player player;

    //Setting our keys to control the player.
    KeyboardEvent up = new KeyboardEvent();
    KeyboardEvent down = new KeyboardEvent();
    KeyboardEvent right = new KeyboardEvent();
    KeyboardEvent left = new KeyboardEvent();

    public KeyboardListener(Player player){
        this.player = player;

        //Creating a keyboard to be able to move our shape.
        Keyboard keyboard = new Keyboard(this);

        //All keys will be pressed ONCE and the player will move until we press another key. This key will change the current direction.
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                player.setDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                player.setDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                player.setDirection(Direction.LEFT);
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}