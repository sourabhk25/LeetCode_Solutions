class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNo = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNo = currNo * 10 + c - '0';
            } else if(c == '[') {
                numSt.push(currNo);
                strSt.push(currStr);
                currNo = 0;
                currStr = new StringBuilder();
            } else if(c == ']') {
                int count = numSt.pop();
                StringBuilder parent = strSt.pop();
                for(int j = 0; j < count; j++) {
                    parent.append(currStr);
                }
                currStr = parent;
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}