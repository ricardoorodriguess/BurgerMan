package game;

import collisions.Point;

public class PowerUp extends Collectible {
    private final PowerUpType type;

    public PowerUp(Point position, PowerUpType type) {
        super(position);
        this.type = type;
    }

    @Override
    public void collect(GameObject go) {
        if (type == PowerUpType.PICKLE && (go.isEnemy() || go.isPlayer())) {
            if (go.isEnemy()) {
                Client.PLAYER_SPEED = 0.8;
                Client.PLAYER_SPEED_BUFFER = 60;
            }
            Client.ENGINE.destroy(this);
        } else if (go.isPlayer()) {
            switch (type) {
                case TOMATO -> Client.PLAYER_INVULNERABLE = 60;
                case ONION -> Client.ENGINE.withRandom(GameObject::isEnemy, en -> ((Enemy) en).kill());
                case CHEESE -> {
                    Client.PLAYER_SPEED = Client.RANDOM.nextBoolean() ? 0.8 : 1.2;
                    Client.PLAYER_SPEED_BUFFER = 60;
                }
            }
            Client.ENGINE.destroy(this);
        }
    }
}
