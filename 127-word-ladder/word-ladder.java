class Pair {
    String first;   //store word
    int second;     //store step no
    Pair(String s, int i) {     //constructor
        first = s;
        second = i;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>(); //Queue to store word transformation and steps
        q.offer(new Pair(beginWord, 1));    //add beginWord to queue to start BFS
        Set<String> st = new HashSet<>();   //to unmark visited words from wordList
        for(String w: wordList) {   //add words to set for better lookup
            st.add(w);
        }
        st.remove(beginWord);   //remove start word since visited

        while(!q.isEmpty()) {   //loop till q is empty
            Pair p = q.poll();  //get front element and fetch data members
            String word = p.first;
            int steps = p.second;
            if(word.equals(endWord)) {  //if word is same as endWord return steps
                return steps;
            }
            //transformation steps
            for(int i = 0; i < word.length(); i++) {    //loop through all char of word
                for(char ch = 'a'; ch <= 'z'; ch++) {   //loop change each char from a to z
                    char[] wordArray = word.toCharArray();  
                    wordArray[i] = ch;
                    String tempWord = new String(wordArray);
                    if(st.contains(tempWord)) {     //if set contains tempWord
                        st.remove(tempWord);    //remove it
                        q.offer(new Pair(tempWord, steps + 1)); //add to queue with steps+1
                    }
                }
            }
        }

        return 0;   //return 0 if could not be converted
    }
}