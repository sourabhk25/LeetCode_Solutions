class Solution {
    public int trap(int[] height) {
        //2 pointer approach
        int n = height.length;
        if(n == 0)  return 0;
        int left = 0, right = n - 1;
        int leftmax = height[0];
        int rightmax = height[n - 1];
        int ans = 0;
        
        while(left <= right) {
            //check which side has minimum height
            if(leftmax < rightmax) {
                if(height[left] > leftmax) {
                    leftmax = height[left];
                } else {
                    ans += leftmax - height[left];
                    left++;
                }
            } else {
                if(height[right] > rightmax) {
                    rightmax = height[right];
                } else {
                    ans += rightmax - height[right];
                    right--;
                }
            }
        }

        return ans;
    }
}