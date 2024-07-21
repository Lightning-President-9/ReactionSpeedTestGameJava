package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
	final short originalTileSize = 16; // tile size
	final short scale = 3;
	
	final short tileSize=originalTileSize * scale; //48x48 tile
	final short maxScreenCol = 16;
	final short maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;// 768 pixels
	final int screenHeight = tileSize * maxScreenRow;// 576 pixels
	
	// GAMESTATES
	boolean titleScreenGameState = true,
			scoreTableState,
			oneShootTableState,
			oneMinTableState,
			survivalTableState,
			optionScreenGameState ,
			gameSelectScreenState ,
			confirmScreenState ,
			inGameState ,
			threeTwoOneState ,
			oneShotGameState ,
			easy1MinGameState,
			survivalGameState,
			enterNameState;
	

	final short FPS = 60;
	double countTimer = 0; // this is basically 60 frames per seconds counter. adds 60 per increment.
	
	KeyHandler keyH = new KeyHandler(this);
	MouseHandler mouseH = new MouseHandler(this);
	MouseMotionHandler mouseMH = new MouseMotionHandler(this);
	UI ui = new UI(this);
	Sound soundBG = new Sound(this);
	Sound soundEffect = new Sound(this);
	Target target = new Target(this);
	NotTarget notTarget = new NotTarget(this);
	Config config = new Config(this);
	OneShootModeFM oneShootFM = new OneShootModeFM(this);
	OneMinAndSurvModeFM oneMinAndSurvFM = new OneMinAndSurvModeFM(this);
	Thread gameThread;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.addMouseMotionListener(mouseMH);
		this.setFocusable(true);
		soundBG.playMusic(0,soundBG);		
	}

	public void startGameThread() {

		
		gameThread = new Thread(this);
		notTarget.notTargetArLi.add(notTarget);
//		notTarget.setImageXY(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		/*1,000,000,000 Nanoseconds = 1 second*/
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer= 0 ;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >=1) {
				// UPDATE
				update();
				
				// DRAW
				repaint();
				
				delta--;
				drawCount++;
			}
			
			if(timer >=1000000000) {
//				System.out.println("FPS:"+drawCount);
				countTimer += drawCount;
				drawCount= 0 ;
				timer = 0;			
			}
		}
	}
	public void update() {
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		if(titleScreenGameState == true) {
			ui.drawTitleScreen(g2);
		}
		else if(scoreTableState == true) {
			ui.drawGameSelectScreen(g2);
		}
		else if(oneShootTableState == true || oneMinTableState == true || survivalTableState == true) {
			ui.drawTableScreen(g2);
		}
		else if(optionScreenGameState == true){
			ui.drawOptionScreen(g2);
		}
		else if(gameSelectScreenState == true) {
			ui.drawGameSelectScreen(g2);
		}
		else if(oneShotGameState == true) {
			ui.drawOneShotScreen(g2);
		}
		else if(easy1MinGameState == true) {
			ui.drawEasy1MinScreen(g2);
		}
		else if(survivalGameState == true) {
			ui.drawSurvivalScreen(g2);
		}
		
		g2.dispose();
	}
}
