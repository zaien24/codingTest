package baekjoon;

import java.util.*;

public class C2089 {
    public static void go(int n) {
        if (n == 0) {
            return;
        }
        if (n%2 == 0) {
            go(-(n/2));
            System.out.print(0);
        } else {
            if (n > 0) {
                go(-(n/2));
            } else {
                go((-n+1)/2);
            }
            System.out.print(1);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            go(n);
            System.out.println();
        }
    }
}

// C++14
/*
#include <cstdio>
void go(int n) {
    if(n==0) {
        return;
    }
    if (n%2 == 0) {
        go(-(n/2));
        printf("0");
    } else {
        if (n > 0) {
            go(-(n/2));
        } else {
            go((-n+1)/2);
        }
        printf("1");
    }
}
int main(){
    int n;
    scanf("%d\n",&n);
    if(n==0) {
        printf("0\n");
    } else {
        go(n);
    }
    return 0;
}*/

// Python 3
/*#!/usr/bin/python3
def go(n):
    if n == 0:
        return
    if n % 2 == 0:
        go(-(n//2))
        print(0,end='')
    else:
        if n > 0:
            go(-(n//2))
        else:
            go((-n+1)//2)
        print(1,end='')
n = int(input())
if n == 0:
    print(0)
else:
    go(n)
*/
