package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class NotTarget {

	int notTargetX,notTargetY;
	GamePanel gp;
	public BufferedImage notTargetImg;
	short notTargetIncrValue;
	boolean notTargetsDrawn = false;
	ArrayList<NotTarget> notTargetArLi = new ArrayList<>();
	boolean onNotTargets = false;
	
	public NotTarget(GamePanel gp) {
		
		this.gp = gp;
		getTargetImage();
	}
	public void getTargetImage() {
		try{
			notTargetImg = ImageIO.read(getClass().getResourceAsStream("/target/nottarget.png"));
			notTargetX = gp.ui.random.nextInt(gp.tileSize + (gp.tileSize/2),gp.screenWidth -(gp.tileSize * 3));
			notTargetY = gp.ui.random.nextInt(gp.tileSize,gp.screenHeight - (gp.tileSize * 4));	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setImageXY(GamePanel gp) {

		for (NotTarget nt:notTargetArLi) {
			nt.notTargetX = gp.ui.random.nextInt(gp.tileSize + (gp.tileSize/2),gp.screenWidth -(gp.tileSize * 3));
			nt.notTargetY = gp.ui.random.nextInt(gp.tileSize,gp.screenHeight - (gp.tileSize * 4));	
		}
	}
	public void checkImageXY() {
		
	}
	public void update() {}
	public void draw(Graphics2D g2) {
		if(gp.ui.currentTime > gp.ui.delayTime) {
			
			for (NotTarget nt:notTargetArLi) {
				g2.drawImage(nt.notTargetImg, nt.notTargetX,nt.notTargetY ,gp.tileSize/2,gp.tileSize/2, null);
			}
			
			if(notTargetsDrawn == false) {notTargetsDrawn = true;}
		}
	}
	public void disposeNotTargets(Graphics2D g2) {
		
		for (NotTarget nt:notTargetArLi) {
			
			g2.drawImage(null, nt.notTargetX,nt.notTargetY ,gp.tileSize/2,gp.tileSize/2, null);
		}	
	}
}
