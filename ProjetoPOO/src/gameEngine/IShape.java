package gameEngine;

import java.awt.*;

public interface IShape {
    /**
     * Desenha o shape do objeto no ecrã.
     * @param g
     * @param transform
     */
    void draw(Graphics2D g, ITransform transform);
}
