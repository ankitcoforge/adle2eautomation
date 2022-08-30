package utils;
import java.util.Random;

import org.testng.annotations.Test;


public class Randomizer {
	
//	public static void main(String[] args) {
//		
//	//}
	 Random rand = new Random();
	 int num;
	 
	
	public String getRamdomPhnNo() {
		    num = rand.nextInt (999) + 100;
		    String string = String.format("%010d", num);
		    return string;
		  }
	
	public String getMilage() {
		    num = rand.nextInt (9999);
		    String string = String.format("%04d", num);
		    return string;
		  }
	}

