class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //if mid or leftmost or rightmost index is peak
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n-1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if(mid == n-1 || nums[mid + 1] > nums[mid]) {  //climb on right of mid
                low = mid + 1;
            } else {    //decend on left of peak
                high = mid - 1;
            }
        }
        return -1;  //no peak
    }
}