package Invaders;

import java.awt.Graphics;

public class Goat extends GameObject{

	public Goat(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}
	
	
	public void update() {
		super.update();
		x-=5;	
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(GamePanel.goatImg, x, y, width, height, null);
		
	}

}
