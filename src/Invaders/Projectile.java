package Invaders;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Projectile extends GameObject  implements ActionListener, KeyListener{

	 int speedP;
	boolean direction;

	public Projectile(int bob, int sally, int jill, int susan) {

		super(bob, sally, jill, susan);

		x = bob;
		y = sally;
		width = jill;
		height = susan;

		 speedP = 10;
		 direction = false;
	}

	public void update() {
		super.update();
		

		if (y < 0) {

			isAlive = false;

		}
		
		
		if (direction == true) {
			
			x -= speedP;
			
		}
		else {
			x += speedP;
		}

	}

	public void draw(Graphics g) {

		//g.setColor(Color.WHITE);

		//g.fillRect(x, y + 10, width, height);
		
		
		g.drawImage(GamePanel.bulletImg, x, y + 20, width, height, null);
		
	}

		public void keyPressed(KeyEvent e) {
		

	
		 if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			
			

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			
			//direction = direction * -1;
			System.out.println("Hola");
			direction = true;
			
		}

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
