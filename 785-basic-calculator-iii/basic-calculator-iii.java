class Solution {
    // static class Pair {
    //     Stack<Integer> st;
    //     char sign;
    //     Pair(Stack<Integer> st, char sign) {
    //         this.st = st;
    //         this.sign = sign;
    //     }
    // }

    // private void cal(Stack<Integer> st, int val, char sign) {
    //     //compare sign value, for +,- push +ve,-ve val. for *,/ calculate ans and push
    //     if(sign == '+') {
    //         st.push(val);
    //     } else if(sign == '-') {
    //         st.push(-val);
    //     } else if(sign == '*') {
    //         int a = st.pop();
    //         int ans = a * val;
    //         st.push(ans); 
    //     } else if(sign == '/') {
    //         int a = st.pop();
    //         int ans = a / val;
    //         st.push(ans); 
    //     }
    // }
    // public int calculate(String s) {
    //     Stack<Pair> stPar = new Stack<>();  //stack to store details related to parenthesis
    //     Stack<Integer> st = new Stack<>();  //current stack
    //     char sign = '+';    //default sign is +
    //     int n = s.length();
    //     for(int i = 0; i < n; i++) {
    //         char ch = s.charAt(i);
    //         if(Character.isDigit(ch)) { //if ch is a digit
    //             int val = 0;
    //             while(i < n && Character.isDigit(s.charAt(i))) {
    //                 val = val * 10 + (s.charAt(i) - '0');   //handling case of no. of with multiple digits
    //                 i++;
    //             }
    //             i--;    //move i back 1 space after loop
    //             cal(st, val,sign);
    //         } else if(ch == '(') {
    //             stPar.push(new Pair(st, sign)); //push current stack and sign as pair to parenthesis stack
    //             st = new Stack<>(); //reset st variable
    //             sign = '+'; //reset sign variable with +
    //         } else if(ch == ')') {  //calculate the val
    //             int tempval = 0;
    //             while(!st.isEmpty()) {
    //                 tempval += st.pop();
    //             }
    //             Pair p = stPar.pop();   //get prev stack details
    //             st = p.st;  //get prev stack      
    //             sign = p.sign;  //get prev sign
    //             cal(st, tempval, sign); //calculate total ans for bracket
    //         } else if(ch != ' ') {  //if not whitespace
    //             sign = ch;  //assign sign
    //         }
    //     }

    //     int sum = 0;
    //     while(!st.isEmpty()) {  //calulate sum of all terms on stack
    //         sum += st.pop();
    //     }
    //     return sum;
    // }

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char lastSign = '+';
        int result = 0;
        int openBrace = Integer.MAX_VALUE;
        s = s.trim();   //remove all whitespaces first

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
                if(i == s.length() - 1) {
                    if(lastSign == '+')     st.push(currNum);
                    else if(lastSign == '-')    st.push(-currNum);
                    else if(lastSign == '*')    st.push(st.pop() * currNum);
                    else if(lastSign == '/')   st.push(st.pop() / currNum);
                }
            }
            else if(c == '(') { //storing previous sign
                if(lastSign == '+')     st.push(1);
                else if(lastSign == '-')    st.push(-1);
                else if(lastSign == '*')    st.push(null);  //for *
                else if(lastSign == '/')   st.push(Integer.MIN_VALUE);  //for /
                st.push(openBrace);
                lastSign = '+'; //reset lastSign and currNum
                currNum = 0;
            }
            else if(c == ')') { 
                //first process last formed number in braces
                if(lastSign == '+')     st.push(currNum);
                else if(lastSign == '-')    st.push(-currNum);
                else if(lastSign == '*')    st.push(st.pop() * currNum);  //for *
                else if(lastSign == '/')   st.push(st.pop() / currNum);  //for /
                int temp = 0;
                while(st.peek() != openBrace) { //process till find '('
                    temp += st.pop();
                }
                st.pop();   //pop openBrace
                //Now, process whole bracket value i.e. temp as per previous signs
                if(st.peek() == null) { //* sign
                    st.pop();   //pop null value
                    st.push(st.pop() * temp);   //push value
                } else if(st.peek() == Integer.MIN_VALUE) { //division sign
                    st.pop();
                    st.push(st.pop() / temp);   //push value
                } else {
                    st.push(temp * st.pop());   //multiply by 1 or -1 as per + or - sign before open braces
                }

                lastSign = c; //reset lastSign and currNum
                currNum = 0;
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/') { //any operator comes
                if(lastSign == '+') st.push(currNum);
                else if(lastSign == '-')    st.push(-currNum);
                else if(lastSign == '*')    st.push(st.pop() * currNum);
                else if(lastSign == '/')   st.push(st.pop() / currNum);
                lastSign = c;
                currNum = 0;
            }
        }

        while(!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }
}