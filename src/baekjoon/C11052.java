package baekjoon;

import java.util.*;

public class C11052 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=1; i<=n; i++) {
        	a[i] = sc.nextInt();
        }
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
        	for (int j=1; j<=i; i++) {
        		if (d[i] < d[i-j] + a[j]) {
        			d[i] = d[i-j] + a[j];
        		}
        	}
        }
    }
}

// C++14
/*#include <iostream>
#include <vector>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<int> a(n+1);
    for (int i=1; i<=n; i++) {
        cin >> a[i];
    }
    vector<int> d(n+1);
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=i; j++) {
            d[i] = max(d[i],d[i-j]+a[j]);
        }
    }
    cout << d[n] << '\n';
    return 0;
}*/

// Python 3
/*n = int(input())
a = [0] + list(map(int,input().split()))
d = [0]*(n+1)
for i in range(1, n+1):
    for j in range(1, i+1):
        d[i] = max(d[i],d[i-j]+a[j])
print(d[n])*/

// C
/*#include <stdio.h>
int a[1001];
int d[1001];
int main() {
    int n;
    scanf("%d",&n);
    for (int i=1; i<=n; i++) {
        scanf("%d",&a[i]);
    }
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=i; j++) {
            if (d[i] < d[i-j] + a[j]) {
                d[i] = d[i-j] + a[j];
            }
        }
    }
    printf("%d\n",d[n]);
    return 0;
}
*/