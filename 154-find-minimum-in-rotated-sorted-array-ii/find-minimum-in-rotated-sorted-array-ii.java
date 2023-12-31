class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[low]);
                low++;
                high--;
                continue;
            }
            
            if(nums[low] <= nums[mid]) {  //left half is sorted
                ans = Math.min(ans, nums[low]); //update ans using min function
                low = mid + 1;  //increment low
            } else {    //right half is sorted
                ans = Math.min(ans, nums[mid]); //update ans using min function
                high = mid - 1; //decrement high
            }
        }
        
        return ans;
    }
}