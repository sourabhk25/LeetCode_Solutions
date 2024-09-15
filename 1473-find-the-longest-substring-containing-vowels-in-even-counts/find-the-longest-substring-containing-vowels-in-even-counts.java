class Solution {
    public int findTheLongestSubstring(String s) {
        //bitmasking
        //hash[26] for a,e,i,o,u as 1,2,4,8,16 consonents as 0 -> use these values for masking
        //find mask using mask^hash[str[i]-'a']
        //prevSeen[32] array to store index where this mask was seen previously
        //NO NEED to store count of vowels just keep flag of even or odd
        //so 2^5 combinations = 32 size of prevSeen[]
        //maxLen to store ans
        
        int[] hash = new int[26];
        hash['a' - 'a'] = 1;
        hash['e' - 'a'] = 2;
        hash['i' - 'a'] = 4;
        hash['o' - 'a'] = 8;
        hash['u' - 'a'] = 16;

        int maxLen = 0, mask = 0;
        int[] prevSeen = new int[32];
        Arrays.fill(prevSeen, -1);  //intialize to -1

        for(int i=0; i<s.length(); i++) {
            mask = mask ^ hash[s.charAt(i) - 'a'];
            if(mask != 0 && prevSeen[mask] == -1) {  //new mask value and it is nonzero i.e. first occurance of vowel
                prevSeen[mask] = i; //update prevSeen value
            }
            maxLen = Math.max(maxLen, i - prevSeen[mask]);  //update maxLen value per character
        }

        return maxLen;  //return maxLenth as ans
    }
}