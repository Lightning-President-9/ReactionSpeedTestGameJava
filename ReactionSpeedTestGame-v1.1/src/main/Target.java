package main;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Target {

	int targetX,targetY;
	GamePanel gp;
	float targetOnScreenTime = 0;
	float targetHitPerS =0;
	public BufferedImage targetImage;
	boolean targetDrawn = false;
	short targetHitCount =0;
	
	// For Frame Icon and Cursor
	Image image,cursorImage;
	ImageIcon icon;
	Point hotspot;
	Cursor cursor;
	
	public Target(GamePanel gp) {
		
		this.gp = gp;
		getTargetImage();
		
	}
	public void getTargetImage() {
		try{
			//Frame Icon
			image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/target/target.png"));
			icon = new ImageIcon(image);
			
			//Cursor
			cursorImage = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/cursor/cursor1.png"))).getImage();
			hotspot = new Point(cursorImage.getWidth(null)/3,cursorImage.getHeight(null)/3);
			cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, hotspot, "TargetCursor");
			
			//Target Image
			targetImage = ImageIO.read(getClass().getResourceAsStream("/target/target.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setImageXY(GamePanel gp) {

		targetX = gp.ui.random.nextInt(gp.tileSize + (gp.tileSize/2),gp.screenWidth -(gp.tileSize * 3));
		targetY = gp.ui.random.nextInt(gp.tileSize,gp.screenHeight - (gp.tileSize * 4));	
	}
	public void checkImageXY() {
		
	}
	public void update() {}
	public void draw(Graphics2D g2) {
		if(gp.ui.currentTime > gp.ui.delayTime) {
			
			g2.drawImage(gp.target.targetImage, gp.target.targetX,gp.target.targetY ,gp.tileSize/2,gp.tileSize/2, null);
			if(targetDrawn == false) {targetOnScreenTime = gp.ui.currentTime;targetDrawn = true;}
		}
	}
	public void disposeTarget(Graphics2D g2) {
		if(gp.ui.currentTime > gp.ui.delayTime) {
			
			g2.drawImage(null, gp.target.targetX,gp.target.targetY ,gp.tileSize/2,gp.tileSize/2, null);
		}
	}
}
