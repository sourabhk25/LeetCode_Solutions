class Solution {
    // public int change(int amount, int[] coins) {
    //     int m = coins.length;
    //     int n = amount;
    //     int[][] dp = new int[m+1][n+1]; //to store cnt of ways of making coin change

    //     //initialize first 0 like with 0 coins and 0 amt, 1 ways possible, like 0 amt is possible with any no of coins so cnt is 1
    //     dp[0][0] = 1;   //in recursssion, when amt reaches 0 then we incremented count

    //     //loop through values of m and n in matrix
    //     for(int i = 1; i <=m; i++) {
    //         for(int j = 0; j <= n; j++) {
    //             if(j < coins[i-1]) {    //amt less than coin denomination so no choose case
    //                 dp[i][j] = dp[i-1][j];
    //             } else {
    //                 dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }

    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                //if amt is less then no choose case in that case we use same value in current cell
                if(j >= coins[i - 1]) { //if amt is greater or equal to denomination of coin then choose case
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[n];
    }
}