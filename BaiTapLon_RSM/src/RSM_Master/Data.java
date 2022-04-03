package RSM_Master;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Data {
	
	public static BufferedImage sprite;
	
	//load image for sanke head
	public static Image imageHead;
	public static Image imageHead_GoLeft;
	public static Image imageHead_GoRight;
	public static Image imageHead_GoUp;
	public static Image imageHead_GoDown;
	
	//load image for bait
	public static Image imageWorm2;
	public static Image imageWorm3;
	
	
	public static Image imageBody;
	public static Image imageWorm;
	
	//load snake animation
	public static Animation HeadGoUp;
	public static Animation HeadGoDown;
	public static Animation HeadGoRight;
	public static Animation HeadGoLeft;
	
	//load worm animation
	public static Animation Worm;
	
	public static void loadImage() {
		try {
			
			sprite = ImageIO.read(new File("res/sprite1.png"));
			
			//animation
			//1. animation for snake's head
			imageHead = sprite.getSubimage(2, 3, 30, 30);
			imageHead_GoLeft = sprite.getSubimage(74, 3, 30, 30);
			imageHead_GoRight = sprite.getSubimage(110, 3, 30, 30);
			imageHead_GoUp = sprite.getSubimage(145, 3, 30, 30);
			imageHead_GoDown = sprite.getSubimage(39, 3, 30, 30);
			
			//
			imageBody = sprite.getSubimage(7, 78, 18, 18);
			
			
			//3. animation for bait
			imageWorm = sprite.getSubimage(7, 43, 24, 28);
			imageWorm2 = sprite.getSubimage(35, 45, 24, 26);
			imageWorm3 = sprite.getSubimage(62, 47, 24, 24);
			
		}catch(Exception e) {}
	}
	
	// load all animation we have
	public static void loadAllAnim() {
		//ani.1 snake animation
		HeadGoUp = new Animation();
		HeadGoUp.addImage(imageHead);
		HeadGoUp.addImage(imageHead_GoUp);
		
		HeadGoDown = new Animation();
		HeadGoDown.addImage(imageHead);
		HeadGoDown.addImage(imageHead_GoDown);
		
		HeadGoLeft = new Animation();
		HeadGoLeft.addImage(imageHead);
		HeadGoLeft.addImage(imageHead_GoLeft);
		
		HeadGoRight = new Animation();
		HeadGoRight.addImage(imageHead);
		HeadGoRight.addImage(imageHead_GoRight);
		
		//ani.2 bait animation
		Worm = new Animation();
		Worm.addImage(imageWorm);
		Worm.addImage(imageWorm2);
		Worm.addImage(imageWorm3);
		Worm.addImage(imageWorm2);

	}

}
