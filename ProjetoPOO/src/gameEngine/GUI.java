package gameEngine;

import gameEngine.object.IGameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import utils.Queue;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;

public class GUI implements IGUI {
    private final Queue<InputEvent> queue;

    public GUI() {
        queue = new Queue<>();
    }

    @Override
    public @Nullable InputEvent dequeue() {
        return queue.dequeue();
    }

    @Override
    public void display(@NotNull List<IGameObject> list) {
        // TODO
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        queue.enqueue(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        queue.enqueue(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
