package codility;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

	public static void main(String[] args) { 
		System.out.println("result : " +  countBits(21));
	}	
	
	public static int countBits(int number) {		
		int result = 0;
		String dchar = "0123456789";
		
		do {					
			char chkStr = dchar.charAt(number % 2);
			
			if (chkStr == '1') {
				result++;
			}
			number /= 2;
		 } while (number != 0);		
		return result;
	}
	
	
}

