package Invaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class CowAttack {

	JFrame a;

	final int sizeX = 1000;// idk if I should make it static, only cause g.fillRect(0, 0,
							// LeagueInvaders.sizeX, LeagueInvaders.sizeY); asked for it
	final int sizeY = 1000;

	GamePanel b;

	public CowAttack() {

		a = new JFrame("League Invaders");
		b = new GamePanel();

	}

	public static void main(String[] args) {

		// Don't know how to make constructors yet

		CowAttack bob = new CowAttack();

		bob.setup();

	}

	public void setup() {

		a.add(b);
		a.addKeyListener(b);

		a.setSize(sizeX, sizeY);
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		a.getContentPane().setPreferredSize(new Dimension(sizeX, sizeY));

		a.pack();

		b.startGame();

	}

	public int getSizeX() {

		return sizeX;
	}

	public int getSizeY() {

		return sizeY;
	}

}
