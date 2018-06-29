package Invaders;




import java.awt.Color;
import java.awt.Graphics;

public class Chicken extends GameObject {

	

	public Chicken(int bob, int sally, int jill, int susan) {

		super(bob, sally, jill, susan);

		x = bob;
		y = sally;
		width = jill;
		height = susan;

		

	}
	
	
	public void update() {
		super.update();
		x-=8;	
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
		
	}


}
