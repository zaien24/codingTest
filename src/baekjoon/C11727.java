package baekjoon;

import java.util.*;
public class C11727 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        d[0] = 1;
        d[1] = 1;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + d[i-2]*2;
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}

// C++14
/*#include <cstdio>
int d[1001];
int main() {
    d[0]=1;
    d[1]=1;
    int n;
    scanf("%d",&n);
    for (int i=2; i<=n; i++) {
        d[i] = d[i-1]+d[i-2]+d[i-2];
        d[i] %= 10007;
    }
    printf("%d\n",d[n]);
    return 0;
}*/


// Python 3
/*n = int(input())
d = [0]*1001
d[0] = 1
d[1] = 1
for i in range(2, n+1):
    d[i] = d[i-1] + d[i-2] + d[i-2]
    d[i] %= 10007
print(d[n])
*/
