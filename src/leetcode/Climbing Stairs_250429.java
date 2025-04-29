package leetcode;

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] D = new int[n+1];
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= n; i++) {
            D[i] = D[i-1] + D[i-2];
        }

       return D[n];
    }
}

