package main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SoundManager
{
    private Clip clip;
    private final Map<String, URL> soundURL = new HashMap<>(Map.of(

    ));

    public SoundManager() {}

    public void setSound(String key) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL.get(key));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
    public void addSound(String soundName, URL url) {

        if (soundURL.containsKey(soundName)) {
            System.out.println("[" + soundName + "] Already exist.");
            return;
        }
        soundURL.put(soundName, url);
    }
    public void forceAddSound(String soundName, URL url) {

        // Overwrite old sound if it already exists
        soundURL.put(soundName, url);
    }
}
