package baekjoon;

import java.util.*;

public class C10799 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().trim();
        int n = a.length();
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for (int i=0; i<n; i++) {
            char c = a.charAt(i);
            if (c == '(') {
                s.push(i);
            } else {
                if (s.peek()+1 == i) {
                    s.pop();
                    ans += s.size();
                } else {
                    s.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}


// C++14
/*#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main() {
    string a;
    cin >> a;
    int n = a.size();
    stack<int> s;
    int ans = 0;
    for (int i=0; i<n; i++) {
        if (a[i] == '(') {
            s.push(i);
        } else {
            if (s.top()+1 == i) {
                s.pop();
                ans += s.size();
            } else {
                s.pop();
                ans += 1;
            }
        }
    }
    cout << ans << '\n';
    return 0;
}*/