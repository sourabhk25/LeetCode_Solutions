class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store key -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        // Convert map values to a list of lists
        return new ArrayList<>(map.values());
    }

    // Build a key from character counts
    private String getKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        // Build a unique string that represents character frequency
        // Example: "aab" => count array [2, 1, 0, 0, ..., 0] => "2#1#0#0#...#"
        StringBuilder sb = new StringBuilder();
        for (int cnt : count) {
            sb.append(cnt).append('#');
        }
        return sb.toString();
    }
}