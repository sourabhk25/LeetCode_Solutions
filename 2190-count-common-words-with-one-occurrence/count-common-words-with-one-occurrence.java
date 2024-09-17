class Solution {
    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> occurance_count1 = new HashMap<>();
        Map<String, Integer> occurance_count2 = new HashMap<>();
        for(String word: words1) {
            occurance_count1.put(word, occurance_count1.getOrDefault(word, 0) + 1);
        }
        for(String word: words2) {
            occurance_count2.put(word, occurance_count2.getOrDefault(word, 0) + 1);
        }
        
        int count = 0;
        for (String word : words1) {
            if(occurance_count1.get(word) == 1 && occurance_count2.getOrDefault(word, 0) == 1) {
                count++;
            }
        }

        return count;
    }
}