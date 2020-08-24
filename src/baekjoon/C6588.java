package baekjoon;

import java.util.*;

public class C6588 {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        check[0] = check[1] = true;
        for (int i=2; i*i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }
            prime.add(i);
            for (int j=i+i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i=1; i<prime.size(); i++) {
                int p = prime.get(i);
                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n-p));
                    break;
                }
            }
        }
    }
}


//C++14
/*#include <iostream>
using namespace std;
const int MAX = 1000000;
int prime[MAX];
int pn;
bool check[MAX+1];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    for (int i = 2; i <= MAX; i++) {
        if (check[i] == false) {
            prime[pn++] = i;
            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }
    }
    while (true) {
        int n;
        cin >> n;
        if (n == 0) {
            break;
        }
        for (int i = 1; i < pn; i++) {
            if (check[n - prime[i]] == false) {
                cout << n << " = " << prime[i] << " + " << n - prime[i] << '\n';
                break;
            }
        }
    }
    return 0;
}*/

//PyPy3
/*MAX = 1000000
check = [0]*(MAX+1)
check[0] = check[1] = True
prime = []
for i in range(2, MAX+1):
    if not check[i]:
        prime.append(i)
        j = i+i
        while j <= MAX:
            check[j] = True
            j += i
prime = prime[1:]
while True:
    n = int(input())
    if n == 0:
        break
    for p in prime:
        if check[n-p] == False:
            print("{0} = {1} + {2}".format(n, p, n-p))
            break*/

