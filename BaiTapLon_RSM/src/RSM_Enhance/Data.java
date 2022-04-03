package RSM_Enhance;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Data {
	//load image for sanke and background
	public static Image imageHead;
	public static Image imageBody;
	public static Image imageWorm;
	
	public static void loadImage() {
		try {
			imageHead = ImageIO.read(new File("res/head.png"));
			imageBody = ImageIO.read(new File("res/body.png"));
			imageWorm = ImageIO.read(new File("res/bait.png"));
		}catch(Exception e) {}
	}

}
