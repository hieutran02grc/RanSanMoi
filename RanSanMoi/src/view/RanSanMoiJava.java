package view;


import java.awt.event.KeyEvent;
import user.User;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import control.GameScreen;
import model.ConRan;


public class RanSanMoiJava extends JFrame{
	
	GameScreen game;
	
	public static ArrayList<User> users;
	
	public RanSanMoiJava() {
		setSize(738,460);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game = new GameScreen();
		add(game);
		this.addKeyListener(new handler());
		users = new ArrayList<user.User>();
		readData();
		setVisible(true);
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				updateData();
			}
			
		});

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RanSanMoiJava f = new RanSanMoiJava();

	}
	// lop noi tai
	// listener event from keyboard
	private class handler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				GameScreen.isPlaying =! GameScreen.isPlaying;
				if(GameScreen.isGameOver) {
					GameScreen.isGameOver = false;
					game.ran.resetGame();
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				game.ran.setVector(ConRan.GO_UP);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				game.ran.setVector(ConRan.GO_DOWN);
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				game.ran.setVector(ConRan.GO_LEFT);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				game.ran.setVector(ConRan.GO_RIGHT);
			}
			
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public static void readData() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("data/data.txt");
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine())!= null) {
				String[] str = line.split(" ");
				users.add(new user.User(str[0],str[1]));
			}
			
			
			br.close();
		} catch (IOException ex) {}
		finally {
			try {
				br.close();
			} catch (IOException ex) {}	
		}
	}
		


	public static void updateData() {
		// TODO Auto-generated method stub
		BufferedWriter bw = null; 
		try {
			FileWriter fw = new FileWriter("data/data.txt");
			bw = new BufferedWriter(fw );
			
			for(User u:users) {
				bw.write(u.getName() + " "+ u.getPoint());
				bw.newLine();
			}
			

		} catch (IOException ex) {}
		finally {
			try {
				bw.close();
			} catch (IOException ex) {}	
		}
	}



}
