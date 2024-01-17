class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0')   return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {  //consider single digit
                dp[i] = dp[i - 1];
            }
            if(s.charAt(i - 2) == '1') {    //if prev digit is 1 then add ans
                dp[i] += dp[i - 2];
            } else if(s.charAt(i - 2) == '2' && (s.charAt(i - 1) >= 48 && s.charAt(i - 1) <= 54)) { //if prev digit is 2 then check if no. is 21 to 26 if yes add ans
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}