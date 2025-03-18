class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> valueSet = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) {  //duplicate entry from s char but with different value
                    return false;
                }
            } else {
                if(valueSet.contains(tChar)) {
                    return false;
                }
                sMap.put(sChar, tChar);
                valueSet.add(tChar);
            }
        }
        return true;
    }
}