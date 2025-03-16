class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = getFirstPosition(nums, target);
        result[1] = getLastPosition(nums, target);
        return result;
    }

    private int getFirstPosition(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                index = mid;    //don't stop binary search since we need to find first occurance
            }
            if(nums[mid] >= target) {   //target is in left half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private int getLastPosition(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}