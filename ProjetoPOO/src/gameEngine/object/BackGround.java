package gameEngine.object;

import gameEngine.Transform;
import gameEngine.shape.BackGroundShape;

public class BackGround extends GameObject {
    public BackGround() {
        super("BackGround", Transform.backgroundTransform(), null, null, new BackGroundShape(null));
        shape.gameObject(this);
    }
}
