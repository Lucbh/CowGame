package Invaders;

import java.awt.Graphics;

public class Background extends GameObject{
	 public Background(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}

	int backwards = 0;
	
		
		// TODO Auto-generated constructor stub
	
	
		
	
	
	
	
	
	
	
	
	public void update() {
		super.update();
		
		

		backwards-=5;

	
	}
	
	public void draw(Graphics g) {
		
		
		 g.drawImage(GamePanel.fieldImg, backwards, 0, 4096, 1000, null);
	
		 
		
	}
	
	
	
	
	
	
	
}
