package baekjoon;

import java.math.BigInteger;

public class Gcd {

	public static void main(String[] args) {
		
		// 최대 공약수 구하기
		int gcdValue = gcdThing(192, 72);
		System.out.println("1. BigInteger.gcd() 함수이용, 최대공약수 : " + gcdValue);
		System.out.println("2. 호제법 최대공약수 : " + GCD(24,16));
	}

	private static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

	private static int gcdThing(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		
		return gcd.intValue();
	}
	
	
}
