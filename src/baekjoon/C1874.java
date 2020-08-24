package baekjoon;

import java.util.*;

public class C1874 {
    public static void solve(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<Integer>();
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for(int x : a) {
            if (x > m) {
                while (x > m) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != x) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        solve(a);
    }
}

// Python 3
/*#!/usr/bin/python3
import sys
n = int(input())
a = [int(input()) for _ in range(n)]
stack = []
m = 0
ans = ''
for x in a:
    if x > m:
        while x > m:
            m += 1
            stack.append(m)
            ans += '+\n'
        stack.pop()
        ans += '-\n'
    else:
        if stack[-1] != x:
            print('NO')
            sys.exit(0)
        stack.pop()
        ans += '-\n'
print(ans, end='')*/

// PyPy3
/*#!/usr/bin/python3
import sys
n = int(input())
a = [int(input()) for _ in range(n)]
stack = []
m = 0
ans = []
for x in a:
    if x > m:
        while x > m:
            m += 1
            stack.append(m)
            ans += ['+']
        stack.pop()
        ans += ['-']
    else:
        if stack[-1] != x:
            print('NO')
            sys.exit(0)
        stack.pop()
        ans += ['-']
print('\n'.join(ans)+'\n')*/

// C++11
/*#include <iostream>
#include <stack>
#include <string>
using namespace std;
int main() {
    stack<int> s;
    int n;
    string ans;

    cin >> n;

    int m = 0;

    while (n--) {
        int x;
        cin >> x;
        if (x > m) {
            while (x > m) {
                s.push(++m);
                ans += '+';
            }
            s.pop();
            ans += '-';
        } else {
            bool found = false;
            if (!s.empty()) {
                int top = s.top();
                s.pop();
                ans += '-';
                if (x == top) {
                    found = true;
                }
            }
            if (!found) {
                cout << "NO" << '\n';
                return 0;
            }
        }
    }
    for (auto x : ans) {
        cout << x << '\n';
    }
    return 0;
}*/