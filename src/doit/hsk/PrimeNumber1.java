package doit.hsk;

// 1000 이하의 소수를 열거(버전1)
public class PrimeNumber1 {
	
	public static void main(String[] args) {
		int counter = 0; // 나눗셈의 횟수
		
		for (int n = 2; n <= 1000; n++) {
			int i;
			
			for (i = 2; i < n; i++) {
				counter++;
				if (n % i == 0) {
					break;
				}
			}
			
			if (n == i) {
				System.out.println(n);
			}
		}
		System.out.println(counter);
	}
}