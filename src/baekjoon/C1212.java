package baekjoon;

import java.util.*;

public class C1212 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] eight = {"000","001","010","011","100","101","110","111"};
        String s = sc.nextLine();
        boolean start = true;
        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.print(0);
        }
        for (int i=0; i<s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (start == true && n < 4) {
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    System.out.print("1");
                } else if (n == 2) {
                    System.out.print("10");
                } else if (n == 3) {
                    System.out.print("11");
                }
                start = false;
            } else {
                System.out.print(eight[n]);
                start = false;
            }
        }
        System.out.println();
    }
}

// C++14
/*#include <cstdio>
#include <string>
#include <iostream>
using namespace std;
string eight[8] = {"000","001","010","011","100","101","110","111"};
int main(){
    string s;
    cin >> s;
    bool start = true;
    if (s.length() == 1 && s[0]-'0' == 0) {
        cout << "0";
    }
    for (int i=0; i<s.length(); i++) {
        int n = s[i]-'0';
        if (start == true && n < 4) {
            if (n == 0) {
                continue;
            } else if(n == 1) {
                cout << "1";
            } else if (n == 2) {
                cout << "10";
            } else if (n == 3) {
                cout << "11";
            }
            start = false;
        } else {
            cout << eight[n];
            start = false;
        }
    }
    return 0;
}*/

//Python 3
/*#!/usr/bin/python3
eight = ["000","001","010","011","100","101","110","111"]
s = input()
start = True
ans = ''
if s == '0':
    ans = '0'
for ch in s:
    n = ord(ch)-ord('0')
    if start and n < 4:
        if n == 0:
            continue
        elif n == 1:
            ans += '1'
        elif n == 2:
            ans += '10'
        elif n == 3:
            ans += '11'
        start = False
    else:
        ans += eight[n]
        start = False
print(ans)*/



