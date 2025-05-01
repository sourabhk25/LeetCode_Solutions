class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int i = 0;
        while(i <= m - n) { 
            int j = 0; //ptr on needle
            if(haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if(j == n) {
                        return i;
                    }
                }
            }
            i++;    //char not matched so incr i
        }

        return -1;
    }
}