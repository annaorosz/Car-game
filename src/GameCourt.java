/**
 * CIS 120 Game HW
 * Anna Orosz
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*;


/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 * 
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

	// the state of the game logic
	public Player player; // the Player, in this case the red car
	public Set<Car> obstacle; //the set of obstacles, in this case the blue cars
	public Set<Star> award; //the set of awards, which are represented by stars
	public Explosion explosion;
	public int score; //the current score in the game
	public static Set<Integer> scores; //set of the highest scores
	public int numCars = 3; //number of cars/obstacles
	public int numStars = 3; //number of starts/awards

	public boolean playing = false; // whether the game is running
	private JLabel status; // Current status text (i.e. Running...)

	// Game constants
	public static final int COURT_WIDTH = 600;
	public static final int COURT_HEIGHT = 800;
	public static final int SQUARE_VELOCITY = 15;
	// Update interval for timer, in milliseconds
	public static final int INTERVAL = 35;

	public GameCourt(JLabel status) {
		// creates border around the court area, JComponent method
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// The timer is an object which triggers an action periodically
		// with the given INTERVAL. One registers an ActionListener with
		// this timer, whose actionPerformed() method will be called
		// each time the timer triggers. We define a helper method
		// called tick() that actually does everything that should
		// be done in a single timestep.
		Timer timer = new Timer(INTERVAL, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tick();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		timer.start(); // MAKE SURE TO START THE TIMER!

		// Enable keyboard focus on the court area.
		// When this component has the keyboard focus, key
		// events will be handled by its key listener.
		setFocusable(true);

		// This key listener allows the player to move as long
		// as an arrow key is pressed, by changing the player's
		// velocity accordingly. (The tick method below actually
		// moves the player.)
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					player.v_x = -SQUARE_VELOCITY;
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					player.v_x = SQUARE_VELOCITY;
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					player.v_y = 0;
				else if (e.getKeyCode() == KeyEvent.VK_UP)
					player.v_y = 0;
			}

			public void keyReleased(KeyEvent e) {
				player.v_x = 0;
				player.v_y = 0;
			}
		});

		this.status = status;
	}

	/**
	 * (Re-)set the game to its initial state.
	 * @throws IOException 
	 */
	public void reset() throws IOException {

		player = new Player(COURT_WIDTH, COURT_HEIGHT);
		Car car = new Car(COURT_WIDTH, COURT_HEIGHT);
		Star star = new Star(COURT_WIDTH, COURT_HEIGHT);
		explosion = new Explosion(COURT_WIDTH, COURT_HEIGHT, 0, 0);
		obstacle = new HashSet<>();
		award = new HashSet<>();
		obstacle.add(car);
		award.add(star);
		score = 0;

		playing = true;
		status.setText("Score: " + score);
		
		read();

		requestFocusInWindow();
	}
	
	public static void read() throws IOException{
		
		scores = new TreeSet<>();
		BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
		String s = null;
        while (reader.ready()) {
        	s = reader.readLine();
        }
        String[] sa = s.split(";");
        System.out.println(Arrays.toString(sa));
        for (int i = 0; i < sa.length; i++) scores.add(Integer.parseInt(sa[i]));
        for (Integer i: scores){
        	System.out.println(i);
        	
        }
        reader.close();
		
	}

	/**
	 * This method is called every time the timer defined in the constructor
	 * triggers.
	 * @throws IOException 
	 */
	void tick() throws IOException {
		if (playing) {
			// advance the player and snitch in their
			// current direction.
			player.move();
			for(Car c: obstacle){
				c.move();
				}
			
			for(Star s: award){
				s.move();
				s.bounce(s.hitWall());
				}
			
			Set<Car> toberemoved1 = new HashSet<>();
			for(Car c: obstacle){
				if (c.pos_y > COURT_HEIGHT) toberemoved1.add(c);
			}
			
			Set<Star> toberemoved2 = new HashSet<>();
			for(Star s: award){
				if (s.pos_y > COURT_HEIGHT) toberemoved2.add(s);
			}
			
			for(Car c: toberemoved1){
				 obstacle.remove(c);
			}
			
			for(Star s: toberemoved2){
				 award.remove(s);
			}
			
			
			
			Set<Car> toberemoved = new HashSet<>();
			for(Car c1: obstacle){
				for(Car c2: obstacle){
					if (c1 == c2) continue;
					if (c1.intersects(c2)) toberemoved.add(c2);
				}
			}
			
			for(Car c: toberemoved){
				 obstacle.remove(c);
			}

			// check for the game end conditions
			for(Car c: obstacle){
				
			if (player.intersects(c)) {
				explosion.pos_x = player.getX() - (int) (player.width / 2.0);
				explosion.pos_y = player.getY() - (int) (player.height / 5.0);
				playing = false;
				status.setText("You lose! Your score is: " + score);
				scores.add(score);
				
				if (scores.size() > 10){
					int i = Integer.MAX_VALUE;
					for (Integer integer: scores){
						if (integer < i) i = integer;
					}
					scores.remove(i);
				}
				
				write();	
				
			}
			}
			
			Set<Star> starset = new HashSet<>();
			for(Star s: award){
				
				if (player.intersects(s)) {
					score++;
					status.setText("Score: " + score);
					starset.add(s);
				}
				}
			award.removeAll(starset);
			
			if (obstacle.size() < numCars) {
				Car car = new Car(COURT_WIDTH, COURT_HEIGHT);
				obstacle.add(car);
			}
			
			if (award.size() < numStars) {
				Star star = new Star(COURT_WIDTH, COURT_HEIGHT);
				award.add(star);
			}
			// update the display
			repaint();
		}
	}
	
	public static void write() throws IOException{
		
		FileWriter writer = new FileWriter("scores.txt");
		for(Integer val : scores){
            writer.write(val+"");  
            writer.write(';');
        }
        writer.close();
        
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		player.draw(g);
		for(Car c: obstacle){
			c.draw(g);
			}
		for(Star s: award){
			s.draw(g);
			}
		for(Car c: obstacle){
			if (player.intersects(c)) explosion.draw(g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
	
}
