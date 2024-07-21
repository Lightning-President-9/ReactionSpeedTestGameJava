package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[7];
	FloatControl fc;
	GamePanel gp;
	float volume ;
	float seVolume ;
	
	public Sound(GamePanel gp) {
		this.gp = gp;
		
		soundURL[0] = getClass().getResource("/sound/title.wav");
		soundURL[1] = getClass().getResource("/sound/select_option.wav");
		soundURL[2] = getClass().getResource("/sound/count321.wav");
		soundURL[3] = getClass().getResource("/sound/start.wav");
		soundURL[4] = getClass().getResource("/sound/hit.wav");
		soundURL[5] = getClass().getResource("/sound/lose.wav");
		soundURL[6] = getClass().getResource("/sound/game_music.wav");
	}
	public void setFile(int i) {
		try {
			AudioInputStream ais =AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			checkVolume(gp);
			checkSEVolume(gp);
		}catch(Exception e) {}
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
	public void playMusic(int i,Sound s) {
		s.setFile(i);
		s.play();
		s.loop();
		s.checkVolume(gp);
	}
	public void stopMusic(Sound s) {
		s.stop();
	}
	public void playSE(int i,Sound s) {
		s.setFile(i);
		s.play();
		s.checkSEVolume(gp);
	}
	public void checkVolume(GamePanel gp) {
		switch(gp.ui.volumeCounter) {
			case 0:volume = -80f;
				break;
			case 1:volume = -12f;
				break;
			case 2:volume = -5f;
				break;
			case 3:volume = 1f;
				break;
			case 4:volume = 6f;
				break;
		}
		fc.setValue(volume);
	}
	public void checkSEVolume(GamePanel gp) {
		switch(gp.ui.seVolumeCounter) {
		case 0:seVolume = -80f;
			break;
		case 1:seVolume = -12f;
			break;
		case 2:seVolume = -5f;
			break;
		case 3:seVolume = 1f;
			break;
		case 4:seVolume = 6f;
			break;
		}
		fc.setValue(seVolume);
	}
}
