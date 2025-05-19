package gameEngine.shape;

import gameEngine.ITransform;
import gameEngine.object.IGameObject;

import java.awt.*;

public interface IShape {
    /**
     * Retorna o GameObject associado a este shape.
     * @return GameObject vinculado.
     */
    IGameObject gameObject();

    /**
     * Define o GameObject para umm shape.
     * @param gameObject Novo GameObject a ficar com o shape em questão.
     */
    void gameObject(IGameObject gameObject);

    /**
     * Desenha o shape do objeto no ecrã.
     * @param g
     * @param transform
     */
    void draw(Graphics2D g);
}
