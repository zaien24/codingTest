package baekjoon;

import java.util.*;

public class C2004 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long two = 0, five = 0;
        for (long i=2; i<=n; i*=2) {
            two += n/i;
        }
        for (long i=2; i<=n-m; i*=2) {
            two -= (n-m)/i;
        }
        for (long i=2; i<=m; i*=2) {
            two -= m/i;
        }
        for (long i=5; i<=n; i*=5) {
            five += n/i;
        }
        for (long i=5; i<=n-m; i*=5) {
            five -= (n-m)/i;
        }
        for (long i=5; i<=m; i*=5) {
            five -= m/i;
        }
        System.out.println(Math.min(two,five));
    }
}

//C++14

/*#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    long long two = 0, five = 0;
    long long n, m;
    cin >> n >> m;
    for (long long i=2; i<=n; i*=2) {
        two += n/i;
    }
    for (long long i=2; i<=n-m; i*=2) {
        two -= (n-m)/i;
    }
    for (long long i=2; i<=m; i*=2) {
        two -= m/i;
    }
    for (long long i=5; i<=n; i*=5) {
        five += n/i;
    }
    for (long long i=5; i<=n-m; i*=5) {
        five -= (n-m)/i;
    }
    for (long long i=5; i<=m; i*=5) {
        five -= m/i;
    }
    cout << min(two, five) << '\n';
    return 0;
}*/

//Python 3
/*#!/usr/bin/python3
def calc(n, v):
    ans = 0
    i = v
    while i <= n:
        ans += n//i
        i *= v
    return ans
two = 0
five = 0
n, m = map(int,input().split())
two += calc(n, 2)
two -= calc(n-m, 2)
two -= calc(m, 2)
five += calc(n, 5)
five -= calc(n-m, 5)
five -= calc(m, 5)
print(min(two, five))
*/