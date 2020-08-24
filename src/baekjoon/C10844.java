package baekjoon;
import java.util.*;
import java.math.*;

public class C10844 {
	public static long mod = 1000000000L;
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	long[][] d = new long[n+1][10];
    	for (int i=1; i<=9; i++) {
    		d[1][i] = 1;
    	}
    	for (int i=2; i<=n; i++) {
    		for (int j=0; j<=9; j++) {
    			d[i][j] = 0;
    			if (j-1 >= 0) {
    				d[i][j] += d[i-1][j-1];
    			}
    			if (j+1 <= 9) {
    				d[i][j] += d[i-1][j+1];
    			}
    			d[i][j] %= mod;
    		}
    	}
    	long ans = 0;
    	for (int i=0; i<=9; i++) {
    		ans += d[n][i];
    	}
    	ans %= mod;
    	System.out.println(ans);
    }
}

// C++14
/*#include <iostream>
using namespace std;
long long d[101][10];
long long mod = 1000000000;
int main() {
    int n;
    cin >> n;
    for (int i=1; i<=9; i++) {
        d[1][i] = 1;
    }
    for (int i=2; i<=n; i++) {
        for (int j=0; j<=9; j++) {
            d[i][j] = 0;
            if (j-1 >= 0) {
                d[i][j] += d[i-1][j-1];
            }
            if (j+1 <= 9) {
                d[i][j] += d[i-1][j+1];
            }
            d[i][j] %= mod;
        }
    }
    long long ans = 0;
    for (int i=0; i<=9; i++) {
        ans += d[n][i];
    }
    ans %= mod;
    cout << ans << '\n';
    return 0;
}*/

// Python 3
/*d = [[0]*10 for _ in range(100+1)]
mod = 1000000000 
n = int(input())
for i in range(1, 10):
    d[1][i] = 1
for i in range(2, n+1):
    for j in range(10):
        d[i][j] = 0
        if j-1 >= 0:
            d[i][j] += d[i-1][j-1]
        if j+1 <= 9:
            d[i][j] += d[i-1][j+1]
        d[i][j] %= mod
ans = sum(d[n]) % mod
print(ans)
*/
