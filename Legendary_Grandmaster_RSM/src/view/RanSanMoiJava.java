package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import control.GameScreen;
import model.ConRan;

public class RanSanMoiJava extends JFrame{
	
	GameScreen game;
	
	
	public RanSanMoiJava() {
		setSize(650, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game = new GameScreen();
		add(game);
		this.addKeyListener(new handler());
		
		setVisible(true);
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

}
