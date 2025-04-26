package gameEngine.object;

import collisions.Circle;
import collisions.Point;
import gameEngine.Transform;
import gameEngine.behaviour.CollectibleBehaviour;
import org.jetbrains.annotations.NotNull;

public class Collectible extends GameObject {
    public Collectible(@NotNull Type type, @NotNull Point position) {
        super(type.name, Transform.simpleTransform(position), new Circle(position, 0.5), new CollectibleBehaviour(null));
        behaviour.gameObject(this);
    }

    public enum Type {
        POINT("Point"), TOMATO("Tomato"), ONION("Onion"), CHEESE("Cheese"), PICKLE("Pickle");

        final String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
