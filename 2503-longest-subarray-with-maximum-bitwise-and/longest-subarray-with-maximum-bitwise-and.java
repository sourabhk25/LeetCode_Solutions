class Solution {
    public int longestSubarray(int[] nums) {
        // 2 ways - 1. Just use sliding window and take bitwise AND
        // 2. We see that max AND value occurs only when subarray contains all maximum elements in that array like [3,3]
        //so for 2nd approach, look for subarray containing same elements and that element should be maximum in array

        int maxVal = 0, maxLen = 0, currLen = 0;
        for(int num: nums) {
            if(maxVal < num) {  //new value is larger than maxVal
                maxVal = num;
                maxLen = 0; //reset maxLen and currLen
                currLen = 0;
            }
            if(maxVal == num) { //if num is same as maxVal then increase lenght of window
                currLen++;
            } else {    //else reset current window size
                currLen = 0;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}