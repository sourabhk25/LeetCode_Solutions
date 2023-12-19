class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLength = 0, maxStartIndex = 0;
        String ans = "";
        if(s.length() == 0) return ans;
        
        for(int[] arr : dp) {   //initialization step
            Arrays.fill(arr, 0);
        }
        
        //i denotes start index of substring, j denotes end index of substring
        // need to traverse diagonally
        for(int diff = 0; diff < n; diff++) {
            for(int i = 0, j = i + diff; j < n; i++, j++) {
                if(i == j) {    //middle diagonal i.e. 1 length substring
                    dp[i][j] = 1;
                } else if(diff == 1) { //2nd diagonal in towards top right from middle
                    //means 2 length substring, just check i and j char
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;    
                    } //else already 0 due to initialization step
                } else {    //for other columns i.e. substrings of length 3 or more
                    //check if i and j char same and check inner diagonal was substring
                    //if true add inner diagonal value + 2 (for chars i and j) else 0
                    if((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } //else already 0 due to initialization step
                }
                if(dp[i][j] != 0) { //palindrome substring present
                    if(maxLength < (j - i + 1)) {
                        maxLength = (j - i + 1);
                        maxStartIndex = i;
                    }
                }
            }
        }
        
        return s.substring(maxStartIndex, maxStartIndex + maxLength);
    }
}