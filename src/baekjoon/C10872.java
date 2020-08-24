package baekjoon;
import java.util.*;

public class C10872 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        for (int i=2; i<=n; i++) {
            ans *= i;
        }
        System.out.println(ans);
    }
}

//C++14
/*#include <iostream>
using namespace std;
int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}
int main() {
    int n;
    cin >> n;
    cout << factorial(n) << '\n';
    return 0;
}*/

//Python 3
/*def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
n = int(input())
print(factorial(n))*/
