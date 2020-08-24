package baekjoon;

import java.util.*;

public class C1934 {
    
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	while (t-- > 0) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int g = gcd(a, b);
    		int l = a * b / g;
    		System.out.println(l);
    	}
    }

	private static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		} else {
			return gcd(y, x%y);
		}
	}
}

// C++14
/*#include <iostream>
using namespace std;
int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y, x%y);
}
int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;
        int g = gcd(a,b);
        cout << a*b/g << '\n';
    }
    return 0;
}*/

// Python 3
/*def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x%y)
t = int(input())
for _ in range(t):
    a,b = map(int, input().split())
    g = gcd(a, b)
    print(a*b//g)
*/
