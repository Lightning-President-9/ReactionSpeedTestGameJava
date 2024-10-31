package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

public class MouseHandler implements MouseListener{

	GamePanel gp;
	Sound s1,s2;
	boolean targetHit = false;
	long startTime;
	long endTime;
	long elapsedNano;
	double elapsedSeconds;
	
	// MouseEvent.BUTTON1 == Left Mouse Button

	public MouseHandler(GamePanel gp) {
		this.gp = gp;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int code = e.getButton();
		if(gp.titleScreenGameState == true) {
			if(gp.mouseMH.onPlayGame == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.titleScreenGameState = false;
				gp.gameSelectScreenState = true;

			}
			else if(gp.mouseMH.onScoreTable == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.scoreTableState = true ;
				gp.titleScreenGameState = false;
			}
			else if(gp.mouseMH.onOptions == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.optionScreenGameState = true ;
				gp.titleScreenGameState = false;
				
			}
			else if(gp.mouseMH.onQuit == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				System.exit(0);
			}
		}
		else if(gp.scoreTableState == true) {
			if(gp.mouseMH.onOneShoot == true && code == MouseEvent.BUTTON1) {
				gp.scoreTableState = false;
				gp.oneShootTableState = true;
				gp.oneShootFM.getValues();
				gp.soundEffect.playSE(1,gp.soundEffect);
			}
			else if(gp.mouseMH.on1Min == true && code == MouseEvent.BUTTON1) {

				gp.scoreTableState = false;
				gp.oneMinTableState = true;
				gp.oneMinAndSurvFM.getValues();
				gp.soundEffect.playSE(1,gp.soundEffect);
			}
			else if(gp.mouseMH.onSurvival == true && code == MouseEvent.BUTTON1) {

				gp.scoreTableState = false;
				gp.survivalTableState = true;
				gp.oneMinAndSurvFM.getValues();
				gp.soundEffect.playSE(1,gp.soundEffect);
			}
			else if(gp.mouseMH.onBack == true && code == MouseEvent.BUTTON1) {
				gp.scoreTableState = false;
				gp.titleScreenGameState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
			}
		}
		else if(gp.oneShootTableState == true || gp.oneMinTableState == true || gp.survivalTableState == true) {
			if(gp.mouseMH.onBack == true && code == MouseEvent.BUTTON1) {
				gp.oneShootTableState = false;
				gp.oneMinTableState = false;
				gp.survivalTableState = false;
				gp.scoreTableState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.oneShootFM.storedRecords.clear();
				gp.oneMinAndSurvFM.storedRecords.clear();
			}
		}
		else if(gp.optionScreenGameState == true ) {
			
			if(gp.mouseMH.onVolDown == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				if(gp.ui.volumeCounter == 0) {
					gp.ui.volumeCounter = 0;
				}
				else {
					gp.ui.volumeCounter--;
				}
				gp.soundBG.checkVolume(gp);
			}
			else if(gp.mouseMH.onVolUp == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				if(gp.ui.volumeCounter == 4) {
					gp.ui.volumeCounter = 4;
				}
				else {
					gp.ui.volumeCounter++;
				}
				gp.soundBG.checkVolume(gp);
			}
			else if(gp.mouseMH.onSEVolDown == true && code == MouseEvent.BUTTON1) {
				if(gp.ui.seVolumeCounter == 0) {
					gp.ui.seVolumeCounter = 0;
				}
				else {
					gp.ui.seVolumeCounter--;
				}
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.soundEffect.checkSEVolume(gp);
			}
			else if(gp.mouseMH.onSEVolUp == true && code == MouseEvent.BUTTON1) {
				if(gp.ui.seVolumeCounter == 4) {
					gp.ui.seVolumeCounter = 4;
				}
				else {
					gp.ui.seVolumeCounter++;
				}
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.soundEffect.checkSEVolume(gp);
			}
			else if(gp.mouseMH.onBack == true && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.optionScreenGameState = false;
				gp.titleScreenGameState = true;
				gp.config.saveConfig();
			}
		}
		else if(gp.gameSelectScreenState == true) {
			
			if(gp.mouseMH.onOneShoot == true && code == MouseEvent.BUTTON1) {

				gp.gameSelectScreenState = false;
				gp.oneShotGameState = true;
				gp.threeTwoOneState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.ui.delayTime = (short)gp.ui.random.nextInt(5,20);
				gp.target.setImageXY(gp);
				gp.soundBG.stopMusic(gp.soundBG);
				gp.soundBG.playMusic(6, gp.soundBG);
			}
			else if(gp.mouseMH.on1Min == true && code == MouseEvent.BUTTON1) {

				gp.gameSelectScreenState = false;
				gp.ui.delayTime = 0;
				gp.easy1MinGameState = true;
				gp.threeTwoOneState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.soundBG.stopMusic(gp.soundBG);
				gp.soundBG.playMusic(6, gp.soundBG);
			}
			else if(gp.mouseMH.onSurvival == true && code == MouseEvent.BUTTON1) {

				gp.gameSelectScreenState = false;
				gp.survivalGameState = true;
				gp.threeTwoOneState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.soundBG.stopMusic(gp.soundBG);
				gp.soundBG.playMusic(6, gp.soundBG);
			}
			else if(gp.mouseMH.onBack == true && code == MouseEvent.BUTTON1) {
				
				gp.gameSelectScreenState = false;
				gp.titleScreenGameState = true;
				gp.soundEffect.playSE(1,gp.soundEffect);
//				gp.soundBG.stopMusic(gp.soundBG);
			}
		}
		else if(gp.oneShotGameState == true && gp.inGameState == true) {

			if(gp.mouseMH.onTarget == false && gp.mouseMH.onExit == false && gp.confirmScreenState == false && code == MouseEvent.BUTTON1) {
				gp.enterNameState = true;
				gp.ui.wrongHit = true;
				if(gp.enterNameState == false) {
					gp.soundEffect.playSE(5,gp.soundEffect);
				}
				gp.soundBG.stopMusic(gp.soundBG);
			}
			if(gp.mouseMH.onTarget == true && code == MouseEvent.BUTTON1 && targetHit == false) {
				gp.soundEffect.playSE(4,gp.soundEffect);
				//Float.parseFloat(new DecimalFormat("#.000").format((System.nanoTime())))
				gp.ui.yourTime =  (float) (gp.ui.currentTime - gp.ui.delayTime);
				gp.ui.yourTime = Float.parseFloat(new DecimalFormat("#.000").format(gp.ui.yourTime));
				targetHit = true;
				gp.enterNameState = true;
				gp.soundBG.stopMusic(gp.soundBG);
			}
			// on EXIT
			if(gp.mouseMH.onExit ==true && code == MouseEvent.BUTTON1) {

				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.confirmScreenState = true;
				gp.mouseMH.onExit = false;
				gp.mouseMH.playedSE = false;
			}
//			gp.mouseMH.onExit = true;

		}
		else if(gp.easy1MinGameState == true && gp.inGameState == true) {
			
			if(gp.ui.exactTime == 0) {
				if(gp.mouseMH.onTarget == false && gp.mouseMH.onExit == false && gp.confirmScreenState == false && code == MouseEvent.BUTTON1) {
					if(gp.ui.start == false) {
						gp.ui.yourTime = gp.ui.currentTime;
						gp.soundEffect.playSE(5,gp.soundEffect);
						gp.target.targetHitPerS =gp.target.targetHitCount/gp.ui.yourTime;
						gp.target.targetHitPerS = Float.parseFloat(new DecimalFormat("#.000").format(gp.target.targetHitPerS));
						// this gp.ui.start is just used as a condition to play sound effect only once.
						gp.ui.start = true;}
					gp.soundBG.stopMusic(gp.soundBG);
					
					gp.ui.wrongHit = true;
					if(gp.ui.yourTime == 0 || gp.target.targetHitPerS == 0) {gp.ui.yourTime = gp.ui.currentTime; gp.target.targetHitPerS = 0;}
					
					gp.enterNameState = true;
				}
			}
			if(gp.mouseMH.onTarget == true && code == MouseEvent.BUTTON1 && targetHit == false) {
				gp.soundEffect.playSE(4,gp.soundEffect);
				gp.target.targetHitCount++;

				targetHit = true;
				gp.mouseMH.onTarget = false;
			}
			// on EXIT
			if(gp.mouseMH.onExit ==true && code == MouseEvent.BUTTON1) {

				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.confirmScreenState = true;
				gp.mouseMH.onExit = false;
				gp.mouseMH.playedSE = false;
			}
//			gp.mouseMH.onExit = true;

		}
		else if(gp.survivalGameState == true && gp.inGameState == true) {
			if(gp.ui.exactTime == 0) {
				if(gp.mouseMH.onTarget == false && gp.mouseMH.onExit == false && gp.confirmScreenState == false && gp.notTarget.onNotTargets == false && code == MouseEvent.BUTTON1) {
					if(gp.ui.start == false) {
						gp.soundEffect.playSE(5,gp.soundEffect);
						gp.ui.yourTime = gp.ui.currentTime;
						gp.target.targetHitPerS =gp.target.targetHitCount/gp.ui.yourTime;
						gp.target.targetHitPerS = Float.parseFloat(new DecimalFormat("#.000").format(gp.target.targetHitPerS));					// this gp.ui.start is just used as a condition to play sound effect only once.
						gp.ui.start = true;}
					
					gp.soundBG.stopMusic(gp.soundBG);
					
					gp.ui.wrongHit = true;
					if(gp.ui.yourTime == 0 || gp.target.targetHitPerS == 0) {gp.ui.yourTime = gp.ui.currentTime; gp.target.targetHitPerS = 0;}
					
					gp.enterNameState = true;
				}
			}	
			if(gp.notTarget.onNotTargets == true && gp.mouseMH.onTarget == false && code == MouseEvent.BUTTON1) {
				if(gp.ui.start == false) {
					gp.soundEffect.playSE(5,gp.soundEffect);
					gp.ui.yourTime = gp.ui.currentTime;
					gp.target.targetHitPerS =gp.target.targetHitCount/gp.ui.yourTime;
					// this gp.ui.start is just used as a condition to play sound effect only once.
					gp.ui.start = true;}
				gp.soundBG.stopMusic(gp.soundBG);
				gp.ui.wrongHit = true;
				gp.enterNameState = true;
				if(gp.ui.start == false) {// this gp.ui.start is just used as a condition to compute the division only once.
					gp.ui.start = true;
					if(gp.ui.yourTime == 0 || gp.target.targetHitPerS == 0) {gp.ui.yourTime = gp.ui.currentTime; gp.target.targetHitPerS = 0;}
				}
			}
			if(gp.mouseMH.onTarget == true && targetHit == false && gp.notTarget.onNotTargets == false && code == MouseEvent.BUTTON1) {
				gp.soundEffect.playSE(4,gp.soundEffect);
				gp.target.targetHitCount++;

				targetHit = true;
				gp.mouseMH.onTarget = false;
//				gp.notTarget.onNotTargets = true; // Making the game loop Stop if we did not move when we clicked
			}
			// on EXIT
			if(gp.mouseMH.onExit ==true && code == MouseEvent.BUTTON1) {

				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.confirmScreenState = true;
				gp.mouseMH.onExit = false;
				gp.mouseMH.playedSE = false;
			}
//			gp.mouseMH.onExit = true;

		}
		if(gp.confirmScreenState == true) {
			
			// on YES
			if(gp.mouseMH.onYes ==true && code == MouseEvent.BUTTON1) {
				
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.confirmScreenState = false;
				gp.titleScreenGameState = true;
				gp.inGameState = false;
				gp.threeTwoOneState = false;
				gp.countTimer = 0;
				gp.soundBG.stopMusic(gp.soundBG);
				gp.soundBG.playMusic(0, gp.soundBG);
			}
			gp.mouseMH.onYes = false; // Important
			
			// on NO
			if(gp.mouseMH.onNo ==true && code == MouseEvent.BUTTON1) {
				
				gp.soundEffect.playSE(1,gp.soundEffect);
				gp.confirmScreenState = false;
			}
			gp.mouseMH.onNo = false; // Important
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}
