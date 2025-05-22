package gameEngine.sound;
import javax.sound.sampled.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {
    private static final Map<String, Clip> sounds = new HashMap<>();

    public void loadSound(String name, String resourcePath) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(resourcePath);
            if (audioSrc == null) {
                System.err.println("Sound not found: " + name);
                return;
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioSrc);
            Clip sound = AudioSystem.getClip();
            sound.open(ais);
            sounds.put(name, sound);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSound(String name) {
        Clip sound = sounds.get(name);
        if (sound != null) {
            if (sound.isRunning()) sound.stop();
            sound.setFramePosition(0);
            sound.start();
        }
    }

    public static void stopSound(String name) {
        Clip clip = sounds.get(name);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void stopAllSounds() {
        for (Clip clip : sounds.values()) {
            if (clip.isRunning()) {
                clip.stop();
            }
        }
    }
}
