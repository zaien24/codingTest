package baekjoon;

import java.util.*;

public class C10430 {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();
       
       System.out.println("(A+B)%C : " + (a+b)%c);
       System.out.println("((A%C)+(B%C))%C : " + ((a%c)+(b%c)) % c);
       System.out.println("(A×B)%C : " + (a*b)%c);
       System.out.println("((A%C) × (B%C))%C : " + ((a%c)*(b%c))%c);
    }
}

//C++14
/*#include <iostream>
using namespace std;
int main() {
    int a, b, c;
    cin >> a >> b >> c;

    cout << (a+b)%c << '\n';
    cout << (a+b)%c << '\n';
    cout << (a*b)%c << '\n';
    cout << (a*b)%c << '\n';

    return 0;
}*/

//Python 3
/*a,b,c = map(int,input().split())
print((a%c+b%c)%c)
print((a%c+b%c)%c)
print((a%c*b%c)%c)
print((a%c*b%c)%c)*/
