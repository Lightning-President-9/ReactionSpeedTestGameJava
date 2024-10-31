package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	GamePanel gp;
	String name;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(gp.enterNameState == true) {
			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				gp.soundEffect.playSE(1, gp.soundEffect);
	            if (name.length() > 0) {
//	            	gp.soundEffect.playSE(1,gp.soundEffect);
	                name = name.substring(0, name.length() - 1); // creates a new string containing all characters except the last one
	            }
	        }
			else {
	            char keyChar = e.getKeyChar();
	            if ((Character.isLetter(keyChar) || Character.isSpaceChar(keyChar)) && name.length() < 12) { // checks if the character is either a letter or a space
	                name += keyChar;
	                gp.soundEffect.playSE(1, gp.soundEffect);
//	                gp.soundEffect.playSE(1,gp.soundEffect);
	            }
	        }
			if(e.getKeyCode() == KeyEvent.VK_ENTER && name.length() > 0) {
				if(gp.oneShotGameState == true && gp.ui.yourTime != 0) {
					gp.oneShootFM.setData();
				}
				else if((gp.easy1MinGameState == true || gp.survivalGameState == true)&& gp.ui.yourTime != 0 && gp.target.targetHitCount !=0 && gp.target.targetHitPerS != 0) {
					gp.oneMinAndSurvFM.setData();
				}
//				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.inGameState = false;
				gp.enterNameState = false;
				gp.titleScreenGameState = true;
				gp.notTarget.notTargetArLi.clear();
				gp.notTarget.notTargetArLi.add(gp.notTarget);
				gp.soundEffect.playSE(1, gp.soundEffect);
				gp.soundBG.playMusic(0, gp.soundBG);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
}
