import java.util.ArrayList;

public class GameEngine {
    private final ArrayList<GameObject> loadedObjects;

    public GameEngine() {
        this.loadedObjects = new ArrayList<>();
    }

    public void add(GameObject go) {
        loadedObjects.add(go);
    }

    public void destroy(GameObject go) {
        loadedObjects.remove(go);
    }
}
