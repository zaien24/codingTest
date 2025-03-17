class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // 정답 반환
                }
            }
        }
        return new int[]{}; // 정답이 항상 존재하므로 실행되지 않음. 
    }
}