package gameEngine.sound;

import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;


/**
 * This class represents an audio player for the game.
 * It initializes the Clip and URL objects to null.
 *
 * @author Rodrigo Linhas
 * @author Ricardo Rodrigues
 * @author Tiago Tome
 * @version May 24, 2025
 */
public class AudioPlayer {

    private Clip clip;
    private URL soundurl[] = new URL[10];

    /**
     * Constructor of the AudioPlayer class.
     * Initializes the Clip and URL objects to null.
     */
    public AudioPlayer() {
        soundurl[0] = getClass().getResource("/sounds/pacmanDeath.wav");
        soundurl[1] = getClass().getResource("/sounds/pacmanEat.wav");
        soundurl[2] = getClass().getResource("/sounds/pacmanEatFruit.wav");
        soundurl[3] = getClass().getResource("/sounds/pacmanEatGhost.wav");
        soundurl[4] = getClass().getResource("/sounds/test.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundurl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}