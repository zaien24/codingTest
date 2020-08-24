package baekjoon;

import java.util.*;

public class C1676 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i=5; i<=n; i*=5) {
            ans += n/i;
        }
        System.out.println(ans);
    }
}

//C++14
/*#include <iostream>
using namespace std;
int main() {
    int ans = 0;
    int n;
    cin >> n;
    for (int i=5; i<=n; i*=5) {
        ans += n/i;
    }
    cout << ans << '\n';
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
n = int(input())
ans = calc(n, 5)
print(ans)
*/

