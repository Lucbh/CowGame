package Invaders;

import java.awt.Graphics;

public class Background extends GameObject{
	 public Background(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}

	int backwards = 0;
	
		
		
	
		
	
	
	
	
	
	
	
	
	public void update() {
		super.update();
		
		

		backwards-=6;
		
		if (backwards <= -4096) {
			
			backwards =  0;
		}

	
	}
	
	public void draw(Graphics g) {
		
		
		 g.drawImage(GamePanel.fieldImg, backwards, 0, 4096, 1000, null);
		 g.drawImage(GamePanel.fieldImg, backwards + 4096, 0, 4096, 1000, null);
	
		 
		
	}
	
	
	
	
	
	
	
}
