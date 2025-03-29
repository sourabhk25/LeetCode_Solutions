class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //create dp[] to store sums of falling path sum for each column
        int n = matrix.length;        
        int[] dp = new int[n + 1];
        
        for(int i = n - 1; i >= 0; i--) {
            int[] currRow = new int[n + 1];
            for(int j = 0; j < n; j++) {
                if(j == 0) {    //left most column so 2 choices, below or diagonal right and add that cell value
                    currRow[j] = Math.min(dp[j], dp[j + 1]) + matrix[i][j];
                } else if(j == n - 1) { //right most column so 2 choices, below or diagonal left and add that cell value
                    currRow[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
                } else {    //middle column cases, so 3 options, below or diagonal left/right and add that cell value
                    currRow[j] = Math.min(dp[j], Math.min(dp[j - 1], dp[j + 1])) + matrix[i][j];
                }
            }
            //update dp array with temp array values in currRow array
            dp = currRow;            
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }
}