class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int noOfWords = words.length;
        return words[noOfWords - 1].length();
    }
}