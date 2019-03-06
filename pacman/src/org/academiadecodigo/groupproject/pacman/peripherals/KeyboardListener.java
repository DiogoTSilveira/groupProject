package org.academiadecodigo.groupproject.pacman.peripherals;

import org.academiadecodigo.groupproject.pacman.Direction;
import org.academiadecodigo.groupproject.pacman.Game;
import org.academiadecodigo.groupproject.pacman.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class KeyboardListener implements KeyboardHandler {

    Keyboard keyboard;
    //Setting our keys to control the player.
    KeyboardEvent up = new KeyboardEvent();
    KeyboardEvent down = new KeyboardEvent();
    KeyboardEvent right = new KeyboardEvent();
    KeyboardEvent left = new KeyboardEvent();
    KeyboardEvent space = new KeyboardEvent();
    KeyboardEvent r = new KeyboardEvent();
    KeyboardEvent p = new KeyboardEvent();
    /**
     * @Movable - uppon assigning our player to this KeyboardListener, this shape will become movable.
     */

    private Player player;
    private Game game;

    public KeyboardListener(Player player, Game game) {
        this.game = game;
        this.player = player;

        //Creating a peripherals to be able to move our shape.
        keyboard = new Keyboard(this);

        setKeyboardEventType();
        setKey();
        addEventListener();

    }

    private void setKeyboardEventType() {

        //All keys will be pressed ONCE and the player will move until we press another key. This key will change the current direction.
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        p.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
//        space.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        r.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    }

    private void setKey() {

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_LEFT);

        space.setKey(KeyboardEvent.KEY_SPACE);

        r.setKey(KeyboardEvent.KEY_R);
        p.setKey(KeyboardEvent.KEY_P);


    }

    private void addEventListener() {

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);

        keyboard.addEventListener(space);

        keyboard.addEventListener(r);
        keyboard.addEventListener(p);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                if (game.isPause()) {
                    break;
                }
                player.setDirection(Direction.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                if (game.isPause()) {
                    break;
                }

                player.setDirection(Direction.DOWN);
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (game.isPause()) {
                    break;
                }

                player.setDirection(Direction.RIGHT);
                break;

            case KeyboardEvent.KEY_LEFT:
                if (game.isPause()) {
                    break;
                }
                System.out.println("left");

                player.setDirection(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_SPACE:
                if (game.isPause()) {
                    break;
                }
                player.move();
                System.out.println("space");
                break;

            case KeyboardEvent.KEY_R:
                if (game.isPause()) {
                    break;
                }
                break;

            case KeyboardEvent.KEY_P:
                game.setPause();
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        /*switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                player.move();
                break;
        }*/
    }
}
