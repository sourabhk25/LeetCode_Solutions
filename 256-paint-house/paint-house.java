class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;

//this time we dont need extra 1 space in row and column.
        int[][] dp = new int[m][n];
        //intialize last row of dp matrix with same costs from costs matrix sinze last row wont have option of choosing
        dp[m - 1][0] = costs[m - 1][0];
        dp[m - 1][1] = costs[m - 1][1];
        dp[m - 1][2] = costs[m - 1][2];

        //traverse costs and dp array from bottom to up to get the answers
        for(int i = m - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }

        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}