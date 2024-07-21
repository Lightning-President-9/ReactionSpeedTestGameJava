package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {

	GamePanel gp;
	
	public Config(GamePanel gp) {
		this.gp = gp;
	}
	
	public void saveConfig() {
		
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("config.txt"));
			
			// Volume
			br.write(Short.toString(gp.ui.volumeCounter));
			br.newLine();
			br.write(Short.toString(gp.ui.seVolumeCounter));
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadConfig() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
			
			String s = br.readLine();
			
			// For Volume
			gp.ui.volumeCounter = Short.parseShort(s);
			s = br.readLine();
			gp.ui.seVolumeCounter = Short.parseShort(s);
			
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
