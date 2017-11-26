/** 
 * Car Game
 * Author: Anna Orosz
 */

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class IOtest {
	
	@Test
	public void ThreeScoresTest() throws IOException{
		
		Set<Integer> set1 = new TreeSet<>();
		set1.add(2);
		set1.add(5);
		set1.add(27);
		FileWriter writer = new FileWriter("test.txt");
        for(Integer val : set1){
            writer.write(val+"");  
            writer.write(';');
        }
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String s = reader.readLine();
        reader.close();
        String[] array2 = s.split(";");
        String[] array1 = {"2", "5", "27"};
        assertArrayEquals(array1, array2);
	}
	
	@Test 
	public void ThreeSameNumbers() throws IOException {
		
		Set<Integer> set1 = new TreeSet<>();
		set1.add(2);
		set1.add(2);
		set1.add(2);
		FileWriter writer = new FileWriter("test.txt");
        for(Integer val : set1){
            writer.write(val+"");  
            writer.write(';');
        }
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String s = reader.readLine();
        reader.close();
        String[] array2 = s.split(";");
        String[] array1 = {"2"};
        assertArrayEquals(array1, array2);
	
	}
	
	@Test 
	public void TwoSameNumbers() throws IOException {
		
		Set<Integer> set1 = new TreeSet<>();
		set1.add(0);
		set1.add(100);
		set1.add(100);
		FileWriter writer = new FileWriter("test.txt");
        for(Integer val : set1){
            writer.write(val+"");  
            writer.write(';');
        }
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String s = reader.readLine();
        reader.close();
        String[] array2 = s.split(";");
        String[] array1 = {"0", "100"};
        assertArrayEquals(array1, array2);
	
	}
	
	//This test should return more than 10 numbers
	//since the unnecessary numbers will be taken out in the tick() method in the Gamecourt class.
	@Test 
	public void MoreThanTenNumbersTest() throws IOException {
		
		Set<Integer> set1 = new TreeSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(6);
		set1.add(7);
		set1.add(8);
		set1.add(9);
		set1.add(10);
		set1.add(11);
		set1.add(12);
		FileWriter writer = new FileWriter("test.txt");
        for(Integer val : set1){
            writer.write(val+"");  
            writer.write(';');
        }
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String s = reader.readLine();
        reader.close();
        String[] array2 = s.split(";");
        String[] array1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        assertArrayEquals(array1, array2);
	
	}
	
}
