package Invaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Cow rocket;

	ArrayList<Projectile> p;
	ArrayList<Chicken> a;
	ArrayList<Goat> gt;
	long enemyTimer;
	int enemySpawnTime;
	long goatTimer;
	int goatSpawnTime;
	int score;
	Background b;

	public ObjectManager(Cow rocket) {

		this.rocket = rocket;
	
		p = new ArrayList<Projectile>();
		a = new ArrayList<Chicken>();	
		gt = new ArrayList<Goat>();
		enemyTimer = 0;
		enemySpawnTime = 1000;
		goatTimer = 0;
		goatSpawnTime = 1000;
		score = 0;
		b = new Background(0, 0, 0, 0);
	}

	public void update() {
		b.update();
		rocket.update();
		

		for (int x = 0; x < p.size(); x++) {

			p.get(x).update();

		}
		
		for (int x = 0; x < a.size(); x++) {

			a.get(x).update();

		}
		
		for (int x = 0; x < gt.size(); x++) {
			gt.get(x).update();
		}
		

	}

	public void draw(Graphics g) {
		b.draw(g);
		rocket.draw(g);
		
		for (int x = 0; x < p.size(); x++) {

			p.get(x).draw(g);

		}
		
		for (int x = 0; x < a.size(); x++) {

			a.get(x).draw(g);

		}
		
		for (int x = 0; x < gt.size(); x++) {

			gt.get(x).draw(g);

		}
		

	}

	public void addProjectile(Projectile p1) {
		p.add(p1);

	}
	
	public void addAlien(Chicken a1) {
		
		a.add(a1);
	}
	
	public void addGoat(Goat g1) {
		
		gt.add(g1);
		
	}
	
	

	public void manageEnemies(){ //I haven't made them turn and stuff
		
	        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	        	
	                addAlien(new Chicken(/*new Random().nextInt(1000)*/ 1000, 700, 50, 50));
	                enemySpawnTime = new Random().nextInt(1300);
	                enemySpawnTime += 1000;
	               
	                
	enemyTimer = System.currentTimeMillis();
	
	        }
	        
	        if(System.currentTimeMillis() - goatTimer >= goatSpawnTime){
	        	
	        
	        	
	        	
	        	
	        	
                goatSpawnTime = new Random().nextInt(2000);
                goatSpawnTime += 2000;
                addGoat(new Goat(1000,700,50,50));
                
                
                goatTimer = System.currentTimeMillis();

        }
	}
	
	public void purgeObjects() { // Have no idea what this does
		
		for (int i = 0; i < p.size(); i++) {
			if (!p.get(i).isAlive) {
				p.remove(i);
			}
		}
		
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).isAlive) {
				a.remove(i);
			}
		}
		for (int i = 0; i < gt.size(); i++) {
			if (!gt.get(i).isAlive) {
				gt.remove(i);
			}
		}
		
		
		
	}
	
	public void checkCollision() {
		
		for(Chicken al : a){

	        if(rocket.collisionBox.intersects(al.collisionBox)){

	                rocket.isAlive = false;
	                System.out.println("ROCKETISDEAD");
	        }
	        
	        for (Projectile pl : p) {
	        	
	        	 if(pl.collisionBox.intersects(al.collisionBox)){

		                al.isAlive = false;
		                pl.isAlive = false;
		                System.out.println("ALIENISDEAD");
		                score++;
		        }
	        	 
	        
	        	
	        }
	        
	        for (Goat gl : gt) {
	        	
	        	if(rocket.collisionBox.intersects(gl.collisionBox)){

	                rocket.isAlive = false;
	                System.out.println("ROCKETISDEAD");
	        }
	        	
	        	for (Projectile pl : p) {
	        		
	        		 if(pl.collisionBox.intersects(gl.collisionBox)){

	        			 	rocket.isAlive = false;
			                System.out.println("YOUAREDEAD");
			            
			        }
	        		
	        	}
	        	
	        	
	        	 
	        
	        	
	        }

	           
	}
		
	
		
		
	}

	public boolean toEndState() {
		
		
		
		if (rocket.isAlive == false) {
			rocket.isAlive = true;
			a.clear();
			gt.clear();
			
			
			
			
				return true;
		}
		return false;
		
	
		
		
		
		
	}
	
	public int getScore() {
		
		
		return score;
		
	}
	

}