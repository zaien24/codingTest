package baekjoon;

import java.util.*;
import java.io.*;
public class C17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        int[] freq = new int[1000001];
        String[] temp = bf.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(temp[i]);
            freq[a[i]] += 1;
        }
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i=1; i<n; i++) {
            if (s.isEmpty()) {
                s.push(i);
            }
            while (!s.isEmpty() && freq[a[s.peek()]] < freq[a[i]]) {
                ans[s.pop()] = a[i];
            }
            s.push(i);
        }
        while (!s.empty()) {
            ans[s.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}



// C++14
/*
#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int freq[1000001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    vector<int> a(n);
    vector<int> ans(n);
    for (int i=0; i<n; i++) {
        cin >> a[i];
        freq[a[i]] += 1;
    }
    stack<int> s;
    s.push(0);
    for (int i=1; i<n; i++) {
        if (s.empty()) {
            s.push(i);
        }
        while (!s.empty() && freq[a[s.top()]] < freq[a[i]]) {
            ans[s.top()] = a[i];
            s.pop();
        }
        s.push(i);
    }
    while (!s.empty()) {
        ans[s.top()] = -1;
        s.pop();
    }
    for (int i=0; i<n; i++) {
        cout << ans[i] << ' ';
    }
    cout << '\n';
    return 0;
}
*/

// PyPy3
/*#!/usr/bin/python3
freq = [0] * 1000001
n = int(input())
a = list(map(int,input().split()))
for i in range(n):
    freq[a[i]] += 1
ans = [0]*n
s = [0]
for i in range(1, n):
    if not s:
        s.append(i)
    while s and freq[a[s[-1]]] < freq[a[i]]:
        ans[s.pop()] = a[i]
    s.append(i)
while s:
    ans[s.pop()] = -1
print(' '.join(map(str,ans)))
*/