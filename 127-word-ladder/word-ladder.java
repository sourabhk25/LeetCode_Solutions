class Pair {
    String first;
    int second;
    Pair(String s, int i) {
        first = s;
        second = i;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>(); //Queue to store word transformation and steps
        q.offer(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();   //to unmark visited words from wordList
        for(String w: wordList) {
            st.add(w);
        }
        st.remove(beginWord);   //remove start word since visited

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.first;
            int steps = p.second;
            if(word.equals(endWord)) {
                return steps;
            }
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String tempWord = new String(wordArray);
                    if(st.contains(tempWord)) {
                        st.remove(tempWord);
                        q.offer(new Pair(tempWord, steps + 1));
                    }
                }
            }
        }

        return 0;        
    }
}