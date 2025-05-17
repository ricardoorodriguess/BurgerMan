package gameEngine;

import gameEngine.object.IGameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

public interface IGUI extends KeyListener, MouseListener {
    @Nullable InputEvent dequeue();

    void display(@NotNull List<IGameObject> list);
}
