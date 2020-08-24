package baekjoon;

import java.util.Scanner;

public class C2609 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int g = gcd(a, b); // 최대공약수
		int l = a * b / g; // 최소공배수
		System.out.println(g);
		System.out.println(l);
	}
	
	private static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return gcd(y, x%y);
		}
	}
}

//C++14
/*#include <iostream>
using namespace std;
int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y, x%y);
}
int main() {
    int a, b;
    cin >> a >> b;
    int g = gcd(a,b);
    cout << g << '\n' << a*b/g << '\n';
    return 0;
}*/

//Python 3
/*def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x%y)
a,b = map(int, input().split())
g = gcd(a, b)
print(g)
print(a*b//g)
*/
