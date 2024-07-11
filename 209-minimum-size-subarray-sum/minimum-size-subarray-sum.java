class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int result = Integer.MAX_VALUE;
        int currSum = 0;
        
        for(right=0; right<nums.length; right++) {
            currSum += nums[right];
            while(currSum >= target) {
                result = Math.min(result, right - left + 1);    //getting window size
                currSum -= nums[left++];    //moving left side of window to forward and removing it from sum of window
            }
        }
        
        if(result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }
}