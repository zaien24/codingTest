package baekjoon;

import java.util.*;
import java.io.*;
public class C1406 {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	Stack<Character> left = new Stack<>();
    	Stack<Character> right = new Stack<>();
    	for (int i = 0; i < s.length(); i++) {
    		left.push(s.charAt(i));
    	}
    	int m = Integer.parseInt(br.readLine());
    	while (m-- > 0) {
    		String[] line = br.readLine().split(" ");
    		char what = line[0].charAt(0);
    		if (what == 'L') {
    			if (!left.empty()) {
    				right.push(left.pop());
    			}
    		} else if (what == 'D') {
    			if (!right.empty()) {
    				left.push(right.pop());
    			}
    		} else if (what == 'P') {
    			char c = line[1].charAt(0);
    			left.push(c);
    		} else if (what == 'B') {
    			if (!left.empty()) {
    				left.pop();
    			}
    		}
    	}
    	while (!left.empty()) {
    		right.push(left.pop());
    	}
    	StringBuilder sb = new StringBuilder();
    	while (!right.empty()) {
    		sb.append(right.pop());
    	}
    	System.out.println(sb);
    }
}



// C++14
/*#include <cstdio>
#include <cstring>
#include <stack>
using namespace std;
char a[600000];
int main() {
    scanf("%s",a);
    stack<char> left, right;
    int n = strlen(a);
    for (int i=0; i<n; i++) {
        left.push(a[i]);
    }
    int m;
    scanf("%d",&m);
    while (m--) {
        char what;
        scanf(" %c",&what);
        if (what == 'L') {
            if (!left.empty()) {
                right.push(left.top());
                left.pop();
            }
        } else if (what == 'D') {
            if (!right.empty()) {
                left.push(right.top());
                right.pop();
            }
        } else if (what == 'B') {
            if (!left.empty()) {
                left.pop();
            }
        } else if (what == 'P') {
            char c;
            scanf(" %c",&c);
            left.push(c);
        }
    }
    while (!left.empty()) {
        right.push(left.top());
        left.pop();
    }
    while (!right.empty()) {
        printf("%c",right.top());
        right.pop();
    }
    printf("\n");
    return 0;
}*/

/*//PyPy3
import sys
input = sys.stdin.readline
left = list(input().strip())
right = []
m = int(input())
for _ in range(m):
    line = input().strip().split()
    what = line[0]
    if what == 'L':
        if left:
            right.append(left.pop())
    elif what == 'D':
        if right:
            left.append(right.pop())
    elif what == 'P':
        left.append(line[1])
    elif what == 'B':
        if left:
            left.pop()
left += right[::-1]
print(''.join(left))
*/