class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int n = s.length();
        int max = 0;
        HashSet<Character> hset = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(hset.contains(c)) {
                //move slow and all characters till before ith char
                while(s.charAt(slow) != c) {
                    hset.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            hset.add(c);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}