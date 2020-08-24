package baekjoon;

import java.util.*;

public class C17103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[1000001];
        for (int i=2; i<=1000000; i++) {
            if (check[i] == false) {
                primes.add(i);
                for (int j=i+i; j<=1000000; j+=i) {
                    check[j] = true;
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            for (int p : primes) {
                if (n-p >= 2 && p <= n-p) {
                    if (check[n-p] == false) {
                        ans += 1;
                    }
                } else {
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}

//  C++14
/*#include <iostream>
#include <vector>
using namespace std;
bool check[1000001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<int> primes;
    for (int i=2; i<=1000000; i++) {
        if (check[i] == false) {
            primes.push_back(i);
            for (int j=i+i; j<=1000000; j+=i) {
                check[j] = true;
            }
        }
    }
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int ans = 0;
        for (int i=0; i<primes.size(); i++) {
            if (n-primes[i] >= 2 && primes[i] <= n-primes[i]) {
                if (check[n-primes[i]] == false) {
                    ans += 1;
                }
            } else {
                break;
            }
        }
        cout << ans << '\n';
    }
    return 0;
}*/

// PyPy3
/*#!/usr/bin/python3
check = [False] * 1000001
primes = []
for i in range(2, 1000001):
    if check[i] == False:
        primes.append(i)
        j = i+i
        while j <= 1000000:
            check[j] = True
            j += i
t = int(input())
for _ in range(t):
    n = int(input())
    ans = 0
    for p in primes:
        if n - p >= 2 and p <= n - p:
            if check[n-p] == False:
                ans += 1
        else:
            break
    print(ans)
*/