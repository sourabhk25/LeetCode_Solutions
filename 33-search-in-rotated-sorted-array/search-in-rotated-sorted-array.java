class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;                
            }
            if(nums[low] <= nums[mid]) {
                //left sorted array
                if(nums[low] <= target && target <= nums[mid]) {    //if target is in left part
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if(nums[mid] <= nums[high]) {
                //right sorted array
                if(nums[mid] <= target && target <= nums[high]) {   //if target is in left part
                    low = mid + 1;
                } else {
                    high = mid - 1; 
                }
            }
        }
        return -1;
    }
}