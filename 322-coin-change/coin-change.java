class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int m = amount;
    //     int[][] dp = new int[n+1][m+1];
    //     for(int j = 1; j <= m; j++) {
    //         dp[0][j] = 999999;
    //     }

    //     for(int i = 1; i <= n; i++) {
    //         for(int j = 0; j <= m; j++) {
    //             if(j < coins[i-1]) {  //if amount is less than denomination then don't choose that coin
    //                 dp[i][j] = dp[i-1][j];
    //             } else {
    //                 //choose case
    //                 dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
    //             }
    //         }
    //     }
    //     if(dp[n][m] == 999999)  return -1;
    //     return dp[n][m];
    // }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
    
        int[] dp = new int[m+1];

        for(int j = 1; j <=m; j++) {
            dp[j] = 999999;
        }
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(j < coins[i - 1]) {  //no choose since amt is greater than coin denomination
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
                }
            }
        }
        if(dp[m] == 999999) {
            return -1;
        } else {
            return dp[m];
        }
    }
}