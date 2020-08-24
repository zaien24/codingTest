package baekjoon;

import java.util.*;
import java.math.*;

public class C9095 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11];
        d[0] = 1;
        for (int i=1; i<=10; i++) {
            for (int j=1; j<=3; j++) {
                if (i-j >= 0) {
                    d[i] += d[i-j];
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}

// C++14
/*#include <stdio.h>
int d[11];
int main() {
    d[0] = 1;
    for (int i=1; i<=10; i++) {
        if (i-1 >= 0) {
            d[i] += d[i-1];
        }
        if (i-2 >= 0) {
            d[i] += d[i-2];
        }
        if (i-3 >= 0) {
            d[i] += d[i-3];
        }
    }
    int t;
    scanf("%d",&t);
    while (t--) {
        int n;
        scanf("%d",&n);
        printf("%d\n",d[n]);
    }
}*/

// Python 3
/*d = [0]*11
d[0] = 1
for i in range(1, 11):
    if i-1 >= 0:
        d[i] += d[i-1]
    if i-2 >= 0:
        d[i] += d[i-2]
    if i-3 >= 0:
        d[i] += d[i-3]

t = int(input())
for _ in range(t):
    n = int(input())
    print(d[n])
*/

