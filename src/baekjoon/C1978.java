package baekjoon;

import java.util.*;
public class C1978 {
	
    public static boolean is_prime(int x) {
        if (x <= 1) {
            return false;
        } else if (x == 2) {
            return true;
        }
        for (int i=2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n-- > 0) {
            if (is_prime(sc.nextInt())) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

//C++14
/*#include <iostream>
using namespace std;
bool is_prime(int x) {
    if (x < 2) {
        return false;
    }
    for (int i=2; i*i <= x; i++) {
        if (x % i == 0) {
            return false;
        }
    }
    return true;
}
int main() {
    int n;
    cin >> n;
    
    int cnt = 0;
    for (int i=0; i<n; i++) {
        int num;
        cin >> num;
        if (is_prime(num)) {
            cnt += 1;
        }
    }

    cout << cnt << '\n';
    return 0;
}*/

//Python 3
/*def is_prime(x):
    if x < 2:
        return False
    i = 2
    while i*i <= x:
        if x % i == 0:
            return False
        i += 1
    return True

n = int(input())
a = list(map(int,input().split()))
ans = 0
for x in a:
    if is_prime(x):
        ans += 1
print(ans)*/