package baekjoon;

import java.util.*;
public class C17087 {
    static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x%y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int diff = Math.abs(x-s);
            a[i] = diff;
        }
        int ans = a[0];
        for (int i=1; i<n; i++) {
            ans = gcd(ans, a[i]);
        }
        System.out.println(ans);
    }
}



// C++14
/*#include <iostream>
#include <vector>
using namespace std;
int gcd(int x, int y) {
    if (y == 0) return x;
    else return gcd(y, x%y);
}
int main() {
    int n, s;
    cin >> n >> s;
    vector<int> a(n);
    for (int i=0; i<n; i++) {
        int x;
        cin >> x;
        int diff = x-s;
        if (diff < 0) diff = -diff;
        a[i] = diff;
    }
    int ans = a[0];
    for (int i=1; i<n; i++) {
        ans = gcd(ans, a[i]);
    }
    cout << ans << '\n';
    return 0;
}
*/

// Python 3
/*#!/usr/bin/python3
def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x%y)
n, s = map(int,input().split())
a = list(map(int,input().split()))
a = [abs(x-s) for x in a]
ans = a[0]
for i in range(1, n):
    ans = gcd(ans, a[i])
print(ans)
*/