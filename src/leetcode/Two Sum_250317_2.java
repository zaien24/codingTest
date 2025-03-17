class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 타겟에서 현재 숫자를 뺀 값

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }           

            map.put(nums[i], i); // 현재 숫자와 인덱스를 저장
        }

        return new int[]{}; // 정답이 항상 존재하므로 실행되지 않음.
    }
}