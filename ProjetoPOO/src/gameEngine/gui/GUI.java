package gameEngine.gui;

import gameEngine.object.IGameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class represents the GUI of the game Burger Man
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 17, 2025
 */
public class GUI implements IGUI {
    private final CopyOnWriteArrayList<InputEvent> queue;

    /**
     * Constructor of the GUI class.
     * Initializes the input event queue using CopyOnWriteArrayList
     * to ensure thread safety in concurrent environments.
     */
    public GUI() {
        queue = new CopyOnWriteArrayList<>();
    }

     /**
      * Removes the next event from the input queue, if it exists.
      * @return next InputEvent in queue or null if the queue is empty.
      */
    @Override
    public @Nullable InputEvent dequeue() {
        return queue.removeFirst();
    }

    /**
     * Displays the game objects in the GUI.
     * @param list List of game objects to be displayed.
     */
    @Override
    public void display(@NotNull List<IGameObject> list) {

    }

    /**
     * Handles the keyTyped event. Currently, this method does not perform any action.
     * @param e KeyEvent containing information about the key typed.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Handles the keyPressed event.
     * Adds the KeyEvent to the input queue.
     * @param e KeyEvent containing information about the key pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        queue.addLast(e);
    }

    /**
     * Handles the keyReleased event.
     * Currently, this method does not perform any action.
     * @param e KeyEvent containing information about the key released.
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}
