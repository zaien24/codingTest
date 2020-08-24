package baekjoon;

import java.util.Scanner;

public class C1929 {
	 public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        boolean[] check = new boolean[m+1];
	        check[0] = check[1] = true;
	        for (int i=2; i*i <= m; i++) {
	            if (check[i] == true) {
	                continue;
	            }
	            for (int j=i+i; j<=m; j+=i) {
	                check[j] = true;
	            }
	        }
	        for (int i=n; i<=m; i++) {
	            if (check[i] == false) {
	                System.out.println(i);
	            }
	        }
	    }
}

// C++14
/*#include <iostream>
using namespace std;
const int MAX = 1000000;
bool check[MAX+1];
int main() {
    check[0] = check[1] = true;
    for (int i=2; i*i<=MAX; i++) {
        if (check[i] == false) {
            for (int j=i+i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }
    }
    int m, n;
    cin >> m >> n;
    for (int i=m; i<=n; i++) {
        if (check[i] == false) {
            cout << i << '\n';
        }
    }
    return 0;
}*/

//Python 3
/*MAX = 1000000
check = [0]*(MAX+1)
check[0] = check[1] = True

for i in range(2, MAX+1):
    if not check[i]:
        j = i+i
        while j <= MAX:
            check[j] = True
            j += i
m, n = map(int,input().split())
for i in range(m, n+1):
    if check[i] == False:
        print(i)
*/
