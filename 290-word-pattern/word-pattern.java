class Solution {
    public boolean wordPattern(String pattern, String s) {
        //split the string by spaces to get individual words
        String[] words = s.split(" ");

        //if the number of words doesn't match the length of pattern, they can't follow the same pattern
        if (words.length != pattern.length()) {
            return false;
        }

        //map for a character in pattern to its corresponding word
        HashMap<Character, String> charToWord = new HashMap<>();
        //set to keep track of which words have already been mapped
        HashSet<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                //if current character is already mapped, but the mapped word doesn't match the current word, pattern fails
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                //if the word is already mapped to another character, we cannot reuse it return false
                if (usedWords.contains(w)) {
                    return false;
                }
                //map the new character->word
                charToWord.put(c, w);
                usedWords.add(w);
            }
        }
        return true;
    }
}