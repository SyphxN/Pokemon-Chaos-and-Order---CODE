/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PokemonChaosandOrder;

/**
 *
 * @author SyphiN
 */
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
public class Sound {
    Clip clip;
    float previousVolume = 0;
    float currentVolume = 0;
    FloatControl fcV;
    FloatControl fcP;
    boolean mute = false;

    public void setFile(URL url) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        AudioInputStream sound = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(sound);
        System.out.println(sound);
        fcV = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        fcP = (FloatControl)clip.getControl(FloatControl.Type.PAN);
    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void pan(float pan){
        fcP.setValue(pan);
    }
    public void stop(){
        clip.stop();
    }
    public void volumeUp(){
        currentVolume += 1.0f;
        if(currentVolume>6.0f){
            currentVolume = 6.0f;
        }
        fcV.setValue(currentVolume);
    }
    public void volumeDown(){
        currentVolume -=1.0f;
        if(currentVolume<-80.0f){
            currentVolume = -80.0f;
        }
        fcV.setValue(currentVolume);
    }

    public void volumeMute(){
        mute = !mute;
        if(mute){
            previousVolume = currentVolume;
            currentVolume = -80.0f;
        }else{
            currentVolume = previousVolume;
        }
        fcV.setValue(currentVolume);
    }
}
