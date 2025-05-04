class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;  //keep no of char matched with p
        for(int i = 0; i < m; i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int freq = map.get(in);
                freq--;
                map.put(in, freq); 
                if(freq == 0) {
                    match++;
                }
            }

            if(i >= n) {
                char out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if(freq == 1) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                result.add(i - n + 1);
            }
        }

        return result;
    }
}