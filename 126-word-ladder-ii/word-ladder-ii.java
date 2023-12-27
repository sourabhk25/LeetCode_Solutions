class Solution {
    String b;
    List<List<String>> ans;
    HashMap<String, Integer> hmap;

    private void dfs(String word, List<String> seq) {
        if(word.equals(b)) {    //check if word is begin word
            List<String> temp = new ArrayList<>(seq);   //if yes then create a copy of seq
            Collections.reverse(temp);  //reverse it and add to ans
            ans.add(temp);
            return;
        }
        int steps = hmap.get(word);
        int sz = word.length();
        for(int i = 0; i < sz; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                char[] wordArray = word.toCharArray();
                wordArray[i] = ch;
                String tempWord = new String(wordArray);
                if(hmap.containsKey(tempWord) && hmap.get(tempWord) == steps - 1) {
                    seq.add(tempWord);
                    dfs(tempWord, seq);
                    seq.removeLast();
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();
        for(String s: wordList) {
            st.add(s);
        }
        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.offer(beginWord);
        hmap = new HashMap<>();
        hmap.put(beginWord, 1);
        int size = beginWord.length();
        st.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.poll();
            int steps = hmap.get(word);
            if(word.equals(endWord)) {
                break;
            }
            for(int i = 0; i < size; i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String tempWord = new String(wordArray);
                    if(st.contains(tempWord)) {
                        q.offer(tempWord);
                        st.remove(tempWord);
                        hmap.put(tempWord, steps + 1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(hmap.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}