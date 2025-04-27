class Solution {
    // public String decodeString(String s) {
    //     Stack<Integer> numSt = new Stack<>();
    //     Stack<StringBuilder> strSt = new Stack<>();

    //     int currNo = 0;
    //     StringBuilder currStr = new StringBuilder();

    //     for(int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)) {
    //             currNo = currNo * 10 + c - '0';
    //         } else if(c == '[') {
    //             numSt.push(currNo);
    //             strSt.push(currStr);
    //             currNo = 0;
    //             currStr = new StringBuilder();
    //         } else if(c == ']') {
    //             int count = numSt.pop();
    //             StringBuilder parent = strSt.pop();
    //             for(int j = 0; j < count; j++) {
    //                 parent.append(currStr);
    //             }
    //             currStr = parent;
    //         } else {
    //             currStr.append(c);
    //         }
    //     }

    //     return currStr.toString();
    // }


    int i = 0;  //index
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if(c == '[') {
                String baby = decodeString(s);
                for(int k =0; k < currNum; k++) {
                    currStr.append(baby);
                }
                currNum = 0; //reset number
            } else if(c == ']') {
                return currStr.toString();
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}