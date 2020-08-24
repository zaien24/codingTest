package baekjoon;

import java.util.Scanner;

public class C9012 {
	
	public static String isValid(String s) {
		int n = s.length();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				cnt += 1;
			} else {
				cnt -= 1;
			}
			if (cnt < 0) {
				return "NO";
			}
		}
		if (cnt == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
        	System.out.println(isValid(sc.next()));
        }        
    }
}


// C++14
/*#include <iostream>
#include <string>
using namespace std;
string valid(string s) {
    int cnt = 0;
    for (int i=0; i<s.size(); i++) {
        if (s[i] == '(') {
            cnt += 1;
        } else {
            cnt -= 1;
        }
        if (cnt < 0) {
            return "NO";
        }
    }
    if (cnt == 0) {
        return "YES";
    } else {
        return "NO";
    }
}
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        cout << valid(s) << '\n';
    }
    return 0;
}*/


/*#!/usr/bin/python3
def valid(s):
    cnt = 0
    for ch in s:
        if ch == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt < 0:
            return 'NO'
    if cnt == 0:
        return 'YES'
    else:
        return 'NO'
t = int(input())
for _ in range(t):
    print(valid(input()))
*/