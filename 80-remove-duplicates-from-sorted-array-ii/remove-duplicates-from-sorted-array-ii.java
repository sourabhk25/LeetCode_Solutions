class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }

        int j = 2;
        for(int i = 2; i < nums.length; i++) {
            nums[j] = nums[i];
            if(nums[j] != nums[j - 2]) {
                j++;
            }
        }
        return j;
    }
}