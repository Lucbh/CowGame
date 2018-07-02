package Invaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer time;

	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;
	Font subtitleFont;
	Cow r;
	CowAttack l;

	int rX = 250;
	int rY = 700;
	

	ObjectManager ob;
	
	boolean jump;
	
	
	 public static BufferedImage alienImg;

     public static BufferedImage cowImg;

     public static BufferedImage bulletImg;

     public static BufferedImage fieldImg;
     
     public static BufferedImage goatImg;



	public GamePanel() {
		
	

		time = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.BOLD, 48);
		subtitleFont = new Font("Arial", Font.BOLD, 25);

		r = new Cow(rX, rY, 80, 60);
		

		ob = new ObjectManager(r);
		
		
		jump =true;
		
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("chicken.png"));

             cowImg = ImageIO.read(this.getClass().getResourceAsStream("cow.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("droplet.png"));
             
             fieldImg = ImageIO.read(this.getClass().getResourceAsStream("background.png"));
             
             goatImg = ImageIO.read(this.getClass().getResourceAsStream("goat.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }

	}

	public void startGame() {

		time.start();

	}

	public void updateMenuState() {
		
		ob.score = 0;

	}

	public void updateGameState() {

		ob.update();
		ob.getScore();
		ob.checkCollision();
		ob.manageEnemies();
		ob.purgeObjects();  
		
		
		
		
		if (ob.toEndState() == true) {
			currentState = END_STATE;
			
		}
		
		
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {

		g.setColor(Color.WHITE);

		g.fillRect(0, 0, 1000, 1000);

		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("CHICK-FIL-ATTACK", 280, 300);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start",360, 500);
		g.drawString("Press SPACE for instructions", 320, 700);
		
	}

	public void drawGameState(Graphics g) {

		
		

		g.fillRect(0, 0, 1000, 1000);

		ob.draw(g);
		
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("SHOOT THE CHICKENS!!", 200, 200);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 1000, 1000);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("YOU DIED", 370, 300);
		g.setFont(subtitleFont);
		g.drawString("YOU MADE " + ob.getScore() + " CHICKEN SANDWICHES", 300, 500);
		g.drawString("Press ENTER to start over", 350, 700);

	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		repaint();

		

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("I am going so fast");

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState++;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			
		
			if (currentState == MENU_STATE) {
				r = new Cow(rX, rY, 50, 50);
				
				ob = new ObjectManager(r);
				
			}
			
			

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) { // I need to make it more smooth

			if (r.y <= 700 && r.y >= 550 && jump == true) {
				r.speedY = -15;
				jump = false;
			}
			
			if (r.y == 700) {
				
				jump = true;
				r.speedY =-15;
			}
			
			

		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			
			

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			
			
			
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			
			if (currentState == MENU_STATE) {
				
				JOptionPane.showMessageDialog(null, " Press Space to shoot and the Up-Arrow to Jump\n"
						+ "Press the Up-Arrow 2 times to double jump. You'll need it!\n"
						+ "Try and shoot as many chickens as you can!\n "
						+ "Watch out for goats. Don't shoot them! \n"
						+ "Plan you shots wisely! \n"
						+ "Good luck!");
			}

			ob.addProjectile(new Projectile(r.x + 20, r.y, 10, 10));

		}
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Wow!!");

		if (e.getKeyCode() == KeyEvent.VK_UP) { // I need to make it more smooth
			
			
			
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			r.speedY = 0;
			;
		}

		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			r.speedX = 0;

		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			r.speedX = 0;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("Can I finish soon?!");

	}

}
