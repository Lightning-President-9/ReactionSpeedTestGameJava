package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Reaction Speed Test Game");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		gamePanel.config.loadConfig();
		gamePanel.soundBG.checkVolume(gamePanel);
		
		window.setIconImage(gamePanel.target.icon.getImage());
		window.setCursor(gamePanel.target.cursor);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
