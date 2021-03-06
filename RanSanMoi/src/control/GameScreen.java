package control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import data.Data;
import model.ConRan;
import view.RanSanMoiJava;

public class GameScreen extends JPanel implements Runnable{
	//declare matrix two dementional
	public static int [][] bg = new int [20][20];
	
	//align boder game
	public static int padding = 10;
	static int WIDTH = 400;
	static int HEIGHT = 400;
	
	//check game started
	public static boolean isPlaying = false;
	public static boolean enableTextStartGame  = true;
	
	public ConRan ran;
	
	Thread thread;
	
	//check current level
	public static int CurrentLevel = 1;
	
	//check is game over
	public static boolean isGameOver = false;
	
	//check player point
	public static int point = 0;
	
	
	
	//1. constructor
	public GameScreen() {
		
		//load snake
		ran = new ConRan();
		
		//load img snake
		Data.loadImage();
		
		//load animation
		Data.loadAllAnim();
		
		bg[10][10] = 2;
		
		
		thread = new Thread(this);
		// when start method run auto called by start()
		
		
		thread.start();
	}
	public void run() {
		long t = 0;
		long t2 = 0;
		while(true) {
			
			// loop for text animation in game
			if(System.currentTimeMillis()-t2>500) {
				enableTextStartGame =! enableTextStartGame;
				t2 = System.currentTimeMillis();
			}
			
			if(isPlaying) {
				if(System.currentTimeMillis()-t >= 200) {
					Data.Worm.update();
					t = System.currentTimeMillis();			}
				ran.update();
			}
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
		g.fillRect(0, 0, WIDTH+padding*2+300, HEIGHT+padding*2);
		//set each box have height=20, width=20
		for(int i=0; i<20;i++) {
			for(int j=0;j<20;j++) {
				//g.fillRect(i*20+1, j*20+1, 18, 18);
				//draw the bait
				if(bg[i][j] == 2) {
					g.drawImage(Data.Worm.getCurrentImage(),i*20+padding,j*20+padding,null);
				}
			}
		}
	}
	
	private void veKhung(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(0, 0, WIDTH+padding*2, HEIGHT+padding*2);
		g.drawRect(1, 1, WIDTH+padding*2-2, HEIGHT+padding*2-2);
		g.drawRect(2, 2, WIDTH+padding*2-4, HEIGHT+padding*2-4);
		g.drawRect(0, 0, WIDTH+padding*2+300, HEIGHT+padding*2);
		g.drawRect(1, 1, WIDTH+padding*2-2+300, HEIGHT+padding*2-2);
		g.drawRect(2, 2, WIDTH+padding*2-4+300, HEIGHT+padding*2-4);
	}

	
	//3. Overide paint form JPanel
	//make object moving by clear display before
	public void paint(Graphics g) {
		//layer-1
		paintBg(g);
		//layer-2
		ran.veRan(g);
		
		veKhung(g);
		
		if(!isPlaying) {
			if(enableTextStartGame) {
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(18.0f));
				g.drawString("SPACE TO PLAY", 60, 200);
			}
			
		}
		if(isGameOver) {
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(28.0f));
				g.drawString("GameOver", 140, 250);
			
		}
		
		g.setColor(Color.white);
		g.setFont(g.getFont().deriveFont(20.0f));
		for(int i=0; i <RanSanMoiJava.users.size();i++) {
			g.drawString(RanSanMoiJava.users.get(i).toString(), 450,i*30+190 );
		}
		
		g.setColor(Color.white);
		g.setFont(g.getFont().deriveFont(28.0f));
		g.drawString("LEVEL"+CurrentLevel, 450, 100);
		
		g.setFont(g.getFont().deriveFont(20.0f));
		g.drawString("Point: "+point, 450, 150);
		
	}
}

