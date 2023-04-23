package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Sound {
    Clip clip;
    File[] files = new File[15];
    FloatControl volume;
    float dB;

    public Sound() {
        files[0] = new File("src/main/resources/sound/theme_sound.wav");
        files[1] = new File("src/main/resources/sound/powerup.wav");
        files[2] = new File("src/main/resources/sound/firstblood.wav");
        files[3] = new File("src/main/resources/sound/doublekill.wav");
        files[4] = new File("src/main/resources/sound/triplekill.wav");
        files[5] = new File("src/main/resources/sound/quadrakill.wav");
        files[6] = new File("src/main/resources/sound/pentakill.wav");
        files[7] = new File("src/main/resources/sound/hexakill.wav");
        files[8] = new File("src/main/resources/sound/ace.wav");
        files[9] = new File("src/main/resources/sound/player_hurt.wav");
        files[10] = new File("src/main/resources/sound/enemy_hurt.wav");
        files[11] = new File("src/main/resources/sound/monster_hurt.wav");
        files[12] = new File("src/main/resources/sound/explode.wav");
    }

    public void setSound(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(files[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            if (i == 0) {
                dB = -18f;
            } else if (i == 12) {
                dB = -28f;
            } else if (i == 1 || i == 9) {
                dB = -5f;
            } else if (i == 10) {
                dB = 6f;
            } else {
                dB = -15f;
            }

            volume.setValue(dB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
