class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];

        for(int i = 0; i < n; i++) {
            int currMax = 0;
            for(int j = 1; j <= k && i-j+1 >= 0; j++) { //2nd condition to make sure we are making correct partition and not going out of bounds 
                currMax = Math.max(currMax, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], (currMax * j) + dp[i-j]);    //sum of current partition and previous partiotion of remainig elements
                } else {
                    dp[i] = Math.max(dp[i], (currMax * j));
                }                
            }
        }

        return dp[n - 1];
    }
}