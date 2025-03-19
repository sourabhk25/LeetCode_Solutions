class Solution {
    //2 pass - TC = O(2n), SC = O(128)
    // public int longestPalindrome(String s) {
    //     int[] frequency = new int[128]; //128 due to ascii 
    //     for(char c: s.toCharArray()) {
    //         frequency[c]++; //increase frequency
    //     }

    //     int result = 0;
    //     for(int f:frequency) {
    //         result += f / 2 * 2;    //increase result/max length of palindrome
    //         if(result % 2 == 0 && f % 2 == 1) { //check if centre char is added to palindrom or not
    //             result++;
    //         }
    //     }

    //     return result;
    // }

    public int longestPalindrome(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0;
        for(char c: s.toCharArray()) {
            if(hashSet.contains(c)) {
                maxLength += 2;
                hashSet.remove(c);
            } else {
                hashSet.add(c);
            }
        }
        if(!hashSet.isEmpty()) {
            maxLength++;
        }
        return maxLength;
    }
}