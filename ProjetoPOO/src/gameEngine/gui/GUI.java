package gameEngine.gui;

import gameEngine.Client;
import gameEngine.behaviour.PlayerBehaviour;
import gameEngine.object.IGameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class represents the GUI of the game Burger Man
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version May 17, 2025
 */
public class GUI extends JFrame implements IGUI {
    public final CopyOnWriteArrayList<InputEvent> queue;

    /**
     * Constructor of the GUI class.
     * Initializes the input event queue using CopyOnWriteArrayList
     * to ensure thread safety in concurrent environments.
     */
    public GUI() {
        super("Hamburger-Man");
        queue = new CopyOnWriteArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(672, 744);
        setLocationRelativeTo(null); // Center the window on the screen
        setResizable(false);
        setContentPane(new BackgroundPanel());
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/burgerUp.png"))).getImage());
        setVisible(true);

        addKeyListener();
    }

    @Override
    public @Nullable InputEvent dequeue() {
        try {
            InputEvent ie = queue.removeFirst();
            //System.out.println(ie);
            return ie;
        } catch (Exception _) {
            return null;
        }
    }

    @Override
    public void display(@NotNull List<IGameObject> list, Graphics graphics) {
        for (IGameObject go : list)
            go.shape().draw((Graphics2D) graphics);
    }

    private void addKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e);
                //System.out.println(((PlayerBehaviour) Client.ENGINE.getPlayerObject().behaviour()).speed);
                queue.addLast(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        display(Client.ENGINE.getEnabled(), g);
    }
}
