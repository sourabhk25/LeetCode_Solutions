class Solution {
    public int longestPalindrome(String s) {
        int[] frequency = new int[128]; //128 due to ascii 
        for(char c: s.toCharArray()) {
            frequency[c]++; //increase frequency
        }

        int result = 0;
        for(int f:frequency) {
            result += f / 2 * 2;    //increase result/max length of palindrome
            if(result % 2 == 0 && f % 2 == 1) { //check if centre char is added to palindrom or not
                result++;
            }
        }

        return result;
    }
}