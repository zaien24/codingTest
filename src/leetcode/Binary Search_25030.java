class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int L = 0;
        int R = nums.length - 1;

        while (L < R) {
            int  mid = (L + R) / 2;
            if (nums[mid] < target) {
                L = mid;
            } else {
                R--;
            }
            result = mid;
        }

        return result;

    }
}

class Solution {
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;  
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1; 
    }
}