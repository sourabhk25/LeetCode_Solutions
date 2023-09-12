class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rCount = new int[26];
        int[] mCount = new int[26];
        char[] ransoms = ransomNote.toCharArray();
        char[] magazines = magazine.toCharArray();

        for(char r: ransoms) {
            rCount[r - 'a']++;
        }

        for(char m: magazines) {
            mCount[m - 'a']++;
        }

        for(char c: ransoms) {
            if(rCount[c - 'a'] > mCount[c - 'a']) {
                return false;
            }
        }

        return true;
    }
}