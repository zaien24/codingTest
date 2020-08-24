package baekjoon;

import java.util.*;

public class C1373 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        if (n%3 == 1) {
            System.out.print(s.charAt(0));
        } else if (n%3 == 2) {
            System.out.print((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
        }
        for (int i=n%3; i<n; i+=3) {
            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
        }
        System.out.println();
    }
}

// C++14
/*#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    cin >> s;
    int n = s.size();
    if (n%3 == 1) {
        cout << s[0];
    } else if (n%3 == 2) {
        cout << (s[0]-'0')*2 + (s[1]-'0');
    }
    for (int i=n%3; i<n; i+=3) {
        cout << (s[i]-'0')*4 + (s[i+1]-'0')*2 + (s[i+2]-'0');
    }
    cout << '\n';
    return 0;
}*/

//Python 3
/*#!/usr/bin/python3
s = input()
n = len(s)
ans = ''
if n%3 == 1:
    print(s[0], end='')
elif n%3 == 2:
    print((ord(s[0])-ord('0'))*2 + ord(s[1])-ord('0'), end='')
for i in range(n%3, n, 3):
    print((ord(s[i])-ord('0'))*4 + (ord(s[i+1])-ord('0'))*2 + (ord(s[i+2])-ord('0')), end='')
    
*/

