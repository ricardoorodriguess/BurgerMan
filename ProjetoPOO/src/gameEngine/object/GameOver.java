package gameEngine.object;

import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.LivesBehaviour;
import gameEngine.behaviour.ScoreBehaviour;
import gameEngine.shape.TextShape;

import java.awt.*;

/**
 * Responsive class to represent the Score GameObject.
 * <p>
 * This class is responsible for displaying the current score in the game.
 * <p>
 * It extends the GameObject class and uses a TextShape to render the score.
 *
 * @author Rodrigo Linhas
 * @author Ricardo Rodrigues
 * @author Tiago Tome
 * @version May 24, 2025
 */
public class GameOver extends GameObject {

    /**
     * Constructs a Score GameObject that displays the player's current score.
     * <p>
     * The score is positioned at coordinates (125, 65) on the game screen.
     * <p>
     * It uses a white TextShape with font size 24 to render the score text.
     * <p>
     * The score starts at 0 and is updated through the ScoreBehaviour component.
     */
    public GameOver() {
        super("GameOver", Transform.simpleTransform(new Point(336, 372)), null, null,
                new TextShape("GAME OVER", Color.RED, 44)); //por enquanto deixar assim
        shape.gameObject(this);
    }
}
