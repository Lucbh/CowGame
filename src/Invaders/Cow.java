package Invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Cow extends GameObject{
	
	 int speedX;
	 int speedY;
	 double gravity;
	
	
	public Cow(int bob, int sally, int jill, int susan) {
		
		super(bob, sally, jill, susan);
		
		x = bob;
		y = sally;
		width = jill;
		height = susan;
		
		speedX = 0;
		speedY = 5;
		gravity = 1.0;
		
	}
	
	
	
	public void update() {
		super.update();
		
		
		y+=speedY;
	
		/***
		 * AT THE END OF 8, BEGINNING OF 9
		 * 
		 */
		stayOnGround();
	}
	
	public void draw(Graphics g) {
		
		
		 
		 g.drawImage(GamePanel.cowImg, x, y, width, height, null);
		 
		
	}
	
	public void stayOnGround() {
		
		speedY = (int) (gravity + speedY);
		
		if (y > 700) {
			
			
			y = 700;
			
		}
		
		
		
	}
	
	
	
	

}
