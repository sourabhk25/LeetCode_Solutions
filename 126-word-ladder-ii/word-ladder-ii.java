class Solution {
    //BFS and Backtracking
    String b;   //string to store beginword
    List<List<String>> ans; //ans list
    HashMap<String, Integer> hmap;  //map to store word and its step count

    private void dfs(String word, List<String> seq) {   //dfs for backtracking
        if(word.equals(b)) {    //check if word is begin word
            List<String> temp = new ArrayList<>(seq);   //if yes then create a copy of seq
            Collections.reverse(temp);  //reverse it and add to ans and return
            ans.add(temp);
            return;
        }
        int steps = hmap.get(word);     //get step count for word
        int sz = word.length(); //size of word to don't calculate again and again
        for(int i = 0; i < sz; i++) {   //loop for each char in word
            for(char ch = 'a'; ch <= 'z'; ch++) {   //change each char between a to z
                char[] wordArray = word.toCharArray();
                wordArray[i] = ch;
                String tempWord = new String(wordArray);
                if(hmap.containsKey(tempWord) && hmap.get(tempWord) == steps - 1) { //if map contains changed word and its step count is 1 less than steps of original word
                    seq.add(tempWord);  //add tempWord to seq
                    dfs(tempWord, seq); //call dfs for backtracking
                    seq.removeLast();   //remove last element as usual in backtracking
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();   //set for better lookup of visited words
        for(String s: wordList) {   //add words from wordList to set
            st.add(s);
        }
        Queue<String> q = new LinkedList<>();   //queue for BFS
        b = beginWord;  //initialize b for backtracking
        q.offer(beginWord); //add beginWord to BFS as start point
        hmap = new HashMap<>(); //initialize hmap
        hmap.put(beginWord, 1); //add beginWord to hmap
        int size = beginWord.length();  //size of beginWord
        st.remove(beginWord);   //remove beginWord from set
        while(!q.isEmpty()) {   //Start BFS
            String word = q.poll(); //get front word
            int steps = hmap.get(word); //get steps for word from map
            if(word.equals(endWord)) {  //if word is same as endWord break loop
                break;
            }
            for(int i = 0; i < size; i++) { //loop through each char in word''
                for(char ch = 'a'; ch <= 'z'; ch++) {   //change ith char with a to z
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String tempWord = new String(wordArray);
                    if(st.contains(tempWord)) {     //if chnaged word is in set
                        q.offer(tempWord);  //add it to queue
                        st.remove(tempWord);    //remove from set
                        hmap.put(tempWord, steps + 1);  //add to map with steps+1
                    }
                }
            }
        }
        ans = new ArrayList<>();    //initialize ans list
        if(hmap.containsKey(endWord)) { //if map contains endWord
            List<String> seq = new ArrayList<>();   //create temp list to store sequence
            seq.add(endWord);   //add endWord to seq
            dfs(endWord, seq);  //call backtracking dfs
        }
        return ans; //return ans list
    }
}