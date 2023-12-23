class Solution {
    public int trap(int[] height) {
        //2 pointer approach
        int n = height.length;
        if(n == 0)  return 0;   //return 0 if empty input array
        int left = 0, right = n - 1;    //setting 2 pointers
        int leftmax = height[0];    //max height from left
        int rightmax = height[n - 1];   //max height from right
        int ans = 0;    //ans variable
        
        while(left <= right) {  //loop till left and right don't cross each other
            //check which side has minimum height
            if(leftmax < rightmax) {    //if left side has smaller 
                if(height[left] > leftmax) {    //check left bar height is greater than current leftmax
                    leftmax = height[left]; //change if yes
                } else {
                    ans += leftmax - height[left];  //else add difference to ans
                    left++; //increment left ptr
                }
            } else {    //right side has smaller 
                if(height[right] > rightmax) {  //check right bar height is greater than current rightmax
                    rightmax = height[right];   //change if yes
                } else {
                    ans += rightmax - height[right];    //else add difference to ans
                    right--;    //increment right ptr
                }
            }
        }

        return ans; //return ans
    }
}