class Solution {
//     public int minCost(int[][] costs) {
//         int m = costs.length;
//         int n = costs[0].length;

// //this time we dont need extra 1 space in row and column.
//         int[][] dp = new int[m][n];
//         //intialize last row of dp matrix with same costs from costs matrix sinze last row wont have option of choosing
//         dp[m - 1][0] = costs[m - 1][0];
//         dp[m - 1][1] = costs[m - 1][1];
//         dp[m - 1][2] = costs[m - 1][2];

//         //traverse costs and dp array from bottom to up to get the answers
//         for(int i = m - 2; i >= 0; i--) {
//             //cost is calculated as cost at that place + min of cost of subtree of 2 other colors
//             dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
//         }

//         //return min from first row which contains total costs for each subtree for each color choice
//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//     }
    
    public int minCost(int[][] costs) {
        //0-R 1-B 2-G
        int m = costs.length;
        int n = costs[0].length;
        //intialize color variables for each color trees from last row of costs since they dont have choice of choosing
        int colorR = costs[m - 1][0];
        int colorB = costs[m - 1][1];
        int colorG = costs[m - 1][2];

        for(int i = m - 2; i >= 0; i--) {
            int tempR = colorR; //store previous values before updating it 
            int tempB = colorB;
            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(colorR, Math.min(colorB, colorG));
    }
}