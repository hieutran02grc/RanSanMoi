package RSM;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	//declare matrix two dementional
	static int [][] bg = new int [20][20];
	
	
	ConRan ran;
	
	
	
	//1. constructor
	Thread thread;
	public GameScreen() {
		
		ran = new ConRan();
		
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
		g.setColor(Color.gray);
		//set each box have height=20, width=20
		for(int i=0; i<20;i++) {
			for(int j=0;j<20;j++) {
				g.fillRect(i*20+1, j*20+1, 18, 18);
				if(bg[i][j] == 2) {
					g.setColor(Color.red);
					g.fillRect(i*20+1, j*20+1, 18, 18);
					g.setColor(Color.gray);
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

