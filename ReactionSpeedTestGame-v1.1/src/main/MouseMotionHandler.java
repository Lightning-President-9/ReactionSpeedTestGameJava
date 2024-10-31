package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener{

	GamePanel gp;
	Sound s1,s2;
	
	// FOR MANAGING CLICKING
	boolean onPlayGame = false,
			onScoreTable = false,
			onOptions = false,
			onQuit = false,
			onOneShoot = false,
			on1Min = false,
			onSurvival = false,
			onBack = false,
			onExit = false,
			onYes = false,
			onNo = false,
			onTarget = false,
			onNotTarget = false,
			onVolUp = false,
			onVolDown = false,
			onSEVolUp = false,
			onSEVolDown = false;
	
	// FOR SOUND
	boolean playSE = false;
	boolean playedSE = false;

	public MouseMotionHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(gp.titleScreenGameState == true) {
			
			checkMouseOnPlayGame(e);
			checkMouseOnScoreTable(e);
			checkMouseOnOptions(e);
			checkMouseOnQuit(e);
		}
		else if(gp.scoreTableState == true) {
			checkMouseOnOneShoot(e);
			checkMouseOn1Min(e);
			checkMouseOnSurvival(e);
			checkMouseOnBack(e);
		}
		else if(gp.oneShootTableState == true || gp.oneMinTableState == true || gp.survivalTableState == true){
			checkMouseOnBack(e);
		}
		else if(gp.optionScreenGameState == true) {
			checkMouseOnBack(e);
			checkMouseOnVolUp(e);
			checkMouseOnVolDown(e);
			checkMouseOnSEVolUp(e);
			checkMouseOnSEVolDown(e);
		}
		else if(gp.gameSelectScreenState == true) {
			
			checkMouseOnOneShoot(e);
			checkMouseOn1Min(e);
			checkMouseOnSurvival(e);
			checkMouseOnBack(e);
		}
		else if((gp.oneShotGameState == true  || gp.easy1MinGameState == true || gp.survivalGameState == true)&& gp.inGameState == true && gp.confirmScreenState == false) {
			
			checkMouseOnTarget(e);
			if(gp.survivalGameState == true) {
				if(checkMouseOnTarget(e) == true && checkMouseOnNotTargets(e) == true) {
					gp.notTarget.onNotTargets = false;
					gp.mouseMH.onTarget = true;
				}
				else {
					checkMouseOnNotTargets(e);
				}
			}
			if(gp.enterNameState == false) {
				checkMouseOnExit(e);
			}
		}
		else if(gp.confirmScreenState == true) {

			checkMouseOnYes(e);
			checkMouseOnNo(e);
		}
	}
	public boolean checkMouseOnYes(MouseEvent e) {
		
		int x,y,width,height;
		
		x =(gp.screenWidth / 2) - (gp.tileSize * 2);
		y = (int)((gp.screenHeight / 2) - (gp.tileSize * 1.8));
		width = gp.tileSize * 4;
		height = gp.tileSize * 1;
		
		y+= gp.tileSize;
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height) {
			onYes = true;
		}
		else {
			onYes = false;
		}
		return onYes;
	}
	public boolean checkMouseOnNo(MouseEvent e) {
	
		int x,y,width,height;
		
		x =(gp.screenWidth / 2) - (gp.tileSize * 2);
		y = (int)((gp.screenHeight / 2) - (gp.tileSize * 1.8));
		width = gp.tileSize * 4;
		height = gp.tileSize * 1;
		
		y+= gp.tileSize;
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >= y+gp.tileSize  && e.getY() <= y + height+ gp.tileSize) {
			
			onNo = true;
		}
		else {
			onNo = false;
		}
		return onNo;
	}
	public boolean checkMouseOnExit(MouseEvent e) {
		int x = ((gp.screenWidth / 2) - gp.tileSize * 2),
				y = gp.screenHeight - gp.tileSize * 2,
				width =  x + (gp.tileSize * 4),
				height =  (int)(y + (gp.tileSize* 1.2));
				
				if((e.getX() >= x && e.getX() <= width && e.getY() >=y && e.getY() <= height) && gp.confirmScreenState == false) {

					onExit = true;
				}
				else {onExit = false;}
				return onExit;
	}
	public boolean checkMouseOnOneShoot(MouseEvent e) {
		
		int x = gp.tileSize / 2,
				y = gp.tileSize / 2,
				width = gp.screenWidth - gp.tileSize ,
				height = gp.screenHeight / 4;
		
		if((e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height)) {
			onOneShoot = true;
			on1Min = false;
			onSurvival = false;
			onBack = false;
		}
		else {onOneShoot = false;}
		return onOneShoot;
	}
	public boolean checkMouseOn1Min(MouseEvent e) {
		
		int x = gp.tileSize / 2,
				y = gp.tileSize / 2,
				width = gp.screenWidth - gp.tileSize ,
				height = gp.screenHeight / 4;
		
		if((e.getX() >= x && e.getX() <= x + width && e.getY() >=y + (height * 1) && e.getY() <= y + (height * 2))) {
			onOneShoot = false;
			on1Min = true;
			onSurvival = false;
			onBack = false;
		}
		else {on1Min = false;}
		return on1Min;
	}
	public boolean checkMouseOnSurvival(MouseEvent e) {
		
		int x = gp.tileSize / 2,
				y = gp.tileSize / 2,
				width = gp.screenWidth - gp.tileSize ,
				height = gp.screenHeight / 4;
		
		if((e.getX() >= x && e.getX() <= x + width && e.getY() >=y + (height * 2) && e.getY() <= y + (height * 3))) {
			onOneShoot = false;
			on1Min = false;
			onSurvival = true;
			onBack = false;
		}
		else {onSurvival = false;}
		return onSurvival;
	}
	public boolean checkMouseOnBack(MouseEvent e) {
		
		int x = (gp.screenWidth / 2) - gp.tileSize * 2,
				y = gp.tileSize / 2,
				height = gp.screenHeight / 4;
		
		if((e.getX() >= x && e.getX() <=  x + (gp.tileSize * 4) && e.getY() >=y + (height * 3) + 20 && e.getY() <= y + (height * 3.5))) {
			onOneShoot = false;
			on1Min = false;
			onSurvival = false;
			onBack = true;
		}
		else {onBack = false;}
		return onBack;
	}
	public boolean checkMouseOnPlayGame(MouseEvent e) {
		int x = (gp.screenWidth/2) - (gp.tileSize * 3),
				y = (gp.screenHeight/2)- gp.tileSize,
				width = (gp.screenWidth/3) + (int)(gp.tileSize * 0.7),
				height = (int)(gp.tileSize * 1.5);

		if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {

			onPlayGame = true;
			onScoreTable = false;
			onOptions = false;
			onQuit = false;
		}
		else {onPlayGame = false;}
		return onPlayGame;

	}
	public boolean checkMouseOnScoreTable(MouseEvent e) {
		int x = (gp.screenWidth/2) - (gp.tileSize * 3),
				y = (gp.screenHeight/2)- gp.tileSize,
				width = (gp.screenWidth/3) + (int)(gp.tileSize * 0.7),
				height = (int)(gp.tileSize * 1.5);
		
		y += gp.tileSize * 1.5;

		if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {

			onPlayGame = false;
			onScoreTable = true;
			onOptions = false;
			onQuit = false;
		}
		else {onScoreTable = false;}
		return onScoreTable;
	}
	public boolean checkMouseOnOptions(MouseEvent e) {
		int x = (gp.screenWidth/2) - (gp.tileSize * 3),
				y = (gp.screenHeight/2)- gp.tileSize,
				width = (gp.screenWidth/3) + (int)(gp.tileSize * 0.7),
				height = (int)(gp.tileSize * 1.5);

		y += gp.tileSize * 3;
		
		if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {

			onPlayGame = false;
			onScoreTable = false;
			onOptions = true;
			onQuit = false;
		}
		else {onOptions = false;}
		return onOptions;
	}
	public boolean checkMouseOnQuit(MouseEvent e) {
		
		int x = (gp.screenWidth/2) - (gp.tileSize * 3),
				y = (gp.screenHeight/2)- gp.tileSize,
				width = (gp.screenWidth/3) + (int)(gp.tileSize * 0.7),
				height = (int)(gp.tileSize * 1.5);

		y += gp.tileSize * 4.5;
		
		if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {
			
			onPlayGame = false;
			onScoreTable = false;
			onOptions = false;
			onQuit = true;
		}
		else {onQuit = false;}
		return onQuit;
	}
	public boolean checkMouseOnTarget(MouseEvent e) {
		int x = gp.target.targetX,
				y = gp.target.targetY,
				width = gp.tileSize/2,
				height = gp.tileSize/2;

		if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {

			onTarget = true;
		}
		else {onTarget = false;}
		return onTarget;
	}
	public boolean checkMouseOnNotTargets(MouseEvent e) {
		
		NotTarget temp = new NotTarget(gp);
//		temp.onNotTargets = false;
		for (NotTarget nt:gp.notTarget.notTargetArLi) {
			int x = nt.notTargetX,
					y = nt.notTargetY,
					width = gp.tileSize/2,
					height = gp.tileSize/2;

			if((e.getX() >= x && e.getX() <=  x + width && e.getY() >=y && e.getY() <=  y + height)) {

				nt.onNotTargets = true;
				temp.onNotTargets = nt.onNotTargets;
//				gp.notTarget.onNotTargets = true;
				break;
			}
			else {nt.onNotTargets = false;temp.onNotTargets = nt.onNotTargets;}
//			break;
//			System.out.println(nt.onNotTargets);
		}
//		System.out.println(temp.onNotTargets);
		gp.notTarget.onNotTargets = temp.onNotTargets;
		return temp.onNotTargets;
//		return gp.notTarget.onNotTargets;
	}
	public boolean checkMouseOnVolUp(MouseEvent e) {
		
		int x = (gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3),
				y = (gp.tileSize*2) + (gp.tileSize/3),
				width = gp.tileSize/3,
				height = gp.tileSize/3;
		
//		y = y -(gp.tileSize/2);
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height) {
			onVolUp = true;
		}
		else {
			onVolUp = false;
		}
		return onVolUp;
	}
	public boolean checkMouseOnVolDown(MouseEvent e) {
			
		int x = (gp.screenWidth/2),
				y = (gp.tileSize*2) + (gp.tileSize/3),
				width = gp.tileSize/3,
				height = gp.tileSize/3;
		
//		y = y -(gp.tileSize/2);
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height) {
			onVolDown = true;
		}
		else {
			onVolDown = false;
		}
		return onVolDown;
		}
	public boolean checkMouseOnSEVolUp(MouseEvent e) {
		
		int x = (gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3),
				y = (gp.tileSize*2) + (gp.tileSize/3),
				width = gp.tileSize/3,
				height = gp.tileSize/3;
		
		y += gp.tileSize + (gp.tileSize/3);
//		y =y -(gp.tileSize/2);
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height) {
			onSEVolUp = true;
		}
		else {
			onSEVolUp = false;
		}
		return onSEVolUp;
	}
	public boolean checkMouseOnSEVolDown(MouseEvent e) {
	
		int x = (gp.screenWidth/2),
				y = (gp.tileSize*2) + (gp.tileSize/3),
				width = gp.tileSize/3,
				height = gp.tileSize/3;
		
		y += gp.tileSize + (gp.tileSize/3);
//		y =y -(gp.tileSize/2);
		
		if(e.getX() >= x && e.getX() <= x + width && e.getY() >=y && e.getY() <= y + height) {
			onSEVolDown = true;
		}
		else {
			onSEVolDown = false;
		}
		return onSEVolDown;
	}
}
