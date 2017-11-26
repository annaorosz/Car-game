/** 
 * Car Game
 * Author: Anna Orosz
 */

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JLabel;
import org.junit.Test;


public class GameTest {
	
	@Test
	public void GameIsNotPlayingYetTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        assertEquals(court.playing, false);
	}
	
	@Test
	public void GameisPlayingTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.reset();
		        assertEquals(court.playing, true);
	}
	
	@Test
	public void GameisNotPlayingAnymoreTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.reset();
		        court.playing = false;
		        assertEquals(court.playing, false);
	}
	
	@Test
	public void ThereIsOnlyOneCarTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.obstacle = new HashSet<>();
		        Car car = new Car(court.COURT_WIDTH, court.COURT_HEIGHT);
		        court.obstacle.add(car);
		        court.reset();
		        for(int i = 0; i < 10; i++){
		        court.tick();
		        }
		        assertTrue(court.numCars == court.obstacle.size() || 
		        		(court.numCars - 2) == court.obstacle.size());
	}
	
	@Test
	public void ThereAreTwoCarsTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.obstacle = new HashSet<>();
		        Car car1 = new Car(court.COURT_WIDTH, court.COURT_HEIGHT);
		        Car car2 = new Car(court.COURT_WIDTH, court.COURT_HEIGHT);
		        court.obstacle.add(car1);
		        court.obstacle.add(car2);
		        court.reset();
		        for(int i = 0; i < 10; i++){
		        court.tick();
		        }
		        assertTrue(court.numCars == court.obstacle.size() || 
		        		(court.numCars - 2) == court.obstacle.size());
	}
	
	@Test
	public void ThereIsOnlyOneStarTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.award = new HashSet<>();
		        Star star = new Star(court.COURT_WIDTH, court.COURT_HEIGHT);
		        court.award.add(star);
		        court.reset();
		        for(int i = 0; i < 10; i++){
		        court.tick();
		        }
		        assertTrue(court.numStars == court.award.size() || 
		        		(court.numStars - 2) == court.award.size());
	}
	
	@Test
	public void ThereAreTwoStarsTest() throws IOException{
		
				final JLabel status = new JLabel("Running...");
		        GameCourt court = new GameCourt(status);
		        court.award = new HashSet<>();
		        Star star1 = new Star(court.COURT_WIDTH, court.COURT_HEIGHT);
		        Star star2 = new Star(court.COURT_WIDTH, court.COURT_HEIGHT);
		        court.award.add(star1);
		        court.award.add(star2);
		        court.reset();
		        for(int i = 0; i < 10; i++){
		        court.tick();
		        }
		        assertTrue(court.numStars == court.award.size() || 
		        		(court.numStars - 2) == court.award.size());
	}

}
