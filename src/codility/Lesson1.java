package codility;

import java.util.ArrayList;

public class Lesson1 {

	public static void main(String[] args) {
		System.out.println(solution(145));
	}
	
	public static int solution(int num) {
		String binaryString = Integer.toBinaryString(num);
		int count = 0;
		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				array.add(i);
				count++;
			}
		}
		
		int  result = 0;
		if (count == 1) {
			result = 0;
		} else {
			for (int i = 0; i < count -1; i++) {				
				String zero = binaryString.substring(array.get(i) + 1, array.get(i+1));
				if (result < zero.length()) {
					result = zero.length();
				}
			}

		}
		return result;
	}
}
