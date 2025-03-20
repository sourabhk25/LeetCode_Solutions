class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        String searchStr = "01";
        while(searchStr.length() <= s.length()) {
            if(s.contains(searchStr)) {
                result = searchStr.length();
            }
            searchStr = "0" + searchStr + "1";  //prepend 0 and apend 1 to search str to increase its length for each iteration
        }

        return result;
    }
}