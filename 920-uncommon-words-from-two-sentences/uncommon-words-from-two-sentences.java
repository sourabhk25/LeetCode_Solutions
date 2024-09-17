class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //create a map of word and occurance count
        //repeated word would have more than 1 count
        //uncommon word will have 1 count and should be added in output

        Map<String, Integer> occurance_count = new HashMap<>();
        for(String word: s1.split(" ")) {
            occurance_count.put(word, occurance_count.getOrDefault(word, 0) + 1);
        }
        for(String word: s2.split(" ")) {
            occurance_count.put(word, occurance_count.getOrDefault(word, 0) + 1);
        }
        List<String> output = new ArrayList<>();
        for(String word: occurance_count.keySet()) {
            if(occurance_count.get(word) == 1) {
                output.add(word);
            }
        }

        return output.toArray(new String[output.size()]);
    }
}