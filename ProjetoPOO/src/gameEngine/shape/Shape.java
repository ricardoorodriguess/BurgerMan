package gameEngine.shape;
import gameEngine.ITransform;
import gameEngine.object.IGameObject;

import java.awt.*;

abstract class Shape implements IShape {
    IGameObject igameObject;

    /**
     * Construtor que associa um GameObject a este shape.
     * @param igameObject GameObject que tem este shape.
     */
    public Shape(IGameObject igameObject) {
        this.igameObject = igameObject;
    }

    /**
     * Retorna o GameObject associado a este shape.
     * @return GameObject vinculado.
     */
    @Override
    public IGameObject gameObject() {
        return igameObject;
    }

    @Override
    public void gameObject(IGameObject gameObject) {
        this.igameObject = gameObject;
    }

    @Override
    public final void draw(Graphics2D g, ITransform transform) {
        var originalTx = g.getTransform();
        var originalHints = g.getRenderingHints();

        g.translate(transform.position().getX(), transform.position().getY());
        g.rotate(transform.angle());
        g.scale(transform.scale(), transform.scale());

        this.render(g);

        g.setTransform(originalTx);
        g.setRenderingHints(originalHints);
    }

    //metodo que todos as classes que extenderem esta vao ter que fazer, é aqui que se vai fazer a escolha
    //se é para desenhar ou para carregar sprites, é aqui que se da a render que queremos (NAO SEI SE PODERIA ESTAR NA ISHAPE).
    public abstract void render(Graphics2D g);
}
