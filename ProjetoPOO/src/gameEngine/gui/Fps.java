package gameEngine.gui;

import java.time.Duration;
import java.time.Instant;

public class Fps {
    private Fps(){}

    private static Duration fpsDeltaTime = Duration.ZERO;
    private static Duration lastTime = Duration.ZERO;
    private static Instant beginTime = Instant.now();
    private static double dTime = fpsDeltaTime.toMillis() - lastTime.toMillis();

    public static void calcBeginTime() {
        beginTime = Instant.now();
        fpsDeltaTime = Duration.ZERO;
    }

    public static void calcDeltaTime() {
        fpsDeltaTime = Duration.between(beginTime, Instant.now());
        dTime = (double)fpsDeltaTime.toMillis() - lastTime.toMillis();
        lastTime = fpsDeltaTime;
    }

    public static double getDeltaTime() {
        return dTime/1000;
    }
}
