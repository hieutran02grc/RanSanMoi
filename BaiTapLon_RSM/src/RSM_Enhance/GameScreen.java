package RSM_Enhance;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	//declare matrix two dementional
	static int [][] bg = new int [20][20];
	
	
	ConRan ran;
	
	
	
	//1. constructor
	Thread thread;
	public GameScreen() {
		
		//load snake
		ran = new ConRan();
		
		//load img snake
		Data.loadImage();
		
		bg[10][10] = 2;
		
		
		thread = new Thread(this);
		// when start method run auto called by start()
		thread.start();
	}
	public void run() {
		while(true) {
			
			ran.update();
			repaint();
			//ms
			try {
				thread.sleep(20);
			} catch (InterruptedException e) {}
		}
	}
	
	//paint net for matrix
	public void paintBg(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 400, 400);
		//set each box have height=20, width=20
		for(int i=0; i<20;i++) {
			for(int j=0;j<20;j++) {
				//g.fillRect(i*20+1, j*20+1, 18, 18);
				//draw the bait
				if(bg[i][j] == 2) {
					g.drawImage(Data.imageWorm,i*20,j*20,null);
				}
			}
		}
	}

	
	//3. Overide paint form JPanel
	//make object moving by clear display before
	public void paint(Graphics g) {
		//layer-1
		paintBg(g);
		//layer-2
		ran.veRan(g);
		
	}
}

