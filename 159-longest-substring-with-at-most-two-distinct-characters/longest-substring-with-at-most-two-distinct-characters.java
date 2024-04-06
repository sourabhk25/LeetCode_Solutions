class Solution {
    //sliding window approach
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < s.length()) {
            hmap.put(s.charAt(right), right);
            if(hmap.size() == 3) {  //3 characters present in window, need to modify window
                int smallestIndex = Collections.min(hmap.values()); //find smallest index value i.e. the most last seen character in window
                hmap.remove(s.charAt(smallestIndex));   //remove that character from map/ window
                left = smallestIndex + 1; //move left ptr of window 
            }
            maxLen = Math.max(maxLen, right - left + 1); //calculate window size
            right++;
        }

        return maxLen;
    }
}