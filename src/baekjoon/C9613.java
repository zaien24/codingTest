package baekjoon;

import java.util.*;

public class C9613 {
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            long ans = 0;
            for (int i=0; i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    ans += gcd(a[i], a[j]);
                }
            }
            System.out.println(ans);
        }
    }
}
//C++14
/*#include <iostream>
using namespace std;
int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y,x%y);
}
int main() {
    int t;
    cin >> t;
    while (t--) {
        int a[111];
        int n;
        cin >> n;
        for (int i=0; i<n; i++) {
            cin >> a[i];
        }
        long long sum=0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                sum += gcd(a[i],a[j]);
            }
        }
        cout << sum << '\n';
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
    a = list(map(int, input().split()))
    n = a[0]
    a = a[1:]
    ans = 0
    for i in range(0, n-1):
        for j in range(i+1, n):
            ans += gcd(a[i], a[j])
    print(ans)*/