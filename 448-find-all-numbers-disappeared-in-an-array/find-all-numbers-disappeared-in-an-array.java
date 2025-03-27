class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = Math.abs(nums[i]) - 1;    //taking abs for repeated no case which might be already -ve
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}