package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.Random;

public class UI {

	GamePanel gp;
	BasicStroke bs3;
	BasicStroke bs7;
	
	// FOR 3 2 1 START MUSIC HANDLER
	boolean start3=true,start2,start1,start;
	
//	double timer;
	double longTimer=0;  // Timer in seconds
    int frameCount=0;    // Count of frames since last second update
    float currentTime;
	Random random;
	short delayTime = 0;
	float yourTime;
	float exactTime = 0;
	DecimalFormat formatter;
	String curTime = "";
	
	boolean wrongHit = false;
	
	// For Sound/Volume Counter
	short volumeCounter ;
	short seVolumeCounter ;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		this.bs3 = new BasicStroke(3);
		this.bs7 = new BasicStroke(7);
		this.random = new Random();
		this.formatter =new DecimalFormat("#.0");
	}
	public void drawTitleScreen(Graphics2D g2){
		
		setUpInitials();
		
		int x,y;
		
		g2.setStroke(bs7);
		g2.drawRoundRect((gp.tileSize/2), gp.tileSize/2,gp.screenWidth - (gp.tileSize) , gp.screenHeight - (gp.tileSize),20, 20);
		
		// GAME TITLE
		String text = "RST Game";
		g2.setFont(g2.getFont().deriveFont(80f));
		x = findXForMiddleText(text,g2);
		y = gp.tileSize * 2;
		g2.drawString(text, x ,y + gp.tileSize);
		
		g2.drawRoundRect(x - (gp.tileSize/2), y - (gp.tileSize/2), (gp.screenWidth/2) + (int)(gp.tileSize *1.3), gp.tileSize * 2, 20, 20);
		
		g2.setStroke(bs3);
		
		// TITLE OPTIONS
		text = "Play Game";
		g2.setFont(g2.getFont().deriveFont(50f));
		x = findXForMiddleText(text,g2);
		y = (gp.screenHeight/2);
		if(gp.mouseMH.onPlayGame == true) {
			
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		else {
			
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		
		g2.drawString(text, x ,y);
		
		text = "Score Table";
		g2.setFont(g2.getFont().deriveFont(50f));
		x = findXForMiddleText(text,g2);
		y += gp.tileSize * 1.5;
		if(gp.mouseMH.onScoreTable == true) {
			
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		else {
			
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		g2.drawString(text, x ,y);
		
		text = "Options";
		g2.setFont(g2.getFont().deriveFont(50f));
		x = findXForMiddleText(text,g2);
		y += gp.tileSize * 1.5;
		if(gp.mouseMH.onOptions == true) {
			
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		else {
			
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		g2.drawString(text, x ,y);
		
		text = "Quit";
		g2.setFont(g2.getFont().deriveFont(50f));
		x = findXForMiddleText(text,g2);
		y += gp.tileSize * 1.5;
		if(gp.mouseMH.onQuit == true) {
			
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		else {
			
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth/2) - (gp.tileSize * 3), y - gp.tileSize, (gp.screenWidth/3) + (int)(gp.tileSize * 0.7), (int)(gp.tileSize * 1.5), 20, 20);
		}
		g2.drawString(text, x ,y);
		
		//System.out.println();
		g2.setFont(g2.getFont().deriveFont(20f));
		text = "v1.1";
		g2.drawString(text, gp.screenWidth - (int)(gp.tileSize * 1.7) ,gp.screenHeight - (int)(gp.tileSize * 0.7));
		
	}
	public void drawTableScreen(Graphics2D g2) {
		
		int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth - gp.tileSize * 2,
				height = gp.screenHeight - gp.tileSize * 3;
		String text;
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y - 25, width, height, 20, 20);
			
			text = "Name";
			g2.setFont(g2.getFont().deriveFont(30f));
			g2.drawString(text, gp.tileSize +(gp.tileSize/3), y);
			if(gp.oneShootTableState == true) {
				text = "Time";
				g2.drawString(text, gp.screenWidth/2, y);
				
				g2.setFont(g2.getFont().deriveFont(20f));
				for(Record record :gp.oneShootFM.storedRecords) {
					y+= (gp.tileSize*0.8);
					g2.drawString(record.name, gp.tileSize +(gp.tileSize/3), y);
					g2.drawString(Float.toString(record.time), gp.screenWidth/2 , y);
				}
			}
			else if(gp.oneMinTableState == true || gp.survivalTableState == true) {
				text = "Time";
				g2.drawString(text, gp.screenWidth/3 - gp.tileSize, y);
				
				text = "Hit Count";
				g2.drawString(text, gp.screenWidth/2, y);
				
				text = "Hit/sec";
				g2.drawString(text,  gp.screenWidth - (gp.tileSize * 4), y);
				
				g2.setFont(g2.getFont().deriveFont(20f));
				for(Record record :gp.oneMinAndSurvFM.storedRecords) {
					y+= (gp.tileSize*0.8);
					g2.drawString(record.name, gp.tileSize +(gp.tileSize/3), y);
					g2.drawString(Float.toString(record.time), gp.screenWidth/3 - gp.tileSize , y);
					g2.drawString(Short.toString(record.targetHitCount), (gp.screenWidth/2) + gp.tileSize , y);
					g2.drawString(Float.toString(record.targetHPS), gp.screenWidth - (gp.tileSize * 4) , y);
				}
			}
			
			if(gp.mouseMH.onBack == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, gp.screenHeight - (int)(gp.tileSize * 2.1), gp.tileSize * 4, gp.tileSize, 20, 20);
			}
			else {
				g2.setStroke(bs3);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, gp.screenHeight - (int)(gp.tileSize * 2.1), gp.tileSize * 4, gp.tileSize, 20, 20);
			}
			
			text = "BACK";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y = (int)(gp.tileSize * 10.7);
			g2.drawString(text, x ,y);
	}
	public void drawOptionScreen(Graphics2D g2) {
		
		int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth - gp.tileSize * 2,
				height = gp.screenHeight - gp.tileSize * 3;
		String text;
		
		g2.setStroke(bs7);
		g2.drawRoundRect(x, y - 25, width, height, 20, 20);
			
		text = "OPTIONS";
		g2.setFont(g2.getFont().deriveFont(40f));
		x += gp.tileSize/2;
		y += gp.tileSize/2;
		g2.drawString(text,findXForMiddleText(text,g2) ,y);
		
		g2.setFont(g2.getFont().deriveFont(40f));
		text = "Music Volume";
		x = gp.tileSize + (gp.tileSize/2);
		y += gp.tileSize + (gp.tileSize/3);
		g2.drawString(text, x ,y);
		
		g2.setStroke(bs3);
		
		if(gp.mouseMH.onVolDown == true) {
			g2.fillRoundRect((gp.screenWidth/2) , y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
		else {
			g2.drawRoundRect((gp.screenWidth/2) , y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}

		g2.drawRoundRect((gp.screenWidth/2) + (gp.tileSize ), y -(gp.tileSize/2), gp.tileSize * 4, gp.tileSize/3, 10, 10);
		g2.fillRoundRect((gp.screenWidth/2) + (gp.tileSize ), y -(gp.tileSize/2), gp.tileSize * volumeCounter, gp.tileSize/3, 10, 10);
		
		if(gp.mouseMH.onVolUp == true) {
			g2.fillRoundRect((gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3), y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
		else {
			g2.drawRoundRect((gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3), y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}	
		
		g2.setFont(g2.getFont().deriveFont(40f));
		text = "SE Volume";
		x = gp.tileSize + (gp.tileSize/2);
		y += gp.tileSize + (gp.tileSize/3);
		g2.drawString(text, x ,y);
		
		if(gp.mouseMH.onSEVolDown == true) {
			g2.fillRoundRect((gp.screenWidth/2) , y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
		else {
			g2.drawRoundRect((gp.screenWidth/2) , y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
			
		g2.drawRoundRect((gp.screenWidth/2) + (gp.tileSize ), y -(gp.tileSize/2), gp.tileSize * 4, gp.tileSize/3, 10, 10);
		g2.fillRoundRect((gp.screenWidth/2) + (gp.tileSize ), y -(gp.tileSize/2), gp.tileSize * seVolumeCounter, gp.tileSize/3, 10, 10);
		
		if(gp.mouseMH.onSEVolUp == true) {
			g2.fillRoundRect((gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3), y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
		else {
			g2.drawRoundRect((gp.screenWidth/2) + ((gp.tileSize * 6) - gp.tileSize/3), y -(gp.tileSize/2), gp.tileSize/3, gp.tileSize/3, 10, 10);
		}
		
		if(gp.mouseMH.onBack == true) {
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, gp.screenHeight - (int)(gp.tileSize * 2.1), gp.tileSize * 4, gp.tileSize, 20, 20);
		}
		else {
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, gp.screenHeight - (int)(gp.tileSize * 2.1), gp.tileSize * 4, gp.tileSize, 20, 20);
		}
		
		text = "BACK";
		g2.setFont(g2.getFont().deriveFont(40f));
		x = findXForMiddleText(text,g2);
		y = (int)(gp.tileSize * 10.7);
		g2.drawString(text, x ,y);
	}
	public void drawGameSelectScreen(Graphics2D g2) {
		
		int x = gp.tileSize / 2,
			y = gp.tileSize / 2,
			width = gp.screenWidth - gp.tileSize ,
			height = gp.screenHeight / 4;
		String text;
		
		// DRAW RECTANGLE
//		g2.setStroke(new BasicStroke(3));
		if(gp.mouseMH.onOneShoot == true) {
			g2.setStroke(bs7);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		else {
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		y += height;
		
		if(gp.mouseMH.on1Min == true) {
			g2.setStroke(bs7);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		else {
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		y += height;
		
		if(gp.mouseMH.onSurvival == true) {
			g2.setStroke(bs7);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		else {
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y, width, height, 20, 20);
		}
		y += height + 20;
		
		if(gp.mouseMH.onBack == true) {
			g2.setStroke(bs7);
			g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, y, gp.tileSize * 4, gp.tileSize, 20, 20);
		}
		else {
			g2.setStroke(bs3);
			g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, y, gp.tileSize * 4, gp.tileSize, 20, 20);
		}
		
		// DRAW TEXT
		text = "ONE SHOOT MODE";
		g2.setFont(g2.getFont().deriveFont(70f));
		x = findXForMiddleText(text,g2);
		y = (int)(gp.tileSize * 2.5);
		g2.drawString(text, x ,y);
		
		text = "1 MIN MODE";
		g2.setFont(g2.getFont().deriveFont(70f));
		x = findXForMiddleText(text,g2);
		y = (int)(gp.tileSize * 5.5);
		g2.drawString(text, x ,y);
		
		text = "SURVIVAL MODE";
		g2.setFont(g2.getFont().deriveFont(70f));
		x = findXForMiddleText(text,g2);
		y = (int)(gp.tileSize * 8.5);
		g2.drawString(text, x ,y);
		
		text = "BACK";
		g2.setFont(g2.getFont().deriveFont(40f));
		x = findXForMiddleText(text,g2);
		y = (int)(gp.tileSize * 10.7);
		g2.drawString(text, x ,y);
	}
	public void drawConfirmScreenState(Graphics2D g2) {
		
		int x = (gp.screenWidth / 2) - (gp.tileSize * 3) + gp.tileSize / 2,
				y = (gp.screenHeight / 2) - (gp.tileSize * 2),
				width = gp.tileSize * 5 ,
				height = (int)(gp.tileSize * 3.5);
			String text = "Confirm?";
			
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y, width, height, 20, 20);
			
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y += gp.tileSize;
			g2.drawString(text, x ,y);
			
			text = "YES";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y += gp.tileSize;
			g2.drawString(text, x ,y);

			text = "NO";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y += gp.tileSize;
			g2.drawString(text, x ,y);
			
			x = (gp.screenWidth / 2) - (gp.tileSize * 2);
			y = (int)((gp.screenHeight / 2) - (gp.tileSize * 1.8));
			width = gp.tileSize * 4;
			height = gp.tileSize * 1;
			
			g2.drawRoundRect(x, y, width, height, 20, 20);
			y+= gp.tileSize;
			
			if(gp.mouseMH.onYes == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect(x, y, width, height, 20, 20);
			}
			else {
				g2.setStroke(bs3);
				g2.drawRoundRect(x, y, width, height, 20, 20);
			}

			y+= gp.tileSize;

			if(gp.mouseMH.onNo == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect(x, y, width, height, 20, 20);
			}
			else {
				g2.setStroke(bs3);
				g2.drawRoundRect(x, y, width, height, 20, 20);
			}

			
	}
	public void drawOneShotScreen(Graphics2D g2) {
		if(gp.threeTwoOneState == true) {
			
			drawInstructionScreen(g2);
			threeTwoOneScreen(g2);
		}
		else if(gp.inGameState == true) {
			
//			Image/Target Draw Area
//			g2.drawRoundRect(gp.tileSize + (gp.tileSize/2) , gp.tileSize, gp.screenWidth -(gp.tileSize * 3),gp.screenHeight - (gp.tileSize * 4), 20, 20);

			if(gp.enterNameState == true) {
				drawEnterNameState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
				gp.mouseMH.onTarget = false;
			}
			else {gp.target.draw(g2);}
			if(gp.confirmScreenState == true) {
				frameCount = 0;
				drawConfirmScreenState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			}
			int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth - gp.tileSize * 2,
				height = gp.screenHeight - gp.tileSize * 3;
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y - 25, width, height, 20, 20);
			if(gp.mouseMH.onExit == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			else {
				
				g2.setStroke(bs3);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			
			g2.setStroke(bs3);
			
			// For Time Displaying
			g2.drawRoundRect(gp.tileSize,(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.setFont(g2.getFont().deriveFont(20f));
			g2.drawString("Time",(int)(gp.tileSize * 2.5),(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			g2.drawRoundRect(gp.screenWidth - (gp.tileSize * 5),(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.drawString("Your Time",gp.screenWidth - (gp.tileSize * 4) ,(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			String text = "EXIT";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y =gp.screenHeight - gp.tileSize + 5;
			g2.drawString(text, x ,y);
			
			startTimer();
//			currentTime = (float)longTimer / 2;
			currentTime = Float.parseFloat(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0));
			
			g2.setFont(g2.getFont().deriveFont(30f));
			g2.drawString(Float.toString(currentTime), gp.tileSize +(gp.tileSize / 2), (gp.screenHeight / 2) + (gp.tileSize * 5));
			if(gp.mouseH.targetHit == true ) {
				
//				g2.drawString(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0), gp.tileSize +(gp.tileSize / 2), (gp.screenHeight / 2) + (gp.tileSize * 5));
//				currentTime = Float.parseFloat(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0));
				
				g2.drawString(Float.toString(gp.ui.yourTime), (int)(gp.screenWidth - (gp.tileSize * 4.5)), (gp.screenHeight / 2) + (gp.tileSize * 5));
			}
		}
		if(currentTime > 60) {
			
			gp.threeTwoOneState = false;
			gp.inGameState = false;
			gp.titleScreenGameState = true;
			gp.confirmScreenState = false;
			gp.soundBG.stopMusic(gp.soundBG);
		}
		
	}
	public void drawEasy1MinScreen(Graphics2D g2) {
		if(gp.threeTwoOneState == true) {
			
			drawInstructionScreen(g2);
			threeTwoOneScreen(g2);
		}
		else if(gp.inGameState == true) {
			
//			Image/Target Draw Area
//			g2.drawRoundRect(gp.tileSize + (gp.tileSize/2) , gp.tileSize, gp.screenWidth -(gp.tileSize * 3),gp.screenHeight - (gp.tileSize * 4), 20, 20);
	
			if(gp.mouseH.targetHit == true) {
				
				gp.target.disposeTarget(g2);
				gp.target.setImageXY(gp);
				gp.mouseH.targetHit = false;
			}
			else {
				if(gp.enterNameState == true) {}
				else {
					currentTime = (float)longTimer / 2;
					curTime = Float.toString(currentTime);
					gp.target.draw(g2);
				}	
			}
			if(gp.enterNameState == true) {
				
				drawEnterNameState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
				gp.mouseMH.onTarget = false;
//				currentTime = exactTime;
			}
			if(gp.confirmScreenState == true) {
				
				frameCount = 0;
				drawConfirmScreenState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			}
			int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth - gp.tileSize * 2,
				height = gp.screenHeight - gp.tileSize * 3;
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y - 25, width, height, 20, 20);
			if(gp.mouseMH.onExit == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			else {
				
				g2.setStroke(bs3);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			
			g2.setStroke(bs3);
			
			// For Time Displaying
			g2.drawRoundRect(gp.tileSize,(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.setFont(g2.getFont().deriveFont(20f));
			g2.drawString("Time",(int)(gp.tileSize * 2.5),(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			g2.drawRoundRect(gp.screenWidth - (gp.tileSize * 5),(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.drawString("Targets Hit",gp.screenWidth - (gp.tileSize * 4) ,(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			String text = "EXIT";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y =gp.screenHeight - gp.tileSize + 5;
			g2.drawString(text, x ,y);
			
			startTimer();
//			currentTime = (float)longTimer / 2;
			
			g2.setFont(g2.getFont().deriveFont(30f));
			if(currentTime < 60.01 && gp.enterNameState == false) {
				g2.drawString(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0), gp.tileSize +(gp.tileSize / 2), (gp.screenHeight / 2) + (gp.tileSize * 5));
			}
			currentTime = Float.parseFloat(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0));
//			System.out.println(new DecimalFormat("#.00").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0));
			g2.drawString(Short.toString(gp.target.targetHitCount), (int)(gp.screenWidth - (gp.tileSize * 4.5)), (gp.screenHeight / 2) + (gp.tileSize * 5));
		}
		if(currentTime > 60.01 && gp.enterNameState == false) {
			g2.drawString(Float.toString(60.00f), gp.tileSize +(gp.tileSize / 2), (gp.screenHeight / 2) + (gp.tileSize * 5));
			gp.soundBG.stopMusic(gp.soundBG);
			curTime = formatter.format(currentTime);
//			if(exactTime == 0) {exactTime = 0;}
//			else {
//				avgTime /= gp.target.targetHitCount;
				exactTime = gp.ui.currentTime;
				yourTime = 60.0f;
				gp.target.targetHitPerS =gp.target.targetHitCount/60.0f;
//			}
			gp.threeTwoOneState = false;
			gp.enterNameState = true;
			exactTime = 1;
		}
	}
	public void drawSurvivalScreen(Graphics2D g2) {
		if(gp.threeTwoOneState == true) {
			
			drawInstructionScreen(g2);
			threeTwoOneScreen(g2);
		}
		else if(gp.inGameState == true) {
			
//			Image/Target Draw Area
//			g2.drawRoundRect(gp.tileSize + (gp.tileSize/2) , gp.tileSize, gp.screenWidth -(gp.tileSize * 3),gp.screenHeight - (gp.tileSize * 4), 20, 20);
	
			if(gp.mouseH.targetHit == true && gp.notTarget.onNotTargets == false) {
				
				gp.notTarget.disposeNotTargets(g2);
				gp.notTarget.setImageXY(gp);
				gp.target.disposeTarget(g2);
				gp.target.setImageXY(gp);
				gp.mouseH.targetHit = false;
			}
			else {
				if(gp.enterNameState == true) {}
				else {
					currentTime = (float)longTimer / 2;
					gp.notTarget.draw(g2);
					gp.target.draw(g2);
				}
			}
			if(gp.enterNameState == true) {
				
				drawEnterNameState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
				gp.mouseMH.onTarget = false;
				currentTime = exactTime;
			}
			if(gp.confirmScreenState == true) {
				
				frameCount = 0;
				drawConfirmScreenState(g2);
				g2.setColor(new Color(0,0,0,75));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			}
			int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth - gp.tileSize * 2,
				height = gp.screenHeight - gp.tileSize * 3;
			g2.setStroke(bs3);
			g2.drawRoundRect(x, y - 25, width, height, 20, 20);
			if(gp.mouseMH.onExit == true) {
				g2.setStroke(bs7);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			else {
				
				g2.setStroke(bs3);
				g2.drawRoundRect((gp.screenWidth / 2) - gp.tileSize * 2, (gp.screenHeight / 2) + (gp.tileSize * 4) + 15, gp.tileSize * 4, gp.tileSize, 20, 20);			
			}
			
			g2.setStroke(bs3);
			
			// For Time Displaying
			g2.drawRoundRect(gp.tileSize,(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.setFont(g2.getFont().deriveFont(20f));
			g2.drawString("Time",(int)(gp.tileSize * 2.5),(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			g2.drawRoundRect(gp.screenWidth - (gp.tileSize * 5),(gp.screenHeight / 2) + (gp.tileSize * 4) + 15, (gp.tileSize * 4), gp.tileSize ,20,20);
			g2.drawString("Targets Hit",gp.screenWidth - (gp.tileSize * 4) ,(gp.screenHeight / 2) + (gp.tileSize * 4));
			
			String text = "EXIT";
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y =gp.screenHeight - gp.tileSize + 5;
			g2.drawString(text, x ,y);
			
			startTimer();
//			currentTime = (float)longTimer / 2;
			
			g2.setFont(g2.getFont().deriveFont(30f));

			g2.drawString(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0), gp.tileSize +(gp.tileSize / 2), (gp.screenHeight / 2) + (gp.tileSize * 5));
			currentTime = Float.parseFloat(new DecimalFormat("#.000").format((System.nanoTime() - gp.mouseH.startTime)/1_000_000_000.0));
			g2.drawString(Short.toString(gp.target.targetHitCount), (int)(gp.screenWidth - (gp.tileSize * 4.5)), (gp.screenHeight / 2) + (gp.tileSize * 5));
		}
		if(gp.target.targetHitCount > gp.notTarget.notTargetIncrValue) {
			gp.notTarget.notTargetIncrValue+= gp.ui.random.nextInt(1,2);
			NotTarget tempNT = new NotTarget(gp);
			gp.notTarget.notTargetArLi.add(tempNT);
//			tempNT.setImageXY(gp);
		}
	}
	public void threeTwoOneScreen(Graphics2D g2) {
		
		int x,y;
		String text;
		g2.setFont(g2.getFont().deriveFont(150f));
		y = gp.screenHeight / 2;
		if(gp.countTimer == gp.FPS) {
			text = "3";x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
			if(start3 == true) {
				gp.soundEffect.playSE(2,gp.soundEffect);
				start2 = true;
				start3 = false;				
			}
		}
		if(gp.countTimer == (gp.FPS * 2)) {
			text = "2";x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
			if(start2 == true) {
				gp.soundEffect.playSE(2,gp.soundEffect);
				start1 = true;
				start2 = false;
			}
		}
		if(gp.countTimer == (gp.FPS * 3)) {
			text = "1";x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
			if(start1 == true) {
				gp.soundEffect.playSE(2,gp.soundEffect);
				start = true;
				start1 = false;
			}
		}
		if(gp.countTimer == 240) {text = "START";
		x = findXForMiddleText(text,g2);
		g2.drawString(text, x ,y);
			if(start == true) {
				gp.soundEffect.playSE(3,gp.soundEffect);
				start = false;
				gp.mouseH.startTime = System.nanoTime();
			}
		}
		if(gp.countTimer > 240) {gp.countTimer=0; gp.threeTwoOneState = false;gp.inGameState = true;}

	}
	public void drawEnterNameState(Graphics2D g2) {
		
		int x = (gp.screenWidth/2) - (gp.tileSize * 4),
				y = gp.tileSize,
				width = gp.tileSize * 8 ,
				height = (int)(gp.tileSize * 4.5);
			String text = "";
			
			g2.setStroke(bs7);
			
			if(wrongHit == true) {
				g2.drawRoundRect(x, 0, width, y, 20, 20);
				g2.setFont(g2.getFont().deriveFont(25f));
				text = "Oops You Missed The Target";
				g2.drawString(text,findXForMiddleText(text,g2),(int)(gp.tileSize/1.5));
			}
			
			if(gp.oneShotGameState == true) {
				text = "Your Time";
				g2.drawRoundRect(x, y, width, height, 20, 20);
			}
			if(gp.easy1MinGameState == true || gp.survivalGameState == true) {
				text = "Your Time";
				g2.drawRoundRect(x, y, width, height + (gp.tileSize *4), 20, 20);
			}
			
			g2.setFont(g2.getFont().deriveFont(40f));
			x = findXForMiddleText(text,g2);
			y += gp.tileSize;
			g2.drawString(text, x ,y);
			
			if(gp.oneShotGameState == true) {
				text = Float.toString(yourTime);
			}
			if(gp.easy1MinGameState == true || gp.survivalGameState == true) {
				text = Float.toString(yourTime);
			}
			
			y += gp.tileSize;
			x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
			
			if(gp.easy1MinGameState == true || gp.survivalGameState == true) {
				
				y += gp.tileSize;
				text ="Targets Hit/s";
				x = findXForMiddleText(text,g2);
				g2.drawString(text, x ,y);
				
				y += gp.tileSize;
				text =Float.toString((float)(gp.target.targetHitPerS));
				x = findXForMiddleText(text,g2);
				g2.drawString(text, x ,y);
				
				y += gp.tileSize;
				text = "Total Targets Hit";
				x = findXForMiddleText(text,g2);
				g2.drawString(text, x ,y);
				
				y += gp.tileSize;
				text = Short.toString(gp.target.targetHitCount);
				x = findXForMiddleText(text,g2);
				g2.drawString(text, x ,y);
			}
			y += gp.tileSize;
			text = "Enter Your Name";
			x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
			
			y += gp.tileSize;
			text = gp.keyH.name;
			x = findXForMiddleText(text,g2);
			g2.drawString(text, x ,y);
	}
	public void drawInstructionScreen(Graphics2D g2) {
		
		int x = gp.tileSize,
				y = gp.tileSize,
				width = gp.screenWidth -(gp.tileSize * 2) ,
				height = gp.tileSize * 2;
		
		g2.setStroke(bs7);
		g2.drawRoundRect(x, y, width, height, 20, 20);
		y += gp.tileSize + (gp.tileSize/2);
		x += gp.tileSize * 5;
		
		g2.setFont(g2.getFont().deriveFont(50f));
		g2.drawString("HIT", x ,y - 8);
		g2.drawImage(gp.target.targetImage, x + (gp.tileSize * 2),y - gp.tileSize ,gp.tileSize,gp.tileSize, null);
		
		if(gp.survivalGameState == true) {
			g2.drawRoundRect(gp.tileSize, gp.tileSize * 7, width, height, 20, 20);
			g2.drawString("DON'T HIT", x - (gp.tileSize *2),(int)(gp.tileSize * 8.5)- 8);
			g2.drawImage(gp.notTarget.notTargetImg, x + (int)(gp.tileSize *3.5),(int)(gp.tileSize * 7.5),gp.tileSize,gp.tileSize, null);
		}
		
	}
	public void startTimer() {
		
//		timer+=0.017;
//		timer+=0.016555;

		if(gp.mouseH.targetHit == false) {
				longTimer += 1.0 / gp.FPS;
			     frameCount++;

			        // Check if 60 frames have passed (1 second)
			        if (frameCount >= gp.FPS) {
			            // Update longTimer by 1 second
			            longTimer += 1.0;
			            frameCount = 0;  // Reset frame count for the next second
			        }
		}
	}
	public int findXForMiddleText(String text,Graphics2D g2) {
		
		short length = (short)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - (length/2);
		return x;
		
	}
	public void setUpInitials() {
		
		delayTime = 0;
		longTimer = 0;
		frameCount = 0;
		currentTime = 0;
		exactTime = 0;
		gp.target.targetHitPerS = 0;
		gp.notTarget.notTargetIncrValue= 2;
		gp.target.targetHitCount = 0;
		gp.countTimer = 0;
		curTime = "";
		gp.target.setImageXY(gp);
		gp.mouseH.targetHit = false;
		gp.notTarget.onNotTargets = false;
		yourTime = 0;
		gp.target.targetDrawn = false;
		start3 = true;
		gp.keyH.name="";
		gp.scoreTableState =false;
		gp.optionScreenGameState = false;
		gp.gameSelectScreenState = false;
		gp.confirmScreenState = false;
		gp.inGameState = false;
		gp.threeTwoOneState = false;
		gp.oneShotGameState = false;
		gp.easy1MinGameState = false;
		gp.survivalGameState = false;
		gp.enterNameState = false;
		gp.notTarget.notTargetsDrawn = false;
		wrongHit = false;
	}
}
